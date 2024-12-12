package com.capitol.interview.infrastructure.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitol.interview.application.usecases.PriceService;
import com.capitol.interview.domain.model.dto.PriceDto;
import com.capitol.interview.domain.model.dto.request.PriceRequest;

@RestController
@RequestMapping("/price")
public class PriceController {

	private final PriceService priceService;
	
	public PriceController(PriceService priceService) {
		this.priceService = priceService;
	}
	
    @GetMapping
    public PriceDto getPriceOfProduct(@RequestBody PriceRequest priceRequest){
        return priceService.getPriceOfProduct(priceRequest);
    }
}
