package logstash_app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPasswordField;

/**
 *
 * @author Nicholas Ottaviani
 * @date 01 apr 2017 18:29:00
 * Crea la grafica e gestisce gli eventi ad essa associata
 */
public class Frame extends JFrame implements ActionListener {
	
	private BufferedWriter bw;
	private FileWriter fw;
	private String fileName = "";
	
	private JPanel contentPane;
	private JTextField campiTextField;
	private JTextField hostTextField;
	private JTextField pathTextField;
	private JTextField userNameTextField;
	private JTextField separatoreTextField;
	private JPasswordField passwordTextField;
	private JTextField indexTextField;
	private JTextField fileNameTextField;
	//Bottoni
	private JButton btnCarica;
	private JButton btnTest;
	private JButton btnScegli;	
	private JButton btnCreateConf;
	
	private boolean isConfigCreated = false;

	/**
	 * Create the frame.
	 */
	public Frame() {
		
		setTitle("Logstash Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 482);
		setResizable(false);
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
		hostTextField.setBounds(65, 146, 120, 20);
		contentPane.add(hostTextField);
		hostTextField.setColumns(10);
		
		JLabel lblPath = new JLabel("Path ");
		lblPath.setBounds(10, 80, 46, 14);
		contentPane.add(lblPath);
		
		pathTextField = new JTextField();
		pathTextField.setBounds(65, 77, 345, 20);
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
		
		JLabel lblSeparatore = new JLabel("Separatore");
		lblSeparatore.setBounds(439, 114, 71, 14);
		contentPane.add(lblSeparatore);
		
		separatoreTextField = new JTextField();
		separatoreTextField.setBounds(509, 111, 39, 20);
		contentPane.add(separatoreTextField);
		separatoreTextField.setColumns(10);
		
		btnCreateConf = new JButton("Genera Configurazione");
		btnCreateConf.setBounds(365, 222, 181, 33);
		btnCreateConf.addActionListener(this);
		contentPane.add(btnCreateConf);
		
		btnTest = new JButton("Test");
		btnTest.setBounds(365, 275, 181, 33);
		btnTest.addActionListener(this);
		contentPane.add(btnTest);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(86, 281, 86, 20);
		contentPane.add(passwordTextField);
		
		JLabel lblIndex = new JLabel("Index");
		lblIndex.setBounds(200, 149, 52, 14);
		contentPane.add(lblIndex);
		
		indexTextField = new JTextField();
		indexTextField.setBounds(245, 146, 120, 20);
		contentPane.add(indexTextField);
		indexTextField.setColumns(10);
		
	    btnScegli = new JButton("...");
		btnScegli.setBounds(439, 76, 71, 20);
		btnScegli.addActionListener(this);
		contentPane.add(btnScegli);
		
		fileNameTextField = new JTextField();
		fileNameTextField.setBounds(503, 146, 146, 20);
		contentPane.add(fileNameTextField);
		fileNameTextField.setColumns(10);
		
		JLabel lblFileConfiggurazione = new JLabel("Nome configurazione");
		lblFileConfiggurazione.setBounds(375, 149, 135, 14);
		contentPane.add(lblFileConfiggurazione);
		
	    btnCarica = new JButton("Carica");
		btnCarica.setBounds(365, 327, 181, 33);
		btnCarica.addActionListener(this);
		contentPane.add(btnCarica);
	}

	/**
	 * Gestisce gli eventi
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Quando viene premuto il bottone Crea Configurazione
		if(e.getSource().equals(btnCreateConf)){
			if(checkFields()){//Controlla se tutti i campi sono stati riempiti
				fileName = fileNameTextField.getText();
				scriviInput();
				scriviFilter();
				scriviOutput();
				JOptionPane.showMessageDialog(this,"Configurazione creata con successo!");
				isConfigCreated = true;
			}
		}
		//Quando viene premuto il bottone Test
		if(e.getSource().equals(btnTest)){
			testConfig();
		}
		//Apre la finestra per la scelta del file
		if(e.getSource().equals(btnScegli)){
			sfoglia();
		}
		//Bottone carica
		if(e.getSource().equals(btnCarica)){
			carica();
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
			
			char[] pass = passwordTextField.getPassword();
			String password = new String(pass);
			
			String output = "\noutput{\nelasticsearch{\nindex =>"+'"'+indexTextField.getText()+'"'+"\nhosts =>"+'"'+"["+hostTextField.getText()+"]"+'"'+"\nuser => "+'"'+userNameTextField.getText()+'"' + 
					"\npassword => " + '"'+password+'"' + "\n} stdout{}\n}";
			
			bw.append(output);
			System.out.println("Scrittura Output Eseguita!");
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Divide i campi di campiJTextField e li inserisce in un arraylist
	 * @return comulms - arraylist contenete i campi     
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
	 * Esegue logstash per testare la configurazione
	 */
	public void testConfig(){
		
		if(isConfigCreated){//Se la configurazione è già stata creata
			Runtime rt = Runtime.getRuntime();
			try {
				rt.exec("cmd.exe /c start logstash.bat -f " + fileName + "-t");
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			JOptionPane.showMessageDialog(this, "Devi prima creare la configurazione");
		}
	}
	
	/**
	 * Controlla che tutti i campi siano inseriti prima di generare la configurazione
	 * @return boolean 
	 */
	public boolean checkFields(){
		
		String path = pathTextField.getText();
		String campi = campiTextField.getText();
		String host = hostTextField.getText();
		String separatore = separatoreTextField.getText();
		String userName = userNameTextField.getText();
		String fileName = fileNameTextField.getText();
		char[] password = passwordTextField.getPassword();

		
		//Se tutti i campi sono stati inseriti ritorna true
		if(path.equals("") || campi.equals("") || host.equals("")  || separatore.equals("") || userName.equals("") || password.equals("") || fileName.equals("")){
			JOptionPane.showMessageDialog(this, "Inserisci tutti i campi!");
			return false;
		}
		else{
			return true;
		}
	}
	
	/**
	 * Apre la finestra per scegliere il il file da caricare
	 */
	public void sfoglia(){
		
		JFileChooser fc = new JFileChooser ();
		int response = fc.showOpenDialog(null);

		if(response == JFileChooser.APPROVE_OPTION){
		   String stringa = fc.getSelectedFile().getPath();
		   pathTextField.setText(stringa);
		}
	}
	
	/**
	 * Esegue logstash per caricare i dati											
	 */
	public void carica(){
		
		if(isConfigCreated){
			Runtime rt = Runtime.getRuntime();
			try {
				rt.exec("cmd.exe /c start logstash.bat -f " + fileName +  "-r");
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			JOptionPane.showMessageDialog(this, "Devi prima creare la configurazione");
		}			
	}
}//Classe
