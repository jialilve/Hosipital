package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Deparst;
import model.Patient;
import model.dest1;

public class DeparstDao extends BaseDao{
   
	public ArrayList<Deparst> queryAlldest()
    {
   	 ArrayList array =new ArrayList();
   	 String sqlstr="select * from dest";
   	 try 
   	 {
			 this.pSatement=this.con.prepareStatement(sqlstr);
			 ResultSet executeQuery=this.pSatement.executeQuery();
	    	 while(executeQuery.next())
	    	 {
	    		 Deparst deparst =new Deparst();
	    		 deparst.setTime(executeQuery.getString(1));
	    		 deparst.setDename(executeQuery.getString(2));
	    		 deparst.setPid(executeQuery.getString(3));
	    		 deparst.setPname(executeQuery.getString(4));
	    		 deparst.setDoname(executeQuery.getString(5));
	    		 array.add(deparst);
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

	public ArrayList<Deparst> querysomedest(String time1 ,String time2)
    {
   	 ArrayList array =new ArrayList();
   	 String sqlstr="{call DEST2(?,?)}";
   	 try 
   	 {
			 this.pSatement=this.con.prepareStatement(sqlstr);
			 this.pSatement.setString(1, time1);
			 this.pSatement.setString(2,time2);
			// System.out.print(this.pSatement);
			 ResultSet executeQuery=this.pSatement.executeQuery();
	    	 while(executeQuery.next())
	    	 {
	    		 Deparst deparst =new Deparst();
	    		 deparst.setTime(executeQuery.getString(1));
	    		 deparst.setDename(executeQuery.getString(2));
	    		 deparst.setPid(executeQuery.getString(3));
	    		 deparst.setPname(executeQuery.getString(4));
	    		 deparst.setDoname(executeQuery.getString(5));
	    		 array.add(deparst);
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
	
	public ArrayList<Deparst> queryAlldest_p(String Pid)
    {
   	 ArrayList array =new ArrayList();
   	 String sqlstr="select * from dest where Pid ='"+Pid+"'";
   	 try 
   	 {
			 this.pSatement=this.con.prepareStatement(sqlstr);
			 ResultSet executeQuery=this.pSatement.executeQuery();
	    	 while(executeQuery.next())
	    	 {
	    		 Deparst deparst =new Deparst();
	    		 deparst.setTime(executeQuery.getString(1));
	    		 deparst.setDename(executeQuery.getString(2));
	    		 deparst.setPid(executeQuery.getString(3));
	    		 deparst.setPname(executeQuery.getString(4));
	    		 deparst.setDoname(executeQuery.getString(5));
	    		 array.add(deparst);
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
	public ArrayList<dest1> queryAlldest1(String date1,String date2)
    {
   	 ArrayList array =new ArrayList();
   	 String sqlstr="{call DEST1(?,?)}";
   	 try 
   	 {
			 this.pSatement=this.con.prepareStatement(sqlstr);	 
			 this.pSatement.setString(1, date1);
			 this.pSatement.setString(2, date2);
			 ResultSet executeQuery=this.pSatement.executeQuery();
			 System.out.print(this.pSatement);
		
	    	 while(executeQuery.next())
	    	 {
	    		 dest1 d1=new dest1();
	    		 d1.setName(executeQuery.getString(1));
	    		 d1.setSum(executeQuery.getInt(2));
	    		 array.add(d1);
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
