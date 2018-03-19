package br.com.falgs.newbietests.model;

import java.math.BigDecimal;

public class Planet {

	private Long id;
	
	private String name;
	
	private BigDecimal diameter;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getDiameter() {
		return diameter;
	}

	public void setDiameter(BigDecimal diameter) {
		this.diameter = diameter;
	}
	
}
