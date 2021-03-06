import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ClientFrame {

	private JFrame frame;
	private JTextField translatedTextF;
	ClientTranslation clientTr = new ClientTranslation();
	ServerTranslationApplication serverTr = new ServerTranslationApplication();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame window = new ClientFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 14));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		translatedTextF = new JTextField();
//		translatedTextF.setFont(new Font("Calibri", Font.PLAIN, 14));
		translatedTextF.setEditable(false);
		translatedTextF.setBounds(68, 146, 159, 31);
		frame.getContentPane().add(translatedTextF);
		translatedTextF.setColumns(10);
		
		JComboBox<String> comboBoxText = new JComboBox<String>();
		comboBoxText.setModel(new DefaultComboBoxModel<String>(clientTr.defaultText));
		comboBoxText.setFont(new Font("Calibri", Font.PLAIN, 14));
		comboBoxText.setBounds(68, 26, 159, 32);
		frame.getContentPane().add(comboBoxText);
		
		JComboBox<String> comboBoxLang = new JComboBox<String>();
		comboBoxLang.setModel(new DefaultComboBoxModel<String>(clientTr.languageSelect));
		comboBoxLang.setFont(new Font("Calibri", Font.PLAIN, 14));
		comboBoxLang.setBounds(68, 86, 159, 32);
		frame.getContentPane().add(comboBoxLang);
		
		JLabel lblNewLabel = new JLabel("Selected text");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel.setBounds(291, 31, 76, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblLanguage.setBounds(302, 91, 55, 23);
		frame.getContentPane().add(lblLanguage);
		
		JButton btnNewButton = new JButton("Translate");
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				try {
//					serverTr.serverTranslationApplications();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				int textSelect = comboBoxText.getSelectedIndex();
				int langSelect= comboBoxLang.getSelectedIndex();
				String translatedText = clientTr.clientTranslation(langSelect, textSelect);
				if (langSelect == 2) {
					translatedTextF.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
				}else {
					translatedTextF.setFont(new Font("Calibri", Font.PLAIN, 14));
				}
				translatedTextF.setText(translatedText);
			}
		});
		btnNewButton.setBounds(283, 145, 92, 32);
		frame.getContentPane().add(btnNewButton);
	}
}
