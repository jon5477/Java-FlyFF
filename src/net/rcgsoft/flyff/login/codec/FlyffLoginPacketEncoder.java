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

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import tools.HexTool;

final class FlyffLoginPacketEncoder implements ProtocolEncoder {
	/*
	 * Information retrieved from:
	 * http://forum.ragezone.com/f457/flyff-packet-breakdown-488888/
	 */

	FlyffLoginPacketEncoder() {
		// keep package-private
	}

	@Override
	public void dispose(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void encode(IoSession session, Object msg, ProtocolEncoderOutput out) throws Exception {
		// TODO Auto-generated method stub
		// Start packet with 5E
		// Include length hash [int]
		// Include packet length [int]
		// Include data hash [int]
		// Command (no clue) [int]
		// Append existing data
		if (msg instanceof byte[]) {
			byte[] src = (byte[]) msg;
			byte[] output = new byte[src.length + 5];
			output[0] = 0x5E;
			output[1] = (byte) (src.length & 0xFF);
			output[2] = (byte) (src.length >>> 8 & 0xFF);
			output[3] = (byte) (src.length >>> 16 & 0xFF);
			output[4] = (byte) (src.length >>> 24 & 0xFF);
			System.arraycopy(src, 0, output, 5, src.length);
			System.out.println(HexTool.toString(output));
			out.write(IoBuffer.wrap(output));
		}
	}
}