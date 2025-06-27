package ArchitectureClientServeur;
import java.io.*;
import java.net.*;
public class Client {

	public static void main(String[] args) {
		Socket socket;
		PrintWriter write;
		
		try {
			socket = new Socket("localhost", Serveur.Port);
			write = new PrintWriter(socket.getOutputStream(), true);
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(5000);
					String buf = "Voila un Nombre " + i;
					System.out.println("J envoie " + buf);
					write.println(buf);
				}catch (InterruptedException e) {
					System.err.println("Interrupted IO");
				}
			}
			socket.close();
		}catch(UnknownHostException e) {
			System.err.println("Localhost /??");
			System.exit(1);			
		} catch (IOException e) {
			System.err.println("Probleme d'acquisition sortie");
			System.exit(1);
		}
		
	}

}
