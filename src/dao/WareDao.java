package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Patient;
import model.Store;

public class WareDao extends BaseDao{

	public ArrayList<Store> queryAll(int lid)
    {
   	 ArrayList array =new ArrayList();
   	 String sqlstr;
   	 
   	 if(lid==0)
   	 {
   		   sqlstr="select store.Waid,medicine.Meid,medicine.Mename,store.Snumber,Principal \r\n"
   		  		+ "from warehouse ,store,medicine\r\n"
   		  		+ "WHERE warehouse.Waid=store.Waid and medicine.Meid=store.Meid\r\n";
   	 }
   	 else
   	 {
   		    sqlstr="select deliver.Waid,medicine.Meid,medicine.Mename,deliver.Dnumber,Principal \r\n"
   				+ "from warehouse ,deliver,medicine\r\n"
   				+ "WHERE warehouse.Waid=deliver.Waid and medicine.Meid=deliver.Meid\r\n";
   	 }
   	 
   	 
   	 try 
   	 {
			 this.pSatement=this.con.prepareStatement(sqlstr);
	 
			 ResultSet executeQuery=this.pSatement.executeQuery();
	    	 while(executeQuery.next())
	    	 {
	    		 Store sr =new Store();
	    		 sr.setWaid(executeQuery.getString(1));
	    		 sr.setMeid(executeQuery.getString(2));
	    		 sr.setName(executeQuery.getString(3));
	    		 sr.setSum(executeQuery.getInt(4));
	    		 sr.setPerson(executeQuery.getString(5));
	    		 array.add(sr);
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
	
	public String addWare(String waid,String meid,int sum,int lid) 
    {
   	 String resultstr="添加失败",sql,sql1;
	 int sum1 = 0;
   	 if(lid==0)
   	 {
   		   sql1="select count(*) from store";
   		   try {
			this.pSatement=this.con.prepareStatement(sql1);
			ResultSet executeQuery=this.pSatement.executeQuery();
	    	 while(executeQuery.next())
	    	 {
	    		  sum1=executeQuery.getInt(1);
	    	 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		 
   		sql="insert into store values(?,?,?,?)";
   		   
   		   
   	 }
   	 else
   	 {
   		   sql1="select count(*) from deliver";
   		  try {
  			this.pSatement=this.con.prepareStatement(sql1);
  			ResultSet executeQuery=this.pSatement.executeQuery();
  	    	 while(executeQuery.next())
  	    	 {
  	    		  sum1=executeQuery.getInt(1);
  	    	 }
  			
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
     		 
   		   sql="insert into deliver values(?,?,?,?)";
   	 }
   	// System.out.println(this.pSatement);
   	 try {
   	     
   	     this.pSatement=this.con.prepareStatement(sql);
   	   
   		 this.pSatement.setString(1, waid);
   		 this.pSatement.setString(2, meid);
   	   	 this.pSatement.setInt(3, sum);
   	   	 this.pSatement.setInt(4,sum1+1);
   	   	// System.out.println(this.pSatement);
   	     System.out.println(this.pSatement);
   	   	 if(this.pSatement.executeUpdate()>0)
   	   	 {
   	   		 resultstr="添加成功";
   	   	 }
   			} catch (SQLException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
 	finally
   	{
   		this.close();
   	}
   			return resultstr;
    }
	
}
