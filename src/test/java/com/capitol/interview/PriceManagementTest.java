package com.capitol.interview;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capitol.interview.application.mapper.PriceDtoMapper;
import com.capitol.interview.application.service.PriceManagementService;
import com.capitol.interview.domain.model.Brand;
import com.capitol.interview.domain.model.Price;
import com.capitol.interview.domain.model.dto.BrandDto;
import com.capitol.interview.domain.model.dto.PriceDto;
import com.capitol.interview.domain.model.dto.request.PriceRequest;
import com.capitol.interview.infrastructure.adapter.PriceJpaAdapter;

@ExtendWith(MockitoExtension.class)
public class PriceManagementTest {
	@Mock
	private PriceJpaAdapter priceJpaAdapter;
	
	private PriceDtoMapper priceDtoMapper = Mappers.getMapper(PriceDtoMapper.class);
	
	private PriceManagementService priceManagementService;
	
	@BeforeEach
	void setUp() {
		priceManagementService = new PriceManagementService(priceJpaAdapter, priceDtoMapper);
	}
	
	@DisplayName("When asking for the price of a product, receive "
			+ "the according price depending on date of application and priority number")
	@Test
	public void expectCorrectPriceWhenAskingForAProductDay14At10() {
		LocalDateTime requestDate = LocalDate.of(2020, 6, 14).atTime(10, 0,0);
		LocalDateTime startDate = LocalDate.of(2020, 6, 14).atTime(0, 0, 0);
		LocalDateTime endDate = LocalDate.of(2020, 12, 31).atTime(23, 59, 59);
		sendData(requestDate,startDate,endDate, 35455L, new BrandDto(1L, "ZARA"), 35.50, 0);
	}
	
	@Test
	public void expectCorrectPriceWhenAskingForAProductDay14At16() {
		LocalDateTime requestDate = LocalDate.of(2020, 6, 14).atTime(16, 0,0);
		LocalDateTime startDate = LocalDate.of(2020, 6, 14).atTime(15, 0, 0);
		LocalDateTime endDate = LocalDate.of(2020, 6, 14).atTime(18, 30, 0);
		sendData(requestDate,startDate,endDate, 35455L, new BrandDto(1L, "ZARA"), 25.45, 0);
	}
	
	@Test
	public void expectCorrectPriceWhenAskingForAProductDay14At21() {
		LocalDateTime requestDate = LocalDate.of(2020, 6, 14).atTime(21, 0,0);
		LocalDateTime startDate = LocalDate.of(2020, 6, 14).atTime(0, 0, 0);
		LocalDateTime endDate = LocalDate.of(2020, 6, 14).atTime(23, 59, 59);
		sendData(requestDate,startDate,endDate, 35455L, new BrandDto(1L, "ZARA"), 35.50, 0);
	}
	
	@Test
	public void expectCorrectPriceWhenAskingForAProductDay15at10() {
		LocalDateTime requestDate = LocalDate.of(2020, 6, 15).atTime(10, 0,0);
		LocalDateTime startDate = LocalDate.of(2020, 6, 15).atTime(0, 0, 0);
		LocalDateTime endDate = LocalDate.of(2020, 6, 15).atTime(11, 0, 0);
		sendData(requestDate,startDate,endDate, 35455L, new BrandDto(1L, "ZARA"), 30.50, 0);
	}
	
	@Test
	public void expectCorrectPriceWhenAskingForAProductDay16At21() {
		LocalDateTime requestDate = LocalDate.of(2020, 6, 16).atTime(21, 0,0);
		LocalDateTime startDate = LocalDate.of(2020, 6, 15).atTime(16, 0, 0);
		LocalDateTime endDate = LocalDate.of(2020, 12, 31).atTime(23, 59, 59);
		sendData(requestDate,startDate,endDate, 35455L, new BrandDto(1L, "ZARA"), 38.95, 0);
	}
	
	private void sendData(LocalDateTime requestDate, LocalDateTime startDate, LocalDateTime endDate,
			Long productId, BrandDto brand, double price, int priority) {
		PriceRequest request = new PriceRequest(requestDate, productId, brand.getBrandId());
	
		PriceDto expected = new PriceDto(productId, new BrandDto(brand.getBrandId(), brand.getName()),
				startDate, endDate, price);
		
		Price domain = new Price(new Brand(brand.getBrandId(), brand.getName()), startDate, 
				endDate, Mockito.anyLong(), productId, priority, price, "EUR");
		List<Price> domainList = new ArrayList<>();
		domainList.add(domain);
		Mockito.when(priceJpaAdapter.getPriceOfProduct(productId)).thenReturn(domainList);
		
		
		PriceDto result = priceManagementService.getPriceOfProduct(request);
		Assertions.assertEquals(expected.getBrand().getBrandId(), result.getBrand().getBrandId());
		Assertions.assertEquals(expected.getBrand().getName(), result.getBrand().getName());
		Assertions.assertEquals(expected.getStartDate(), result.getStartDate());
		Assertions.assertEquals(expected.getEndDate(), result.getEndDate());
		Assertions.assertEquals(expected.getProductId(), result.getProductId());
		Assertions.assertEquals(expected.getPrice(), result.getPrice());
	}
	
}
