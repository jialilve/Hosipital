package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Patient;
import model.R_X;



public class RxDao extends BaseDao
{
	public ArrayList<R_X> queryAllRX_a()
    {
   	 ArrayList array =new ArrayList();
   	 String sqlstr="SELECT opener.RXid,patient.Pname,doctor.Doname,medicine.Mename,opener.Onumber\r\n"
   	 		+ "FROM patient,medicine,opener,rx,doctor\r\n"
   	 		+ "WHERE rx.RXid = opener.RXid and patient.Pid=rx.Pid and medicine.Meid=opener.Meid and doctor.Doid=opener.Doid";
   	 try 
   	 {
			 this.pSatement=this.con.prepareStatement(sqlstr);
			 System.out.println(this.pSatement);
			 ResultSet executeQuery=this.pSatement.executeQuery();
			// System.out.println(this.pSatement);
	    	 while(executeQuery.next())
	    	 {
	    		 R_X me=new R_X();
	    		 me.setRxid(executeQuery.getString(1));
	    		 me.setPid(executeQuery.getString(2));
 	    		 me.setPname(executeQuery.getString(3));
	    		 me.setMename(executeQuery.getString(4));
	    		 me.setSum(executeQuery.getInt(5));
	    		 array.add(me);
	    	 }
		} 
   	 catch (SQLException e) 
   	 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	finally
   	{
   		this.close();
   	}
		return array;
    }
	public ArrayList<R_X> queryAllRX(String id)
    {
   	 ArrayList array =new ArrayList();
   	 String sqlstr="SELECT opener.RXid,patient.Pid,patient.Pname,medicine.Mename,opener.Onumber\r\n"
   	 		+ "FROM patient,medicine,opener,rx\r\n"
   	 		+ "WHERE rx.RXid = opener.RXid and patient.Pid=rx.Pid and medicine.Meid=opener.Meid  and opener.Doid = '"+id+"'";
   	 try 
   	 {
			 this.pSatement=this.con.prepareStatement(sqlstr);
			 System.out.println(this.pSatement);
			 ResultSet executeQuery=this.pSatement.executeQuery();
			// System.out.println(this.pSatement);
	    	 while(executeQuery.next())
	    	 {
	    		 R_X me=new R_X();
	    		 me.setRxid(executeQuery.getString(1));
	    		 me.setPid(executeQuery.getString(2));
 	    		 me.setPname(executeQuery.getString(3));
	    		 me.setMename(executeQuery.getString(4));
	    		 me.setSum(executeQuery.getInt(5));
	    		 array.add(me);
	    	 }
		} 
   	 catch (SQLException e) 
   	 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	finally
   	{
   		this.close();
   	}
		return array;
    }
	public ArrayList<R_X> queryAllRX_p(String id)
    {
   	 ArrayList array =new ArrayList();
   	 String sqlstr="SELECT opener.RXid,patient.Pid,patient.Pname,medicine.Mename,opener.Onumber\r\n"
   	 		+ "FROM patient,medicine,opener,rx\r\n"
   	 		+ "WHERE rx.RXid = opener.RXid and patient.Pid=rx.Pid and medicine.Meid=opener.Meid  and patient.Pid='"+id+"'";
   	 try 
   	 {
			 this.pSatement=this.con.prepareStatement(sqlstr);
			 System.out.println(this.pSatement);
			 ResultSet executeQuery=this.pSatement.executeQuery();
			 
	    	 while(executeQuery.next())
	    	 {
	    		 R_X me=new R_X();
	    		 me.setRxid(executeQuery.getString(1));
	    		 me.setPid(executeQuery.getString(2));
 	    		 me.setPname(executeQuery.getString(3));
	    		 me.setMename(executeQuery.getString(4));
	    		 me.setSum(executeQuery.getInt(5));
	    		 array.add(me);
	    	 }
		} 
   	 catch (SQLException e) 
   	 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	finally
   	{
   		this.close();
   	}
		return array;
    }
	public ArrayList<R_X> querysomeRX(String id,String Pid,String RXid)
    {
   	 ArrayList<R_X> arrays=new ArrayList<R_X>();
   	 String str="SELECT rx.RXid,patient.Pid,patient.Pname,medicine.Mename,opener.Onumber\r\n"
    	 		+ "FROM patient,medicine,opener,rx\r\n"
       	 		+ "WHERE patient.Pid=rx.Pid and medicine.Meid=opener.Meid and rx.RXid =opener.RXid and rx.RXid like '"+RXid+"%' and rx.Pid like '"+Pid+"%'and opener.Doid = '"+id+"'ORDER BY RXid,Pid";
   	 try {
   		this.pSatement=this.con.prepareStatement(str);
   		System.out.println(this.pSatement);
		ResultSet executeQuery=this.pSatement.executeQuery();
		 
   	 while(executeQuery.next())
   	 {
   		 R_X me=new R_X();
   		 me.setRxid(executeQuery.getString(1));
   		 me.setPid(executeQuery.getString(2));
    		 me.setPname(executeQuery.getString(3));
   		 me.setMename(executeQuery.getString(4));
   		 me.setSum(executeQuery.getInt(5));
   		 arrays.add(me);
   	 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	finally
   	{
   		this.close();
   	}
		return arrays;
    }

	public ArrayList<R_X> querysomeRX_p(String Pid,String RXid)
    {
   	 ArrayList<R_X> arrays=new ArrayList<R_X>();
   	 String str="SELECT rx.RXid,patient.Pid,patient.Pname,medicine.Mename,opener.Onumber\r\n"
    	 		+ "FROM patient,medicine,opener,rx\r\n"
       	 		+ "WHERE patient.Pid=rx.Pid and medicine.Meid=opener.Meid and rx.RXid =opener.RXid and rx.RXid like '"+RXid+"%' and rx.Pid = '"+Pid+"'ORDER BY RXid,Pid";
   	 try {
   		this.pSatement=this.con.prepareStatement(str);
   		System.out.println(this.pSatement);
		 ResultSet executeQuery=this.pSatement.executeQuery();
		 
   	 while(executeQuery.next())
   	 {
   		 R_X me=new R_X();
   		 me.setRxid(executeQuery.getString(1));
   		 me.setPid(executeQuery.getString(2));
    	 me.setPname(executeQuery.getString(3));
   		 me.setMename(executeQuery.getString(4));
   		 me.setSum(executeQuery.getInt(5));
   		 arrays.add(me);
   	 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	finally
   	{
   		this.close();
   	}
		return arrays;
    }
	public ArrayList<R_X> querysomeRX_a(String Pid,String RXid)
    {
   	 ArrayList<R_X> arrays=new ArrayList<R_X>();
   	 String str="SELECT rx.RXid,patient.Pname,doctor.Doname,medicine.Mename,opener.Onumber\r\n"
    	 		+ "FROM patient,medicine,opener,rx,doctor\r\n"
       	 		+ "WHERE patient.Pid=rx.Pid and doctor.Doid=opener.Doid and medicine.Meid=opener.Meid and rx.RXid =opener.RXid and rx.RXid like '"+RXid+"%' and rx.Pid like '"+Pid+"%' ORDER BY RXid";
   	 try {
   		this.pSatement=this.con.prepareStatement(str);
   		System.out.println(this.pSatement);
		 ResultSet executeQuery=this.pSatement.executeQuery();
		 
   	 while(executeQuery.next())
   	 {
   		 R_X me=new R_X();
   		 me.setRxid(executeQuery.getString(1));
   		 me.setPid(executeQuery.getString(2));
    	 me.setPname(executeQuery.getString(3));
   		 me.setMename(executeQuery.getString(4));
   		 me.setSum(executeQuery.getInt(5));
   		 arrays.add(me);
   	 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	finally
   	{
   		this.close();
   	}
		return arrays;
    }
    public int pd(String Rxid)
    {
    	int fl=0;
    	String sql="select * from rx where RXid = '"+Rxid+"'";
    	try {
			this.pSatement=this.con.prepareStatement(sql);
			System.out.println(this.pSatement);
			ResultSet executeQuery=this.pSatement.executeQuery();
			if(executeQuery.next())
			{
				String l=executeQuery.getString(1);
				if(l!=null)
				{
					fl=1;
				}
			}
			// System.out.println("dsd"+fl);
		} 
    	catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
		return fl;
		
    	
    }
	public String addRX(String Rxid,String Doid,String Meid,int sum,String Pid) 
    {
   	 String resultstr="添加失败";
   	 String sql2="insert into opener values(?,?,?,?)";
   	 //String sql1="select count(*) from doctor where Doid like '"+tmpdoctor.getId()+"%'";
   	 if(pd(Rxid)==0)
   	 {
   		 String sql1;
   		 sql1="insert into rx values(?,?,?)";
   		try {
			this.pSatement=this.con.prepareStatement(sql1);
			System.out.println(this.pSatement);
			this.pSatement.setString(1, Rxid);
   	       this.pSatement.setString(2, Pid);
      	 this.pSatement.setString(3, Doid);
      	this.pSatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	   
   	 }
   	 try 
   	 {
     this.pSatement=this.con.prepareStatement(sql2);
	 this.pSatement.setString(1, Rxid);
	 this.pSatement.setString(2, Doid);
   	 this.pSatement.setString(3, Meid);
   	 this.pSatement.setInt(4, sum);
     System.out.println(this.pSatement);
   	 if(this.pSatement.executeUpdate()>0)
   	 {
   		 resultstr="添加成功";
   	 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultstr;
   	 
    }
}
