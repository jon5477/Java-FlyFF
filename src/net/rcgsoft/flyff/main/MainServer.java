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