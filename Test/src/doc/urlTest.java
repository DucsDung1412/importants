/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhVy
 */
public class urlTest {
    public static void main(String[] args) {
        try {
            //URL url = new URL("http://www.xyz.com:80/abc/page.do?x=5&b=7#xxx");
            URL url = new URL("https://nld.com.vn:81/thoi-su.htm");
            System.out.println("Protocol : " + url.getProtocol());
            System.out.println("Host : " + url.getHost());
            System.out.println("Path : "+url.getPath());
            System.out.println("File : "+url.getFile());
            System.out.println("Port : "+url.getPort());
            System.out.println("Query : " + url.getQuery());
            System.out.println("Reference : " + url.getRef());
        } catch (MalformedURLException ex) {
            Logger.getLogger(urlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
