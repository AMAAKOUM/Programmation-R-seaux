package ArchitectureClientServeur;
import java.io.*;
import java.net.*;

public class Service extends Thread {
	 static private int incarnations;
	 Socket socket;
	 BufferedReader reader;
	 int MyIncarnation;
	 
	 Service(Socket socket) throws IOException {
		 this.socket = socket;
		 reader = new BufferedReader(
				 new InputStreamReader(socket.getInputStream()));
		 MyIncarnation = incarnations++;
		 System.out.println("New Service: " + MyIncarnation);				 
				 
	 }
	 public void run() {
		 boolean execute = true;
		 while(execute) {
			 try {
				 String s = reader.readLine();
				 if (s == null) 
					 execute = false;
				 else 
					 System.out.println("Service "+MyIncarnation + " a lu message: " + s);				 
			 }catch(IOException e) {
				 execute = false;
				 System.err.println("Erreur de lecture");
			 }
		 }
		 try {
			 socket.close();			 
		 } catch(IOException e) {
			 System.err.println("Erreur de fermeture");
		 }
		 System.out.println("Service "+MyIncarnation+" terminé");
	 } 
	

}
