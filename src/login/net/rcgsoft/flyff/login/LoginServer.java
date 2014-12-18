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

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LoginServer {
	private static final LoginServer INSTANCE = new LoginServer();
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServer.class);
	private static final int LOGIN_PORT = 24000; // I hope this is correct.

	private LoginServer() {
	}

	public static final LoginServer getInstance() {
		return INSTANCE;
	}

	public static final void main(String[] args) {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
			.channel(NioServerSocketChannel.class)
			.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				public void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(FlyffLoginServerHandler.getInstance());
				}
			})
			.option(ChannelOption.SO_BACKLOG, 128)
			.childOption(ChannelOption.SO_KEEPALIVE, true);
			LOGGER.info("Listening on port {}.", LOGIN_PORT);
			b.bind(LOGIN_PORT).sync().channel().closeFuture().sync();
		} catch (InterruptedException e) {
			return;
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}
}