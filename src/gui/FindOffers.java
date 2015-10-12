package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import businessLogic.ApplicationFacadeInterface;

import com.toedter.calendar.JCalendar;

import domain.Offer;
import domain.RuralHouse;

import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JButton;

public class FindOffers extends JFrame implements Serializable{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Calendar calendarInicio = null;
	private Calendar calendarFin = null;
	ApplicationFacadeInterface facade = StartWindow.getBusinessLogic();
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
					FindOffers frame = new FindOffers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FindOffers() {
		setBounds(100, 100, 473, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblMezu.setBounds(292, 226, 139, 14);
		contentPane.add(lblMezu);


		getContentPane().setLayout(null);
		contentPane.setLayout(null);

		JLabel lblFirstDate = new JLabel("First date: ");
		lblFirstDate.setBounds(32, 44, 66, 14);
		getContentPane().add(lblFirstDate);

		JLabel lblLastDate = new JLabel("Last date: ");
		lblLastDate.setBounds(241, 44, 66, 14);
		getContentPane().add(lblLastDate);

		textField = new JTextField();
		textField.setBounds(99, 41, 122, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(309, 41, 122, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		jCalendar1.setBounds(32, 69, 190, 146);
		getContentPane().add(jCalendar1);

		jCalendar2.setBounds(241, 69, 190, 146);
		getContentPane().add(jCalendar2);

		jCalendar1.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent propertychangeevent) {
				if (propertychangeevent.getPropertyName().equals("locale")) {
					jCalendar1.setLocale((Locale) propertychangeevent
							.getNewValue());
					DateFormat dateformat = DateFormat.getDateInstance(1,
							jCalendar1.getLocale());
					textField.setText(dateformat.format(calendarInicio
							.getTime()));
				} else if (propertychangeevent.getPropertyName().equals(
						"calendar")) {
					calendarInicio = (Calendar) propertychangeevent
							.getNewValue();
					DateFormat dateformat1 = DateFormat.getDateInstance(1,
							jCalendar1.getLocale());
					textField.setText(dateformat1.format(calendarInicio
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
					textField_1.setText(dateformat.format(calendarFin.getTime()));
				} else if (propertychangeevent.getPropertyName().equals(
						"calendar")) {
					calendarFin = (Calendar) propertychangeevent.getNewValue();
					DateFormat dateformat1 = DateFormat.getDateInstance(1,
							jCalendar2.getLocale());
					textField_1.setText(dateformat1.format(calendarFin
							.getTime()));
					jCalendar2.setCalendar(calendarFin);
				}
			}
		});

		JLabel lblBilatuOfertak = new JLabel("Bilatu Ofertak");
		lblBilatuOfertak.setFont(new Font("Tunga", Font.BOLD, 22));
		lblBilatuOfertak.setBounds(170, 11, 162, 22);
		getContentPane().add(lblBilatuOfertak);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		JButton btnBilatu = new JButton("Bilatu");
		btnBilatu.setBounds(193, 221, 89, 23);
		btnBilatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				Date d1 = trim(new Date(jCalendar1.getCalendar().getTime()
						.getTime()));
				String s1 = d1.toString();
				Date d2 = trim(new Date(jCalendar2.getCalendar().getTime()
						.getTime()));
				String s2 = d2.toString();
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(32, 255, 389, 20);
				//comboBox.setVisible(true);
				lblMezu.setVisible(true);

				if (!textField.getText().equals("")
						&& !textField_1.getText().equals("")) {

					if (d2.before(d1)) {
						comboBox.setVisible(false);
						lblMezu.setForeground(Color.RED);
						lblMezu.setText("Datak ez egokiak.");
						System.out.println("Gaizki datak");
					} else {
						System.out.println("ondo");

						try {
							Vector<Offer> ofertak = facade.getOffers(d1, d2);
							System.out.println(ofertak);
							
						
							if (ofertak.size() == 0) {
								comboBox.setVisible(false);
								lblMezu.setForeground(Color.RED);
								lblMezu.setText("Ez daude ofertak.");
								
								
							} else {
								lblMezu.setVisible(false);
								comboBox.setVisible(true);
								Vector<String>offr= new Vector<String>();
								for (int i=0; i< ofertak.size(); i++){
									offr.add(ofertak.elementAt(i).getRuralHouse().getCity()+" "+ofertak.elementAt(i).getRuralHouse().getDescription()+" "+ofertak.elementAt(i).getPrice()+"¤");
								}
								
								
								comboBox = new JComboBox(offr);
								comboBox.setBounds(32, 255, 389, 20);
								getContentPane().add(comboBox);
								
							}

							

							
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				}

			}

		});
		getContentPane().add(btnBilatu);
		
		
	}

	private Date trim(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR, 0);
		return calendar.getTime();

	}
}
