package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Deparment;
import model.Doctor;

public class DeparmentDao extends BaseDao{
    
	 public ArrayList<Deparment> queryAlldeparment()
     {
    	 ArrayList array =new ArrayList();
    	 String sqlstr="select * from department";
    	 try 
    	 {
			 this.pSatement=this.con.prepareStatement(sqlstr);
			 ResultSet executeQuery=this.pSatement.executeQuery();
	    	 while(executeQuery.next())
	    	 {
	    		 Deparment d=new Deparment();
	    		 d.setId(executeQuery.getString(1));
	    		 d.setName(executeQuery.getString(2));
	    		 d.setSum(executeQuery.getInt(3));
	    		 d.setText(executeQuery.getString(4));
	    		 array.add(d);
	    		 
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

	 public ArrayList<Deparment> querysomedeparment(String d)
     {
    	 ArrayList<Deparment> arrays=new ArrayList<Deparment>();
    	 String str="select * from department where Deid like '"+d+"%'" ;
    	 try {
			 this.pSatement=this.con.prepareStatement(str);
			 
			 
			 System.out.println(this.pSatement);
			 ResultSet executeQuery=this.pSatement.executeQuery();
	    	 while(executeQuery.next())
	    	 {
	    		 Deparment de1=new Deparment();
	    		 de1.setId(executeQuery.getString(1));
	    		 de1.setName(executeQuery.getString(2));
	    		 de1.setSum(executeQuery.getInt(3));
	    		 de1.setText(executeQuery.getString(4));
	    		 arrays.add(de1);
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

     public String editDeparment(Deparment de)
     {
    	 String resultstr="±à¼­Ê§°Ü";
    	 String sql="update  department set Dename = ?,Dsum=? ,Dtext = ? where Deid = ?";
    	 //String sql1="select count(*) from doctor where Doid like '"+tmpdoctor.getId()+"%'";
    	 try {
         this.pSatement=this.con.prepareStatement(sql);
		
		 this.pSatement.setString(1,de.getName());
    	 this.pSatement.setInt(2, de.getSum());
    	 this.pSatement.setString(3, de.getText());
    	 this.pSatement.setString(4, de.getId()); 
     	 System.out.println(this.pSatement);
    	 if(this.pSatement.executeUpdate()>0)
    	 {
    		 resultstr="±à¼­³É¹¦";
    	 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultstr;
     }
     


}
