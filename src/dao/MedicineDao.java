package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Medicine;
import model.Patient;
import model.dest1;
import model.mest1;

public class MedicineDao extends BaseDao{
     
	public String addMedicine(Medicine me) 
    {
   	 String resultstr="添加失败";
   	 String sql="insert into medicine values(?,?,?,?,?,?,?,?)";
   	 //String sql1="select count(*) from  where Doid like '"+tmpdoctor.getId()+"%'";
   	 try {
     
     this.pSatement=this.con.prepareStatement(sql);
	 this.pSatement.setString(1, me.getMeid());
	 this.pSatement.setString(2, me.getMename());
   	 this.pSatement.setFloat(3, me.getPrice());
   	 this.pSatement.setString(4,me.getFirm());
   	 this.pSatement.setString(5,me.getType());
   	 this.pSatement.setString(6, me.getWaid());
   	 this.pSatement.setFloat(7, me.getPrice1());
   	 this.pSatement.setInt(8, me.getSnumber());
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

    public ArrayList<Medicine> queryAllmedicine()
    {
   	 ArrayList array =new ArrayList();
   	 String sqlstr="select * from medicine";
   	 try 
   	 {
			 this.pSatement=this.con.prepareStatement(sqlstr);
			 ResultSet executeQuery=this.pSatement.executeQuery();
	    	 while(executeQuery.next())
	    	 {
	    		 Medicine me=new Medicine();
	    		 me.setMeid(executeQuery.getString(1));
	    		 me.setMename(executeQuery.getString(2));
	    		 me.setPrice(executeQuery.getFloat(3));
	    		 me.setFirm(executeQuery.getString(4));
	    		 me.setType(executeQuery.getString(5));
	    		 me.setWaid(executeQuery.getString(6));
	    		 me.setPrice1(executeQuery.getFloat(7));
	    		 me.setSnumber(executeQuery.getInt(8));
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

    public ArrayList<Medicine> querysomeMedicine(String name,String firm,String type)
    {
   	 ArrayList<Medicine> arrays=new ArrayList<Medicine>();
   	 String str="select * from medicine where Mename like '"+name+"%' and Firm Like '"+firm+"%' and Type like '"+type+"%'";
   	 try {
			 this.pSatement=this.con.prepareStatement(str);
			 System.out.println(this.pSatement);
			 ResultSet executeQuery=this.pSatement.executeQuery();
	    	 while(executeQuery.next())
	    	 {
	    		 Medicine me =new Medicine();
	    		 me.setMeid(executeQuery.getString(1));
	    		 me.setMename(executeQuery.getString(2));
	    		 me.setPrice(executeQuery.getFloat(3));
	    		 me.setFirm(executeQuery.getString(4));
	    		 me.setType((executeQuery.getString(5)));
	    		 me.setWaid(executeQuery.getString(6));
	    		 me.setPrice1(executeQuery.getFloat(7));
	    		 me.setSnumber(executeQuery.getInt(8));
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
     
    public String editMedicine(Medicine mm)
    {
    	 String resultstr="修改失败";
    	 String sql="update medicine set Mename = ? ,Price = ?,Firm=? ,Type = ?,Waid = ?,Price1 = ? ,Snumber = ? where Meid = ?";
    	 //String sql1="select count(*) from doctor where Doid like '"+tmpdoctor.getId()+"%'";
    	 try {
         this.pSatement=this.con.prepareStatement(sql);
		
		 this.pSatement.setString(8, mm.getMeid());
    	 this.pSatement.setString(1, mm.getMename());
    	 this.pSatement.setFloat(2, mm.getPrice());
    	 this.pSatement.setString(3, mm.getFirm());
    	 this.pSatement.setString(4, mm.getType());
    	 this.pSatement.setString(5, mm.getWaid()); 
    	 this.pSatement.setFloat(6, mm.getPrice1());
    	 this.pSatement.setInt(7, mm.getSnumber());
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
    public String QueryMedicine(Medicine mm)
    {
    	 String resultstr="失败";
    	 String sql="";
    	 //String sql1="select count(*) from doctor where Doid like '"+tmpdoctor.getId()+"%'";
    	 try {
         this.pSatement=this.con.prepareStatement(sql);
		
		 this.pSatement.setString(8, mm.getMeid());
    	 this.pSatement.setString(1, mm.getMename());
    	 this.pSatement.setFloat(2, mm.getPrice());
    	 this.pSatement.setString(3, mm.getFirm());
    	 this.pSatement.setString(4, mm.getType());
    	 this.pSatement.setString(5, mm.getWaid()); 
    	 this.pSatement.setFloat(6, mm.getPrice1());
    	 this.pSatement.setInt(7, mm.getSnumber());
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
    public ArrayList<mest1> queryAllMedicine()
    {
   	 ArrayList array =new ArrayList();
   	 String sqlstr="SELECT* FROM mest";
   	 try 
   	 {
			 this.pSatement=this.con.prepareStatement(sqlstr);	 
			 ResultSet executeQuery=this.pSatement.executeQuery();
			 System.out.print(this.pSatement);
		
	    	 while(executeQuery.next())
	    	 {
	    		 mest1 d1=new mest1();
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
