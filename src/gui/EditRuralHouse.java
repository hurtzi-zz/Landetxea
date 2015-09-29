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

public class EditRuralHouse extends JPanel implements Serializable{

	private Owner owner;
	//private static Owner updatedOwner;
	private RuralHouse ruralhouse;
	//private static RuralHouse updatedRuralHouse;
	private JLabel textZenbakia;
	private JTextField textDeskribapena;
	private JTextField textHiria;
	private JLabel lblOharrak = null;
	
	private ApplicationFacadeInterface facade = StartWindow.getBusinessLogic();
	
	/**
	 * Create the panel.
	 */
	public EditRuralHouse(final Owner o, final RuralHouse rh) {
		this.owner = o;
		this.ruralhouse = rh;
		setLayout(null);
		
		JLabel lblLandetxearenDatuakBete = new JLabel("Landetxearen datu berriak bete:");
		lblLandetxearenDatuakBete.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLandetxearenDatuakBete.setBounds(50, 40, 260, 25);
		add(lblLandetxearenDatuakBete);
		
		JLabel lblZenbakia = new JLabel("Landetxe zbkia:");
		lblZenbakia.setBounds(50, 100, 100, 25);
		add(lblZenbakia);
		
		JLabel lblDeskribapena = new JLabel("Deskribapena:");
		lblDeskribapena.setBounds(50, 150, 100, 25);
		add(lblDeskribapena);
		
		textZenbakia = new JLabel(Integer.toString(rh.getHouseNumber()));
		textZenbakia.setBounds(160, 102, 150, 25);
		add(textZenbakia);
		
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
		lblOharrak.setBounds(372, 205, 150, 20);
		add(lblOharrak);
		lblOharrak.setVisible(false);

		JButton btnAldatu = new JButton("ALDATU");
		btnAldatu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!textDeskribapena.getText().equals("")
						&& !textHiria.getText().equals("")) {
					System.out.println("bai");
					try {
						System.out.println(o.getLogin()+"Hau da logina");
//						Owner bi = facade.ownerBuelta(owner.getLogin());
//						Boolean ondo = facade.editRuralHouse(textHiria.getText(), textDeskribapena.getText(), bi,
//															 bi.getRHByNumber(ruralhouse.getHouseNumber()));
						Boolean ondo = facade.editRuralHouse(textHiria.getText(), textDeskribapena.getText(), o, rh);
						if (ondo==true) {
							lblOharrak.setText("Landetxea eguneratu da.");
							lblOharrak.setForeground(Color.GREEN);
							lblOharrak.setVisible(true);
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
		btnAldatu.setForeground(new Color(0, 100, 0));
		btnAldatu.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAldatu.setBounds(372, 100, 150, 50);
		add(btnAldatu);
		JButton btnBueltatu = new JButton("Bueltatu");
		btnBueltatu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GTFO();
			}
		});
		btnBueltatu.setBounds(433, 227, 89, 23);
		add(btnBueltatu);
		
		JButton btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEzabatu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (lblOharrak.getText().compareTo("Ziur?")==0) {
					System.out.println("Ezabatzen...");
					try {
						System.out.println(o.getLogin()+"Hau da logina");
						Boolean ondo = facade.deleteRuralHouse(o, rh);
						if (ondo==true) {
							lblOharrak.setText("Landetxea ezabatu da.");
							lblOharrak.setForeground(Color.GREEN);
							lblOharrak.setVisible(true);
							GTFO();
						}
					} catch (RemoteException e) {
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				} else {
					lblOharrak.setText("Ziur?");
					lblOharrak.setForeground(Color.RED);
					lblOharrak.setVisible(true);
				}
			}
		});
		btnEzabatu.setForeground(new Color(255, 0, 0));
		btnEzabatu.setBounds(447, 150, 75, 25);
		add(btnEzabatu);
		
		JButton btnEkitaldiak = new JButton("Ekitaldia gehitu");
		btnEkitaldiak.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					StartWindow.setAddActivityPanel(owner, ruralhouse);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnEkitaldiak.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEkitaldiak.setForeground(new Color(0, 0, 128));
		btnEkitaldiak.setBounds(372, 177, 150, 25);
		add(btnEkitaldiak);
	}
	
	public void GTFO(){
		try {
			Vector<RuralHouse> h = facade.SarchByCity(ruralhouse.getCity());
			if(h.size()==0){
				StartWindow.setLogedPanel(owner);
			}else{
				Iterator<RuralHouse> it = h.iterator();
				System.out.println(ruralhouse.getCity()+"-n etxeak:");
				while (it.hasNext()) {
					RuralHouse rh = (RuralHouse) it.next();
					System.out.println(rh.getHouseNumber()+" "+rh.getCity()+" "+rh.getDescription());
				}
				StartWindow.setFoundPanelClient(owner,h,0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
