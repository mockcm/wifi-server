package com.mock.wifiserver.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.mock.wifiserver.config.JedisManager;
import com.mock.wifiserver.domain.MachineOperator;
import com.mock.wifiserver.protocol.StatInfo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class StatInfoHandler extends ChannelInboundHandlerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(StatInfoHandler.class);
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		
		StatInfo statInfo = null;
		try {
			statInfo = StatInfo.decode((ByteBuf)msg);
			logger.info("decode statInfo : {}",statInfo);
			MachineOperator stat = new MachineOperator();
			stat.setAttarCount(new Integer(statInfo.getOilTotal()));
			stat.setAttarUse(new Integer(statInfo.getOilRemind()));
			stat.setElectricCount(new Integer(statInfo.getElectricity()));
			stat.setMachineMac(statInfo.getHeader().getMac());
			stat.setPressure(new Integer(statInfo.getEnvPressure()));
			stat.setPump(new Integer(statInfo.getPumpPressure()));
			stat.setPumpTime(new Integer(statInfo.getPumpWorkTime()));
			stat.setUseTime(new Integer(statInfo.getMachineWorkTime()));
			
			try {
				//通知Redis.
				Long result =  JedisManager
					.getPublishClient()
					.publish("MACHINE_STAT", JSON.toJSONString(stat));
				if (result > 0) {
					logger.info("publish to channen MACHINE_STAT {} consumer consumed",result); 
				}
			}catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		
		} finally {
			
			ReferenceCountUtil.release(msg);
			if (statInfo.getChangedFlag() == 1) {
				logger.info("change flag equal 1 ,send 0x01 to deveic.");
				//向设备回送0x01
				ByteBuf resp = ByteBufAllocator.DEFAULT.buffer(3);
				resp.writeShort(1);
				resp.writeByte(0x01);
				ctx.writeAndFlush(resp);
			}
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
