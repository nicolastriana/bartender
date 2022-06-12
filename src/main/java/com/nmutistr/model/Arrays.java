package com.nmutistr.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase modelo de Arrays
 * @author nicolas
 *
 */
@Getter
@Setter
@Entity
@Table(name = "arrays")
public class Arrays {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "input_array", nullable = false, length=20)
	private String inputArray;

}
