package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JRadioButton;

import domain.RuralHouse;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class FoundPanel extends JPanel implements Serializable{
	private JLabel searchOwnerN = new JLabel("");
	private JLabel lblOwner = new JLabel("Owner:");
	private JLabel searchZbkia = new JLabel("");
	private JLabel label = new JLabel("Landetxe zbkia:");
	private JLabel searchDescription = new JLabel("");
	private JLabel lblDescription = new JLabel("Description:");
	private JButton btnSartu = new JButton("Go");
	private JLabel lblOfertaKop = new JLabel("Oferta kop:");
	private JLabel searchOfert = new JLabel("");
	private JLabel lblHiria = new JLabel("Hiria:");
	private JLabel searchHiria;
	
	/**
	 * Create the panel.
	 */
	public FoundPanel(final Vector<RuralHouse> h, final int ind) {

		setLayout(null);

		
		searchOwnerN.setBounds(10, 81, 108, 14);
		add(searchOwnerN);
		searchOwnerN.setText(h.get(ind).getOwner().getName() + " "
				+ h.get(ind).getOwner().getAbizena());

		
		lblOwner.setBounds(10, 66, 46, 14);
		add(lblOwner);

		
		searchZbkia.setBounds(10, 27, 46, 14);
		add(searchZbkia);
		searchZbkia.setText(Integer.toString(h.get(ind).getHouseNumber()));

		
		label.setBounds(10, 11, 93, 14);
		add(label);

		
		lblDescription.setBounds(131, 11, 85, 14);
		add(lblDescription);

		
		searchDescription.setBounds(141, 27, 280, 81);
		add(searchDescription);
		searchDescription.setBackground(Color.WHITE);
		searchDescription.setText(h.get(ind).getDescription());

		
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame a= new Go(h.get(ind));
				a.setVisible(true);
			}
		});
		btnSartu.setBounds(453, 46, 55, 55);
		add(btnSartu);

		
		lblOfertaKop.setBounds(418, 11, 68, 14);
		add(lblOfertaKop);

		
		searchOfert.setBounds(496, 11, 36, 14);
		add(searchOfert);
		searchOfert.setText(Integer.toString(h.get(ind).getOffer().size()));

		
		
		lblHiria.setBounds(262, 11, 36, 14);
		add(lblHiria);
		searchHiria = new JLabel("");
		searchHiria.setBounds(308, 11, 100, 14);
		add(searchHiria);
		searchHiria.setText(h.get(ind).getCity());
	}
	
	
	
	
	
}