package net.rcgsoft.flyff.login;

public final class LoginServer {
	private static final LoginServer INSTANCE = new LoginServer();

	private LoginServer() {
	}

	public static final LoginServer getInstance() {
		return INSTANCE;
	}

	public static final void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}