package com.ss.roomdbsampleapp.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Notes", indices = {@Index(value = "number", unique = true)})
public class NotesEntity implements Serializable {

	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "id")
	public int id;

	@ColumnInfo(name = "name")
	public String name;

	@ColumnInfo(name = "number")
	public String phone_number;

	@ColumnInfo(name = "email")
	public String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public NotesEntity() {

	}

}