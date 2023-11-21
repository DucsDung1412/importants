//package googleAPI;
//
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
//import com.google.api.client.http.HttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.jackson2.JacksonFactory;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Arrays;
//
//public class GoogleSignInExample extends JPanel {
//    // Replace with your own Client ID and Client Secret obtained from the Google Developer Console.
//    private static final String CLIENT_ID = "739747427774-2ab3trhbcbdjakt4l1diqv6s0fq6etb4.apps.googleusercontent.com";
//    private static final String CLIENT_SECRET = "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";
//    private static final String REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";
//
//    // JSON factory and HTTP transport
//    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
//    private static final HttpTransport HTTP_TRANSPORT = new com.google.api.client.http.javanet.NetHttpTransport();
//
//    public GoogleSignInExample() {
//        initComponents();
//    }
//
//    private void initComponents() {
//        JButton signInButton = new JButton("Login with Google");
//        signInButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                GoogleAuthorizationCodeFlow flow = getFlow();
//
//                // Create an authorization URL and prompt the user to visit it.
//                GoogleAuthorizationCodeRequestUrl authorizationUrl = flow.newAuthorizationUrl().setRedirectUri(REDIRECT_URI);
////                System.out.println("Please visit the following URL to grant permission: \n" + authorizationUrl.build());
//                // Open the authorization URL in the default web browser.
//                Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
//                try {
//                    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
//                        desktop.browse(authorizationUrl.toURI());
//                    } else {
//                        JOptionPane.showMessageDialog(GoogleSignInExample.this,
//                                "Please visit the following URL to grant permission: \n" + authorizationUrl.build(),
//                                "Open URL in Browser", JOptionPane.INFORMATION_MESSAGE);
//                    }
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//
//                // Prompt the user to enter the authorization code received after granting permission.
//                String code = JOptionPane.showInputDialog(null, "Enter the authorization code:");
//                if (code != null) {
//                    // Exchange the authorization code for an access token and refresh token.
//                    try {
//                        GoogleTokenResponse tokenResponse = flow.newTokenRequest(code).setRedirectUri(REDIRECT_URI).execute();
////                        String accessToken = tokenResponse.getAccessToken();
////                        String refreshToken = tokenResponse.getRefreshToken();
//
//                        // Now you can use the access token and refresh token to authenticate the user and store their information.
////                        System.out.println("Access Token: " + accessToken);
////                        System.out.println("Refresh Token: " + refreshToken);
//                        JOptionPane.showMessageDialog(null, "Login compelete");
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                }
//            }
//        });
//
////        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
////        setTitle("Google Sign-In Example");
//        setLayout(new FlowLayout());
//        add(signInButton);
////        pack();
////        setLocationRelativeTo(null); // Center the frame on the screen
//    }
//
//    private GoogleAuthorizationCodeFlow getFlow() {
//        try {
//            GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
//                    new FileReader("client_secret.json")); // Replace with the path to your client secrets JSON file.
//
//            return new GoogleAuthorizationCodeFlow.Builder(
//                    HTTP_TRANSPORT, JSON_FACTORY, clientSecrets,
//                    Arrays.asList("https://www.googleapis.com/auth/userinfo.email", "https://www.googleapis.com/auth/userinfo.profile"))
//                    .build();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new GoogleSignInExample().setVisible(true);
//            }
//        });
//    }
//}
