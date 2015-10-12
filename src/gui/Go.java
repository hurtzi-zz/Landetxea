package gui;

import gui.AddActivity.ComboItem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import domain.Activity;
import domain.Comment;
import domain.RuralHouse;

import java.awt.Font;
import java.io.Serializable;

import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Go extends JFrame implements Serializable{

	private static JPanel contentPane;
	private JComboBox<ComboItem> comboBox = new JComboBox<ComboItem>();
	
	
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
	 * Create the frame.
	 */
	
	public Go(RuralHouse h) {
		
		
		setBounds(290, 2, 680, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		JLabel searchOwnerN = new JLabel("");
		searchOwnerN.setBounds(79, 103, 184, 14);
		getContentPane().add(searchOwnerN);
		searchOwnerN.setText(h.getOwner().getName() + " "
				+ h.getOwner().getAbizena());

		JLabel lblOwner = new JLabel("Owner:");
		lblOwner.setBounds(34, 103, 46, 14);
		lblOwner.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblOwner);

		JLabel searchZbkia = new JLabel("");
		searchZbkia.setBounds(137, 78, 46, 14);
		getContentPane().add(searchZbkia);
		searchZbkia.setText(Integer.toString(h.getHouseNumber()));

		JLabel label = new JLabel("Landetxe zbkia:");
		label.setBounds(34, 78, 93, 14);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(label);

		final JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(34, 128, 85, 14);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblDescription);

		final JTextField searchDescription = new JTextField("");
		searchDescription.setBounds(54, 144, 544, 38);
		getContentPane().add(searchDescription);
		searchDescription.setBackground(new Color(245, 245, 245));
		searchDescription.setText(h.getDescription());


		JLabel lblOfertaKop = new JLabel("Oferta kop:");
		lblOfertaKop.setBounds(35, 53, 68, 14);
		lblOfertaKop.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblOfertaKop);

		JLabel searchOfert = new JLabel("");
		searchOfert.setBounds(107, 53, 36, 14);
		getContentPane().add(searchOfert);
		searchOfert.setText(Integer.toString(h.getOffer().size()));
		
		JLabel lblRuralHouseDetails = new JLabel("Rural House Details");
		lblRuralHouseDetails.setBounds(209, 11, 228, 32);
		lblRuralHouseDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblRuralHouseDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblRuralHouseDetails);
		
		JLabel lblAverageMark = new JLabel("Average mark:");
		lblAverageMark.setBounds(34, 193, 93, 14);
		lblAverageMark.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblAverageMark);
		
		JLabel searchAvg = new JLabel("");
		searchAvg.setBounds(125, 183, 28, 24);
		searchAvg.setHorizontalAlignment(SwingConstants.CENTER);
		searchAvg.setVerticalAlignment(SwingConstants.BOTTOM);
		searchAvg.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(searchAvg);
		
		LinkedList<Comment> lista = h.getComments();
		if(lista.isEmpty()){
			searchAvg.setText("-");
		}else{
			Double NotaAvg = 0.0; 
			int NotaTotala=0;
			for(int i=0 ; i < lista.size() ; i++){
				NotaTotala=NotaTotala+lista.get(i).getBotua();
			}
			NotaAvg =(double) (NotaTotala/lista.size());
			if(NotaAvg>=8.0){
				searchAvg.setForeground(Color.GREEN);
			}else if(NotaAvg>=5.0 && NotaAvg<8.0){
				searchAvg.setForeground(Color.BLUE);
			}else if(NotaAvg>=3.0 && NotaAvg<5.0){
				searchAvg.setForeground(Color.YELLOW);
			}else if(NotaAvg>=0.0 && NotaAvg<3.0){
				searchAvg.setForeground(Color.RED);
			}
			searchAvg.setText(Double.toString(NotaAvg));
		}

		
		
		
		JLabel lblComments = new JLabel("Comments:");
		lblComments.setBounds(34, 218, 85, 14);
		lblComments.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblComments);
		
