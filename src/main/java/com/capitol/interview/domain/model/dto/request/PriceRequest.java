package com.capitol.interview.domain.model.dto.request;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PriceRequest {
	@JsonProperty("fechaAplicacion")
	@JsonFormat(pattern= "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime apDate;
	@JsonProperty("idProducto")
	private Long productId;
	@JsonProperty("idCadena")
	private Long brandId;
}
