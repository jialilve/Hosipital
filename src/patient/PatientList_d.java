package patient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.PatientDao;
import model.Patient;
import view.Indexframe;

public class PatientList_d extends JFrame {

	

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	private JPanel contentPane;
	private JTable table;
	private JTextField id;
	private JTextField name;
	private JTextField sex;
	private JTextField state;
	private DefaultTableModel dtm=null;
	private String idd;
	/**
	 * Launch the application.
	 */
	 
	/**
	 * Create the frame.
	 */
	public PatientList_d(String idd) 
	{
		this.idd=idd;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 818, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 784, 345);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				mouseClick(e);
			}
		});
		table.setFont(new Font("华文楷体", Font.PLAIN, 16));
		table.setBackground(new Color(200,210,210));
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u75C5\u4EBA\u7F16\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u8D26\u6237\u4F59\u989D", "\u7C4D\u8D2F", "\u75C5\u4EBA\u5907\u6CE8"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(87);
		table.getColumnModel().getColumn(1).setPreferredWidth(95);
		table.getColumnModel().getColumn(2).setPreferredWidth(77);
		table.getColumnModel().getColumn(3).setPreferredWidth(83);
		table.getColumnModel().getColumn(4).setPreferredWidth(97);
		table.getColumnModel().getColumn(5).setPreferredWidth(84);
		table.getColumnModel().getColumn(6).setPreferredWidth(94);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u75C5\u4EBA\u7F16\u53F7");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 19));
		lblNewLabel.setBounds(10, 387, 82, 21);
		contentPane.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(108, 387, 82, 24);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(232, 387, 54, 21);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(304, 387, 82, 24);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B");
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(10, 441, 63, 21);
		contentPane.add(lblNewLabel_2);
		
		sex = new JTextField();
		sex.setBounds(109, 441, 81, 24);
		contentPane.add(sex);
		sex.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u72B6\u6001");
		lblNewLabel_3.setFont(new Font("华文楷体", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(232, 441, 54, 21);
		contentPane.add(lblNewLabel_3);
		
		state = new JTextField();
		state.setBounds(304, 441, 82, 24);
		contentPane.add(state);
		state.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//querysomeButton(e);
				querysomeButton(e);
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton.setBounds(473, 409, 93, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("\u91CD\u7F6E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				resetButton(e);
			}
		});
		btnNewButton_2.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(639, 409, 93, 33);
		contentPane.add(btnNewButton_2);
		
		this.dtm=(DefaultTableModel) table.getModel();
		
		QueryAllpatient();
	}

	protected void mouseClick(MouseEvent e) {
		// TODO Auto-generated method stub
		this.id.setText(dtm.getValueAt(this.table.getSelectedRow(), 0).toString());
		this.name.setText(dtm.getValueAt(this.table.getSelectedRow(), 1).toString());
		this.sex.setText(dtm.getValueAt(this.table.getSelectedRow(), 2).toString());
		this.state.setText(dtm.getValueAt(this.table.getSelectedRow(), 6).toString());
		 //this.editButton.setEnabled(true);
		//this.deleteButton.setEnabled(true);
	}

	protected void resetButton(ActionEvent e) {
		// TODO Auto-generated method stub
		this.id.setText("");
		this.name.setText("");
		this.sex.setText("");
		this.state.setText("");
	}

	protected void querysomeButton(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String name=this.name.getText();
		String id=this.id.getText();
		String sex=this.sex.getText();
		String state=this.state.getText();
		System.out.println(this.state.getText());
		Patient patient=new Patient();
		patient.setId(id);
		patient.setName(name);
		patient.setSex(sex);
		patient.setState(state);
		this.dtm.setRowCount(0);
		
		PatientDao patientdao=new PatientDao();
		List<Patient> allList=patientdao.querysomePatient_d(patient,this.idd);
		for(Patient st:allList)
		{
			Vector v=new Vector();
			v.add(st.getId());
			v.add(st.getName());
			v.add(st.getSex());
			v.add(st.getAge());
			v.add(st.getAccount());
			v.add(st.getDisease());
			v.add(st.getState());
			dtm.addRow(v);
		}
		
	}
	public void QueryAllpatient()
	{
			this.dtm.setRowCount(0);
			PatientDao patientdao=new PatientDao();
			List<Patient> allList=patientdao.queryAllpatient_d(this.idd);
			for(Patient st:allList)
			{
				Vector v=new Vector();
				v.add(st.getId());
				v.add(st.getName());
				v.add(st.getSex());
				v.add(st.getAge());
				v.add(st.getAccount());
				v.add(st.getDisease());
				v.add(st.getState());
				dtm.addRow(v);
			}
	}
}


 
