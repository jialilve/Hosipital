package model;

public class Record 
{
   private String Doid;
   private String Dname;
   private String Pname;
   private String Pid;
   private String disease;
   private String date;
   public Record()
   {
	   
   }
   public Record(String Pid,String Pname,String Doid ,String Dname,String disease,String date)
   {
	    this.date=date;
	    this.Pname=Pname;
	    this.Dname=Dname;
	    this.disease=disease;
	    this.Doid=Doid;
	    this.Pid=Pid;
   }
public String getPname() {
	return Pname;
}
public void setPname(String pname) {
	Pname = pname;
}
public String getDoid() {
	return Doid;
}
public void setDoid(String doid) {
	Doid = doid;
}
public String getDname() {
	return Dname;
}
public void setDname(String dname) {
	Dname = dname;
}
public String getPid() {
	return Pid;
}
public void setPid(String pid) {
	Pid = pid;
}
public String getDisease() {
	return disease;
}
public void setDisease(String disease) {
	this.disease = disease;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
 
}
