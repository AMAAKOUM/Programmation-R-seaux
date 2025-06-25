package ModelClientServeur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

	public static void main(String[] args) {
		int portEcoute = 10350;
		ServerSocket standariste;
		Socket socket;
		
		try {
			standariste = new ServerSocket(portEcoute);
			while (true) {
				socket = standariste.accept();
				new Service(socket);
			}
		}catch (IOException exc) {
			System.out.println("Probleme de connexion ");
		}

	}

}
