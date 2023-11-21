/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB_7;

/**
 *
 * @author AnhVy
 */
import java.io.*;
import java.net.*;

class TCPServer {

    public static void main(String argv[]) throws Exception {
        String clientSentence;
        String capitalizedSentence;
        
        /* Tao Server Socket lắng nghe port 6789 */
        ServerSocket welcomeSocket = new ServerSocket(6789);
        System.out.println("Server is running ...");
        System.out.println("Wait client at port 6789  ...");
        
        /* Tạo Client Socket nhận dữ liệu từ Client qua port 6789 */
        Socket connectionSocket = welcomeSocket.accept();
        
        /* Lấy InpuStream của Client Socket để đọc dữ liệu */
        BufferedReader inFromClient=
                  new BufferedReader(
                  new InputStreamReader(connectionSocket.getInputStream()));
        /* Lấy OutputStream của Client Socket để gửi dữ liếu */
        DataOutputStream outToClient
                    = new DataOutputStream(connectionSocket.getOutputStream());
            
        /* vong lặp trao doi dữ liệu */
        while (true) {         
            clientSentence = inFromClient.readLine();
            if (clientSentence!=null) {
                System.out.println("Receiving from Client ... "+ clientSentence);
                capitalizedSentence = clientSentence.toUpperCase() + '\n';
                outToClient.writeBytes(capitalizedSentence); 
            }
            else break;
        }
        /* ket thúc */
        welcomeSocket.close();
    }
}

