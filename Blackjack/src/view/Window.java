package view;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import entities.Baraja;
import entities.Jugador;
import entities.RNA;

public class Window extends JFrame 
{
	private static final long serialVersionUID = 1L;
	
	/*Modelo*/
	private Baraja mazo;
	private Jugador dealer;
	private Jugador jugador1; //un solo jugador de momentoO
	private RNA neurona;
	
	/*Timer*/
	
	private Timer timer; 
	
	/*Imágenes*/
	private ImageIcon fondo = new ImageIcon(getClass().getResource("/images/fondo.png"));
	private ImageIcon imgCartas[][];
	
	/*componentes*/
	private JPanel contentPane;
	private JPanel panelDealer;
	private JPanel panelPlayer;
	private JButton btnCardDealer1;
	private JButton btnCardDealer2;
	private JButton btnCardDealer3;
	private JButton btnCardDealer4;
	private JButton btnCardDealer5;
	private JButton btnCardPlayer1;
	private JButton btnCardPlayer2;
	private JButton btnCardPlayer3;
	private JButton btnCardPlayer4;
	private JButton btnCardPlayer5;
	private JButton btnPedirCarta;
	private JButton btnPlantarse;
	private JButton btnNuevoJuego;
	private JTextField textPuntosPlayer;
	private JTextField textPuntosDealer;
	private JLabel lblTuPuntaje;
	private JLabel lblPuntajeDelDealer;
	private JLabel lblEstado;
	private JButton btnAprender;
	private JLabel lblPesosActuales;
	private JLabel lblX;
	private JLabel lblX_1;
	private JTextField textFieldPeso1;
	private JTextField textFieldPeso2;
	private JTextField textFieldPeso3;
	private JLabel lblX_2;
	private JLabel lblSugerencia;

