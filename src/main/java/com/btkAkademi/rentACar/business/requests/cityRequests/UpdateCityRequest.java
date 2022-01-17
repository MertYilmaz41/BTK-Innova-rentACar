package com.btkAkademi.rentACar.business.requests.cityRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCityRequest {
	private int cityId;
	private String cityName;
}
