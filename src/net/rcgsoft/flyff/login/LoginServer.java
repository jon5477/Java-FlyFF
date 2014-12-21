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

import java.io.IOException;
import java.net.InetSocketAddress;

import net.rcgsoft.flyff.login.codec.FlyffLoginCodecFactory;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LoginServer {
	private static final LoginServer INSTANCE = new LoginServer();
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServer.class);
	private static final int LOGIN_PORT = 24000; // I hope this is correct.
	private static SocketAcceptor acceptor;

	private LoginServer() {
	}

	public static final LoginServer getInstance() {
		return INSTANCE;
	}

	public static final void main(String[] args) {
		// TODO Auto-generated method stub
		acceptor = new NioSocketAcceptor();
		acceptor.getSessionConfig().setTcpNoDelay(true); // Disable Nagle's Algorithm
		// Close all connections when the SocketAcceptor is deactivated.
		acceptor.setCloseOnDeactivation(true);
		acceptor.getFilterChain().addFirst("codec", new ProtocolCodecFilter(new FlyffLoginCodecFactory()));
		acceptor.setHandler(FlyffLoginServerHandler.getInstance());
		try {
			acceptor.bind(new InetSocketAddress(LOGIN_PORT));
			LOGGER.info("Bound to port {}.", LOGIN_PORT);
		} catch (IOException e) {
			LOGGER.error(e.getLocalizedMessage(), e);
		}
	}
}