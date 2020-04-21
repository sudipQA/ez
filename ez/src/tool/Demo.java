package tool;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
//import tool.SimpleExcelReaderExample;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Demo extends JFrame {

	private JPanel contentPane;
	private JTextField t2;
	private JTextField t1;
	private JTextField t3;
	private JTextField t4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo frame = new Demo();
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
	public Demo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Automation Datasheet Validation");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(165, 42, 42));
		
		JLabel lblDatasheetPath = new JLabel("Datasheet Path");
		lblDatasheetPath.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblTestcaseName = new JLabel("Control Sheet");
		lblTestcaseName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		t2 = new JTextField();
		t2.setColumns(10);
		
		t1 = new JTextField();
		t1.setColumns(10);
		
		JButton btnValidate = new JButton("Validate");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//SimpleExcelReaderExample bt = new SimpleExcelReaderExample();
				//Excelreader bt = new Excelreader();
				base kt = new base();
				kt.autopath = t1.getText();
				kt.autocontrol=t2.getText();
				kt.testNm =t3.getText();
				
				
				
				
				        try {
							kt.automain();
					} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				String outpt = kt.outpath;        
				System.out.println(outpt);
				t4.setText(outpt);
				System.out.println("complete");
			}
		});
		btnValidate.setBackground(new Color(175, 238, 238));
		btnValidate.setForeground(Color.BLACK);
		btnValidate.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		t3 = new JTextField();
		t3.setColumns(10);
		
		JLabel label = new JLabel("Testcase Name");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblResultPath = new JLabel("RESULT PATH");
		lblResultPath.setBackground(Color.ORANGE);
		lblResultPath.setForeground(Color.BLUE);
		lblResultPath.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		t4 = new JTextField();
		t4.setBackground(new Color(169, 169, 169));
		t4.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTestcaseName)
						.addComponent(lblDatasheetPath, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblResultPath, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)))
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(t3, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
									.addGap(141))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(t1, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
									.addComponent(t2)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap(74, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(t4, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(381, Short.MAX_VALUE)
					.addComponent(btnValidate)
					.addGap(67))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDatasheetPath)
						.addComponent(t1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTestcaseName)
						.addComponent(t2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(t3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnValidate)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblResultPath)
						.addComponent(t4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
