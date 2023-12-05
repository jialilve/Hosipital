package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Doctor;
import model.Patient;

public class PatientDao extends BaseDao
{
	public String addPatient(Patient patient) 
    {
   	 String resultstr="添加失败";
   	 String sql="insert into patient values(?,?,?,?,?,?,?)";
   	 //String sql1="select count(*) from doctor where Doid like '"+tmpdoctor.getId()+"%'";
   	 try {
     
     this.pSatement=this.con.prepareStatement(sql);
	 this.pSatement.setString(1, patient.getId());
	 this.pSatement.setString(2, patient.getName());
   	 this.pSatement.setString(3, patient.getSex());
   	 this.pSatement.setInt(4, patient.getAge());
   	 this.pSatement.setFloat(5,patient.getAccount());
   	 this.pSatement.setString(6, patient.getDisease());
   	 this.pSatement.setString(7, patient.getState());
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

    public ArrayList<Patient> queryAllpatient()
    {
   	 ArrayList array =new ArrayList();
   	 String sqlstr="select * from patient";
   	 try 
   	 {
			 this.pSatement=this.con.prepareStatement(sqlstr);
			 ResultSet executeQuery=this.pSatement.executeQuery();
	    	 while(executeQuery.next())
	    	 {
	    		 Patient patient =new Patient();
	    		 patient.setId(executeQuery.getString(1));
	    		 patient.setName(executeQuery.getString(2));
	    		 patient.setSex(executeQuery.getString(3));
	    		 patient.setAge(executeQuery.getInt(4));
	    		 patient.setAccount(executeQuery.getFloat(5));
	    		 patient.setDisease(executeQuery.getString(6));
	    		 patient.setState(executeQuery.getString(7));
	    		 array.add(patient);
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

    public ArrayList<Patient> querysomePatient(Patient patient)
    {
   	 ArrayList<Patient> arrays=new ArrayList<Patient>();
   	 String str="select * from patient where Pname like '"+patient.getName()+"%' and Pid Like '"+patient.getId()+"%' and Psex like '"+patient.getSex()+"%' and State like'"+patient.getState()+"%'";
   	 try {
			 this.pSatement=this.con.prepareStatement(str);
			 System.out.println(this.pSatement);
			 ResultSet executeQuery=this.pSatement.executeQuery();
	    	 while(executeQuery.next())
	    	 {
	    		 Patient patient1 =new Patient();
	    		 patient1.setId(executeQuery.getString(1));
	    		 patient1.setName(executeQuery.getString(2));
	    		 patient1.setSex(executeQuery.getString(3));
	    		 patient1.setAge(executeQuery.getInt(4));
	    		 patient1.setAccount((executeQuery.getFloat(5)));
	    		 patient1.setDisease(executeQuery.getString(6));
	    		 patient1.setState(executeQuery.getString(7));
	    		 arrays.add(patient1);
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

    public String DeletePatient(String id)   
    {
   	 String resultstr="删除失败";
   	 String sqlstr="delete from patient where Pid = ?";
   	 try {
			this.pSatement=this.con.prepareStatement(sqlstr);
			this.pSatement.setString(1,id);
			if(this.pSatement.executeUpdate()>0)
			{
				resultstr="删除成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultstr;
    }
     
    public String editPatient(Patient tmppatient)
    {
    	 String resultstr="修改失败";
    	 String sql="update patient set Pname = ? ,Psex = ?,Page=? ,Account = ?,Place = ?,State = ? where Pid = ?";
    	 //String sql1="select count(*) from doctor where Doid like '"+tmpdoctor.getId()+"%'";
    	 try {
         this.pSatement=this.con.prepareStatement(sql);
		
		 this.pSatement.setString(1, tmppatient.getName());
    	 this.pSatement.setString(2, tmppatient.getSex());
    	 this.pSatement.setInt(3, tmppatient.getAge());
    	 this.pSatement.setFloat(4, tmppatient.getAccount());
    	 this.pSatement.setString(5, tmppatient.getDisease());
    	 this.pSatement.setString(6, tmppatient.getState()); 
    	 this.pSatement.setString(7, tmppatient.getId());
    	// System.out.println(this.pSatement);
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
    public ArrayList<Patient> queryAllpatient_d(String id)
    {
   	 ArrayList array =new ArrayList();
   	 String sqlstr="select *\r\n"
   	 		+ "from patient,booking_form \r\n"
   	 		+ "where booking_form.Doid='" + id+"' and booking_form.Pid=patient.Pid ";
   	 try 
   	 {
			 this.pSatement=this.con.prepareStatement(sqlstr);
			 ResultSet executeQuery=this.pSatement.executeQuery();
	    	 while(executeQuery.next())
	    	 {
	    		 Patient patient =new Patient();
	    		 patient.setId(executeQuery.getString(1));
	    		 patient.setName(executeQuery.getString(2));
	    		 patient.setSex(executeQuery.getString(3));
	    		 patient.setAge(executeQuery.getInt(4));
	    		 patient.setAccount(executeQuery.getFloat(5));
	    		 patient.setDisease(executeQuery.getString(6));
	    		 patient.setState(executeQuery.getString(7));
	    		 array.add(patient);
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
    public ArrayList<Patient> querysomePatient_d(Patient patient,String id)
    {
   	 ArrayList<Patient> arrays=new ArrayList<Patient>();
   	 String str="select * from patient,booking_form \r\n"
   	 		+ "where Pname like '%"+patient.getName()+"' and patient.Pid Like '%"+patient.getId()+"' and Psex like '"+patient.getSex()+"%' and State like'%"+patient.getState()+"'and booking_form.Doid='" + id+ "' and booking_form.Pid=patient.Pid";
   	 try {
			 this.pSatement=this.con.prepareStatement(str);
			 System.out.println(this.pSatement);
			 ResultSet executeQuery=this.pSatement.executeQuery();
	    	 while(executeQuery.next())
	    	 {
	    		 Patient patient1 =new Patient();
	    		 patient1.setId(executeQuery.getString(1));
	    		 patient1.setName(executeQuery.getString(2));
	    		 patient1.setSex(executeQuery.getString(3));
	    		 patient1.setAge(executeQuery.getInt(4));
	    		 patient1.setAccount((executeQuery.getFloat(5)));
	    		 patient1.setDisease(executeQuery.getString(6));
	    		 patient1.setState(executeQuery.getString(7));
	    		 arrays.add(patient1);
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
    public Patient queryAllpatient_p(String id)
    {
    	Patient patient =new Patient();
     String sqlstr="select * from patient where Pid='"+id+"'";
   	 try 
   	 {
			 this.pSatement=this.con.prepareStatement(sqlstr);
			 ResultSet executeQuery=this.pSatement.executeQuery();
	    	 if(executeQuery.next())
	    	 {
	    		  
	    		 patient.setId(executeQuery.getString(1));
	    		 patient.setName(executeQuery.getString(2));
	    		 patient.setSex(executeQuery.getString(3));
	    		 patient.setAge(executeQuery.getInt(4));
	    		 patient.setAccount(executeQuery.getFloat(5));
	    		 patient.setDisease(executeQuery.getString(6));
	    		 patient.setState(executeQuery.getString(7));
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
		return patient;
    }
}
