package logstash_app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Nicholas Ottaviani
 * @date 03 apr 2017 15:38:04
 */
public class ParserClass {
	
	
	protected static String fileName = "prova_config.conf";
	protected static BufferedWriter bw;
	protected static FileWriter fw;
	
	public void scriviInput(){
		try {
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			bw.write("Funzia!");
			System.out.println("Scrittura Eseguita!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
