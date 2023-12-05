package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Doctor;

public class DoctorDao extends BaseDao
{
     public String addDoctor(Doctor tmpdoctor) 
     {
    	 String resultstr="添加失败";
    	 String sql="insert into doctor values(?,?,?,?,?,?,?)";
    	 //String sql1="select count(*) from doctor where Doid like '"+tmpdoctor.getId()+"%'";
    	 try {
         this.pSatement=this.con.prepareStatement(sql);
		 this.pSatement.setString(1, tmpdoctor.getId());
		 this.pSatement.setString(2, tmpdoctor.getName());
    	 this.pSatement.setString(3, tmpdoctor.getSex());
    	 this.pSatement.setInt(4, tmpdoctor.getAge());
    	 this.pSatement.setString(5, tmpdoctor.getLevel());
    	 this.pSatement.setString(6, tmpdoctor.getTel());
    	 this.pSatement.setString(7, tmpdoctor.getDeparment());
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

     public ArrayList<Doctor> queryAlldoctor()
     {
    	 ArrayList array =new ArrayList();
    	 String sqlstr="select * from doctor";
    	 try 
    	 {
			 this.pSatement=this.con.prepareStatement(sqlstr);
			 ResultSet executeQuery=this.pSatement.executeQuery();
	    	 while(executeQuery.next())
	    	 {
	    		 Doctor doctor=new Doctor();
	    		 doctor.setId(executeQuery.getString(1));
	    		 doctor.setName(executeQuery.getString(2));
	    		 doctor.setSex(executeQuery.getString(3));
	    		 doctor.setAge(executeQuery.getInt(4));
	    		 doctor.setLevel(executeQuery.getString(5));
	    		 doctor.setTel(executeQuery.getString(6));
	    		 doctor.setDeparment(executeQuery.getString(7));
	    		 array.add(doctor);
	    		 
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

     public ArrayList<Doctor> querysomeDoctor(Doctor doctor)
     {
    	 ArrayList<Doctor> arrays=new ArrayList<Doctor>();
    	 String str="select * from doctor where Doname like '"+doctor.getName()+"%' and Doid Like '"+doctor.getId()+"%' and Dlevel like '"+doctor.getLevel()+"%' and Deid like'"+doctor.getDeparment()+"%'";
    	 try {
			 this.pSatement=this.con.prepareStatement(str);
			 System.out.println(this.pSatement);
			 ResultSet executeQuery=this.pSatement.executeQuery();
	    	 while(executeQuery.next())
	    	 {
	    		 Doctor doctor1=new Doctor();
	    		 doctor1.setId(executeQuery.getString(1));
	    		 doctor1.setName(executeQuery.getString(2));
	    		 doctor1.setSex(executeQuery.getString(3));
	    		 doctor1.setAge(executeQuery.getInt(4));
	    		 doctor1.setLevel(executeQuery.getString(5));
	    		 doctor1.setTel(executeQuery.getString(6));
	    		 doctor1.setDeparment(executeQuery.getString(7));
	    		 arrays.add(doctor1);
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

     public String DeleteDoctor(String id)
     {
    	 String resultstr="删除失败";
    	 String sqlstr="delete from doctor where Doid = ?";
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

     public String editDoctor(Doctor tmpdoctor)
     {
    	 String resultstr="修改失败";
    	 String sql="update doctor set Doname = ? ,Dosex = ?,Doage=? ,Dlevel = ?,Dcall = ?,Deid = ? where Doid = ?";
    	 //String sql1="select count(*) from doctor where Doid like '"+tmpdoctor.getId()+"%'";
    	 try {
         this.pSatement=this.con.prepareStatement(sql);
		
		 this.pSatement.setString(1, tmpdoctor.getName());
    	 this.pSatement.setString(2, tmpdoctor.getSex());
    	 this.pSatement.setInt(3, tmpdoctor.getAge());
    	 this.pSatement.setString(4, tmpdoctor.getLevel());
    	 this.pSatement.setString(5, tmpdoctor.getTel());
    	 this.pSatement.setString(6, tmpdoctor.getDeparment()); 
    	 this.pSatement.setString(7, tmpdoctor.getId());
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
     public Doctor querysd(String id)
     {
    	 
    	 String sqlstr="select * from doctor where Doid = ?";
    	 Doctor doctor=new Doctor();
    	 try 
    	 {
			 this.pSatement=this.con.prepareStatement(sqlstr);
			 this.pSatement.setString(1, id);
			 System.out.println(this.pSatement);
	    	  ResultSet executeQuery=this.pSatement.executeQuery();
               
	    	     while(executeQuery.next())  
	    		 {
	    		 doctor.setId(executeQuery.getString(1));
	    		 doctor.setName(executeQuery.getString(2));
	    		 doctor.setSex(executeQuery.getString(3));
	    		 doctor.setAge(executeQuery.getInt(4));
	    		 doctor.setLevel(executeQuery.getString(5));
	    		 doctor.setTel(executeQuery.getString(6));
	    		 doctor.setDeparment(executeQuery.getString(7));
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
		return doctor;
     }
}
