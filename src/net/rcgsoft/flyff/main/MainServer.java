/*
 *    This file is part of Java-FlyFF, a FlyFF Java based emulator.
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

package net.rcgsoft.flyff.main;

public final class MainServer {
	private static final MainServer INSTANCE = new MainServer();

	private MainServer() {
		// singleton
	}

	public static final MainServer getInstance() {
		return INSTANCE;
	}

	public static final void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}