//		JPanel panelComment = new JPanel();
//		panelComment.setBounds(44, 240, 575, 399);
//		contentPane.add(panelComment);
		
		JPanel panelComment = new SearchCommentPanel(h,0);
		panelComment.setBounds(44, 240, 575, 410);
		contentPane.add(panelComment);
		
		
		JLabel lblEkitaldiak = new JLabel("Ekitaldiak:");
		lblEkitaldiak.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEkitaldiak.setBounds(529, 53, 58, 24);
		contentPane.add(lblEkitaldiak);

		comboBox.setBounds(502, 78, 96, 24);
		contentPane.add(comboBox);
		
		final JLabel lblEkitaldiIzena = new JLabel("Ekitaldi izena:");
		lblEkitaldiIzena.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEkitaldiIzena.setBounds(209, 50, 85, 14);
		contentPane.add(lblEkitaldiIzena);
		lblEkitaldiIzena.setVisible(false);
		
		final JLabel lblPartaideKopurua = new JLabel("Partaide kop.:");
		lblPartaideKopurua.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPartaideKopurua.setBounds(209, 75, 85, 14);
		contentPane.add(lblPartaideKopurua);
		lblPartaideKopurua.setVisible(false);
		
		final JLabel lblEgunezgauez = new JLabel("Egunez/gauez:");
		lblEgunezgauez.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEgunezgauez.setBounds(209, 100, 85, 14);
		contentPane.add(lblEgunezgauez);
		lblEgunezgauez.setVisible(false);
		
		final JLabel txtIzena = new JLabel("");
		txtIzena.setBounds(304, 50, 68, 14);
		contentPane.add(txtIzena);
		
		final JLabel txtKop = new JLabel("");
		txtKop.setBounds(304, 75, 68, 14);
		contentPane.add(txtKop);
		
		final JLabel txtEgunezGauez = new JLabel("");
		txtEgunezGauez.setBounds(304, 100, 68, 14);
		contentPane.add(txtEgunezGauez);
		
		JButton btnEkitaldiak = new JButton("Aztertu");
		try{
			Vector<Activity> houseList = StartWindow.facadeInterface.getHouseActivities(h);
			Iterator<Activity> it = houseList.iterator();
			Activity aTest;
			Boolean aFlag = true;
			while(it.hasNext()){
				aTest = it.next();
				comboBox.addItem(new ComboItem(aTest.getName(), aTest));
				aFlag = false;
			}
			if (aFlag){
				comboBox.setVisible(false);
				btnEkitaldiak.setVisible(false);
				JLabel lblEx = new JLabel("Ekitaldirik ez.");
				lblEx.setBounds(530, 78, 72, 24);
				lblEx.setForeground(Color.RED);
				contentPane.add(lblEx);
			}
		} catch (RemoteException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		btnEkitaldiak.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					Object item = comboBox.getSelectedItem();
					Activity act = ((ComboItem)item).getValue();
					lblEkitaldiIzena.setVisible(true);
					lblPartaideKopurua.setVisible(true);
					lblEgunezgauez.setVisible(true);
					lblDescription.setBounds(209, 125, 85, 14);
					searchDescription.setText("                                                   " + act.getDescription());
					txtIzena.setText(act.getName());
					txtKop.setText(Integer.toString(act.getCantity()));
					if (act.getDayOrNight()) txtEgunezGauez.setText("Egunez");
					else txtEgunezGauez.setText("Gauez");
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		});
		btnEkitaldiak.setBounds(523, 108, 75, 24);
		btnEkitaldiak.setForeground(new Color(0, 0, 128));
		btnEkitaldiak.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnEkitaldiak);
		contentPane.setVisible(true);
	}
	
