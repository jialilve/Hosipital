package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Doctor;
import model.Record;

public class RecordDao extends BaseDao
{
	public ArrayList<Record> queryAllrecord(String id,int lid)
	{
   	 ArrayList array =new ArrayList();
   	 String sqlstr = null;
   	 if(lid==2)
   	 {
   		 sqlstr= "select record.Pid,Pname,record.Doid,Doname,Disease,Date from record,doctor,patient where record.Doid = doctor.Doid and patient.Pid = record.Pid and record.Pid = '"+id+"'";
   	 }
   	 else if(lid==1)
   	 {
   		sqlstr= "select record.Pid,Pname,record.Doid,Doname,Disease,Date from record,doctor,patient where record.Doid = doctor.Doid and patient.Pid= record.Pid and record.Doid= '"+id+"'";
   	 }
   	 else
   	 {
   		sqlstr= "select record.Pid,Pname,record.Doid,Doname,Disease,Date from record,doctor,patient where record.Doid = doctor.Doid and  patient.Pid= record.Pid";
   	 }
   	 try 
   	 {
			 this.pSatement=this.con.prepareStatement(sqlstr);
			 ResultSet executeQuery=this.pSatement.executeQuery();
	    	 while(executeQuery.next())
	    	 {
	    		 Record rc=new Record();
	    		 rc.setPid(executeQuery.getString(1));
	    		 rc.setPname(executeQuery.getString(2));
	    		 rc.setDoid(executeQuery.getString(3));
	    		 rc.setDname(executeQuery.getString(4));
	    		 rc.setDisease(executeQuery.getString(5));
	    		 rc.setDate(executeQuery.getString(6));
	    		 array.add(rc);
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

	public List<Record> querysomerecord(String id, String idd, int lid) {
		// TODO Auto-generated method stub
		ArrayList array =new ArrayList();
	   	 String sqlstr = "";
	   	 if(idd==null)
	   	 {
	   		 idd="";
	   	 }
	   	 
	   	 if(lid==2)
	   	 {
	   		 sqlstr= "select record.Pid,Pname,record.Doid,Doname,Disease,Date from record,doctor,patient where  patient.Pid= record.Pid and record.Doid = doctor.Doid and record.Pid= '"+id+"' and record.Doid like '"+idd+"%'";           
	   	 }
	   	 else if(lid==1)
	   	 {
	   		 sqlstr= "select record.Pid,Pname,record.Doid,Doname,Disease,Date from record,doctor,patient where  patient.Pid= record.Pid and record.Doid = doctor.Doid and record.Doid= '"+id+"' and record.Pid like '"+idd+"%'";
	   	 }
	   	 else
	   	 {
	   		sqlstr= "select record.Pid,Pname,record.Doid,Doname,Disease,Date from record,doctor,patient where  patient.Pid= record.Pid and record.Doid = doctor.Doid and record.Pid like '"+id+"%' and record.Doid like '"+idd+"%'";
	   	 }
	   	 try 
	   	 {
				 this.pSatement=this.con.prepareStatement(sqlstr);
				 System.out.println(this.pSatement);
				 ResultSet executeQuery=this.pSatement.executeQuery();
		    	 while(executeQuery.next())
		    	 {
		    		 Record rc=new Record();
		    		 rc.setPid(executeQuery.getString(1));
		    		 rc.setPname(executeQuery.getString(2));
		    		 rc.setDoid(executeQuery.getString(3));
		    		 rc.setDname(executeQuery.getString(4));
		    		 rc.setDisease(executeQuery.getString(5));
		    		 rc.setDate(executeQuery.getString(6));
		    		 array.add(rc);
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
	 public String editRecord(String Doid,String Pid,String tx,String dt)
     {
    	 String resultstr="修改失败";
    	 String sql="update record set Disease = ? ,Date = ? where Doid = ? and Pid =?";
    	 //String sql1="select count(*) from doctor where Doid like '"+tmpdoctor.getId()+"%'";
    	 try {
         this.pSatement=this.con.prepareStatement(sql);
		
         this.pSatement.setString(1, tx);
         this.pSatement.setString(2, dt);
		 this.pSatement.setString(3, Doid);
    	 this.pSatement.setString(4, Pid);
    	 System.out.println(this.pSatement);
    	 if(this.pSatement.executeUpdate()>0)
    	 {
    		 resultstr="修改成功";
    	 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultstr;
     }
} 
