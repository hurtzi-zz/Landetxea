package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import domain.Client;
import domain.Owner;
import domain.RuralHouse;
import businessLogic.ApplicationFacadeInterface;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JToggleButton;

public class CreateActivity extends JPanel implements Serializable{

	private static Owner owner;
	private JToggleButton tglbtnEgunez = new JToggleButton("Egunez?");
	private JTextField textDeskribapena = new JTextField();
	private JTextField textPartaideKop = new JTextField();
	private JTextField textIzena= new JTextField("");
	private JLabel lblOharrak = new JLabel("");
	private JButton btnSortu = new JButton("SORTU");






	
	/**
	 * Create the panel.
	 */
	public CreateActivity(Owner o) {
		setLayout(null);
		this.owner = o;
		
		JButton btnOut = new JButton("Log Out");
		btnOut.setForeground(Color.RED);
		btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StartWindow.setLoginPanel();
			}
		});
		btnOut.setBounds(516, 11, 75, 25);
		add(btnOut);
		
		JLabel lblEkitaldiDatuakBete = new JLabel("Ekitaldiaren datuak bete:");
		lblEkitaldiDatuakBete.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEkitaldiDatuakBete.setBounds(50, 40, 260, 25);
		add(lblEkitaldiDatuakBete);
		
		JLabel lblIzena = new JLabel("Ekitaldiaren izena:");
		lblIzena.setBounds(50, 100, 100, 25);
		add(lblIzena);
		
		textIzena.setBounds(160, 100, 150, 25);
		add(textIzena);

		JLabel lblDeskribapena = new JLabel("Deskribapena:");
		lblDeskribapena.setBounds(50, 140, 100, 25);
		add(lblDeskribapena);

		textDeskribapena.setBounds(160, 140, 150, 50);
		add(textDeskribapena);
		textDeskribapena.setColumns(10);
		
		JLabel lblPartaideKop = new JLabel("Partaide kopurua:");
		lblPartaideKop.setBounds(50, 205, 100, 25);
		add(lblPartaideKop);
		
		textPartaideKop.setBounds(160, 205, 150, 25);
		add(textPartaideKop);
		textPartaideKop.setColumns(10);
		
		tglbtnEgunez.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("lehen " + tglbtnEgunez.isSelected() + " zegoen");
				if(tglbtnEgunez.isSelected()){
					tglbtnEgunez.setText("GAUEZ");
					tglbtnEgunez.setFont(new Font("Tahoma", Font.BOLD, 14));
					tglbtnEgunez.setForeground(Color.BLUE);
					System.out.println(tglbtnEgunez.isSelected() + " zegoen");
				} else{
					tglbtnEgunez.setText("EGUNEZ");
					tglbtnEgunez.setFont(new Font("Tahoma", Font.BOLD, 14));
					tglbtnEgunez.setForeground(Color.RED);

					System.out.println(tglbtnEgunez.isSelected() + " zegoen");
				}
			}
		});
		tglbtnEgunez.setBounds(110, 240, 150, 25);
		add(tglbtnEgunez);
		
		lblOharrak.setBounds(372, 161, 150, 25);
		add(lblOharrak);
		lblOharrak.setVisible(false);
		
		btnSortu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					int kop = Integer.parseInt(textPartaideKop.getText());
					if (!textIzena.getText().equals("") && !textDeskribapena.getText().equals("") && (kop!=0)) {
						System.out.println("bai");
//						Owner bi = StartWindow.facadeInterface.ownerBuelta(owner.getLogin());
						Boolean isOk = StartWindow.facadeInterface.createActivity(textIzena.getText(), textDeskribapena.getText(), kop, tglbtnEgunez.isSelected(), owner);
						if(isOk){
							lblOharrak.setText("Ekitaldia ondo sortu da!");
							lblOharrak.setForeground(Color.GREEN);
							lblOharrak.setVisible(true);
							btnSortu.setEnabled(false);
						} else{
							lblOharrak.setText("Erroreren bat egon da.");
							lblOharrak.setForeground(Color.RED);
							lblOharrak.setVisible(true);
						}
					} else {
						lblOharrak.setText("Eremu guztiak bete!");
						lblOharrak.setForeground(Color.RED);
						lblOharrak.setVisible(true);
					}
				} catch (java.lang.NumberFormatException e){
					lblOharrak.setText("Baliozko zenbaki bat sartu!");
					lblOharrak.setForeground(Color.RED);
					lblOharrak.setVisible(true);
				} catch (RemoteException e){
					e.printStackTrace();
					lblOharrak.setText("Erroreren bat egon da.");
					lblOharrak.setForeground(Color.RED);
					lblOharrak.setVisible(true);
				} catch (Exception e){
					e.printStackTrace();
					lblOharrak.setText("Erroreren bat egon da.");
					lblOharrak.setForeground(Color.RED);
					lblOharrak.setVisible(true);
				}
			}
		});
		btnSortu.setForeground(new Color(0, 100, 0));
		btnSortu.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSortu.setBounds(372, 100, 150, 50);
		add(btnSortu);
		
		JButton btnBueltatu = new JButton("Bueltatu");
		btnBueltatu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StartWindow.setLogedPanel((Client) owner);
			}
		});
		btnBueltatu.setBounds(433, 227, 89, 23);
		add(btnBueltatu);

	}
}
