package ArchitectureClientServeur;
import java.io.*;
import java.net.*;

public class Serveur {
	public static int Port = 11111;
	public static void main(String[] args) {
		try {
			ServerSocket socket;
			socket = new ServerSocket(Serveur.Port);
			while(true) {
				new Service(socket.accept()).start();
			}			
		}catch(IOException e) {
			System.err.println("Probleme d'acquisition socket de service");
			System.exit(1);
		}

	}

}
