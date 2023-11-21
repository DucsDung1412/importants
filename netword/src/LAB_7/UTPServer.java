/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB_7;

import java.net.DatagramPacket;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
public class UTPServer {

    public static void main(String args[]) throws Exception {
        /* Tạo Doi tượng gửi/nhận thông tin qua port 1234 */
        DatagramSocket serverSocket = new DatagramSocket(1234);
        /* khai báo kích thước dữ liệu nhận */
        byte[] receiveData = new byte[1024];
        /* khai báo kích thước  dữ liệu gửi */
        byte[] sendData = new byte[1024];
        /* vong lặp trao đổi */
        System.out.println("Waiting for Client ...");
        while (true) {
            /* Chuẩn bị gói dữ liệu nhận */
            DatagramPacket receivePacket
                    = new DatagramPacket(receiveData, receiveData.length);
            /* nhận gói dũ liệu */
            serverSocket.receive(receivePacket);
            /* mở gói để lấy thông tin */
            String sentence = new String(receivePacket.getData());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            /* xử lý dữ liệu */
            String capitalizedSentence = sentence.toUpperCase();
            /* CHuẩn bị dữ liệu gửi */
            sendData = capitalizedSentence.getBytes();
            /* đóng gói thông tin vào gói gửi */
            DatagramPacket sendPacket
                    = new DatagramPacket(sendData, sendData.length, IPAddress,
                            port);
            serverSocket.send(sendPacket);
        }
    }
}