public static void ini(RuralHouse h){

		
	JLabel searchOwnerN = new JLabel("");
	searchOwnerN.setBounds(79, 103, 184, 14);
	contentPane.add(searchOwnerN);
	searchOwnerN.setText(h.getOwner().getName() + " "+ h.getOwner().getAbizena());

	JLabel lblOwner = new JLabel("Owner:");
	lblOwner.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblOwner.setBounds(34, 103, 46, 14);
	contentPane.add(lblOwner);

	JLabel searchZbkia = new JLabel("");
	searchZbkia.setBounds(137, 78, 46, 14);
	contentPane.add(searchZbkia);
	searchZbkia.setText(Integer.toString(h.getHouseNumber()));

	JLabel label = new JLabel("Landetxe zbkia:");
	label.setFont(new Font("Tahoma", Font.BOLD, 11));
	label.setBounds(34, 78, 93, 14);
	contentPane.add(label);

	JLabel lblDescription = new JLabel("Description:");
	lblDescription.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblDescription.setBounds(34, 128, 85, 14);
	contentPane.add(lblDescription);

	JTextField searchDescription = new JTextField("");
	searchDescription.setBounds(54, 144, 544, 38);
	contentPane.add(searchDescription);
	searchDescription.setBackground(new Color(245, 245, 245));
	searchDescription.setText(h.getDescription());


	JLabel lblOfertaKop = new JLabel("Oferta kop:");
	lblOfertaKop.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblOfertaKop.setBounds(35, 53, 68, 14);
	contentPane.add(lblOfertaKop);

	JLabel searchOfert = new JLabel("");
	searchOfert.setBounds(107, 53, 36, 14);
	contentPane.add(searchOfert);
	searchOfert.setText(Integer.toString(h.getOffer().size()));
	
	JLabel lblRuralHouseDetails = new JLabel("Rural House Details:");
	lblRuralHouseDetails.setHorizontalAlignment(SwingConstants.CENTER);
	lblRuralHouseDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblRuralHouseDetails.setBounds(209, 11, 228, 32);
	contentPane.add(lblRuralHouseDetails);
	
	JLabel lblAverageMark = new JLabel("Average mark:");
	lblAverageMark.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblAverageMark.setBounds(34, 193, 93, 14);
	contentPane.add(lblAverageMark);
	
	JLabel searchAvg = new JLabel("");
	searchAvg.setHorizontalAlignment(SwingConstants.CENTER);
	searchAvg.setVerticalAlignment(SwingConstants.BOTTOM);
	searchAvg.setFont(new Font("Tahoma", Font.BOLD, 13));
	searchAvg.setBounds(125, 183, 28, 24);
	contentPane.add(searchAvg);
	
	LinkedList<Comment> lista = h.getComments();
	if(lista.isEmpty()){
		searchAvg.setText("-");
	}else{
		Double NotaAvg = 0.0; 
		int NotaTotala=0;
		for(int i=0 ; i < lista.size() ; i++){
			NotaTotala=NotaTotala+lista.get(i).getBotua();
		}
		NotaAvg =(double) (NotaTotala/lista.size());
		if(NotaAvg>=8.0){
			searchAvg.setForeground(Color.GREEN);
		}else if(NotaAvg>=5.0 && NotaAvg<8.0){
			searchAvg.setForeground(Color.BLUE);
		}else if(NotaAvg>=3.0 && NotaAvg<5.0){
			searchAvg.setForeground(Color.YELLOW);
		}else if(NotaAvg>=0.0 && NotaAvg<3.0){
			searchAvg.setForeground(Color.RED);
		}
		searchAvg.setText(Double.toString(NotaAvg));
	}

	JLabel lblComments = new JLabel("Comments:");
	lblComments.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblComments.setBounds(34, 218, 85, 14);
	contentPane.add(lblComments);
	

	}
	public static void setCommentPanel(RuralHouse h,int ind){
		contentPane.setVisible(false);
		contentPane.removeAll();
		ini(h);
				//LinkedList<Comment> Lista = h.getComments();

		JPanel panelComment = new SearchCommentPanel(h,ind);
		panelComment.setBounds(44, 240, 575, 410);
		contentPane.add(panelComment);
		contentPane.setVisible(true);
	}
	
}
