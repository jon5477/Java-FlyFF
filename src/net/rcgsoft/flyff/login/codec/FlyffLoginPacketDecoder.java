package net.rcgsoft.flyff.login.codec;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public final class FlyffLoginPacketDecoder extends CumulativeProtocolDecoder {
	/*
	 * Information retrieved from:
	 * http://forum.ragezone.com/f457/flyff-packet-breakdown-488888/
	 */

	@Override
	protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		if (in.get() != 0x5E) {
			// Invalid packet
			return false;
		}
		// TODO Auto-generated method stub
		return false;
	}
}