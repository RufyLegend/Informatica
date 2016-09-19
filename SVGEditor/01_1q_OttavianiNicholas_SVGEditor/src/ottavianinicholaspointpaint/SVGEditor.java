package ottavianinicholaspointpaint;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * La classe definisce l'interfaccia grafica dell'aplica
 * @author Ottaviani Nicholas 4CI
 * @date 19 set 2016 16:05:09
 * @version 0.1
 */
public class SVGEditor extends JFrame {
	//DAIIII
	private final String TITLE = "SVGEditor";
	private final int WIDTH = 500;
	private final int HEIGHT = 500;
	protected JMenuBar menubar;
	protected JMenu file;
	protected JMenuItem exit;
	protected JMenuItem open;
	protected JMenuItem save;
	
	/**
	 * Costruttore
	 */
	public SVGEditor(){
		createGUI();
	}
	
	/**
	 * Crea la grafica
	 */
    private void createGUI() {
    	
    	//Frame principaale
    	setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        createMenuBar();
    }

    private void createMenuBar() {
    	
    	//MenuBar
        menubar = new JMenuBar();
        
        file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        
        open = new JMenuItem("Open");
        open.setMnemonic(KeyEvent.VK_O);
        
        save = new JMenuItem("Save");
        save.setMnemonic(KeyEvent.VK_S);

        exit = new JMenuItem("Exit");
        exit.setMnemonic(KeyEvent.VK_E);
        exit.setToolTipText("Exit application");
        exit.addActionListener((ActionEvent event) -> {System.exit(0);});
        
        file.add(open);
        file.add(save);
        file.add(exit);

        menubar.add(file);

        setJMenuBar(menubar);
    }


}//classe
