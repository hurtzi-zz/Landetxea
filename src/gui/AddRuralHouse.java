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

public class AddRuralHouse extends JPanel implements Serializable{
	private static Owner owner;
	private static Owner updatedOwner;
	
	private JTextField textDeskribapena;
	private JTextField textHiria;
	private JLabel lblOharrak = null;
	private ApplicationFacadeInterface facade = StartWindow.getBusinessLogic();
	private JButton btnSortu = new JButton("SORTU");
	private JLabel textZenbakia = new JLabel("");



	/**
	 * 
	 * Create the panel.
	 */

	public AddRuralHouse(Owner o) {

		this.owner = o;
		setLayout(null);

		JLabel lblLandetxearenDatuakBete = new JLabel("Landetxearen datuak bete:");
		lblLandetxearenDatuakBete.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLandetxearenDatuakBete.setBounds(50, 40, 260, 25);
		add(lblLandetxearenDatuakBete);
		
		JButton btnOut = new JButton("Log Out");
		btnOut.setForeground(Color.RED);
		btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StartWindow.setLoginPanel();
			}
		});
		btnOut.setBounds(516, 11, 75, 25);
		add(btnOut);

		JLabel lblZenbakia = new JLabel("Landetxe zbkia:");
		lblZenbakia.setBounds(50, 100, 100, 25);
		add(lblZenbakia);
		
		textZenbakia.setForeground(Color.DARK_GRAY);
		textZenbakia.setFont(new Font("Tahoma", Font.BOLD, 11));
		textZenbakia.setBounds(160, 100, 150, 25);
		try{
			textZenbakia.setText(Integer.toString(StartWindow.facadeInterface.getFreeNumber()));
		} catch(Exception e){
			e.printStackTrace();
		}
		add(textZenbakia);
		
		JLabel lblDeskribapena = new JLabel("Deskribapena:");
		lblDeskribapena.setBounds(50, 150, 100, 25);
		add(lblDeskribapena);

		textDeskribapena = new JTextField();
		textDeskribapena.setBounds(160, 152, 150, 50);
		add(textDeskribapena);
		textDeskribapena.setColumns(10);
		
		JLabel lblHiria = new JLabel("Hiria:");
		lblHiria.setBounds(50, 225, 100, 25);
		add(lblHiria);
		
		textHiria = new JTextField();
		textHiria.setBounds(160, 225, 150, 25);
		add(textHiria);
		textHiria.setColumns(10);

		
		lblOharrak = new JLabel("");
		lblOharrak.setBounds(372, 161, 150, 25);
		add(lblOharrak);
		lblOharrak.setVisible(false);

		btnSortu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (!textDeskribapena.getText().equals("")
						&& !textHiria.getText().equals("")) {
					System.out.println("bai");
//					try {
//
//						int n1 = Integer.parseInt(textZenbakia.getText());
//						Boolean hasNumber = false;
//						//System.out.println(owner.getRuralHouses()+" laaa");
//						System.out.println(owner.getRuralHouses());
//						Vector<RuralHouse> vec = owner.getRuralHouses();
//						if(vec==null){
//							vec = new Vector<RuralHouse>();
//						}
//						Iterator it = vec.iterator();
//						while (it.hasNext()) {
//							RuralHouse rh = (RuralHouse) it.next();
//							int n2 = rh.getHouseNumber();
//							if (n1 == n2) {
//								hasNumber = true;
//							}
//						}
//						if (hasNumber == true) {
//							lblOharrak.setText("Zenbaki hori hartuta dago.");
//							lblOharrak.setForeground(Color.RED);
//							lblOharrak.setVisible(true);
//						} else {
//
//							Owner ownerToSet = owner;
//							String d= textDeskribapena.getText();
//							String h=textHiria.getText();
//							Integer z = Integer.valueOf(textZenbakia.getText());
//							
////									ownerToSet.addRuralHouse(Integer.parseInt()............
////									facade.updateOwner(owner, ownerToSet);
//							ApplicationFacadeInterface facades = StartWindow.getBusinessLogic();
//			            	Boolean gordeta=facades.saveRuralHouse(z,h,d);
//			            	if(gordeta==true){
//			            		lblOharrak.setText("Your Ruralhouse have ben saved");
//								lblOharrak.setForeground(Color.GREEN);
//			            	}else{
//			            		lblOharrak.setText("Your Ruralhouse hasent been saved");
//								lblOharrak.setForeground(Color.RED);
//			            	}
//
//							owner = ownerToSet;
//							lblOharrak.setText("Landetxea gehitu da.");
//							lblOharrak.setForeground(Color.GREEN);
//							lblOharrak.setVisible(true);
//						}
//					} catch (java.lang.NumberFormatException e) {
//						lblOharrak.setText("Baliozko zenbakia idatzi!");
//						lblOharrak.setForeground(Color.RED);
//						lblOharrak.setVisible(true);
//
//					} catch (Exception ex) {
//						ex.printStackTrace();
//					}
					
//					Integer zb = new Integer(textZenbakia.getText());
					//RuralHouse gorde = new RuralHouse(zb, owner, textDeskribapena.getText(), textHiria.getText());
				//	System.out.println(gorde);
					try {
						System.out.println(owner.getLogin()+"Hau da logina");
				//		Vector<RuralHouse> rr = StartWindow.facadeInterface.ownerBektoreaBueltatu(owner.getLogin());
						
					//	System.out.println(rr + "Hau da bektorea");
					//	owner.setRuralHouses(rr);
						Owner bi = StartWindow.facadeInterface.ownerBuelta(owner.getLogin());
					//	bi.addRuralHouse(gorde);
						Boolean isOk = StartWindow.facadeInterface.saveRuralHouse(Integer.parseInt(textZenbakia.getText()), textHiria.getText(), textDeskribapena.getText(), bi);
						if (isOk){
							lblOharrak.setText("Landetxea ondo eratu da!");
							lblOharrak.setForeground(Color.GREEN);
							lblOharrak.setVisible(true);
							btnSortu.setEnabled(false);
						} else {
							lblOharrak.setText("Gordeta dago dagoeneko.");
							lblOharrak.setForeground(Color.RED);
							lblOharrak.setVisible(true);
							btnSortu.setEnabled(false);
						}
					} catch (RemoteException e) {
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					lblOharrak.setText("Eremu guztiak bete!");
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