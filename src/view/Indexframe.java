package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Department.DeparmentInput;
import Department.DepartmentList;
import Record.RecordList_a;
import model.Admin;
import model.UserType;
import patient.PatientList;
import patient.addPatient;
import paymentlist.paymentlist;
import rx.RX_List_a;
import medicine.MedicineList;
import view.doctor.AddDoctor;
import view.doctor.DoctorList;
import warehouse.StoreList;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Indexframe extends JFrame {

	private JPanel contentPane;
    private JDesktopPane desktopane;
    public final UserType usertype ;
    public final Admin admin ;
    public static addPatient addpatient =null;
    public static AddDoctor adddoctor=null;
	public static DepartmentList deparmentlist=null;
	/**
	 * Create the frame.
	 * @param admin 
	 */
	public Indexframe(UserType usertype,Admin admin) 
	{
		this.admin=admin;
		this.usertype=usertype;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 646);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u6b22\u8fce");
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		mnNewMenu.setFont(new Font("华文楷体", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("\u533B\u5E08\u7BA1\u7406");
		mnNewMenu_1.setIcon(new ImageIcon(Indexframe.class.getResource("/image/\u533B\u751F (1).png")));
		mnNewMenu_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u6DFB\u52A0\u533B\u5E08");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				addButton(e);
			}
		});
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u533B\u5E08\u4FE1\u606F");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorListButton(e);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("\u75C5\u4EBA\u7BA1\u7406");
		mnNewMenu_2.setIcon(new ImageIcon(Indexframe.class.getResource("/image/\u7528\u6237 (1).png")));
		mnNewMenu_2.setFont(new Font("华文楷体", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u6DFB\u52A0\u75C5\u4EBA");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				addPatientButton(e);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u75C5\u4EBA\u5217\u8868");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     patientList(e);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_3 = new JMenu("\u79D1\u5BA4\u7BA1\u7406");
		mnNewMenu_3.setIcon(new ImageIcon(Indexframe.class.getResource("/image/\u516C\u53F8 (1).png")));
		mnNewMenu_3.setFont(new Font("华文楷体", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem deparmentlist = new JMenuItem("\u79D1\u5BA4\u4FE1\u606F");
		deparmentlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				DeList(e);
			}
		});
		deparmentlist.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_3.add(deparmentlist);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u5C31\u8BCA\u60C5\u51B5");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adddeparset(e);
			}
		});
		mntmNewMenuItem_5.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("\u6570\u636e\u7edf\u8ba1");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				DestButton(e);
			}
		});
		mntmNewMenuItem_11.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu_4 = new JMenu("\u836F\u54C1\u7BA1\u7406");
		mnNewMenu_4.setIcon(new ImageIcon(Indexframe.class.getResource("/image/\u836F\u54C1 (1).png")));
		mnNewMenu_4.setFont(new Font("华文楷体", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u5165\u5E93\u7BA1\u7406");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				stButton(e);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_4.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u51FA\u5E93\u7BA1\u7406");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deButton(e);
			}
		});
		mntmNewMenuItem_6.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_4.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u836F\u54C1\u4FE1\u606F");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicineList(e);
			}
		});
		mntmNewMenuItem_7.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_4.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_6 = new JMenu("\u5C31\u8BCA\u7BA1\u7406");
		mnNewMenu_6.setIcon(new ImageIcon(Indexframe.class.getResource("/image/\u533B\u7597\u670D\u52A1.png")));
		mnNewMenu_6.setFont(new Font("华文楷体", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u8BCA\u65AD\u67E5\u8BE2");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				recordlist(e);
			}
		});
		mntmNewMenuItem_9.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_6.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("\u5904\u65B9\u67E5\u8BE2");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				rxlist(e);
			}
		});
		mntmNewMenuItem_10.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_6.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_5 = new JMenu("\u7F34\u8D39\u7BA1\u7406");
		mnNewMenu_5.setIcon(new ImageIcon(Indexframe.class.getResource("/image/\u7F34\u8D39.png")));
		mnNewMenu_5.setFont(new Font("华文楷体", Font.PLAIN, 19));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u7F34\u8D39\u4FE1\u606F");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paylist(e);
			}
		});
		mntmNewMenuItem_8.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_5.add(mntmNewMenuItem_8);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u533B\u9662\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 39));
		lblNewLabel.setBounds(183, 155, 588, 222);
		contentPane.add(lblNewLabel);
		
	/*	desktopane=new JDesktopPane();
		desktopane.setBackground(new Color(32,178,170));
		contentPane.add(desktopane,BorderLayout.CENTER);*/
	}

	protected void DestButton(ActionEvent e) {
		// TODO Auto-generated method stub
		destframe de=new destframe();
		de.setVisible(true);
	}

	protected void recordlist(ActionEvent e) {
		// TODO Auto-generated method stub
		RecordList_a ra=new RecordList_a(this.admin.getId(),this.admin.getLid());
		ra.setVisible(true);
	}

	protected void rxlist(ActionEvent e) {
		// TODO Auto-generated method stub
		RX_List_a la=new RX_List_a();
		la.setVisible(true);
	}

	protected void paylist(ActionEvent e) {
		// TODO Auto-generated method stub
		paymentlist pl=new paymentlist();
		pl.setVisible(true);
	}

	protected void adddeparset(ActionEvent e) {
		// TODO Auto-generated method stub
		DeparmentInput de=new DeparmentInput();
		de.setVisible(true);
	}

	protected void deButton(ActionEvent e) {
		// TODO Auto-generated method stub
		StoreList sl=new StoreList(1);
		sl.setVisible(true);
	}

	protected void stButton(ActionEvent e) {
		// TODO Auto-generated method stub
		StoreList sl=new StoreList(0);
		sl.setVisible(true);
	}

	protected void MedicineList(ActionEvent e) {
		// TODO Auto-generated method stub
		MedicineList ml=new MedicineList();
		ml.setVisible(true);
	}

	protected void DeList(ActionEvent e) {
		// TODO Auto-generated method stub
		DepartmentList de=new DepartmentList();
		de.setVisible(true);
	}

	protected void patientList(ActionEvent e) {
		// TODO Auto-generated method stub
		PatientList patientlist=new PatientList();
		patientlist.setVisible(true);
	}

	protected void addPatientButton(ActionEvent e) {
		// TODO Auto-generated method stub
		addpatient=new addPatient();
		addpatient.setVisible(true);
	}

	protected void DoctorListButton(ActionEvent e) {
		// TODO Auto-generated method stub
		 
		    DoctorList doctorlist=new DoctorList ();
		//	this.desktopane.add(doctorlist);
		    doctorlist.setVisible(true);
	}

	protected void addButton(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		 adddoctor=new AddDoctor();
	//	this.desktopane.add(adddoctor);
		adddoctor.setVisible(true);
		
	}
}
