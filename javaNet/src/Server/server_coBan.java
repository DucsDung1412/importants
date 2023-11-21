package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server_coBan {
	public static void main(String[] args) throws Exception {
		String string = "";
		ServerSocket ss = new ServerSocket(3306);
		
		Socket s = ss.accept();
		
		DataInputStream dis = new DataInputStream(s.getInputStream());
		
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		
		while(true) {
			string = dis.readUTF();
			if(string.equals("") || string == null) {
				break;
			}
			String xuLy = string.toUpperCase();
			
			dos.writeUTF(xuLy);
			dos.flush();
		}
	}
}
