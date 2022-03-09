package com.jfs.OnlineFlowers.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles {
	
	@Id
	private int roleid;
	private String rolename;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
	private Set<User_Roles> userrole = new HashSet<>();
	
	public Roles() {
		
	}

	

	public Roles(int roleid, String rolename, Set<User_Roles> userrole) {
		
		this.roleid = roleid;
		this.rolename = rolename;
		this.userrole = userrole;
	}



	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	

	public Set<User_Roles> getUserrole() {
		return userrole;
	}

	public void setUserrole(Set<User_Roles> userrole) {
		this.userrole = userrole;
	}

	@Override
	public String toString() {
		return "Roles [roleid=" + roleid + ", rolename=" + rolename + ", userrole=" + userrole + "]";
	}



	
	

}
