package com.pesterenan.citiesapidio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import com.pesterenan.citiesapidio.utils.PointType;

@Entity
@Table(name = "cidade")
@TypeDefs(value = { @TypeDef(name = "point", typeClass = PointType.class) })
public class City {

	@Id
	private Long id;

	@Column(name = "nome")
	private String name;

	@ManyToOne
	@JoinColumn(name = "uf", referencedColumnName = "id")
	private State uf;

	private Integer ibge;

	// 2nd
	@Type(type = "point")
	@Column(name = "lat_lon", updatable = false, insertable = false)
	private Point location;

	public City() {
	}

	public City(final Long id, final String name, final State uf, final Integer ibge, final Point location) {
		this.id = id;
		this.name = name;
		this.uf = uf;
		this.ibge = ibge;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public State getUf() {
		return uf;
	}

	public Integer getIbge() {
		return ibge;
	}

	public Point getLocation() {
		return location;
	}
}