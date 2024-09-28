package jmaster.io.restapi.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "DBUser")
public class User {
	private int user_id;
	@Column(unique = true)
	private String username;
	private String password;
//	private String role_id;	//Set ko có kiểu int
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getUser_id() {
		return user_id;
	}
	private String role_id;
//	@Transient
//	private Set<Integer> role_set = new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER)
    //joinColums: cột nhập vào hay cột khóa ngoại, name: tên của cột khóa ngoại cho bảng tg, ref..: tên cột của user mà bảng tg tham chiếu tới
	@JoinTable(name = "DBUserRole", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id") )
//    private Set<Role> roles = new HashSet<>();
//    public Set<Role> getRoles() {
//		return roles;
//	}
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	//	public void setUser_id(int user_id) {
//		this.user_id = user_id;
//	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	//Má ko để getRole_id đc, máy sẽ biên dịch là getter cho biến (Set)role_id đc, mà mình thì muốn nó ko bị quét bởi jdbc =(
//	public Set<Integer> StringtoSet(){
//		return Arrays.stream(role_id.split(",")).map(Integer::parseInt).collect(Collectors.toSet());
//	}
	public void setPassword(String password) {
		this.password = password;
	}
//	@Transient
//	public Set<Integer> getRole_set() {
//		return Arrays.stream(role_id.split(",")).map(Integer::parseInt).collect(Collectors.toSet());
//	}
//	public void setRole_set(Set<Integer> role_id) {
//		this.role_set = role_id;
//	}
//	Thực ra là getRole_id nma bị lỗi cast String & Set
	public String getRole_id() {
		return role_id;
	}
	public String SezToString(Set<Integer> role_int) {
		return role_int.stream()							//phân luồng
				.map(String::valueOf)				//Thực hiện chuyển giá trị sang String tại mỗi luồng
				.collect(Collectors.joining(","));	//nhặt thêm dấu , 
	}
	public Set<Integer> StrinToSet(){
		return Arrays.stream(role_id.split(",")).map(Integer::parseInt).collect(Collectors.toSet());
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	
	@Override
	public String toString() {
		System.out.println("76 OK");
		return "User [username=" + username + ", password=" + password + ", roles=" + role_id+"]";
	}
	public User(String username, String password,Set<Integer> roles) {
		super();
		this.username = username;
		this.password = password;
		this.role_id = SezToString(roles);
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
		this.user_id = 0;
		this.username = "username";
		this.password = "password";
		this.role_id=null;
	}
	
}
