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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.border.CompoundBorder;
import javax.swing.SwingConstants;


public class ContactDetailJFrame implements Observer {

	private JFrame frame;
	private JTextField nameField;	
	private JLabel namesErrorLabel;
	private JButton saveButton;
	private JTextField firstNameField;
	private JTextField emailField;
	private JLabel emailErrorLabel;
	
	private Contact mContact;
	private JLabel lblNotes;
	private JLabel lblTelBro;
	private JLabel lblTelMobile;
	private JLabel lblGeburtstag;
	private JTextField phoneField;
	private JLabel phoneErrorLabel;
	private JTextField mobilePhoneField;
	private JLabel mobilePhoneErrorLabel;
	private JTextField birthdayField;
	private JLabel birthdayErrorLabel;
	private JTextArea notesArea;

	public ContactDetailJFrame(Contact contact)
	{
		mContact = contact;
		initialize();
	}
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
		return phoneField;
	}
	private JTextField getTelMobileField()
	{
		return mobilePhoneField;
	}
	private JTextField getBirthDayField()
	{
		return birthdayField;
	}
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
		return phoneErrorLabel;
	}
	private JLabel getTelMobileErrorLabel()
	{
		return mobilePhoneErrorLabel;
	}	
	private JLabel getBirthDayErrorLabel()
	{
		return birthdayErrorLabel;
	}
	private JTextArea getNotesArea()
	{
		return notesArea;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				Contact contact = new Contact();

				try {
					ContactDetailJFrame window = new ContactDetailJFrame(contact);
					window.frame.setVisible(true);
					window.frame.setLocation(100, 100);
					contact.addObserver(window);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					ContactDetailJFrame window2 = new ContactDetailJFrame(contact);
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
	public ContactDetailJFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(350, 400));
		frame.setBounds(100, 100, 360, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FocusListener saveChecker =  new CheckSaveableFocusListener();
		KeyListener validChecker = new CheckSaveableKeyEventListener();
			
		ImageIcon errorIcon = new ImageIcon(ContactDetailJFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif"));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{10, 104, 120, 68, 10, 0};
		gridBagLayout.rowHeights = new int[]{35, 25, 38, 38, 38, 38, 38, 0, 75, 0, 35, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		firstNameField = new JTextField();
		firstNameField.addFocusListener(saveChecker);
		firstNameField.addKeyListener(validChecker);
		
		JLabel lblKontaktDetails = new JLabel("Kontakt Details");
		lblKontaktDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblKontaktDetails = new GridBagConstraints();
		gbc_lblKontaktDetails.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
		gbc_lblKontaktDetails.insets = new Insets(0, 0, 5, 5);
		gbc_lblKontaktDetails.gridx = 1;
		gbc_lblKontaktDetails.gridy = 0;
		frame.getContentPane().add(lblKontaktDetails, gbc_lblKontaktDetails);
		
		JLabel lblVorname = new JLabel("Vorname:");
		GridBagConstraints gbc_lblVorname = new GridBagConstraints();
		gbc_lblVorname.anchor = GridBagConstraints.EAST;
		gbc_lblVorname.insets = new Insets(0, 0, 5, 5);
		gbc_lblVorname.gridx = 1;
		gbc_lblVorname.gridy = 1;
		frame.getContentPane().add(lblVorname, gbc_lblVorname);
		firstNameField.setColumns(10);
		GridBagConstraints gbc_firstNameField = new GridBagConstraints();
		gbc_firstNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstNameField.insets = new Insets(0, 0, 5, 5);
		gbc_firstNameField.gridx = 2;
		gbc_firstNameField.gridy = 1;
		frame.getContentPane().add(firstNameField, gbc_firstNameField);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 2;
		frame.getContentPane().add(lblName, gbc_lblName);
				
		nameField = new JTextField();
		nameField.addFocusListener(saveChecker);
		nameField.addKeyListener(validChecker);
		nameField.setColumns(10);
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.insets = new Insets(0, 0, 5, 5);
		gbc_nameField.gridx = 2;
		gbc_nameField.gridy = 2;
		frame.getContentPane().add(nameField, gbc_nameField);
		
		namesErrorLabel = new JLabel(errorIcon);
		namesErrorLabel.setToolTipText("Vorname und Nachmame dürfen nicht beide leer sein");
		GridBagConstraints gbc_namesErrorLabel = new GridBagConstraints();
		gbc_namesErrorLabel.anchor = GridBagConstraints.WEST;
		gbc_namesErrorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_namesErrorLabel.gridx = 3;
		gbc_namesErrorLabel.gridy = 2;
		frame.getContentPane().add(namesErrorLabel, gbc_namesErrorLabel);
		
		JLabel lblEmail = new JLabel("eMail:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 3;
		frame.getContentPane().add(lblEmail, gbc_lblEmail);
		
		emailField = new JTextField();
		emailField.addFocusListener(saveChecker);
		emailField.addKeyListener(validChecker);
		emailField.setColumns(10);
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.insets = new Insets(0, 0, 5, 5);
		gbc_emailField.gridx = 2;
		gbc_emailField.gridy = 3;
		frame.getContentPane().add(emailField, gbc_emailField);

		emailErrorLabel = new JLabel(errorIcon);
		emailErrorLabel.setToolTipText("eMail Adresse muss gültig sein!");
		GridBagConstraints gbc_emailErrorLabel = new GridBagConstraints();
		gbc_emailErrorLabel.anchor = GridBagConstraints.WEST;
		gbc_emailErrorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailErrorLabel.gridx = 3;
		gbc_emailErrorLabel.gridy = 3;
		frame.getContentPane().add(emailErrorLabel, gbc_emailErrorLabel);
		
		lblTelBro = new JLabel("Tel. Büro:");
		GridBagConstraints gbc_lblTelBro = new GridBagConstraints();
		gbc_lblTelBro.anchor = GridBagConstraints.EAST;
		gbc_lblTelBro.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelBro.gridx = 1;
		gbc_lblTelBro.gridy = 4;
		frame.getContentPane().add(lblTelBro, gbc_lblTelBro);
		
		phoneField = new JTextField();
		phoneField.addFocusListener(saveChecker);
		phoneField.addKeyListener(validChecker);
		GridBagConstraints gbc_phoneField = new GridBagConstraints();
		gbc_phoneField.insets = new Insets(0, 0, 5, 5);
		gbc_phoneField.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneField.gridx = 2;
		gbc_phoneField.gridy = 4;
		frame.getContentPane().add(phoneField, gbc_phoneField);
		phoneField.setColumns(10);
		
		phoneErrorLabel = new JLabel(errorIcon);
		phoneErrorLabel.setToolTipText("Telefonnummer muss gültig sein!");
		GridBagConstraints gbc_phoneErrorLabel = new GridBagConstraints();
		gbc_phoneErrorLabel.anchor = GridBagConstraints.WEST;
		gbc_phoneErrorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_phoneErrorLabel.gridx = 3;
		gbc_phoneErrorLabel.gridy = 4;
		frame.getContentPane().add(phoneErrorLabel, gbc_phoneErrorLabel);
		
		lblTelMobile = new JLabel("Tel. Mobil:");
		GridBagConstraints gbc_lblTelMobile = new GridBagConstraints();
		gbc_lblTelMobile.anchor = GridBagConstraints.EAST;
		gbc_lblTelMobile.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelMobile.gridx = 1;
		gbc_lblTelMobile.gridy = 5;
		frame.getContentPane().add(lblTelMobile, gbc_lblTelMobile);
		
		mobilePhoneField = new JTextField();
		mobilePhoneField.addFocusListener(saveChecker);
		mobilePhoneField.addKeyListener(validChecker);
		GridBagConstraints gbc_mobilePhoneField = new GridBagConstraints();
		gbc_mobilePhoneField.insets = new Insets(0, 0, 5, 5);
		gbc_mobilePhoneField.fill = GridBagConstraints.HORIZONTAL;
		gbc_mobilePhoneField.gridx = 2;
		gbc_mobilePhoneField.gridy = 5;
		frame.getContentPane().add(mobilePhoneField, gbc_mobilePhoneField);
		mobilePhoneField.setColumns(10);
		
		mobilePhoneErrorLabel = new JLabel(errorIcon);
		mobilePhoneErrorLabel.setToolTipText("Telefonnummer muss gültig sein!");
		mobilePhoneErrorLabel.setVisible(false);
		GridBagConstraints gbc_mobilePhoneErrorLabel = new GridBagConstraints();
		gbc_mobilePhoneErrorLabel.anchor = GridBagConstraints.WEST;
		gbc_mobilePhoneErrorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_mobilePhoneErrorLabel.gridx = 3;
		gbc_mobilePhoneErrorLabel.gridy = 5;
		frame.getContentPane().add(mobilePhoneErrorLabel, gbc_mobilePhoneErrorLabel);
		
		lblGeburtstag = new JLabel("Geburtstag:");
		GridBagConstraints gbc_lblGeburtstag = new GridBagConstraints();
		gbc_lblGeburtstag.anchor = GridBagConstraints.EAST;
		gbc_lblGeburtstag.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeburtstag.gridx = 1;
		gbc_lblGeburtstag.gridy = 6;
		frame.getContentPane().add(lblGeburtstag, gbc_lblGeburtstag);
		
		birthdayField = new JTextField();
		birthdayField.addFocusListener(saveChecker);
		birthdayField.addKeyListener(validChecker);
		GridBagConstraints gbc_birthdayField = new GridBagConstraints();
		gbc_birthdayField.insets = new Insets(0, 0, 5, 5);
		gbc_birthdayField.fill = GridBagConstraints.HORIZONTAL;
		gbc_birthdayField.gridx = 2;
		gbc_birthdayField.gridy = 6;
		frame.getContentPane().add(birthdayField, gbc_birthdayField);
		birthdayField.setColumns(10);
		
		birthdayErrorLabel = new JLabel(errorIcon);
		birthdayErrorLabel.setToolTipText("Geburtstag muss Format dd.mm.yyyy haben.");
		GridBagConstraints gbc_birthdayErrorLabel = new GridBagConstraints();
		gbc_birthdayErrorLabel.anchor = GridBagConstraints.WEST;
		gbc_birthdayErrorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_birthdayErrorLabel.gridx = 3;
		gbc_birthdayErrorLabel.gridy = 6;
		frame.getContentPane().add(birthdayErrorLabel, gbc_birthdayErrorLabel);
		
		lblNotes = new JLabel("Notes:");
		GridBagConstraints gbc_lblNotes = new GridBagConstraints();
		gbc_lblNotes.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNotes.insets = new Insets(0, 0, 5, 5);
		gbc_lblNotes.gridx = 1;
		gbc_lblNotes.gridy = 8;
		frame.getContentPane().add(lblNotes, gbc_lblNotes);

		notesArea = new JTextArea();
		notesArea.addFocusListener(saveChecker);
		notesArea.addKeyListener(validChecker);
		notesArea.setMinimumSize(new Dimension(120, 40));
		notesArea.setMaximumSize(new Dimension(120, 70));
		notesArea.setLineWrap(true);
		notesArea.setBorder(new CompoundBorder(new CompoundBorder(), new CompoundBorder()));
		notesArea.setRows(5);
		GridBagConstraints gbc_notesArea = new GridBagConstraints();
		gbc_notesArea.fill = GridBagConstraints.BOTH;
		gbc_notesArea.anchor = GridBagConstraints.NORTH;
		gbc_notesArea.insets = new Insets(0, 0, 5, 5);
		gbc_notesArea.gridx = 2;
		gbc_notesArea.gridy = 8;
		frame.getContentPane().add(notesArea, gbc_notesArea);
				
		saveButton = new JButton("Save");
		saveButton.setHorizontalAlignment(SwingConstants.LEFT);
		saveButton.setEnabled(false);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Saved record for: "+getNameField().getText()+" "+getFirstNameField().getText());
			}
		});
		
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.insets = new Insets(0, 0, 0, 5);
		gbc_saveButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_saveButton.gridx = 3;
		gbc_saveButton.gridy = 10;
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
		if (SimpleValidator.isValidTelNr(getTelOfficeField().getText()) && !getTelOfficeField().getText().equals("")) {
			getTelOfficeErrorLabel().setVisible(false);
			return true;
		}else{
			getTelOfficeErrorLabel().setVisible(true);
			return false;		
		}
	}

	private boolean validMobileTelNr () {
		if (SimpleValidator.isValidTelNr(getTelMobileField().getText())) {
			getTelMobileErrorLabel().setVisible(false);
			return true;
		}else{
			getTelMobileErrorLabel().setVisible(true);
			return false;		
		}
	}
	
	private boolean validBirthDate () {
		if (SimpleValidator.isValidDate(getBirthDayField().getText()) && !getBirthDayField().getText().equals("")) {
			getBirthDayErrorLabel().setVisible(false);
			return true;
		}else{
			getBirthDayErrorLabel().setVisible(true);
			return false;		
		}
	}
	
	public void update(Observable object, Object arg)
	{
		// update only the fields which have changed on the event calling this update
		// otherwise not valid fields will be deleted when changing some other valid fields
		
		if (arg.toString().equals("name")) {
			nameField.setText(mContact.getName());
		}
		if (arg.toString().equals("firstName")) {
			firstNameField.setText(mContact.getFirstName());
		}
		if (arg.toString().equals("eMail")) {
			emailField.setText(mContact.getEMail());
		}
		if (arg.toString().equals("telOffice")) {
			phoneField.setText(mContact.getTelOffice());
		}
		if (arg.toString().equals("telMobil")) {
			mobilePhoneField.setText(mContact.getTelMobile());
		}
		if (arg.toString().equals("birthDay")) {
			birthdayField.setText(mContact.getBirthDay());
		}
		if (arg.toString().equals("notes")) {
			notesArea.setText(mContact.getNotes());
		}

		checkSaveable();
	}
	
	private void checkSaveable() {
		Boolean isOk = hasAtLeastOneName();
		
		if (isOk) {
			mContact.setName(getNameField().getText());
			mContact.setFirstName(getFirstNameField().getText());
		}
		
		isOk = isValidEmail() && isOk;
		if (isValidEmail()) {
			mContact.setEMail(getEMailField().getText());
		}
		
		isOk = validOffTelNr() && isOk;
		if (validOffTelNr()) {
			mContact.setTelOffice(getTelOfficeField().getText());
		}
		
		isOk = validMobileTelNr() && isOk;
		if (validMobileTelNr()) {
			mContact.setTelMobile(getTelMobileField().getText());
		}
		
		isOk = validBirthDate() && isOk;
		if (validBirthDate()) {
			mContact.setBirthDay(getBirthDayField().getText());
		}
		// no validation of notes, just set mContact
		mContact.setNotes(getNotesArea().getText());
		
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
	
	private class CheckSaveableKeyEventListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent arg0) {
			checkSaveable();
		}
	}
}
