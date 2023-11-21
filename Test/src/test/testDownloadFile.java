package test;

import java.io.*;
import java.net.*;
import java.nio.file.Files;

public class testDownloadFile {
    public static void main(String[] args) throws IOException {
//        Socket socket = new Socket("localhost", 1234);
//
//        File file = new File("C:\\Users\\Admin\\OneDrive\\Desktop\\aoma\\file.txt");
//        byte[] bytes = Files.readAllBytes(file.toPath());
//
//        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write(bytes, 0, bytes.length);
//
//        outputStream.close();
//        socket.close();
    	
    	Socket sk = new Socket("localhost", 1234);
    	
    	OutputStream os = sk.getOutputStream();
    	
    	File f = new File("C:\\Users\\Admin\\OneDrive\\Desktop\\aoma\\file.txt");
    	byte[] bytes = Files.readAllBytes(f.toPath());
    	
    	os.write(bytes, 0, bytes.length);
    	os.close();
    	sk.close();

        System.out.println("File sent.");
    }
}
