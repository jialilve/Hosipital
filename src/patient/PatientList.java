package patient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.DoctorDao;
import dao.PatientDao;
import model.Doctor;
import model.Patient;
import view.Indexframe;
import view.doctor.AddDoctor;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PatientList extends JFrame {

	//private static final String  = null;
	private JPanel contentPane;
	private JTable table;
	private JTextField id;
	private JTextField name;
	private JTextField sex;
	private JTextField state=null;
	private DefaultTableModel dtm=null;
	private JButton editButton;
	private JButton deleteButton;
	/**
	 * Launch the application.
	 */
	 
	/**
	 * Create the frame.
	 */
	public PatientList() {
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
		table.getColumnModel().getColumn(4).setPreferredWidth(83);
		table.getColumnModel().getColumn(5).setPreferredWidth(88);
		table.getColumnModel().getColumn(6).setPreferredWidth(105);
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
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//querysomeButton(e);
				querysomeButton(e);
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton.setBounds(465, 389, 93, 23);
		contentPane.add(btnNewButton);
		
		editButton = new JButton(" \u7F16\u8F91");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editButton(e);
			}
		});
		editButton.setFont(new Font("华文楷体", Font.PLAIN, 18));
		editButton.setBounds(622, 389, 93, 23);
		contentPane.add(editButton);
		
		JButton btnNewButton_2 = new JButton("\u91CD\u7F6E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				resetButton(e);
			}
		});
		btnNewButton_2.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(465, 443, 93, 23);
		contentPane.add(btnNewButton_2);
		
		deleteButton = new JButton("\u5220\u9664");
		deleteButton.setFont(new Font("华文楷体", Font.PLAIN, 18));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				DeleteButton(e);
			}
		});
		deleteButton.setBounds(622, 443, 93, 23);
		contentPane.add(deleteButton);
		
		this.dtm=(DefaultTableModel) table.getModel();
		
		QueryAllpatient();
	}

	protected void editButton(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		Patient patient=new Patient();
		patient.setId(dtm.getValueAt(this.table.getSelectedRow(), 0).toString());
		patient.setName(dtm.getValueAt(this.table.getSelectedRow(), 1).toString());
		patient.setSex(dtm.getValueAt(this.table.getSelectedRow(), 2).toString());
		patient.setAge((int) dtm.getValueAt(this.table.getSelectedRow(), 3));
		patient.setAccount((float) dtm.getValueAt(this.table.getSelectedRow(), 4));
		patient.setDisease((String) dtm.getValueAt(this.table.getSelectedRow(), 5));
		//patient.setState(dtm.getValueAt(this.table.getSelectedRow(), 6).toString());
		
		if(Indexframe.addpatient==null)
		{
			Indexframe.addpatient=new addPatient();
		}
		Indexframe.addpatient.editPatient(patient);
		Indexframe.addpatient.setVisible(true);
		QueryAllpatient();
	}

	protected void DeleteButton(ActionEvent e) {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this, "是否删除此病人信息？","正在删除",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
		{
			String id=dtm.getValueAt(this.table.getSelectedRow(), 0).toString();
			PatientDao patientdao=new PatientDao();
			JOptionPane.showConfirmDialog(this, patientdao.DeletePatient(id));
			QueryAllpatient();
		}
	}

	protected void mouseClick(MouseEvent e) {
		// TODO Auto-generated method stub
		this.id.setText(dtm.getValueAt(this.table.getSelectedRow(), 0).toString());
		this.name.setText(dtm.getValueAt(this.table.getSelectedRow(), 1).toString());
		this.sex.setText(dtm.getValueAt(this.table.getSelectedRow(), 2).toString());
		//this.state.setText(dtm.getValueAt(this.table.getSelectedRow(), 6).toString());
		this.editButton.setEnabled(true);
		this.deleteButton.setEnabled(true);
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
 
		
		Patient patient=new Patient();
		patient.setId(id);
		patient.setName(name);
		patient.setSex(sex);
		patient.setState("");
		this.dtm.setRowCount(0);
		PatientDao patientdao=new PatientDao();
		List<Patient> allList=patientdao.querysomePatient(patient);
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
			List<Patient> allList=patientdao.queryAllpatient();
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
			this.editButton.setEnabled(false);
			this.deleteButton.setEnabled(false);
	}
}
