package br.furb.dss;

public class Main {

	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket();
		
		ClientKeys keys = initiateSession(server);
		
		MessageEncryptor msgEncryptor = new MessageEncryptor(keys);

		ListeningServer listening = new ListeningServer(server, msgEncryptor);

		ListeningConsoleInput listeningInput = new ListeningConsoleInput(server, msgEncryptor);

		listening.start();
		listeningInput.start();

	}

	private static ClientKeys initiateSession(ServerSocket server) throws Exception {
		return ClientSessionInitiation.getInstance(server).startSession();
	}

}
