package com.capitol.interview.infrastructure.adapter.entity;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="PRICES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PriceEntity {
	@ManyToOne
	@JoinColumn(name="BRAND_ID")
	private BrandEntity brand;
	@Column(name="START_DATE")
	private LocalDateTime startDate;
	@Column(name="END_DATE")
	private LocalDateTime endDate;
	@Id
	@Column(name="ID_PRICE_LIST")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long priceListId;
	@Column(name="PRODUCT_ID")
	private Long productId;
	@Column(name="PRIORITY")
	private int priority;
	@Column(name="PRICE")
	private double price;
	@Column(name="CURR")
	private String curr;
}
