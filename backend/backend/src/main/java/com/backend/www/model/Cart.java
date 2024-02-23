package com.backend.www.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long bookId;
	@Column
	private String bookName;
	@Column
	private String bookImg;
	@Column
	private String bookAuthor;
	@Column
	private String bookPrice;
	@Column
	private String bookGenre;
	@Column
	private String bookDescription;
}
