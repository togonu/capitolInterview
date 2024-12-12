package com.capitol.interview.infrastructure.adapter;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.capitol.interview.domain.model.Price;
import com.capitol.interview.domain.port.PricePersistencePort;
import com.capitol.interview.infrastructure.adapter.mapper.PriceDboMapper;
import com.capitol.interview.infrastructure.adapter.repository.PriceRepository;

@Service
@Transactional
public class PriceJpaAdapter implements PricePersistencePort {
	private final PriceRepository priceRepository;
	private final PriceDboMapper priceDboMapper;
	
	public PriceJpaAdapter(PriceRepository priceRepository, PriceDboMapper priceDboMapper) {
        this.priceRepository = priceRepository;
        this.priceDboMapper = priceDboMapper;
    }
	
	@Override
	public List<Price> getPriceOfProduct(Long productId) {
		return priceRepository.findAllByProductId(productId)
                .stream()
                .map(priceDboMapper::toDomain)
                .collect(Collectors.toList());
	}
}
