package com.capitol.interview.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Price {
	private Brand brand;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Long priceListId;
	private Long productId;
	private int priority;
	private double price;
	private String curr;
}
