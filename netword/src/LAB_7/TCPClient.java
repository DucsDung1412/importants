/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB_7;

import java.io.*;
import java.net.*;
import java.util.Scanner;

class TCPClient {

    public static void main(String argv[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        String sentence;
        String modifiedSentence;
        
        /* Tao Client Socket lắng nghe port 6789 */ 
        Socket clientSocket = new Socket("localhost", 6789);
        
        /* Lấy OutpuStream của Client Socket để gưi dữ liếu */
        DataOutputStream outToServer
                = new DataOutputStream(clientSocket.getOutputStream());
        
        /* Lấy InputStream của Client Socket để nhan dữ liếu */
        BufferedReader inFromServer=
      new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        /* vòng lăp trao doi thong tin */
        do {
            System.out.print("Input : ");
            sentence = sc.nextLine();
            if (!sentence.isEmpty()) {
                System.out.println("Will send to server " + sentence);
                outToServer.writeBytes(sentence + '\n'); // gui toi server
     
                modifiedSentence = inFromServer.readLine(); // nhan tu server
                System.out.println("\nFROM SERVER: " + modifiedSentence);
                //System.out.println(inFromServer.readLine());
            }
        } while (!sentence.isEmpty());
        
        clientSocket.close();
    }
}
