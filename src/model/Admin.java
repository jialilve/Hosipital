package model;

public class Admin {
   private String id;
   private String name;
   private String password;
   private int lid;
   
   public Admin()
   {
	   
   }
   public Admin(String name,String password)
   {
	   this.name=name;
	   this.password=password;
   }
   public Admin(String id ,String name ,String password,int lid)
   {
	   this.id=id;
	   this.name=name;
	   this.lid=lid;
	   this.password=password;
   }
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getLid() {
	return lid;
}
public void setLid(int lid) {
	this.lid = lid;
}
public String toString() {
	return name+" "+password;
}
}

