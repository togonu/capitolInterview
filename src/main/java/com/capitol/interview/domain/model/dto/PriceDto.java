package com.capitol.interview.domain.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PriceDto {
	private Long productId;
	private BrandDto brand;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private double price;
}
