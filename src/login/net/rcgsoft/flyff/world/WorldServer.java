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

package net.rcgsoft.flyff.world;

public final class WorldServer {
	private static final WorldServer INSTANCE = new WorldServer();

	private WorldServer() {
		// singleton
	}

	public static final WorldServer getInstance() {
		return INSTANCE;
	}

	public static final void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}