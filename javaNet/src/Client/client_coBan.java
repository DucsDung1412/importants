package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client_coBan {
	public static void main(String[] args) throws Exception {
		String string = "";
		Socket s = new Socket("localhost", 3306);
		
		DataInputStream dis = new DataInputStream(s.getInputStream());
		
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		
		while(true) {
			string = new Scanner(System.in).nextLine();
			dos.writeUTF(string);
			dos.flush();
			
			string = dis.readUTF();
			
			System.out.println(string);
			
			if(string.equals("") || string == null) {
				break;
			}
		}
	}
}
