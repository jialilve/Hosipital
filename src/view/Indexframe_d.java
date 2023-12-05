package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Department.DeparmentInput;
import Department.DepartmentList;
import model.Admin;
import model.UserType;
import patient.PatientList;
import patient.PatientList_d;
import patient.addPatient;
import paymentlist.paymentlist;
import rx.AddRx;
import rx.RX_List;
import rx.SetRXList;
import medicine.MedicineList;
import view.doctor.AddDoctor;
import view.doctor.DoctorList;
import view.doctor.Doctormation;
import warehouse.StoreList;
import Record.RecordList;
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

public class Indexframe_d extends JFrame {

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
	public Indexframe_d(UserType usertype,Admin admin) 
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
		mnNewMenu_1.setIcon(new ImageIcon(Indexframe_d.class.getResource("/image/\u7F16\u8F91.png")));
		mnNewMenu_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u7F16\u8F91");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				addButton(e);
			}
		});
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_2 = new JMenu("\u75C5\u4EBA\u7BA1\u7406");
		mnNewMenu_2.setIcon(new ImageIcon(Indexframe_d.class.getResource("/image/\u7528\u6237 (1).png")));
		mnNewMenu_2.setFont(new Font("华文楷体", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u75C5\u4EBA\u5217\u8868");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patientList_d(e);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_4 = new JMenu("\u5C31\u8BCA\u7BA1\u7406");
		mnNewMenu_4.setIcon(new ImageIcon(Indexframe_d.class.getResource("/image/\u9884\u7EA6\u6302\u53F7.png")));
		mnNewMenu_4.setFont(new Font("华文楷体", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5C31\u8BCA\u67E5\u8BE2");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				RecordList(e);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_4.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("\u5904\u65B9\u7BA1\u7406");
		mnNewMenu_3.setIcon(new ImageIcon(Indexframe_d.class.getResource("/image/\u6392\u8BFE.png")));
		mnNewMenu_3.setFont(new Font("华文楷体", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem deparmentlist = new JMenuItem("\u5904\u65B9\u4FE1\u606F");
		deparmentlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				RXList(e);
			}
		});
		deparmentlist.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_3.add(deparmentlist);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u767B\u8BB0\u5904\u65B9");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddRx(e);
		}}
			);
		mntmNewMenuItem_5.setFont(new Font("华文楷体", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_5);
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

    

	protected void RecordList(ActionEvent e) {
		// TODO Auto-generated method stub
		RecordList rl=new RecordList(admin.getId(),admin.getLid());
		rl.setVisible(true);
	}



	protected void AddRx(ActionEvent e) {
		// TODO Auto-generated method stub
		SetRXList sl=new SetRXList(this.admin.getId());
		sl.setVisible(true);
	}



	protected void RXList(ActionEvent e) {
		// TODO Auto-generated method stub
		 RX_List rx=new RX_List(admin.getId());
		 rx.setVisible(true);
	}

	protected void patientList_d(ActionEvent e) {
		// TODO Auto-generated method stub
		PatientList_d patientlist1=new PatientList_d(admin.getId());
		patientlist1.setVisible(true);
	}
	 

	protected void addButton(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		Doctormation dm=new Doctormation(this.admin.getId(),this.admin.getLid());
	//	this.desktopane.add(adddoctor);
		dm.setVisible(true);
	}
}