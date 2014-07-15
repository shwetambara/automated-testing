package DBtests;

public class UserInfo {

	private String username, password, email;
	private char admin;
	private int user_id;
	
	public int getuser_id(){
		return user_id;
	}
	
	public void setuser_id(int user_id){
		this.user_id= user_id;
	}
	public String getusername(){
		return username;
	}
	
	public void setusername(String username){
		this.username= username;
	}
	
	public String getpassword(){
		return password;
	}
	
	public void setpassword(String password){
		this.password= password;
	}
	
	public String getemail(){
		return email;
	}
	
	public void setemail(String email){
		this.email= email;
	}
	
	public char getadmin(){
		return admin;
	}
	
	public void setadmin(char admin){
		this.admin= admin;
	}
	
	
	//To display the information taken form the above methods
	public static void main(String[] args) {
		
		UserInfo attri = new UserInfo();
		
		attri.setuser_id(1);
		attri.setadmin('y');
		attri.setusername("rajul");
		attri.setpassword("abc");
		attri.setemail("rajul@xuz.com");
		
		System.out.println("user_id= " +attri.getuser_id());
		System.out.println("username= " +attri.getusername());
		System.out.println("password= " +attri.getpassword());
		System.out.println("email= " +attri.getemail());
		System.out.println("admin= " +attri.getadmin());
	}

}
