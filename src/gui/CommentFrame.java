package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSlider;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;

import businessLogic.ApplicationFacadeInterface;
import dataAccess.DataAccessCommon;
import domain.Client;
import domain.Comment;
import domain.RuralHouse;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.LinkedList;

import javax.swing.SwingConstants;

public class CommentFrame extends JFrame implements Serializable{

	private JPanel contentPane;
	private JTextField textSlider;
	private JTextField comment;
	private JSlider slider = new JSlider();
	private JLabel lblStoreConf = new JLabel("");



	/**
	 * Create the frame.
	 */
	
	
	public CommentFrame(final RuralHouse h,final Client c) {
	
		setBounds(830, 2, 497, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewComment = new JLabel("New Comment & Mark");
		lblNewComment.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewComment.setBounds(172, 11, 149, 45);
		contentPane.add(lblNewComment);

		JLabel lblCommentRuralHouse = new JLabel("Comment Rural House:");
		lblCommentRuralHouse.setBounds(34, 147, 120, 14);
		contentPane.add(lblCommentRuralHouse);

		JLabel lblVoteRuralHoue = new JLabel("Vote Rural House:");
		lblVoteRuralHoue.setBounds(34, 85, 106, 14);
		contentPane.add(lblVoteRuralHoue);

		textSlider = new JTextField();
		textSlider.setBackground(Color.WHITE);
		textSlider.setEditable(false);
		textSlider.setBounds(131, 82, 30, 20);
		contentPane.add(textSlider);
		textSlider.setColumns(10);

		slider.setValue(5);
		slider.setMinorTickSpacing(1);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int nota = slider.getValue();
				textSlider.setText(Integer.toString(nota));

			}
		});
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.setMaximum(10);
		slider.setBounds(172, 68, 226, 54);
		contentPane.add(slider);

		comment = new JTextField();
		comment.setBounds(69, 167, 350, 212);
		contentPane.add(comment);
		comment.setColumns(10);

		
		lblStoreConf.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoreConf.setBounds(111, 429, 268, 14);
		contentPane.add(lblStoreConf);
		
		
		/////////////////
		//Comment co4 = new Comment(cl0,6,"ondoo");
		//RuralHouse rh= ow2.addRuralHouse(5, "Gaztetxea", "a");
		//rh.addComent(co1);
		//////////////////
		
		
		JButton btnNewButton = new JButton("Store");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String notStr = textSlider.getText();
				String com = comment.getText();
				
				if (!notStr.equals("") && !com.equals("")) {
					int not = Integer.parseInt(notStr);
					
					System.out.println("*********************11");
					DataAccessCommon.getInstance().inprimatuEtxeakOwner(h.getOwner());
					
					System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
					LinkedList<Comment> lista = h.getComments();
					if(lista.size()<1){
						System.out.println("no comments");
					}else{
						for(int i = 0; i<lista.size(); i++){
							System.out.print("("+i+"):--> ");
							System.out.print(Integer.toString(lista.get(i).getBotua())+", ");
							System.out.print(lista.get(i).getComent()+", ");
							System.out.println(lista.get(i).getEgilea().getLogin()+" ");
						}
					}System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

	
					
					
					//111111111111
					ApplicationFacadeInterface facades = StartWindow.getBusinessLogic();
					
					
					try {
						//22222222222222
						//Boolean rhUpdate = facades.RuralHouseRefactorComment(h);
						RuralHouse rhUp = facades.addComment(c,not,com,h);
						Boolean rhUpdate = facades.updateHouse(rhUp);
						
						System.out.println("*********************22");
						DataAccessCommon.getInstance().inprimatuEtxeakOwner(h.getOwner());
						
						if(rhUpdate){
							lblStoreConf.setForeground(Color.GREEN);
							lblStoreConf.setText("Komentarioa ondo gorde da");
							JOptionPane.showMessageDialog(null,"Komentarioa ondo gorde da", "Information",JOptionPane.INFORMATION_MESSAGE);
							//close();
							dispose();
							
							System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
							if(lista.size()<1){
								System.out.println("no comments");
							}else{
								for(int i = 0; i<lista.size(); i++){
									System.out.print("("+i+"):--> ");
									System.out.print(Integer.toString(lista.get(i).getBotua())+", ");
									System.out.print(lista.get(i).getComent()+", ");
									System.out.println(lista.get(i).getEgilea().getLogin()+" ");
								}
							}System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

						}else{
							lblStoreConf.setForeground(Color.RED);
							lblStoreConf.setText("Komentarioa gaizki gorde da");
						}

					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Bete itzazu atal guztiak mesedez", "alert",
							JOptionPane.CANCEL_OPTION);
				}
			}
		});
		btnNewButton.setBounds(183, 390, 120, 28);
		contentPane.add(btnNewButton);
		

	}
	
	public void close() {
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
		frame.dispose();
	}
}
