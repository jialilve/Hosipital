package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Book;
import model.Patient;
import model.Payment;

public class PaymentDao extends BaseDao
{
	public ArrayList<Payment> queryAllpayment()
    {
   	 ArrayList array =new ArrayList();
   	 String sqlstr="SELECT payment.RXid,payment.Pid,patient.Pname,doctor.Doname,Cost1,Cost2,Cost,payment.State\r\n"
   	 		+ "from payment,patient,rx,doctor\r\n"
   	 		+ "WHERE  payment.Pid=patient.Pid and doctor.Doid=rx.Doid and rx.RXid=payment.RXid";
   	 try 
   	 {
			 this.pSatement=this.con.prepareStatement(sqlstr);
			 ResultSet executeQuery=this.pSatement.executeQuery();
	    	 while(executeQuery.next())
	    	 {
	    		 Payment py=new Payment();
	    		 py.setRxid(executeQuery.getString(1));
	    		 py.setPid(executeQuery.getString(2));
	    		 py.setDename(executeQuery.getString(3));
	    		 py.setDoname(executeQuery.getString(4));
	    		 py.setPrice1(executeQuery.getFloat(5));
	    		 py.setPrice2(executeQuery.getFloat(6));
	    		 py.setPrice(executeQuery.getFloat(7));
	    		 py.setState(executeQuery.getString(8));
	    		 array.add(py);
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


    public String getMoney(float sum,String Pid,String rxid)
    {
     String resultstr="余额不足";
     
     String sql1="select Account from patient where Pid = ?";
     try {
         this.pSatement=this.con.prepareStatement(sql1);
	//	 this.pSatement.setFloat(1, sum);
   	     this.pSatement.setString(1, Pid);
   	     System.out.println(this.pSatement);
   	     ResultSet executeQuery=this.pSatement.executeQuery();
   	     while(executeQuery.next())
   	     {
   	    	 float sum1=executeQuery.getFloat(1);
   	    	 if(sum1>sum)
   	    	 {
   	    		 resultstr="扣费成功";
   	    	 }
   	    	 else
   	    	 {
   	    		 return "余额不足";
   	    	 }
   	     }
   	    	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	 String sql2="update payment set State ='已收费' where RXid = ?";
   	 //String sql1="select count(*) from doctor where Doid like '"+tmpdoctor.getId()+"%'";
   	 try {
         this.pSatement=this.con.prepareStatement(sql2);
		 this.pSatement.setString(1, rxid);
   	     System.out.println(this.pSatement);
   	     if(this.pSatement.executeUpdate()>0)
   	    {
   		     resultstr="收费成功";
   	    }
   	     else
   	     {
   	    	 resultstr="收费失败";
   	     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultstr;
    }

    public ArrayList<Payment> querysomePayment(String pid,String state)
    {
   	 ArrayList<Payment> arrays=new ArrayList<Payment>();
   	 String sqlstr="SELECT payment.RXid,payment.Pid,patient.Pname,doctor.Doname,Cost1,Cost2,Cost,payment.State\r\n"
    	 		+ "from payment,patient,rx,doctor\r\n"
    	 		+ "WHERE  payment.Pid=patient.Pid and doctor.Doid=rx.Doid and rx.RXid=payment.RXid and payment.Pid like '%"+pid+"%' and payment.State like '%"+state+"%'";                                       
   	 try {
   		this.pSatement=this.con.prepareStatement(sqlstr);
   		 System.out.println(this.pSatement);
		 ResultSet executeQuery=this.pSatement.executeQuery();
		 
   	 while(executeQuery.next())
   	 {
   		 Payment py=new Payment();
   		 py.setRxid(executeQuery.getString(1));
   		 py.setPid(executeQuery.getString(2));
   		 py.setDename(executeQuery.getString(3));
   		 py.setDoname(executeQuery.getString(4));
   		 py.setPrice1(executeQuery.getFloat(5));
   		 py.setPrice2(executeQuery.getFloat(6));
   		 py.setPrice(executeQuery.getFloat(7));
   		 py.setState(executeQuery.getString(8));
   		 arrays.add(py);
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
		return arrays;
    }
    public String addPayment(String Pid,String Doid,String Rxid) 
    {
   	 String resultstr="添加失败";
   	 String sql1="select Dlevel from doctor where Doid = '"+Doid+"'";
   	 String sql2="select count(*) from payment";
   	 String sql3="select sum from pay where Rxid='"+Rxid+"'";
   	 String sql="insert payment values(?,?,?,?,?,?,?)";
   	int sum1=0;
   	double cost1=0,cost2=0;
   	 try 
   	 {
   		
     this.pSatement=this.con.prepareStatement(sql1);
	     
	    	ResultSet executeQuery=this.pSatement.executeQuery();
            while(executeQuery.next())
            {
            	String level=executeQuery.getString(1);
             	if("主任医师".equals(level))
            	{
            		cost1=300;
            	}
            	else if("副主任医师".equals(level))
            	{
            		cost1=200;
            	}
            	else
            	{
            		cost1=100;
            	}
            }
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try 
	   	 {
	   		
	     this.pSatement=this.con.prepareStatement(sql2);
		     
		    	ResultSet executeQuery=this.pSatement.executeQuery();
	            while(executeQuery.next())
	            {
	            	 sum1=executeQuery.getInt(1);
	            }
	            
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try 
	   	 {
	   		
	     this.pSatement=this.con.prepareStatement(sql3);
		     
		    	ResultSet executeQuery=this.pSatement.executeQuery();
	            while(executeQuery.next())
	            {
	            	cost2=executeQuery.getInt(1);
	            }
	            
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   		 
   	  
   	 try 
   	 {
   		
     this.pSatement=this.con.prepareStatement(sql);
	 this.pSatement.setString(1, Pid);
	 this.pSatement.setString(2,String.valueOf(sum1+1));
   	 this.pSatement.setFloat(3, (float) cost1);
   	 this.pSatement.setFloat(4, (float) cost2);
	 this.pSatement.setFloat(5,  (float) ((float) cost2+cost1));
	 this.pSatement.setString(6, Rxid);
	 this.pSatement.setString(7, "未缴费");
    	// System.out.println(this.pSatement);
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
    public ArrayList<Payment> queryAllpayment_p(String Pid)
    {
   	 ArrayList array =new ArrayList();
   	 String sqlstr="SELECT payment.RXid,payment.Pid,patient.Pname,doctor.Doname,Cost1,Cost2,Cost,payment.State\r\n"
   	 		+ "from payment,patient,rx,doctor\r\n"
   	 		+ "WHERE  payment.Pid=patient.Pid and doctor.Doid=rx.Doid and rx.RXid=payment.RXid and payment.Pid='"+Pid+"'";
   	 try 
   	 {
			 this.pSatement=this.con.prepareStatement(sqlstr);
			 ResultSet executeQuery=this.pSatement.executeQuery();
	    	 while(executeQuery.next())
	    	 {
	    		 Payment py=new Payment();
	    		 py.setRxid(executeQuery.getString(1));
	    		 py.setPid(executeQuery.getString(2));
	    		 py.setDename(executeQuery.getString(3));
	    		 py.setDoname(executeQuery.getString(4));
	    		 py.setPrice1(executeQuery.getFloat(5));
	    		 py.setPrice2(executeQuery.getFloat(6));
	    		 py.setPrice(executeQuery.getFloat(7));
	    		 py.setState(executeQuery.getString(8));
	    		 array.add(py);
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

}
