package logstash_app;

import java.awt.EventQueue;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Nicholas Ottaviani
 * @date 03 apr 2017 15:38:04
 */
public class LogstashProgram {
	
	/**
	 * Start the application
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
