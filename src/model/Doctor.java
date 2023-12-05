package model;

public class Doctor 
{
    private String id;
    private String name;
    private String sex;
    private int age;
    private String level;
    private String tel;
    private String deparment;
    public Doctor()
    {
    	
    }
    public Doctor(String id,String name,String sex,int age,String level,String tel,String deparment)
    {
    	this.age=age;
    	this.deparment=deparment;
    	this.id=id;
    	this.level=level;
    	this.name=name;
    	this.sex=sex;
    	this.tel=tel;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDeparment() {
		return deparment;
	}
	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}
	 
}
