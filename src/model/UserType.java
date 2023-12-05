package model;

public enum UserType {
   ADMIN("管理员",0),
   DOCTOR("医生",1),
   PATIENT("病人",2);
   private String name;
   private int index;
   private UserType(String name ,int index)
   {
	   this.index=index;
	   this.name=name;
   } 
   public String getName()
   {
	   return name;
   }
   public void setName(String name)
   {
	   this.name=name;
   }
   public int getIndex()
   {
	   return index;
   }
   public void setIndex(int index)
   {
	   this.index=index;
   }
   public String toString()
   {
	   return name;
   }
}
