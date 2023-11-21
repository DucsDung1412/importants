/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhVy
 */
public class LocalHost {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress myHost, youHost;
        try {
            myHost = InetAddress.getLocalHost();
            JOptionPane.showMessageDialog(null, 
                    myHost.getHostName()+"\n"+
                    myHost.getHostAddress());
                    
            youHost = InetAddress.getByName("www.tuoitre.vn");
            JOptionPane.showMessageDialog(null, 
                    youHost.getHostName()+"\n"+
                    youHost.getHostAddress());             
        } catch (UnknownHostException ex) {}
        
        InetAddress[]  ads = InetAddress.getAllByName("www.vnexpress.vn");
        for (InetAddress ia : ads)
            System.out.println(ia.getHostAddress());
    }
}
