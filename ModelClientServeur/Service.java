package ModelClientServeur;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class Service extends Thread {
	Socket socket;
	BufferedReader entree;
	PrintStream sortie;
	
	Service (Socket socket) throws IOException{
		this.socket = socket;
		try {
			entree = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			sortie = new PrintStream(socket.getOutputStream());
			this.start();
		} catch (IOException e) {			
				socket.close();			
		}
	}
	
	public void run() {
		String texte;
		int compteur = 0;
		try {
			while (!(texte = entree.readLine()).equals("*+*+*+*+*+*+*+"))
				compteur += (new StringTokenizer(texte, " ,.;:_-+*/\\.;\"'{}()=><\t!\n")).countTokens();
			sortie.println("Votre texte possede " + compteur + "mots");
			sortie.close();
			entree.close();
			socket.close();
		} catch (IOException e) {}
		
	}

}
