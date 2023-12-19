package com.project2.www.Store;

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
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class ClassicBooks 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bookNum;
	@Column
	private String bookName;
	@Column
	private String bookCost;
}
