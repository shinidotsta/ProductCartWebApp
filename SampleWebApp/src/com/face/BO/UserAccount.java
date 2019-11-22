package com.face.BO;

public class UserAccount 
{
	public static final String GENDER_MALE ="M";
    public static final String GENDER_FEMALE = "F";
     
    private String username;
    private String gender;
    private String password;
	public String getUserName() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static String getGenderMale() {
		return GENDER_MALE;
	}
	public static String getGenderFemale() {
		return GENDER_FEMALE;
	}
    
    
}