	public Window()
	{
		setTitle("BlackJack UN");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/logoun.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		imagenesCartas();
		
		panelDealer = new JPanel();
		panelDealer.setBorder(new TitledBorder(null, "Cartas Dealer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDealer.setBounds(164, 52, 542, 165);
		contentPane.add(panelDealer);
		panelDealer.setLayout(null);
		
		btnCardDealer1 = new JButton("");
		btnCardDealer1.setBounds(10, 25, 95, 129);
		btnCardDealer1.setIcon(fondo);
		panelDealer.add(btnCardDealer1);
		
		btnCardDealer2 = new JButton("");
		btnCardDealer2.setBounds(115, 25, 95, 129);
		btnCardDealer2.setIcon(fondo);
		panelDealer.add(btnCardDealer2);
		
		btnCardDealer3 = new JButton("");
		btnCardDealer3.setBounds(220, 25, 95, 129);
		btnCardDealer3.setIcon(fondo);
		panelDealer.add(btnCardDealer3);
		
		btnCardDealer4 = new JButton("");
		btnCardDealer4.setBounds(325, 25, 95, 129);
		btnCardDealer4.setIcon(fondo);
		panelDealer.add(btnCardDealer4);
		
		btnCardDealer5 = new JButton("");
		btnCardDealer5.setBounds(430, 25, 95, 129);
		btnCardDealer5.setIcon(fondo);
		panelDealer.add(btnCardDealer5);
		
		panelPlayer = new JPanel();
		panelPlayer.setBorder(new TitledBorder(null, "Tus cartas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPlayer.setBounds(28, 233, 542, 165);
		contentPane.add(panelPlayer);
		panelPlayer.setLayout(null);
		
		btnCardPlayer1 = new JButton("");
		btnCardPlayer1.setBounds(10, 25, 95, 129);
		btnCardPlayer1.setIcon(fondo);
		panelPlayer.add(btnCardPlayer1);
		
		btnCardPlayer2 = new JButton("");
		btnCardPlayer2.setBounds(115, 25, 95, 129);
		btnCardPlayer2.setIcon(fondo);
		panelPlayer.add(btnCardPlayer2);
		
		btnCardPlayer3 = new JButton("");
		btnCardPlayer3.setBounds(220, 25, 95, 129);
		btnCardPlayer3.setIcon(fondo);
		panelPlayer.add(btnCardPlayer3);
		
		btnCardPlayer4 = new JButton("");
		btnCardPlayer4.setBounds(325, 25, 95, 129);
		btnCardPlayer4.setIcon(fondo);
		panelPlayer.add(btnCardPlayer4);
		
		btnCardPlayer5 = new JButton("");
		btnCardPlayer5.setBounds(430, 25, 95, 129);
		btnCardPlayer5.setIcon(fondo);
		panelPlayer.add(btnCardPlayer5);
		
		textPuntosPlayer = new JTextField();
		textPuntosPlayer.setEditable(false);
		textPuntosPlayer.setBounds(134, 479, 86, 20);
		contentPane.add(textPuntosPlayer);
		textPuntosPlayer.setColumns(10);
		
		textPuntosDealer = new JTextField();
		textPuntosDealer.setEditable(false);
		textPuntosDealer.setBounds(478, 476, 86, 20);
		contentPane.add(textPuntosDealer);
		textPuntosDealer.setColumns(10);
		
		lblTuPuntaje = new JLabel("Tu puntaje");
		lblTuPuntaje.setBounds(28, 482, 96, 14);
		contentPane.add(lblTuPuntaje);
		
		lblPuntajeDelDealer = new JLabel("Puntaje del dealer");
		lblPuntajeDelDealer.setBounds(353, 482, 115, 14);
		contentPane.add(lblPuntajeDelDealer);
		
		btnPedirCarta = new JButton("Pedir Carta");
		btnPedirCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				jugador1.pedirCarta(mazo.obtenerCarta());
				switch(jugador1.cartasEnMano())
				{
					case 3: 
						btnCardPlayer3.setIcon(imgCartas[jugador1.mostarCarta(2)[0]][jugador1.mostarCarta(2)[1]-1]);
						break;
					case 4: 
						btnCardPlayer4.setIcon(imgCartas[jugador1.mostarCarta(3)[0]][jugador1.mostarCarta(3)[1]-1]);
						break;
					case 5: 
						btnCardPlayer5.setIcon(imgCartas[jugador1.mostarCarta(4)[0]][jugador1.mostarCarta(4)[1]-1]);
						break;
					default:
						System.out.println("Error");
						break;	
				}
				
				textPuntosPlayer.setText(String.valueOf(jugador1.obtenerTotal()));
				//System.out.println(jugador1);
				
				if(jugador1.obtenerTotal()>21)
				{
					btnPedirCarta.setEnabled(false);
					btnPlantarse.setEnabled(false);
					lblEstado.setText("Perdiste, puntaje mayor a 21");
				}
				else if(jugador1.obtenerTotal()==21)
				{
					btnPedirCarta.setEnabled(false);
					btnNuevoJuego.setEnabled(false);
					btnPlantarse.setEnabled(false);
					timer.start();
				}
				else if(jugador1.obtenerTotal()<21 && jugador1.cartasEnMano()==5)
				{
					btnPedirCarta.setEnabled(false);
					btnNuevoJuego.setEnabled(false);
					btnPlantarse.setEnabled(false);
					timer.start();
				}
				else
				{
					System.out.println(jugador1.obtenerTotal());
					System.out.println(dealer.mostarCarta(0)[1]);
					float entradas[] = {jugador1.obtenerTotal(), dealer.mostarCarta(0)[1],-1};
					float valorArrojado = neurona.testing(entradas);
					if(valorArrojado<0)
					{
						System.out.println(valorArrojado);
						lblSugerencia.setText("Sugerencia: Prueba plantandose");
					}
					else
					{
						System.out.println(valorArrojado);
						lblSugerencia.setText("Sugerencia: Pruebe pidiendo carta");
					}
				}
			}
		});
		btnPedirCarta.setEnabled(false);
		btnPedirCarta.setBounds(579, 243, 127, 23);
		contentPane.add(btnPedirCarta);
		
		timer = new Timer (1000, new ActionListener () {
			    public void actionPerformed(ActionEvent e)
			    {
			    	dealer.pedirCarta(mazo.obtenerCarta());
			    	//System.out.println(dealer.cartasEnMano());
					switch(dealer.cartasEnMano())
					{
						case 2: 
							btnCardDealer2.setIcon(imgCartas[dealer.mostarCarta(1)[0]][dealer.mostarCarta(1)[1]-1]);
							break;
						case 3: 
							btnCardDealer3.setIcon(imgCartas[dealer.mostarCarta(2)[0]][dealer.mostarCarta(2)[1]-1]);
							break;
						case 4: 
							btnCardDealer4.setIcon(imgCartas[dealer.mostarCarta(3)[0]][dealer.mostarCarta(3)[1]-1]);
							break;
						case 5: 
							btnCardDealer5.setIcon(imgCartas[dealer.mostarCarta(4)[0]][dealer.mostarCarta(4)[1]-1]);
							break;
						default:
							System.out.println("Error");
							break;	
					}
					
					textPuntosDealer.setText(String.valueOf(dealer.obtenerTotal()));
					//System.out.println(dealer);
					
					if(dealer.obtenerTotal()<17)
					{
						//seguir pidiendo
						if(dealer.cartasEnMano()==5)
						{
							timer.stop();
							if(dealer.obtenerTotal()<jugador1.obtenerTotal())
							{
								lblEstado.setText("Ganaste");
							}
							else if(dealer.obtenerTotal()==jugador1.obtenerTotal())
							{
								lblEstado.setText("Empate");
							}
							else
							{
								lblEstado.setText("Perdiste");
							}
							btnNuevoJuego.setEnabled(true);
						}
					}
					else if(dealer.obtenerTotal()>21)
					{
						timer.stop();
						btnNuevoJuego.setEnabled(true);
						lblEstado.setText("Ganaste, el dealer tiene puntaje mayor a 21");
					}
					else
					{
						//ya tiene mas de 17 y menos de 22
						timer.stop();
						if(dealer.obtenerTotal()<jugador1.obtenerTotal())
						{
							lblEstado.setText("Ganaste");
						}
						else if(dealer.obtenerTotal()==jugador1.obtenerTotal())
						{
							lblEstado.setText("Empate");
						}
						else
						{
							lblEstado.setText("Perdiste");
						}
						btnNuevoJuego.setEnabled(true);
					}
					
			    }
			});
		
		btnPlantarse = new JButton("Plantarse");
		btnPlantarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				btnPedirCarta.setEnabled(false);
				btnNuevoJuego.setEnabled(false);
				btnPlantarse.setEnabled(false);
				timer.start();
			}
		});
		btnPlantarse.setEnabled(false);
		btnPlantarse.setBounds(579, 277, 127, 23);
		contentPane.add(btnPlantarse);
		
		btnNuevoJuego = new JButton("Nuevo Juego");
		btnNuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				voltearCartas();
				lblEstado.setText(" ");
				
				mazo = new Baraja();
				jugador1 = new Jugador();
				dealer = new Jugador();
				
				mazo.barajar();
				//mazo.barajarConElitismo();
				//System.out.println(mazo.enLaBaraja());
				
				jugador1.pedirCarta(mazo.obtenerCarta());
				jugador1.pedirCarta(mazo.obtenerCarta());
				dealer.pedirCarta(mazo.obtenerCarta());
				
				btnCardPlayer1.setIcon(imgCartas[jugador1.mostarCarta(0)[0]][jugador1.mostarCarta(0)[1]-1]);
				btnCardPlayer2.setIcon(imgCartas[jugador1.mostarCarta(1)[0]][jugador1.mostarCarta(1)[1]-1]);
				btnCardDealer1.setIcon(imgCartas[dealer.mostarCarta(0)[0]][dealer.mostarCarta(0)[1]-1]);
				
				textPuntosPlayer.setText(String.valueOf(jugador1.obtenerTotal()));
				textPuntosDealer.setText(String.valueOf(dealer.obtenerTotal()));
				
				btnPedirCarta.setEnabled(true);
				btnPlantarse.setEnabled(true);
				
				if(jugador1.blackjack())
				{
					lblEstado.setText("Tienes Blackjack");
					btnPedirCarta.setEnabled(false);
					btnNuevoJuego.setEnabled(false);
					btnPlantarse.setEnabled(false);
					timer.start();
				}
				else
				{
					System.out.println(jugador1.obtenerTotal());
					System.out.println(dealer.mostarCarta(0)[1]);
					float entradas[] = {jugador1.obtenerTotal(), dealer.mostarCarta(0)[1],-1};
					float valorArrojado = neurona.testing(entradas);
					if(valorArrojado<0)
					{
						System.out.println(valorArrojado);
						lblSugerencia.setText("Sugerencia: Prueba plantandose");
					}
					else
					{
						System.out.println(valorArrojado);
						lblSugerencia.setText("Sugerencia: Pruebe pidiendo carta");
					}
			
				}
			}
		});
		btnNuevoJuego.setBounds(580, 311, 126, 23);
		contentPane.add(btnNuevoJuego);
		
		lblEstado = new JLabel("");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEstado.setBounds(28, 430, 321, 20);
		contentPane.add(lblEstado);
		
		btnAprender = new JButton("Aprender");
		btnAprender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				neurona = new RNA();
				
				System.out.println("x1: "+String.valueOf(neurona.getPesos()[0]));
				System.out.println("x2: "+String.valueOf(neurona.getPesos()[1]));
				System.out.println("x3: "+String.valueOf(neurona.getPesos()[2]));
				
				neurona.aprender();
				textFieldPeso1.setText(String.valueOf(neurona.getPesos()[0]));
				textFieldPeso2.setText(String.valueOf(neurona.getPesos()[1]));
				textFieldPeso3.setText(String.valueOf(neurona.getPesos()[2]));
			}
		});
		btnAprender.setBounds(580, 345, 126, 23);
		contentPane.add(btnAprender);
		
		lblPesosActuales = new JLabel("Pesos Actuales");
		lblPesosActuales.setBounds(10, 52, 127, 14);
		contentPane.add(lblPesosActuales);
		
		lblX = new JLabel("x1");
		lblX.setBounds(10, 77, 46, 14);
		contentPane.add(lblX);
		
		lblX_1 = new JLabel("x2");
		lblX_1.setBounds(10, 102, 46, 14);
		contentPane.add(lblX_1);
		
		lblX_2 = new JLabel("x3");
		lblX_2.setBounds(10, 127, 46, 14);
		contentPane.add(lblX_2);
		
		textFieldPeso1 = new JTextField();
		textFieldPeso1.setEditable(false);
		textFieldPeso1.setBounds(51, 77, 86, 20);
		contentPane.add(textFieldPeso1);
		textFieldPeso1.setColumns(10);
		
		textFieldPeso2 = new JTextField();
		textFieldPeso2.setEditable(false);
		textFieldPeso2.setColumns(10);
		textFieldPeso2.setBounds(51, 102, 86, 20);
		contentPane.add(textFieldPeso2);
		
		textFieldPeso3 = new JTextField();
		textFieldPeso3.setEditable(false);
		textFieldPeso3.setColumns(10);
		textFieldPeso3.setBounds(51, 127, 86, 20);
		contentPane.add(textFieldPeso3);
		
		lblSugerencia = new JLabel("");
		lblSugerencia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSugerencia.setBounds(385, 430, 321, 20);
		contentPane.add(lblSugerencia);
	}
	
	/*LLenado del arreglo de imágenes*/
	public void imagenesCartas()
	{
		 imgCartas = new ImageIcon[4][13];
		 for (int i = 0; i < 4; i++) 
		 {
			 for (int j = 0; j < 13; j++) 
			 {
				 imgCartas[i][j] = new ImageIcon(getClass().getResource("/images/"+String.valueOf(j+1)+"_"+String.valueOf(i)+".png"));
			 }
		 }
		
	}
	
	public void voltearCartas()
	{
		btnCardPlayer1.setIcon(fondo);
		btnCardPlayer2.setIcon(fondo);
		btnCardPlayer3.setIcon(fondo);
		btnCardPlayer4.setIcon(fondo);
		btnCardPlayer5.setIcon(fondo);
		
		btnCardDealer1.setIcon(fondo);
		btnCardDealer2.setIcon(fondo);
		btnCardDealer3.setIcon(fondo);
		btnCardDealer4.setIcon(fondo);
		btnCardDealer5.setIcon(fondo);
	}
	
	/*Getters de los componentes*/
	
	public JButton getBtnCardDealer1() {
		return btnCardDealer1;
	}
	public JPanel getPanelDealer() {
		return panelDealer;
	}
	public JPanel getPanel() {
		return panelPlayer;
	}
	public JPanel getContentPane() {
		return contentPane;
	}
	public JButton getBtnCardDealer3() {
		return btnCardDealer3;
	}
	public JButton getBtnCardDealer4() {
		return btnCardDealer4;
	}
	public JButton getBtnCardDealer5() {
		return btnCardDealer5;
	}
	public JButton getBtnCardPlayer1() {
		return btnCardPlayer1;
	}
	public JButton getBtnCardPlayer2() {
		return btnCardPlayer2;
	}
	public JButton getBtnCardPlayer3() {
		return btnCardPlayer3;
	}
	public JButton getBtnCardPlayer4() {
		return btnCardPlayer4;
	}
	public JButton getBtnCardPlayer5() {
		return btnCardPlayer5;
	}
	public JButton getBtnCardDealer2() {
		return btnCardDealer2;
	}
	public JButton getBtnPedirCarta() {
		return btnPedirCarta;
	}
	public JButton getBtnPlantarse() {
		return btnPlantarse;
	}
	public JButton getBtnNuevoJuego() {
		return btnNuevoJuego;
	}
	public JLabel getLblTuPuntaje() {
		return lblTuPuntaje;
	}
	public JTextField getTextPuntosPlayer() {
		return textPuntosPlayer;
	}
	public JLabel getLblPuntajeDelDealer() {
		return lblPuntajeDelDealer;
	}
	public JTextField getTextPuntosDealer() {
		return textPuntosDealer;
	}
	public JButton getBtnAprender() {
		return btnAprender;
	}
	public JLabel getLblPesosActuales() {
		return lblPesosActuales;
	}
	public JLabel getLblX() {
		return lblX;
	}
	public JLabel getLblX_1() {
		return lblX_1;
	}
	public JLabel getLblX_2() {
		return lblX_2;
	}
	public JTextField getTextFieldPeso1() {
		return textFieldPeso1;
	}
	public JTextField getTextFieldPeso2() {
		return textFieldPeso2;
	}
	public JTextField getTextFieldPeso3() {
		return textFieldPeso3;
	}
	public JLabel getLblSugerencia() {
		return lblSugerencia;
	}
}
