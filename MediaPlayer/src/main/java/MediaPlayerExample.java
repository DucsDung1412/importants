import javafx.application.Platform;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.awt.BorderLayout;

import javax.swing.*;
public class MediaPlayerExample {
	public static void main(String[] args) {
        JFrame frame = new JFrame("Media Player Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);


        frame.setSize(621, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        Platform.runLater(() -> {
        	Media media = new Media("file:///C:/Users/Admin/Videos/asd.mp4");
        	MediaPlayer mediaPlayer = new MediaPlayer(media);
        	MediaView mediaView = new MediaView(mediaPlayer);
        	Scene scene = new Scene(new Group(mediaView));
        	fxPanel.setScene(scene);
        	mediaPlayer.play();
        });
    }
}
