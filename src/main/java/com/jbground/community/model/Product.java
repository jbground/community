package com.jbground.community.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	private int seq;

	@Column
	private String title;

	@Column
	private String desc;

	@Column
	private String image;

	@Column
	private int price;

	@Column
	private int stock;

	@Column
	private String creator;

	@Column
	private LocalDateTime create_time;

	@Column
	private String editor;

	@Column
	private LocalDateTime edit_time;
	
	public int getSeq() {
		return seq;
	}
	
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String getCreator() {
		return creator;
	}
	
	public void setCreator(String creator) {
		this.creator = creator;
	}

	public LocalDateTime getCreate_time() {
		return create_time;
	}

	public void setCreate_time(LocalDateTime create_time) {
		this.create_time = create_time;
	}

	public LocalDateTime getEdit_time() {
		return edit_time;
	}

	public void setEdit_time(LocalDateTime edit_time) {
		this.edit_time = edit_time;
	}

	public String getEditor() {
		return editor;
	}
	
	public void setEditor(String editor) {
		this.editor = editor;
	}
	

	
}