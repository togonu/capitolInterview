package com.capitol.interview.domain.port;

import java.util.List;

import com.capitol.interview.domain.model.Price;

public interface PricePersistencePort {

	List<Price> getPriceOfProduct(Long productId);
}
