package serverclientobjectövning; 

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ServerClientObjectÖvning {
	Socket socket;
	ObjectInputStream inr;
	ObjectOutputStream out;
	Card incommingCard;
	String input = new String();

	public ServerClientObjectÖvning() {
		try {
			socket = new Socket("127.0.0.1", 1026);
			out = new ObjectOutputStream(socket.getOutputStream());
			inr = new ObjectInputStream(socket.getInputStream());
			
			Scanner sc = new Scanner(System.in);
			System.out.println("What card are you looking for?");
			input = sc.nextLine();
			out.writeObject(input);
			
			while((incommingCard = (Card)inr.readObject()) != null) {
				System.out.println(incommingCard.getName() + " costs " + incommingCard.getCost() + ".\nIs it foil: " + incommingCard.isFoil());
			}
		}
		catch (IOException ex) {
			System.out.println("Could not connect to server.");
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Could not find class.");
		}
	}

    public static void main(String[] args) {
        ServerClientObjectÖvning a = new ServerClientObjectÖvning();
    }
}