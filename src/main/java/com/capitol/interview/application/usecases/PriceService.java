package com.capitol.interview.application.usecases;

import com.capitol.interview.domain.model.dto.PriceDto;
import com.capitol.interview.domain.model.dto.request.PriceRequest;

public interface PriceService {
	PriceDto getPriceOfProduct(PriceRequest priceRequest);
}
