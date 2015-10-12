package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.Serializable;

import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class Register extends JFrame implements ActionListener, Serializable {

    private JPanel contentPane;
    private JPanel panelPrinci;
    private Boolean cli = false;
    private Boolean own = false;
    private final ButtonGroup GroupRegister = new ButtonGroup();

    /**
     * Create the frame.
     */
    public Register() {
        setBounds(100, 100, 388, 519);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelPrinci = new JPanel();
        panelPrinci.setBounds(10, 81, 352, 388);
        contentPane.add(panelPrinci);
        panelPrinci.setLayout(null);

		// ////
        // JPanel panelSub = new JPanel();
        // panelSub.setBounds(10, 11, 332, 370);
        // panelPrinci.add(panelSub);
        // //
        JPanel registerMetod = new JPanel();
        registerMetod.setBounds(31, 11, 302, 59);
        registerMetod.setBorder(new TitledBorder(UIManager
                .getBorder("TitledBorder.border"), "Register as:",
                TitledBorder.LEADING, TitledBorder.TOP, null,
                new Color(0, 0, 0)));
        contentPane.add(registerMetod);
        registerMetod.setLayout(null);

        JRadioButton optUser = new JRadioButton("User");
        optUser.addActionListener(this);
        GroupRegister.add(optUser);
        optUser.setBounds(70, 20, 67, 23);
        registerMetod.add(optUser);

        JRadioButton optOwner = new JRadioButton("Owner");
        //optOwner.setSelected(true);
        optOwner.addActionListener(this);
        GroupRegister.add(optOwner);
        optOwner.setBounds(159, 20, 74, 23);
        registerMetod.add(optOwner);
/*
        if (optUser.isSelected()) {
            panelPrinci.setVisible(false);
            panelPrinci.removeAll();
            JPanel panelClient = new RegisterClient();
            panelClient.setBorder(new EmptyBorder(1, 1, 1, 1));
            panelClient.setBackground(Color.WHITE);
            panelClient.setBounds(45, 11, 250, 240);
            panelPrinci.add(panelClient);
            panelPrinci.setVisible(true);
        } else if (optOwner.isSelected()) {
            panelPrinci.setVisible(false);
            panelPrinci.removeAll();
            JPanel panelOwner = new RegisterOwner();
            panelOwner.setBorder(new EmptyBorder(1, 1, 1, 1));
            panelOwner.setBackground(Color.WHITE);
            panelOwner.setBounds(45, 11, 250, 310);
            panelPrinci.add(panelOwner);
            panelPrinci.setVisible(true);
        }

     * Create the frame.
     */
        
    }

    
    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub
        if (ae.getActionCommand().compareTo("User") == 0) {
            panelPrinci.setVisible(false);
            panelPrinci.removeAll();
            JPanel panelClient = new RegisterClient();
            panelClient.setBorder(new EmptyBorder(1, 1, 1, 1));
            panelClient.setBackground(Color.WHITE);
            panelClient.setBounds(45, 11, 250, 240);
            panelPrinci.add(panelClient);
            panelPrinci.setVisible(true);
        }
        if (ae.getActionCommand().compareTo("Owner") == 0) {
            panelPrinci.setVisible(false);
            panelPrinci.removeAll();
            JPanel panelOwner = new RegisterOwner();
            panelOwner.setBorder(new EmptyBorder(1, 1, 1, 1));
            panelOwner.setBackground(Color.WHITE);
            panelOwner.setBounds(45, 11, 250, 310);
            panelPrinci.add(panelOwner);
            panelPrinci.setVisible(true);
        }
    }

}
