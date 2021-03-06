package com.dusanstanojevic.MetHotels.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.tapestry5.beaneditor.NonVisual;

@MappedSuperclass
public class AbstractEntity implements Serializable, Comparable<AbstractEntity> {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) @Basic(optional = false)
	@NonVisual
	@Column(name = "ID") 
	protected Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int compareTo(AbstractEntity o) {
		return this.toString().compareTo(o.toString());
	} 
}