package com.example.demo.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import com.example.demo.beans.CustomerBean;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor
public class Bill implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date billingdate;

	private Long customerID;
	@OneToMany(mappedBy = "bill")
	private Collection<ProductItem> items;

	@Transient
	CustomerBean customer;
}
