package jmaster.io.restapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "DBRole")
public class Role {
	@Id
	private int role_id;
	private String rolename;
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
		this.role_id = 1;
		this.rolename = "user";
	}
	
	public Role(int role_id, String rolename) {
		super();
		this.role_id = role_id;
		this.rolename = rolename;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole() {
		return rolename;
	}
	public void setRole(String rolename) {
		this.rolename = rolename;
	}
	@Override
	public String toString() {
		return "rolename: "+rolename;
	}
}
