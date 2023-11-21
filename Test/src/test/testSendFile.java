package test;

import java.io.*;
import java.net.*;

public class testSendFile {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started. Listening on port 1234.");

        while (true) {
//            Socket socket = serverSocket.accept();
//            System.out.println("Client connected.");
//
//            InputStream inputStream = socket.getInputStream();
//            byte[] buffer = new byte[4096];
//            int bytesRead;
//            
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                byteArrayOutputStream.write(buffer, 0, bytesRead);
//            }
//
//            // Save the received file
//            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Admin\\OneDrive\\Desktop\\testSaveFile");
//            fileOutputStream.write(byteArrayOutputStream.toByteArray());
//
//            fileOutputStream.close();
//            byteArrayOutputStream.close();
//            inputStream.close();
//            socket.close();
        	
        	Socket sk = serverSocket.accept();
        	
        	InputStream is = sk.getInputStream();
        	byte[] bytes = new byte[4096];
        	int i;
        	
        	ByteArrayOutputStream baos = new ByteArrayOutputStream();
        	
        	while((i = is.read(bytes)) != -1) {
        		baos.write(bytes, 0, i);
        	}
        	
        	FileOutputStream f = new FileOutputStream("C:\\Users\\Admin\\OneDrive\\Desktop\\testSaveFile");
        	f.write(baos.toByteArray());
        	f.close();
        	baos.close();
        	is.close();
        	sk.close();
        	
            System.out.println("File saved.");
        }
    }
}
