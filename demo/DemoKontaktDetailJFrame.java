package demo;


import java.util.Observer;
import java.util.Observable;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;

import util.SimpleValidator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class DemoKontaktDetailJFrame implements Observer {

	private JFrame frame;
	private JTextField nameField;	
	private JLabel namesErrorLabel;
	private JButton saveButton;
	private JTextField vornameField;
	private JTextField emailField;
	private JLabel vornameErrorLabel;
	private JLabel emailErrorLabel;
	
	private Contact mContact;

	public DemoKontaktDetailJFrame(Contact contact)
	{
		mContact = contact;
		initialize();
	}
	
	public void update(Observable object, Object arg)
	{
		vornameField.setText(mContact.getFirstName());
		nameField.setText(mContact.getName());
		emailField.setText(mContact.geteMail());
		System.out.println("Update" + arg);
	}
	
	// TODO Map your JTextFields to the internal names
	private JTextField getNameField()
	{
		return nameField;
	}
	private JTextField getFirstNameField()
	{
		return vornameField;
	}
	private JTextField getEMailField()
	{
		return emailField;
	}
	private JTextField getTelOfficeField()
	{
		return null;
	}
	private JTextField getTelMobileField()
	{
		return null;
	}
	private JTextField getBirthDayField()
	{
		return null;
	}
	
	// TODO Map your JLabels to the internal names
	private JLabel getNamesErrorLabel()
	{
		return namesErrorLabel;
	}
	private JLabel getVornameErrorLabel()
	{
		return vornameErrorLabel;
	}
	private JLabel getEMailErrorLabel()
	{
		return emailErrorLabel;
	}
	private JLabel getTelOfficeErrorLabel()
	{
		return null;
	}
	
	private JLabel getTelMobileErrorLabel()
	{
		return null;
	}	
	
	private JLabel getBirthDayErrorLabel()
	{
		return null;
	}



	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				Contact contact = new Contact();

				try {
					DemoKontaktDetailJFrame window = new DemoKontaktDetailJFrame(contact);
					window.frame.setVisible(true);
					contact.addObserver(window);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					DemoKontaktDetailJFrame window2 = new DemoKontaktDetailJFrame(contact);
					window2.frame.setVisible(true);
					contact.addObserver(window2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DemoKontaktDetailJFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 291, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		FocusListener saveCecker =  new CheckSaveableFocusListener();
			
		ImageIcon errorIcon = new ImageIcon(DemoKontaktDetailJFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif"));
		
		JLabel lblKontaktDetails = new JLabel("Kontakt Details");
		lblKontaktDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKontaktDetails.setBounds(10, 15, 100, 17);
		frame.getContentPane().add(lblKontaktDetails);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 46, 71, 14);
		frame.getContentPane().add(lblName);
		
		nameField = new JTextField();
		nameField.addFocusListener(saveCecker);
		nameField.setBounds(80, 43, 150, 20);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);

		namesErrorLabel = new JLabel(errorIcon);
		namesErrorLabel.setToolTipText("Vorname und Nachmame d�rfen nicht beide l sein");
		namesErrorLabel.setBounds(233, 31, 32, 32);
		frame.getContentPane().add(namesErrorLabel);

		/*
		 * TODO
		 * Stuff to fill in
		 * 
		 */

		JTextArea notesArea = new JTextArea();
		notesArea.setBounds(10, 211, 214, 119);
		frame.getContentPane().add(notesArea);
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Saved record for: "+getNameField().getText()+" "+getFirstNameField().getText());
			}
		});
		saveButton.setBounds(10, 350, 89, 23);
		frame.getContentPane().add(saveButton);
		
		vornameField = new JTextField();
		vornameField.addFocusListener(saveCecker);
		vornameField.setBounds(80, 72, 150, 20);
		frame.getContentPane().add(vornameField);
		vornameField.setColumns(10);
		
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setBounds(10, 75, 71, 14);
		frame.getContentPane().add(lblVorname);
		
		JLabel lblEmail = new JLabel("eMail:");
		lblEmail.setBounds(10, 106, 71, 14);
		frame.getContentPane().add(lblEmail);
		
		emailField = new JTextField();
		emailField.addFocusListener(saveCecker);
		emailField.setBounds(80, 103, 150, 20);
		frame.getContentPane().add(emailField);
		emailField.setColumns(10);
		
		vornameErrorLabel = new JLabel("New label");
		vornameErrorLabel.setIcon(new ImageIcon(DemoKontaktDetailJFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		vornameErrorLabel.setBounds(233, 66, 32, 32);
		frame.getContentPane().add(vornameErrorLabel);
		
		emailErrorLabel = new JLabel("New label");
		emailErrorLabel.setIcon(new ImageIcon(DemoKontaktDetailJFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		emailErrorLabel.setBounds(233, 97, 32, 32);
		frame.getContentPane().add(emailErrorLabel);
		
		// add Observer
		//mContact.addObserver(this);
		
	}
	
	
	private boolean hasAtLeastOneName () {
		if (getNameField().getText().equals("") && getFirstNameField().getText().equals("")){
			getNamesErrorLabel().setVisible(true);
			getVornameErrorLabel().setVisible(true);
			return false;
		} else if (getNameField().getText().equals("")){
			getNamesErrorLabel().setVisible(true);
			return false;
		} else if (getFirstNameField().getText().equals("")){
			getVornameErrorLabel().setVisible(true);
			return false;	
		} else {
			getNamesErrorLabel().setVisible(false);
			getVornameErrorLabel().setVisible(false);
			return true;			
		}
	}

	private boolean isValidEmail () {
		if (SimpleValidator.isValidEmail(getEMailField().getText()) && !getEMailField().getText().equals("")) {
			getEMailErrorLabel().setVisible(false);
			return true;
		} else {
			getEMailErrorLabel().setVisible(true);
			return false;		
		}
	}


	private boolean validOffTelNr () {
		if (SimpleValidator.isValidTelNr(getTelOfficeField().getText())) {
			getTelOfficeErrorLabel().setVisible(false);
			return true;
		}else{
			getTelOfficeErrorLabel().setVisible(true);
			return false;		
		}
	}

	private void checkSaveable() {
		Boolean isOk = hasAtLeastOneName();
		isOk = isValidEmail() && isOk;
		//isOk = validOffTelNr() && isOk;
		//isOk = validMobileTelNr() && isOk;  //TODO
		//isOk = validBirthDate() && isOk; //TODO
		
		if (isOk) {
			saveButton.setToolTipText("Save");
			saveButton.setEnabled(true);
			mContact.setFirstName(getFirstNameField().getText());
		}else{
			saveButton.setToolTipText("Remove Errors before Saving");
			saveButton.setEnabled(false);		
		}
	}
	
	
	private class CheckSaveableFocusListener extends FocusAdapter {
		@Override
		public void focusLost(FocusEvent arg0) {
			checkSaveable();
		}	
	}
}
