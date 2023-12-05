package Book;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import dao.DoctorDao;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.util.*;
import model.Doctor;
import patient.addPatient;
import view.Indexframe;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class BookList extends JFrame {

	private JPanel contentPane;
	private JTable DoctorList;
	private JTextField doctor_id;
	private JTextField doctor_name;
	private JTextField doctor_level;
	private JTextField doctor_de;
    private DefaultTableModel dtm=null;
    private String id;
	/**
	 * Launch the application.
	 */
 

	/**
	 * Create the frame.
	 */
	public BookList(String id) 
	{
		this.id=id;
		//setIconImage(Toolkit.getDefaultToolkit().getImage(DoctorList.class.getResource("/image/\u6392\u8BFE.png")));
		setTitle("\u533B\u5E08\u5217\u8868");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 867, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 833, 324);
		contentPane.add(scrollPane);
		
		DoctorList = new JTable();
		DoctorList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				selectRow(e);
			}
		});
		DoctorList.setFont(new Font("华文楷体", Font.PLAIN, 15));
		DoctorList.setBackground(new Color(200,210,210));
		DoctorList.getTableHeader().setReorderingAllowed(false);
		DoctorList.setRowHeight(25);
		
		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		DoctorList.setDefaultRenderer(Object.class,r);
		
		DoctorList.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u533B\u5E08\u5DE5\u53F7", "\u533B\u5E08\u59D3\u540D", "\u6027\u522B", " \u5E74\u9F84", " \u804C\u79F0", "\u7535\u8BDD\u53F7\u7801", "\u6240\u5C5E\u79D1\u5BA4"
			}
		));
		DoctorList.getColumnModel().getColumn(0).setPreferredWidth(70);
		DoctorList.getColumnModel().getColumn(1).setPreferredWidth(67);
		DoctorList.getColumnModel().getColumn(2).setPreferredWidth(48);
		DoctorList.getColumnModel().getColumn(3).setPreferredWidth(60);
		DoctorList.getColumnModel().getColumn(4).setPreferredWidth(60);
		DoctorList.getColumnModel().getColumn(5).setPreferredWidth(72);
		scrollPane.setViewportView(DoctorList);
		
		JLabel lblNewLabel = new JLabel("\u533B\u5E08\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 19));
		lblNewLabel.setBounds(10, 346, 112, 30);
		contentPane.add(lblNewLabel);
		
		doctor_id = new JTextField();
		doctor_id.setBounds(108, 354, 66, 21);
		contentPane.add(doctor_id);
		doctor_id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u533B\u5E08\u59D3\u540D:");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(224, 348, 86, 30);
		contentPane.add(lblNewLabel_1);
		
		doctor_name = new JTextField();
		doctor_name.setBounds(320, 355, 66, 21);
		contentPane.add(doctor_name);
		doctor_name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u804C  \u79F0\uFF1A");
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(10, 397, 72, 21);
		contentPane.add(lblNewLabel_2);
		
		doctor_level = new JTextField();
		doctor_level.setBounds(77, 400, 66, 21);
		contentPane.add(doctor_level);
		doctor_level.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6240\u5C5E\u79D1\u5BA4\uFF1A");
		lblNewLabel_3.setFont(new Font("华文楷体", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(194, 397, 97, 21);
		contentPane.add(lblNewLabel_3);
		
		doctor_de = new JTextField();
		doctor_de.setBounds(301, 400, 85, 21);
		contentPane.add(doctor_de);
		doctor_de.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				selecSomeoneDoctor(e);
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 17));
		btnNewButton.setBounds(479, 353, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("\u91CD\u7F6E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				reButton(e);
			}
		});
		btnNewButton_2.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(479, 399, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("\u6302\u53F7");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				bookButton(e);
			}
		});
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(642, 353, 93, 23);
		contentPane.add(btnNewButton_1);
		this.dtm=(DefaultTableModel) DoctorList.getModel();
		
		queryAlldoctor();
	}
	 
	 
	protected void bookButton(ActionEvent e) {
		// TODO Auto-generated method stub
	    AddBook dk=new AddBook(this.id);
	    dk.setVisible(true);
	}


	protected void selectRow(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		this.doctor_id.setText(dtm.getValueAt(this.DoctorList.getSelectedRow(), 0).toString());
		this.doctor_name.setText(dtm.getValueAt(this.DoctorList.getSelectedRow(), 1).toString());
		this.doctor_level.setText(dtm.getValueAt(this.DoctorList.getSelectedRow(), 4).toString());
		this.doctor_de.setText(dtm.getValueAt(this.DoctorList.getSelectedRow(), 6).toString());
		//this.editButton.setEnabled(true);
		//this.deleteButton.setEnabled(true);
	}
	protected void selecSomeoneDoctor(ActionEvent e) {
		// TODO Auto-generated method stub
		String name=this.doctor_name.getText();
		String id=this.doctor_id.getText();
		String Deid=this.doctor_de.getText();
		String Dlevel=this.doctor_level.getText();
		
		Doctor doctor =new Doctor();
		doctor.setId(id);
		doctor.setName(name);
		doctor.setLevel(Dlevel);
		doctor.setDeparment(Deid);
		this.dtm.setRowCount(0);
		DoctorDao doctordao=new DoctorDao();
		List<Doctor> allList=doctordao.querysomeDoctor(doctor);
		for(Doctor st:allList)
		{
			Vector v=new Vector();
			v.add(st.getId());
			v.add(st.getName());
			v.add(st.getSex());
			v.add(st.getAge());
			v.add(st.getLevel());
			v.add(st.getTel());
			v.add(st.getDeparment());
			dtm.addRow(v);
		}
		
	}

	protected void reButton(ActionEvent e) {
		// TODO Auto-generated method stub
		this.doctor_id.setText("");
		this.doctor_de.setText("");
		this.doctor_level.setText("");
		this.doctor_name.setText("");
	}
    
	public void queryAlldoctor()
	{
		this.dtm.setRowCount(0);
		DoctorDao doctordao=new DoctorDao();
		List<Doctor> allList=doctordao.queryAlldoctor();
		for(Doctor st:allList)
		{
			Vector v=new Vector();
			v.add(st.getId());
			v.add(st.getName());
			v.add(st.getSex());
			v.add(st.getAge());
			v.add(st.getLevel());
			v.add(st.getTel());
			v.add(st.getDeparment());
			dtm.addRow(v);
		}
					
	}
}
