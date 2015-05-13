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

import java.io.ByteArrayOutputStream;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tools.HexTool;

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
		System.out.println(HexTool.toString((byte[]) message));
		/*
		5E
		
		17 3D 4C 17
		
		BB 02 00 00
		
		CD 48 2A FB
		
		[FC 00 00 00] // opcode (login request)
		
		[08 00 00 00] [30 30 30 30 30 30 30 30]
		
		[07 00 00 00] [6A 6F 6E 35 34 37 37 51]
		
		F1 83 A4 D2 B7 11 75 41
		63 BC 7F 79 5E 4D EE 97
		00 0D 94 13 D9 FD 3C BB
		BB 72 BA E1 EE D8 C9 10
		
		82 C8
		
		C8 CD B4 25 62 53 14 17
		CA 2A 55 09 59 B8 EA B1
		A2 D8 90 FE 5E 3A E6 2C
		50 12 B7 80 68 20 63 19
		BD 6A 7C F3 7D 75 49 45
		D8 B4
		
		F9 6D 88 9F 09 01 9A B9
		9F 08 9D 08 1B A2 43 5E
		6B F3 CF 8A 71 49 A2 FE
		5A B7 F8 E0 C8 85 69 43
		39 01 0A 82 09 DB 30 A4
		A4 C8 23 6F 98 B0 2D 64
		E3 CA 5F A6 0B C8 C3 FC
		71 EF F4 64 64 3E 0E 86
		38 C0 50 F0 A6 B2 E7 BB
		5E 41 F4 0F 1A 56 C9 7A
		A8 32 11 50 16 FC 58 FF
		3D B5 BF B6 DD 19 E3 77
		A5 90 03 01 27 97 01 D4
		A9 F8 76 FC 2C 3B 6F 56
		1B 06 25 CF 56 7A B7 F2
		6B 1D 4B C6 71 C2 96 26
		D5 1A 77 FD A5 68 14 19
		D7 CF AA B9 B8 1E D3 F4
		D9 A8 56 52 31 2B 74 A1
		0D 78 74 C5 11 54 C1 03
		5E 9A 4F 6A 0E AD BB FA A7 86 88 A6 B9 B2 94 A1 EA CB D0 C9 F3 5C 40 56 EF F9 AC A9 2A 4D 34 FB 7A AB AE 09 93 F8 09 0A 02 8F FC 12 7F FE FA 7C 2D 56 0E 7C FA 43 13 A0 04 32 6E 86 0A F0 C4 7C 3F 97 E2 2D 95 BD EF F2 E5 F4 7E EB 18 80 A7 F6 16 80 12 3E 66 40 6F 16 7B 1D 75 3E 73 83 DB FD B7 EF 9D 94 4F 52 44 EE 33 7A F8 A1 C4 7E B8 C9 C1 F5 4A 8B 4C 90 3D 14 09 54 DD E4 75 66 34 B2 41 2F AD 34 34 53 53 BE 14 5C 86 A0 0C 77 AD E2 FC AB 3D AB 88 2D 0C 0B 4A FA 9C 3C 88 BA B9 E5 C1 C7 1A 46 D0 0F 83 D3 81 DC C6 8B B7 FB 9A C6 61 77 FD 54 C6 22 CA 52 74 30 0F 5F 32 09 0A 07 C0 78 DC 11 5C 4B 3A B7 BF A5 C3 DE FD 4D 5D CE AB AB 72 81 7C D5 14 94 24 6B 41 12 F0 F3 B1 74 8F 75 BA EC F7 54 47 4D 20 37 EF D8 35 EC A7 1F 4B AB 51 21 22 4D 7F 34 D8 C7 8A 2E E2 51 CE 8D F1 36 A2 19 89 E6 3B 71 23 2E 4C C6 44 5D 4A 43 E2 07 91 2B 2C 4E EA 5E E0 D9 08 1A CA 40 FD 8F ED 4A A9 92 00 FE AA A4 C8 07 8F A3 64 77 66 76 77 AA 02 2F 9B 7F 9B F9 3F 03 3A 67 46 19 1B FC 69 E3 87 B8 9E 78 3F E5 8D FA 6A 66 B1 B6 F1 F0 C3 1E 8F 58 E4 F6 06 64 20 4D 10 44 19 84 D8 B1 44 F0 79 BD 31 3E FC E0 B8 0B FE 18 8A 54 F9 8D C2 C0 B1 9F 4D 99 06 F9 58 70 81 D4 57 67 48 BE FD F8 7E BE 14 B8 9E 58 5A 72 4F E4 66 35 E2 3C 65 1E 8D 59 B7 8B 94 6B A4 06 23 F4 F3 56 22 E3 22 F3 D8 25 B0 42 82 E7 A5 20 DA 80 12 4F 14 78 9A 42 DF
		*/
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
		System.out.println("Created: " + session.getRemoteAddress());
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Opened: " + session.getRemoteAddress());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		for (int i = 0; i < 4; i++) {
			baos.write(0);
		}
		baos.write(1);
		for (int i = 0; i < 3; i++) {
			baos.write(0);
		}
		session.write(baos.toByteArray());
	}
}