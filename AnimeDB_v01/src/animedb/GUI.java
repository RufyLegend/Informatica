package animedb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Crea e gestisce l'iterfaccia grafica
 * @author Nicholas Ottaviani
 * @date 24 feb 2017 16:59:41
 */
public class GUI implements ActionListener{
	
	//Proprietà finestra
	private String title = "MyAnimeList";
	private int width = 1000;
	private int height = 700;
	
	//Frame Principale
	protected JFrame frame;
	
	//Label campi
	protected JLabel titoloLabel;
	protected JLabel nEpisodiLabel;
	protected JLabel dataInizioLabel;
	protected JLabel dataFineLabel;
	protected JLabel votoLabel;
	
	//Campi inserimento
	protected JTextField titoloText;
	protected JTextField nEpisodiText;
	protected JTextField dataInizioText;
	protected JTextField dataFineText;
	protected JTextField votoText;
	private ArrayList<JTextField> textList = new ArrayList<JTextField>();
	
	//Pulsanti
	protected JButton inserisci;
	protected JButton cancella;
	
	//Coordinate elementi
	private int x = 25;
	private int y = 100;
	
	//Dimensione elementi
	private int elementWidth = 60;
	private int elementHeight = 25;
	
	//Spazio tra gli oggetti
	private int spaziatura = 150;
	private int sequenziale = elementWidth + spaziatura;
	
	/**
	 * Costruttore
	 */
	public GUI(){
		
		//Frame principale
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);		
		
		//Label titolo
		titoloLabel = new JLabel("Titolo");
		titoloLabel.setBounds(x, y, elementWidth, elementHeight);
		frame.add(titoloLabel);
		System.out.println(this.x);
		setX();//Aumenta la x

		//Label nEpisodi
		nEpisodiLabel = new JLabel("Episodi");
		nEpisodiLabel.setBounds(x, y, elementWidth, elementHeight);
		frame.add(nEpisodiLabel);
		System.out.println(this.x);
		setX();
		
		//Label dataInizio
		dataInizioLabel = new JLabel("Data Inizio");
		dataInizioLabel.setBounds(x, y, elementWidth, elementHeight);
		frame.add(dataInizioLabel);
		System.out.println(this.x);
		setX();
		
		//Label dataFine
		dataFineLabel = new JLabel("Data Fine");
		dataFineLabel.setBounds(x, y, elementWidth, elementHeight);
		frame.add(dataFineLabel);
		System.out.println(this.x);
		setX();
		
		//Label voto
		votoLabel = new JLabel("Voto");
		votoLabel.setBounds(x, y, elementWidth, elementHeight);
		frame.add(votoLabel);
		System.out.println(this.x);
		setX();
		
		this.y = this.y + elementHeight + 10;
		this.x = 25;
		this.elementWidth = elementWidth + 100;
		
		//TextField titolo
		titoloText = new JTextField();
		titoloText.setBounds(x, y, elementWidth, elementHeight);
		frame.add(titoloText);
		setX();
		
		//TextField nEpisodi
		nEpisodiText = new JTextField();
		nEpisodiText.setBounds(x, y, elementWidth, elementHeight);
		frame.add(nEpisodiText);
		setX();
		
		//TextField dataInizio
		dataInizioText = new JTextField();
		dataInizioText.setBounds(x, y, elementWidth, elementHeight);
		frame.add(dataInizioText);
		setX();
		
		//TextField dataFine
		dataFineText = new JTextField();
		dataFineText.setBounds(x, y, elementWidth, elementHeight);
		frame.add(dataFineText);
		setX();
		
		//TextField voto
		votoText = new JTextField();
		votoText.setBounds(x, y, elementWidth-45, elementHeight);
		frame.add(votoText);
		//setX();
		
		//Bottone inserisci
		cancella = new JButton("Cancella");
		cancella.setBounds(x, y + 100, elementWidth, elementHeight);
		cancella.addActionListener(this);
		frame.add(cancella);

		
		
		textList.add(titoloText);
		textList.add(nEpisodiText);
		textList.add(dataInizioText);
		textList.add(dataFineText);
		textList.add(votoText);
		
		
		
	}
	
	/**
	 * Incrementa la coordinata x degli oggetti
	 */
	private void setX(){
		
		this.x = this.x + this.sequenziale;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Pulsante cancella
		if(e.getSource().equals(cancella)){
			for(JTextField element : textList){
				element.setText("");				
			}
		}
		
	}
	
	
	
	
	

}//CLASSE
