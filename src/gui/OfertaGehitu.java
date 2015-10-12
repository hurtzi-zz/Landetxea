package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import domain.Owner;
import domain.RuralHouse;
import businessLogic.ApplicationFacadeInterface;

public class OfertaGehitu extends JFrame implements Serializable{

	private JPanel contentPane;
	private JTextField textField;
	private Calendar calendarInicio = null;
	private Calendar calendarFin = null;
	// private JTextField jTextField1 = new JTextField();
	// private JTextField jTextField2 = new JTextField();

	ApplicationFacadeInterface facade = StartWindow.getBusinessLogic();
	private JTextField textField_1 = new JTextField();
	private JTextField textField_2 = new JTextField();
	private JComboBox comboBox;
	private JCalendar jCalendar1 = new JCalendar();
	private JCalendar jCalendar2 = new JCalendar();
	private JLabel lblMezu = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Owner o = null;
					OfertaGehitu frame = new OfertaGehitu(o);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 * @throws RemoteException 
	 */
	public OfertaGehitu(Owner o) throws RemoteException, Exception {
		//ApplicationFacadeInterface facade=StartWindow.getBusinessLogic();
		
		//Vector<RuralHouse> rhs=facade.getAllRuralHouses();
		
		
		
		Vector<RuralHouse> houses = facade.SarchByOwner(o.getLogin());
		//comboBox = new JComboBox(houses);
		setBounds(100, 100, 459, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		getContentPane().setLayout(null);

		lblMezu.setBounds(284, 270, 134, 14);
		getContentPane().add(lblMezu);

		JLabel lblNewLabel = new JLabel("Etxea hautatu: ");
		lblNewLabel.setBounds(10, 52, 76, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblOfertaGehitu = new JLabel("Oferta gehitu");
		lblOfertaGehitu.setFont(new Font("Tunga", Font.BOLD, 22));
		lblOfertaGehitu.setBounds(170, 11, 126, 26);
		getContentPane().add(lblOfertaGehitu);

		JLabel lblHasierakoEguna = new JLabel("Hasierako eguna: ");
		lblHasierakoEguna.setBounds(10, 77, 87, 14);
		getContentPane().add(lblHasierakoEguna);

		JLabel lblAzkenekoEguna = new JLabel("Azkeneko eguna:");
		lblAzkenekoEguna.setBounds(228, 77, 87, 14);
		getContentPane().add(lblAzkenekoEguna);
		

		jCalendar1.setBounds(10, 109, 190, 146);
		getContentPane().add(jCalendar1);

		jCalendar2.setBounds(228, 109, 190, 146);
		getContentPane().add(jCalendar2);

		JLabel lblPrezioa = new JLabel("Prezioa: ");
		lblPrezioa.setBounds(250, 52, 46, 14);
		getContentPane().add(lblPrezioa);

		textField = new JTextField();
		textField.setBounds(316, 49, 102, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(98, 74, 102, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(316, 74, 102, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		comboBox = new JComboBox(o.getRuralHouses());
		comboBox.setBounds(98, 49, 76, 20);
		getContentPane().add(comboBox);

		/*try {

			Vector<RuralHouse> houses = facade.SarchByOwner(o.getLogin());

			Vector<String> housenames = new Vector<String>();
			for (int i = 0; i < houses.size(); i++) {
				housenames.add(houses.elementAt(i).getCity()+" "+ houses.elementAt(i).getHouseNumber());
				System.out.println(houses.elementAt(i));
			}
			comboBox = new JComboBox(housenames);

			comboBox.setBounds(new Rectangle(98, 49, 102, 20));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		// calendarios

		jCalendar1.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent propertychangeevent) {
				if (propertychangeevent.getPropertyName().equals("locale")) {
					jCalendar1.setLocale((Locale) propertychangeevent
							.getNewValue());
					DateFormat dateformat = DateFormat.getDateInstance(1,
							jCalendar1.getLocale());
					textField_1.setText(dateformat.format(calendarInicio
							.getTime()));
				} else if (propertychangeevent.getPropertyName().equals(
						"calendar")) {
					calendarInicio = (Calendar) propertychangeevent
							.getNewValue();
					DateFormat dateformat1 = DateFormat.getDateInstance(1,
							jCalendar1.getLocale());
					textField_1.setText(dateformat1.format(calendarInicio
							.getTime()));
					jCalendar1.setCalendar(calendarInicio);
				}
			}
		});

		jCalendar2.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent propertychangeevent) {
				if (propertychangeevent.getPropertyName().equals("locale")) {
					jCalendar2.setLocale((Locale) propertychangeevent
							.getNewValue());
					DateFormat dateformat = DateFormat.getDateInstance(1,
							jCalendar2.getLocale());
					textField_2.setText(dateformat.format(calendarFin.getTime()));
				} else if (propertychangeevent.getPropertyName().equals(
						"calendar")) {
					calendarFin = (Calendar) propertychangeevent.getNewValue();
					DateFormat dateformat1 = DateFormat.getDateInstance(1,
							jCalendar2.getLocale());
					textField_2.setText(dateformat1.format(calendarFin
							.getTime()));
					jCalendar2.setCalendar(calendarFin);
				}
			}
		});

		JButton btnOk = new JButton("OK!");
		btnOk.setBounds(173, 266, 89, 23);
		getContentPane().add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JComboBox comboBox = new JComboBox(o.getRuralHouses());
				btnOk_actionPerformed(e);
			}

		});


	}

	protected void btnOk_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("a ver");
		RuralHouse ruralHouse = (RuralHouse) comboBox.getSelectedItem();
		System.out.println(comboBox.getSelectedItem());
		System.out.println("etxea " + ruralHouse.getCity());

		Date d1 = trim(new Date(jCalendar1.getCalendar().getTime().getTime()));
		String s1 = d1.toString();
		Date d2 = trim(new Date(jCalendar2.getCalendar().getTime().getTime()));
		String s2 = d2.toString();

		if (!textField.getText().equals("")
				&& !textField_1.getText().equals("")
				&& !textField_2.getText().equals("")) {

			lblMezu.setVisible(true);
			try {

				float prezioa = Float.parseFloat(textField.getText());
				if (prezioa == 0) {
					lblMezu.setForeground(Color.RED);
					lblMezu.setText("Prezioa aldatu (Prezio minimoa 1 ¤)");

				} else if (d2.before(d1)) {
					System.out.println("Gaizki datak");
					lblMezu.setForeground(Color.RED);
					lblMezu.setText("Sartu berriro datak.");
				} else {
					boolean of = facade.VerifyOffer(ruralHouse, d1, d2);
					if (of) {
						lblMezu.setForeground(Color.RED);
						lblMezu.setText("Badago oferta bat data hauetan");
						System.out.println("dentro del of");

					} else {
						Boolean off = facade.saveOffer(ruralHouse, d1, d2,
								prezioa);
						if (off) {
							lblMezu.setForeground(Color.BLUE);
							lblMezu.setText("Oferta eratu da!");
						} else {
							lblMezu.setForeground(Color.RED);
							lblMezu.setText("Error, try again");
						}
					}
				}
			} catch (java.lang.NumberFormatException e1) {
				lblMezu.setForeground(Color.RED);
				lblMezu.setText("Error, try again");

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} else {
			lblMezu.setForeground(Color.RED);
			lblMezu.setText("Bete eremu guztiak");
			System.out.println("eremuak bete");
		}

	

	}

	//private btnOk_actionPerformed(ActionEvent e) {
		
	private Date trim(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR, 0);
		return calendar.getTime();
	}

	// private void btnOkactionPerformed(ActionEvent e)
	// {
	// System.out.println("dentro al principio ");
	// //System.out.println(comboBox.getSelectedItem());
	//
	// RuralHouse ruralHouseizena=(RuralHouse) comboBox.getSelectedItem();
	// System.out.println(ruralHouseizena);
	//
	//
	// Date d1=trim(new Date(jCalendar1.getCalendar().getTime().getTime()));
	//
	//
	// Date d2=trim(new Date(jCalendar2.getCalendar().getTime().getTime()));

	/*
	 * try { System.out.println("dentro try");
	 * 
	 * //It could be to trigger an exception if the introduced string is not a
	 * number float prezioa= Float.parseFloat(textField.getText());
	 * 
	 * //Obtain the business logic from a StartWindow class (local or remote)
	 * ApplicationFacadeInterface facade=MainWindow.getBusinessLogic();
	 * 
	 * Offer o = facade.createOffer(ruralHouse, d1, d2, prezioa);
	 * System.out.println("despues create");
	 * //System.out.println("Offer created: "+o.toString());
	 * 
	 * if (o==null){ System.out.println("dentro if");
	 * lblMezu.setText("Bad dates or there exists an overlapping offer"); }else{
	 * lblMezu.setText("Offer created"); }
	 * 
	 * } catch (java.lang.NumberFormatException e1) {
	 * lblMezu.setText(textField.getText()+ " is not a valid price"); } catch
	 * (OverlappingOfferExists e1) {
	 * lblMezu.setText("There exists an overlapping offer"); } catch (BadDates
	 * e1) { lblMezu.setText("Last day is before first day in the offer"); }
	 * catch (Exception e1) {
	 * 
	 * e1.printStackTrace(); }
	 */

}