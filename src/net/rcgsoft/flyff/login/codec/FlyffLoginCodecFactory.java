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

package net.rcgsoft.flyff.login.codec;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public final class FlyffLoginCodecFactory implements ProtocolCodecFactory {
	private static final FlyffLoginPacketEncoder ENCODER = new FlyffLoginPacketEncoder();
	private static final FlyffLoginPacketDecoder DECODER = new FlyffLoginPacketDecoder();

	@Override
	public final ProtocolDecoder getDecoder(IoSession session) throws Exception {
		return DECODER;
	}

	@Override
	public final ProtocolEncoder getEncoder(IoSession session) throws Exception {
		return ENCODER;
	}
}