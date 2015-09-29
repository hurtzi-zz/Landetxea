package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import domain.Client;
import domain.Owner;
import domain.RuralHouse;

public class ListFav extends JFrame implements Serializable{

	private static JPanel contentPane;


	/**
	 * Create the frame.
	 * @param c 
	 */
	public ListFav(Client c, int ind) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 636, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Favorite Rural Houses");
		lblNewJgoodiesTitle.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 38));
		lblNewJgoodiesTitle.setBounds(123, 11, 383, 46);
		contentPane.add(lblNewJgoodiesTitle);
		
		Vector<RuralHouse> bek=c.getRuralFav();
		JPanel FoundPanel = new FoundFavHouseClient(c,bek,ind);
		FoundPanel.setBounds(10, 51, 622, 494);
		contentPane.add(FoundPanel);
		contentPane.setVisible(true);
		
	}
	
	public static void setListFav(Client c, int ind){
		contentPane.setVisible(false);
		contentPane.removeAll();
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Favorite Rural Houses");
		lblNewJgoodiesTitle.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 38));
		lblNewJgoodiesTitle.setBounds(123, 11, 383, 46);
		contentPane.add(lblNewJgoodiesTitle);
		
		Vector<RuralHouse> bek=c.getRuralFav();
		JPanel FoundPanel = new FoundFavHouseClient(c,bek,ind);
		FoundPanel.setBounds(10, 51, 622, 494);
		contentPane.add(FoundPanel);
		contentPane.setVisible(true);
		
		
	}
	public void close(){
		
	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
	frame.dispose();
	
	}
	


}