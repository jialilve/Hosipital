package dao;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Book;
import model.Doctor;

public class BookDao extends BaseDao
{
	 public String addBook(Book book) 
     {
    	 String resultstr="添加失败";
    	  int sum1=0;
    	 String sql="insert into booking_form values(?,?,?,?)";
    	 //String sql1="select count(*) from doctor where Doid like '"+tmpdoctor.getId()+"%'";
    	 String sql1="select count(*) from booking_form";
    	 try 
    	 {
 			this.pSatement=this.con.prepareStatement(sql1);
 			ResultSet executeQuery=this.pSatement.executeQuery();
 	    	 while(executeQuery.next())
 	    	 {
 	    		  sum1=executeQuery.getInt(1);
 	    	 }
 	    	System.out.println(sum1);
 			
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    		 
    	 try 
    	 {
    		
         this.pSatement=this.con.prepareStatement(sql);
		 this.pSatement.setString(1, String.valueOf(sum1+1));
		 this.pSatement.setString(2, book.getTime());
    	 this.pSatement.setString(3, book.getDoid());
    	 this.pSatement.setString(4, book.getPid());
    	 
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
