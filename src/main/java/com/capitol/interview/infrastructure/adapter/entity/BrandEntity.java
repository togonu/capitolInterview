package com.capitol.interview.infrastructure.adapter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="BRANDS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BrandEntity {
	@Id
	@Column(name="BRAND_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long brandId;
	@Column(name="NAME")
	private String name;
}
