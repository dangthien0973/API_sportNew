package API_sportNew.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(	name = "useraccount")
public class useraccount {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int user_id ;
private String username;
private String password;
private String email;
private Date createdate;
private String customername;
private int isdelete;
private String verificationCode;
private int enabled;
public useraccount() {
	
}
public useraccount(int user_id, String username, String password, String email, Date createdate, String customername,
		int isdelete,String verificationCode,int enabled) {
	super();
	this.user_id = user_id;
	this.username = username;
	this.password = password;
	this.email = email;
	this.createdate = createdate;
	this.customername = customername;
	this.isdelete = isdelete;
	this.verificationCode=verificationCode;
	this.enabled=enabled;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getCreatedate() {
	return createdate;
}
public void setCreatedate(Date createdate) {
	this.createdate = createdate;
}
public String getCustomername() {
	return customername;
}
public void setCustomername(String customername) {
	this.customername = customername;
}
public int getIsdelete() {
	return isdelete;
}
public void setIsdelete(int isdelete) {
	this.isdelete = isdelete;
}

public String getVerificationCode() {
	return verificationCode;
}
public void setVerificationCode(String verificationCode) {
	this.verificationCode = verificationCode;
}
public int getEnabled() {
	return enabled;
}
public void setEnabled(int enabled) {
	this.enabled = enabled;
}
@Override
public String toString() {
	return "useraccount [user_id=" + user_id + ", username=" + username + ", password=" + password + ", email=" + email
			+ ", createdate=" + createdate + ", customername=" + customername + ", isdelete=" + isdelete + "]";
}


}
