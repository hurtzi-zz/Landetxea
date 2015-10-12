package gui;

import gui.AddActivity.ComboItem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.Activity;
import domain.Client;
import domain.Owner;
import domain.RuralHouse;

import javax.swing.JComboBox;

public class AddActivity extends JPanel implements Serializable{
	private Owner owner;
	private RuralHouse ruralhouse;
	
	private JLabel lblOharrak = new JLabel("");
	private JComboBox<ComboItem> comboBox = new JComboBox<ComboItem>();
	private JButton btnGehitu = new JButton("GEHITU");


	
	class ComboItem{
	    private String name;
	    private Activity act;

	    public ComboItem(String key, Activity value){
	        this.name = key;
	        this.act = value;
	    }
	    @Override
	    public String toString(){
	        return name;
	    }
	    public String getKey(){
	        return name;
	    }
	    public Activity getValue(){
	        return act;
	    }
	}
	
	/**
	 * Create the panel.
	 */
	public AddActivity(Owner o, RuralHouse rh) {
		setLayout(null);
		owner = o;
		ruralhouse = rh;
		
		JLabel lblIzenburua = new JLabel("Aukeratu gehitu nahi duzun ekitaldia:");
		lblIzenburua.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIzenburua.setBounds(50, 40, 260, 25);
		add(lblIzenburua);
		
		JLabel lblZenbakia = new JLabel("Landetxe zbkia:");
		lblZenbakia.setBounds(50, 100, 100, 25);
		add(lblZenbakia);
		
		JLabel textZenbakia = new JLabel(Integer.toString(ruralhouse.getHouseNumber()));
		textZenbakia.setBounds(160, 100, 150, 25);
		add(textZenbakia);
		
		JLabel lblHiria = new JLabel("Hiria:");
		lblHiria.setBounds(50, 150, 100, 25);
		add(lblHiria);
		
		JLabel textHiria = new JLabel(ruralhouse.getCity());
		textHiria.setBounds(160, 150, 150, 25);
		add(textHiria);
		
		JLabel lblEkitaldi = new JLabel("Ekitaldia:");
		lblEkitaldi.setBounds(50, 200, 100, 25);
		add(lblEkitaldi);

		lblOharrak.setBounds(372, 165, 150, 20);
		add(lblOharrak);
		lblOharrak.setVisible(false);
		
		comboBox.setBounds(160, 200, 150, 25);
		add(comboBox);
		comboBox.setVisible(false);
		try{
			Vector<Activity> ownList = StartWindow.facadeInterface.getOwnerActivities(owner);
			if (ownList == null || ownList.isEmpty()){
				lblOharrak.setText("Ez dituzu ekitaldirik!");
				lblOharrak.setForeground(Color.RED);
				lblOharrak.setVisible(true);
			} else {
				Vector<Activity> houseList = StartWindow.facadeInterface.getHouseActivities(ruralhouse);
				Iterator<Activity> it = ownList.iterator();
				Activity aTest;
				while(it.hasNext()){
					aTest = it.next();
					if (!houseList.contains(aTest)){
						comboBox.addItem(new ComboItem(aTest.getName(), aTest));
						comboBox.setVisible(true);
					}
				}
			}
		} catch (RemoteException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
		btnGehitu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					if(comboBox.getSelectedIndex()==-1){
						lblOharrak.setText("Ez duzu aukerarik egin.");
						lblOharrak.setForeground(Color.RED);
						lblOharrak.setVisible(true);
					} else{
						Object item = comboBox.getSelectedItem();
						Activity act = ((ComboItem)item).getValue();
						System.out.println("bai");
						Boolean isOk = StartWindow.facadeInterface.addActivity(act, ruralhouse);
						if(isOk){
							lblOharrak.setText("Ekitaldia ondo gehitu da da!");
							lblOharrak.setForeground(Color.GREEN);
							lblOharrak.setVisible(true);
							btnGehitu.setEnabled(false);
						} else{
							lblOharrak.setText("Landetxeak ekitaldi hori badu.");
							lblOharrak.setForeground(Color.RED);
							lblOharrak.setVisible(true);
						}
					}
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
		btnGehitu.setForeground(new Color(0, 100, 0));
		btnGehitu.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGehitu.setBounds(372, 100, 150, 50);
		add(btnGehitu);
		
		
		JButton btnBueltatu = new JButton("Bueltatu");
		btnBueltatu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StartWindow.setLogedPanel((Client) owner);
			}
		});
		btnBueltatu.setBounds(432, 200, 89, 23);
		add(btnBueltatu);
		
		JButton btnOut = new JButton("Log Out");
		btnOut.setForeground(Color.RED);
		btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StartWindow.setLoginPanel();
			}
		});
		btnOut.setBounds(516, 11, 75, 25);
		add(btnOut);
	}
}
