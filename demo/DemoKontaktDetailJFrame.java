package demo;


import java.util.Observer;
import java.util.Observable;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
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
	private JTextField firstNameField;
	private JTextField emailField;
	private JLabel emailErrorLabel;
	
	private Contact mContact;
	private JLabel lblNotes;

	public DemoKontaktDetailJFrame(Contact contact)
	{
		mContact = contact;
		initialize();
	}
	
	// TODO Map your JTextFields to the internal names
	private JTextField getNameField()
	{
		return nameField;
	}
	private JTextField getFirstNameField()
	{
		return firstNameField;
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
					window.frame.setLocation(100, 100);
					contact.addObserver(window);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					DemoKontaktDetailJFrame window2 = new DemoKontaktDetailJFrame(contact);
					window2.frame.setVisible(true);
					window2.frame.setLocation(500, 100);
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
		frame.setMinimumSize(new Dimension(330, 330));
		frame.setBounds(100, 100, 330, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{120, 120, 25, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{35, 40, 40, 40, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0};
		frame.getContentPane().setLayout(gbl_contentPane);
		
		
		FocusListener saveChecker =  new CheckSaveableFocusListener();
			
		ImageIcon errorIcon = new ImageIcon(DemoKontaktDetailJFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif"));
		
		JLabel lblKontaktDetails = new JLabel("Kontakt Details");
		lblKontaktDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblKontaktDetails = new GridBagConstraints();
		gbc_lblKontaktDetails.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblKontaktDetails.insets = new Insets(0, 0, 5, 5);
		gbc_lblKontaktDetails.gridx = 0;
		gbc_lblKontaktDetails.gridy = 0;
		frame.getContentPane().add(lblKontaktDetails, gbc_lblKontaktDetails);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 2;
		frame.getContentPane().add(lblName, gbc_lblName);
		
		nameField = new JTextField();
		nameField.addFocusListener(saveChecker);
		nameField.setColumns(10);
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(0, 0, 5, 5);
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 2;
		frame.getContentPane().add(nameField, gbc_nameField);
		

		namesErrorLabel = new JLabel(errorIcon);
		namesErrorLabel.setToolTipText("Vorname und Nachmame dürfen nicht beide leer sein");
		GridBagConstraints gbc_namesErrorLabel = new GridBagConstraints();
		gbc_namesErrorLabel.anchor = GridBagConstraints.WEST;
		gbc_namesErrorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_namesErrorLabel.gridx = 2;
		gbc_namesErrorLabel.gridy = 2;
		frame.getContentPane().add(namesErrorLabel, gbc_namesErrorLabel);
		
		lblNotes = new JLabel("Notes:");
		GridBagConstraints gbc_lblNotes = new GridBagConstraints();
		gbc_lblNotes.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNotes.insets = new Insets(0, 0, 5, 5);
		gbc_lblNotes.gridx = 0;
		gbc_lblNotes.gridy = 5;
		frame.getContentPane().add(lblNotes, gbc_lblNotes);

		JTextArea notesArea = new JTextArea();
		notesArea.setColumns(10);
		notesArea.setRows(5);
		GridBagConstraints gbc_notesArea = new GridBagConstraints();
		gbc_notesArea.anchor = GridBagConstraints.NORTH;
		gbc_notesArea.insets = new Insets(0, 0, 5, 5);
		gbc_notesArea.gridx = 1;
		gbc_notesArea.gridy = 5;
		frame.getContentPane().add(notesArea, gbc_notesArea);
		
		firstNameField = new JTextField();
		firstNameField.addFocusListener(saveChecker);
		firstNameField.setColumns(10);
		GridBagConstraints gbc_firstNameField = new GridBagConstraints();
		gbc_firstNameField.insets = new Insets(0, 0, 5, 5);
		gbc_firstNameField.gridx = 1;
		gbc_firstNameField.gridy = 1;
		frame.getContentPane().add(firstNameField, gbc_firstNameField);
		
		JLabel lblVorname = new JLabel("Vorname:");
		GridBagConstraints gbc_lblVorname = new GridBagConstraints();
		gbc_lblVorname.anchor = GridBagConstraints.EAST;
		gbc_lblVorname.insets = new Insets(0, 0, 5, 5);
		gbc_lblVorname.gridx = 0;
		gbc_lblVorname.gridy = 1;
		frame.getContentPane().add(lblVorname, gbc_lblVorname);
		
		JLabel lblEmail = new JLabel("eMail:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 3;
		frame.getContentPane().add(lblEmail, gbc_lblEmail);
		
		emailField = new JTextField();
		emailField.addFocusListener(saveChecker);
		emailField.setColumns(10);
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.insets = new Insets(0, 0, 5, 5);
		gbc_emailField.gridx = 1;
		gbc_emailField.gridy = 3;
		frame.getContentPane().add(emailField, gbc_emailField);

		emailErrorLabel = new JLabel(errorIcon);
		emailErrorLabel.setToolTipText("eMail Adresse muss gültig sein!");
		GridBagConstraints gbc_emailErrorLabel = new GridBagConstraints();
		gbc_emailErrorLabel.anchor = GridBagConstraints.WEST;
		gbc_emailErrorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailErrorLabel.gridx = 2;
		gbc_emailErrorLabel.gridy = 3;
		frame.getContentPane().add(emailErrorLabel, gbc_emailErrorLabel);
		

		/*
		 * TODO
		 * Stuff to fill in
		 * 
		 */
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Saved record for: "+getNameField().getText()+" "+getFirstNameField().getText());
			}
		});
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.anchor = GridBagConstraints.WEST;
		gbc_saveButton.insets = new Insets(0, 0, 5, 5);
		gbc_saveButton.gridx = 2;
		gbc_saveButton.gridy = 7;
		frame.getContentPane().add(saveButton, gbc_saveButton);
		
	}
	
	
	private boolean hasAtLeastOneName () {
		if (getNameField().getText().equals("") && getFirstNameField().getText().equals("")){
			getNamesErrorLabel().setVisible(true);
			return false;
		} else {
			getNamesErrorLabel().setVisible(false);
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

	
	public void update(Observable object, Object arg)
	{
		nameField.setText(mContact.getName());
		firstNameField.setText(mContact.getFirstName());
		emailField.setText(mContact.getEMail());
		
		checkSaveable();
	}
	
	private void checkSaveable() {
		Boolean isOk = hasAtLeastOneName();
		
		if (isOk) {
			mContact.setName(getNameField().getText());
			mContact.setFirstName(getFirstNameField().getText());
		}
		isOk = isValidEmail() && isOk;
		
		if (isOk) {
			mContact.setEMail(getEMailField().getText());
		}
		//isOk = validOffTelNr() && isOk;
		//isOk = validMobileTelNr() && isOk;  //TODO
		//isOk = validBirthDate() && isOk; //TODO
		
		if (isOk) {
			saveButton.setToolTipText("Save");
			saveButton.setEnabled(true);
		} else {
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
