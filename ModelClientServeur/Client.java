package ModelClientServeur;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		int portEcouteServeur = 10350;
		BufferedReader lecteurFichier;
		BufferedReader entree;
		PrintStream sortie;
		String ligne;
		Socket socket;
		
		try {
			socket = new Socket(args[1], portEcouteServeur);
			lecteurFichier = new BufferedReader(new FileReader(args[0]));
			entree = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			sortie = new PrintStream(socket.getOutputStream());
			while ((ligne = lecteurFichier.readLine()) != null ) sortie.println(ligne);
			sortie.println("*+*+*+*+*+*+*+");
			System.out.println(entree.readLine());
			sortie.close();
			entree.close();
			socket.close();
			
		}catch(FileNotFoundException exc ) {
			System.out.println("Fichier introuvable");
		}
		catch (UnknownHostException exc) {
			System.out.println("Destinaire inconnu");
		}
		catch (IOException exc ) {
			System.out.println("Probleme E/S");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
