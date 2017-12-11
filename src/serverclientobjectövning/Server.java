package serverclientobjectövning; 

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	ServerSocket serverSocket;
	Socket clientSocket;
	ObjectInputStream in;
	ObjectOutputStream out;
	String incomingObject;
	
	List<Card> listOfCards = new ArrayList<>();

	public Server() {
		try {
			listOfCards.add(new Card("Cancel", 3, true));
			listOfCards.add(new Card("Smite", 1, false));
			listOfCards.add(new Card("Giant Growth", 1, true));
			listOfCards.add(new Card("Warp", 1, false));
			
			serverSocket = new ServerSocket(1026);
			clientSocket = serverSocket.accept();
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			in = new ObjectInputStream(clientSocket.getInputStream());
			
			while((incomingObject = in.readObject().toString().trim()) != null) {
				for (Card card : listOfCards) {
					if(incomingObject.equalsIgnoreCase(card.getName())) {
						System.out.println(card.getName());
						out.writeObject(card);
					}
				}
			}
		}
		catch (IOException ex) {
			System.out.println("Lost connection.");
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Could not find class.");
		}
	}

    public static void main(String[] args) {
        Server a = new Server();
    }
}
