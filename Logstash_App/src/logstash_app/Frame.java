package logstash_app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;

/**
 *
 * @author Nicholas Ottaviani
 * @date 01 apr 2017 18:29:00
 * Crea la grafica e gestisce gli eventi ad essa associata
 */
public class Frame extends JFrame implements ActionListener {
	
	
	private BufferedWriter bw;
	private FileWriter fw;
	private String fileName = "prova_config.conf";
	
	private JPanel contentPane;
	private JTextField campiTextField;
	private JTextField hostTextField;
	private JTextField pathTextField;
	private JTextField userNameTextField;
	private JTextField passwordTextField;
	private JTextField separatoreTextField;
	//Bottoni
	private JButton btnCarica;
	private JButton btnTest;

	/**
	 * Launch the application.
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

	/**
	 * Create the frame.
	 */
	public Frame() {
		setTitle("Logstash Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 482);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCarica = new JMenuItem("Carica");
		mnNewMenu.add(mntmCarica);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCaricaFileIn = new JLabel("Carica file in formato CSV");
		lblCaricaFileIn.setBounds(5, 5, 672, 20);
		lblCaricaFileIn.setFont(new Font("Liberation Sans", Font.PLAIN, 17));
		lblCaricaFileIn.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCaricaFileIn);
		
		JLabel lblCampi = new JLabel("Campi");
		lblCampi.setBounds(10, 105, 45, 33);
		contentPane.add(lblCampi);
		
		campiTextField = new JTextField();
		campiTextField.setBounds(65, 111, 345, 20);
		contentPane.add(campiTextField);
		campiTextField.setColumns(10);
		
		JLabel lblHost = new JLabel("Host");
		lblHost.setBounds(10, 149, 46, 14);
		contentPane.add(lblHost);
		
		hostTextField = new JTextField();
		hostTextField.setBounds(65, 146, 86, 20);
		contentPane.add(hostTextField);
		hostTextField.setColumns(10);
		
		JLabel lblPath = new JLabel("Path ");
		lblPath.setBounds(10, 80, 46, 14);
		contentPane.add(lblPath);
		
		pathTextField = new JTextField();
		pathTextField.setBounds(65, 77, 171, 20);
		contentPane.add(pathTextField);
		pathTextField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 259, 71, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 284, 71, 14);
		contentPane.add(lblPassword);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(86, 255, 86, 20);
		contentPane.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(86, 281, 86, 20);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JLabel lblSeparatore = new JLabel("Separatore");
		lblSeparatore.setBounds(439, 114, 71, 14);
		contentPane.add(lblSeparatore);
		
		separatoreTextField = new JTextField();
		separatoreTextField.setBounds(509, 111, 39, 20);
		contentPane.add(separatoreTextField);
		separatoreTextField.setColumns(10);
		
		btnCarica = new JButton("Genera Configurazione");
		btnCarica.setBounds(365, 222, 155, 33);
		btnCarica.addActionListener(this);
		contentPane.add(btnCarica);
		
		btnTest = new JButton("Test");
		btnTest.setBounds(365, 275, 155, 33);
		btnTest.addActionListener(this);
		contentPane.add(btnTest);
	}

	/**
	 * Gestisce gli eventi
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Quando viene premuto il bottone Crea Configurazione
		if(e.getSource().equals(btnCarica)){
			scriviInput();
			scriviFilter();
			scriviOutput();
		}
		
		//Quando viene premuto il bottone Test
		if(e.getSource().equals(btnTest)){
			checkFields();
			//testConfig();
		}
	}
	
	
	/**
	 * Scrive la sezione dell'input nel file di configurazione di logstash
	 */
	public void scriviInput(){
		
		try {
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			bw.write("input{\nfile{\npath => " + '"'+pathTextField.getText()+'"'+"\nstart_position => beginning\n}\n}");
			System.out.println("Scrittura Input Eseguita!");
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Srive la sezione filter nel file di configurazione di logstash
	 */
	public void scriviFilter(){
		
		try {
			fw = new FileWriter(fileName, true);//Append mode
			bw = new BufferedWriter(fw);
			ArrayList<String> campi  = splitColumns();
			String app = '"' + campi.get(0) + '"';
			campi.remove(0);
			int j = 0;
			
			//Crea la string con tutti i campi formattata per essere scritta come "campo1","campo2", ecc
			for(String element : campi){
				app = app + ',' + '"' + campi.get(j) + '"';
				j++;
				
			}
			
			String filter = "\nfilter{\ncsv{\ncolumns => [" + app + "]\n separator => "+'"'+separatoreTextField.getText()+'"'+"\n}\n}";
			bw.append(filter);
			System.out.println("Scrittura Filter Eseguita!");
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	
	
	/**
	 * Scrive la sezione output nel file di configurazione di logstash
	 */
	public void scriviOutput(){
		
		try {
			fw = new FileWriter(fileName, true);//Append mode
			bw = new BufferedWriter(fw);
			
			String output = "\noutput{\nfile{\nelasticsearch{\nindex =>"+'"'+'"'+"\nhosts =>"+'"'+"["+hostTextField.getText()+"]"+'"'+"\nuser => "+'"'+userNameTextField.getText()+'"' + 
					"\npassword => " + '"'+passwordTextField.getText()+'"' + "\n} stdout{}\n}";
			
			bw.append(output);
			System.out.println("Scrittura Output Eseguita!");
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Divide i campi inseriti nel JTextField campi
	 * @return comulms 
	 */
	public ArrayList<String> splitColumns(){
		
		String[] columns = campiTextField.getText().split("\\,");
		ArrayList<String> campiString = new ArrayList<String>();
		int i = 0;
		for(String item : columns){
			campiString.add(columns[i]);
			i++;
		}
		return campiString;
	}
	
	/**
	 * Lancia logstash per testare la configurazione
	 */
	public void testConfig(){
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("cmd.exe /c start");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Controlla che tutti i campi siano inseriti prima di generare la configurazione
	 */
	public void checkFields(){
		
		String path = pathTextField.getText();
		String campi = campiTextField.getText();
		String host = hostTextField.getText();
		String separatore = separatoreTextField.getText();
		String userName= userNameTextField.getText();
		String password= passwordTextField.getText();
		//File Perk
		
		if(path.equals("") || campi.equals("") || host.equals("")  || separatore.equals("") || userName.equals("") || password.equals("")){
			JOptionPane.showMessageDialog(this,"Inserisci tutti i campi!");
		}
	}
	
	
	
	

}//Classe
