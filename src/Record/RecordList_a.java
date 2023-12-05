package Record;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.PatientDao;
import dao.RecordDao;
import model.Patient;
import model.Record;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RecordList_a extends JFrame {

	private JPanel contentPane;
	private JTextField Pid;
	private JTextField Doid;
    private String id;
    private DefaultTableModel dtm=null;
    private JTable table;
    private int lid;
    private String idd;
    private JButton editButton;
	/**
	 * Launch the application.
	 */
	 

	/**
	 * Create the frame.
	 */
	public RecordList_a(String id,int lid) 
	{
		this.id=id;
		this.lid=lid;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 724, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 690, 369);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u75C5\u4EBA\u7F16\u53F7", "\u75C5\u4EBA\u59D3\u540D", "\u533B\u5E08\u7F16\u53F7", "\u533B\u751F\u59D3\u540D", "\u786E\u8BCA\u75BE\u75C5", "\u8BCA\u65AD\u65F6\u95F4"
			}
		));
		table.setBackground(new Color(200,210,210));
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u75C5\u4EBA\u7F16\u53F7");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 416, 87, 21);
		contentPane.add(lblNewLabel);
		
		Pid = new JTextField();
		Pid.setBounds(149, 416, 87, 21);
		contentPane.add(Pid);
		Pid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u533B\u5E08\u7F16\u53F7");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 471, 80, 18);
		contentPane.add(lblNewLabel_1);
		
		Doid = new JTextField();
		Doid.setBounds(149, 468, 87, 21);
		contentPane.add(Doid);
		Doid.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Querysome(e);
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton.setBounds(406, 410, 93, 24);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				resetButton(e);
			}
		});
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(555, 410, 93, 24);
		contentPane.add(btnNewButton_1);
		
		editButton = new JButton("\u7F16\u8F91");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//editRecord(e);
			}
		});
		editButton.setFont(new Font("华文楷体", Font.PLAIN, 20));
		editButton.setBounds(406, 468, 93, 27);
		contentPane.add(editButton);
		
		JButton btnNewButton_3 = new JButton("\u53D6\u6D88");
		btnNewButton_3.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton_3.setBounds(555, 468, 93, 27);
		contentPane.add(btnNewButton_3);
		this.dtm=(DefaultTableModel) table.getModel();
		QueryAll();
		if(this.lid!=1)
		{
			this.editButton.setEnabled(false);
		}
	}
	protected void resetButton(ActionEvent e) 
	{
		// TODO Auto-generated method stub
	    this.Doid.setText("");
	    this.Pid.setText("");
	}
	public void QueryAll()
	{
		this.dtm.setRowCount(0);
		RecordDao patientdao=new RecordDao();
		List<Record> allList=patientdao.queryAllrecord(this.id,this.lid);
		for(Record st:allList)
		{
			Vector v=new Vector();
 			v.add(st.getPid());
 			v.add(st.getPname());
			v.add(st.getDoid());
			v.add(st.getDname());
			v.add(st.getDisease());
			v.add(st.getDate());
 			dtm.addRow(v);
		}
	}
	public void Querysome(ActionEvent e)
	{
		this.dtm.setRowCount(0);
	//	System.out.println(this.Pid.getText()+idd);
		RecordDao patientdao=new RecordDao();
		List<Record> allList=patientdao.querysomerecord(this.Pid.getText(),this.Doid.getText(),this.lid);
		for(Record st:allList)
		{
			Vector v=new Vector();
 			v.add(st.getPid());
 			v.add(st.getPname());
			v.add(st.getDoid());
			v.add(st.getDname());
			v.add(st.getDisease());
			v.add(st.getDate());
 			dtm.addRow(v);
		}
	}
}
