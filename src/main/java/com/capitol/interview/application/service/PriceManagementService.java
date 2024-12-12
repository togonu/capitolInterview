package com.capitol.interview.application.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.capitol.interview.application.mapper.PriceDtoMapper;
import com.capitol.interview.application.usecases.PriceService;
import com.capitol.interview.domain.model.CapitolConstants;
import com.capitol.interview.domain.model.Price;
import com.capitol.interview.domain.model.dto.PriceDto;
import com.capitol.interview.domain.model.dto.request.PriceRequest;
import com.capitol.interview.domain.port.PricePersistencePort;
import com.capitol.interview.infrastructure.adapter.exception.PriceException;

@Service
public class PriceManagementService implements PriceService {

	private final PricePersistencePort pricePersistencePort;
    private final PriceDtoMapper priceDtoMapper;
    
    @Autowired
    public PriceManagementService(final PricePersistencePort pricePersistencePort,
                                 final PriceDtoMapper priceDtoMapper) {
        this.pricePersistencePort = pricePersistencePort;
        this.priceDtoMapper = priceDtoMapper;
    }
    
	@Override
	public PriceDto getPriceOfProduct(PriceRequest priceRequest) {
		List<Price> priceListResponse = pricePersistencePort.getPriceOfProduct(priceRequest.getProductId());
		
		if(priceListResponse == null || priceListResponse.isEmpty()) {
			throw new PriceException(HttpStatus.BAD_REQUEST,
                    String.format(CapitolConstants.CANNOT_FIND_PRODUCT_ERROR_MESSAGE, priceRequest.getProductId()));
		}
		
		Price price = priceListResponse
				.stream()
				.filter(p -> p.getStartDate().isBefore(priceRequest.getApDate()))
				.filter(p -> p.getEndDate().isAfter(priceRequest.getApDate()))
				.max(Comparator.comparing(Price::getPriority))
				.orElseThrow(PriceException::new);
		
		return priceDtoMapper.toDto(price);
	}
}
