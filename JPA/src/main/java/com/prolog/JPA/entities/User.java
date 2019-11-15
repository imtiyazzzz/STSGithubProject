package com.prolog.JPA.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "find_all_user",query = "SELECT U FROM User U")
public class User {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String role;
	
	protected User() {}
	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}
	public User(long id,String name, String role) {
		super();
		this.id=id;
		this.name = name;
		this.role = role;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role +  "]";
	}
}
