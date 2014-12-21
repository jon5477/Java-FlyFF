/*
 *    This file is part of Java-FlyFF, a Java based FlyFF emulator.
 *    Copyright (C) 2014 Jon Huang <project54_jon@live.com>
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Affero General Public License as
 *    published by the Free Software Foundation, either version 3 of the
 *    License, or (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Affero General Public License for more details.
 *
 *    You should have received a copy of the GNU Affero General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.rcgsoft.flyff.login;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FlyffLoginServerHandler extends IoHandlerAdapter implements IoHandler {
	private static final FlyffLoginServerHandler INSTANCE = new FlyffLoginServerHandler();
	private static final Logger LOGGER = LoggerFactory.getLogger(FlyffLoginServerHandler.class);

	private FlyffLoginServerHandler() {
		// singleton
	}

	public static final FlyffLoginServerHandler getInstance() {
		return INSTANCE;
	}

	@Override
	public final void exceptionCaught(IoSession session, Throwable t) throws Exception {
		LOGGER.error(t.getLocalizedMessage(), t);
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		
	}
}