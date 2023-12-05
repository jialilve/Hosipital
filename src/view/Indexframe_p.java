 package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Book.BookList;
import Department.DeparmentInput;
import Department.DepartmentInput_p;
import Department.DepartmentList;
import model.Admin;
import model.UserType;
import patient.PatientList;
import patient.PatientList_d;
import patient.Patientmation;
import patient.addPatient;
import paymentlist.Addpayment;
import paymentlist.paymentlist;
import paymentlist.paymentlist_p;
import rx.AddRx;
import rx.RX_List;
import rx.RX_List_p;
import rx.SetRXList;
import Record.RecordList;
import medicine.MedicineList;
import view.doctor.AddDoctor;
import view.doctor.DoctorList;
import view.doctor.Doctormation;
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

public class Indexframe_p extends JFrame {

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
	public Indexframe_p(UserType usertype,Admin admin) 
	{
		this.admin=admin;
		this.usertype=usertype;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 646);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u6B22\u8FCE");
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		mnNewMenu.setFont(new Font("华文楷体", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("\u4E2A\u4EBA\u4FE1\u606F\u7BA1\u7406");
		mnNewMenu_1.setIcon(new ImageIcon(Indexframe_p.class.getResource("/image/\u7F16\u8F91.png")));
		mnNewMenu_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4E2A\u4EBA\u4FE1\u606F");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				mation(e);
			}
		});
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_2 = new JMenu("\u6302\u53F7\u7BA1\u7406");
		mnNewMenu_2.setIcon(new ImageIcon(Indexframe_p.class.getResource("/image/\u9884\u7EA6\u6302\u53F7.png")));
		mnNewMenu_2.setFont(new Font("华文楷体", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u6302\u53F7\u4FE1\u606F");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartmentInput(e);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u529E\u7406\u6302\u53F7");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				addbook(e);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("华文楷体", Font.PLAIN, 17));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("\u5C31\u8BCA\u7BA1\u7406");
		mnNewMenu_3.setIcon(new ImageIcon(Indexframe_p.class.getResource("/image/\u533B\u7597\u670D\u52A1.png")));
		mnNewMenu_3.setFont(new Font("华文楷体", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem deparmentlist = new JMenuItem("\u8BCA\u65AD\u67E5\u8BE2");
		deparmentlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				 RecordList(e);
			}
		});
		deparmentlist.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_3.add(deparmentlist);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u5904\u65B9\u67E5\u8BE2");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddRx(e);
		}}
			);
		mntmNewMenuItem_5.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_4 = new JMenu("\u7F34\u8D39\u7BA1\u7406");
		mnNewMenu_4.setIcon(new ImageIcon(Indexframe_p.class.getResource("/image/\u7F34\u8D39.png")));
		mnNewMenu_4.setFont(new Font("华文楷体", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u7F34\u8D39\u4FE1\u606F");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				paymentList(e);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("华文楷体", Font.PLAIN, 17));
		mnNewMenu_4.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u529E\u7406\u7F34\u8D39");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AddPayment(e);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("华文楷体", Font.PLAIN, 17));
		mnNewMenu_4.add(mntmNewMenuItem_4);
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

    

	protected void AddPayment(ActionEvent e) {
		// TODO Auto-generated method stub
		Addpayment at=new Addpayment(this.admin.getId());
		at.setVisible(true);
	}



	protected void paymentList(ActionEvent e) {
		// TODO Auto-generated method stub
		paymentlist_p pp=new paymentlist_p(admin.getId());
	    pp.setVisible(true);
	}



	protected void addbook(ActionEvent e) {
		// TODO Auto-generated method stub
		 BookList bl=new BookList(this.admin.getId());
		    bl.setVisible(true);
	}



	protected void AddRx(ActionEvent e) {
		// TODO Auto-generated method stub
		 RX_List_p rx=new RX_List_p(admin.getId());
		 rx.setVisible(true);
	}



	protected void  RecordList(ActionEvent e) {
		// TODO Auto-generated method stub
		 RecordList rx=new RecordList(admin.getId(),admin.getLid());
		 rx.setVisible(true);
	}

	protected void DepartmentInput(ActionEvent e) {
		// TODO Auto-generated method stub
		DepartmentInput_p patient1=new DepartmentInput_p(admin.getId());
		patient1.setVisible(true);
	}
	 

	protected void mation(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		Patientmation pt=new Patientmation(admin.getId());
		
	//	this.desktopane.add(adddoctor);
		pt.setVisible(true);
	}
}