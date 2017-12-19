package br.furb.dss;

import java.io.IOException;
import java.util.Arrays;

public class ListeningServer extends Thread {

	private ServerSocket server;
	private MessageEncryptor encryptor;

	public ListeningServer(ServerSocket server, MessageEncryptor encryptor) throws Exception {
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

		while (true) {

			EncryptedMessage encMsg = (EncryptedMessage) server.getIn().readObject();

			String msg = encryptor.decryptMessage(encMsg);

			System.out.println(msg);

		}

	}

	private void parsePacket(String msg) throws Exception {

	}

}
