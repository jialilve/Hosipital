package model;

public class Book 
{
   private String time;
   private String Doid;
   private String Pid;
   public Book()
   {
	   
   }
   public Book(String time,String Doid,String Pid)
   {
	   this.time=time;
	   this.Doid=Doid;
	   this.Pid=Pid;
   }
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getDoid() {
	return Doid;
}
public void setDoid(String doid) {
	Doid = doid;
}
public String getPid() {
	return Pid;
}
public void setPid(String pid) {
	Pid = pid;
}
}
