/*
 *    This file is part of Java-FlyFF, a Java based FlyFF emulator.
 *    Copyright (C) 2014 Jon Huang <project54_jon@live.com>
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.rcgsoft.flyff.login;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.ByteOrder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FlyffLoginServerHandler extends ChannelInboundHandlerAdapter {
	private static final FlyffLoginServerHandler INSTANCE = new FlyffLoginServerHandler();
	private static final Logger LOGGER = LoggerFactory.getLogger(FlyffLoginServerHandler.class);

	private FlyffLoginServerHandler() {
		// singleton
	}

	public static final FlyffLoginServerHandler getInstance() {
		return INSTANCE;
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.handlerAdded(ctx);
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.handlerRemoved(ctx);
	}

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelRegistered(ctx);
	}

	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelUnregistered(ctx);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelActive(ctx);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelInactive(ctx);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// TODO Auto-generated method stub
		ByteBuf buf = ((ByteBuf) msg).order(ByteOrder.LITTLE_ENDIAN);
		try {
			if (buf.readableBytes() >= 17 && buf.readByte() == 0x5E) {
				int lengthHash = buf.readInt();
				int packetLength = buf.readInt();
				int dataHash = buf.readInt();
				int command = buf.readInt();
				// rest of packet data
				
			}
		} finally {
			buf.release(); // release resource
		}
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelReadComplete(ctx);
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		// TODO Auto-generated method stub
		super.userEventTriggered(ctx, evt);
	}

	@Override
	public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelWritabilityChanged(ctx);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.error(cause.getLocalizedMessage(), cause);
	}
}