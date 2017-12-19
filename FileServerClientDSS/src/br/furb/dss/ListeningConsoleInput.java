package br.furb.dss;

import java.util.Scanner;

public class ListeningConsoleInput extends Thread {

	private ServerSocket server;
	private MessageEncryptor encryptor;

	public ListeningConsoleInput(ServerSocket server, MessageEncryptor encryptor) {
		this.server = server;
		this.encryptor = encryptor;
	}

	@Override
	public void run() {
		try {
			listen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void listen() throws Exception {

		Scanner sc = new Scanner(System.in);

		while (true) {

			String read = sc.nextLine();

			EncryptedMessage msg = encryptor.encryptMessage(read);

			server.getOut().writeObject(msg);
			server.getOut().flush();

		}
	}

}
