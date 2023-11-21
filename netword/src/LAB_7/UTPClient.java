/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class UTPClient {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                /* Tạo Doi tượng gửi/nhận thông tin qua port 1234 */
                DatagramSocket clientSocket = new DatagramSocket();
                // Lấy địa chỉ sẽ gửi đến */
                InetAddress IPAddress = InetAddress.getByName("localhost");
                /* chuẩn bĩ dữ liệu gửi */
                byte[] sendData = new byte[1024];
                System.out.print("Input : ");
                String sentence = sc.nextLine();
                if (sentence.isEmpty()) {
                    break;
                }
                System.out.println("Client say : " + sentence );
                sendData = sentence.getBytes();
                /* DOng goi du lieu gui */
                DatagramPacket sendPacket =
                new DatagramPacket(sendData, sendData.length, IPAddress, 1234);
                /* gửi đi */
                clientSocket.send(sendPacket);
                
                /* Nhan du lieu tu server */
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket =
                new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                /* xử lý dữ liệu nhận */
                String modifiedSentence =
                new String(receivePacket.getData());
                System.out.println("FROM SERVER:" + modifiedSentence);
                
                clientSocket.close();
            }
        } catch (SocketException ex) {}
    }
}
