package com.btkAkademi.rentACar.ws.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btkAkademi.rentACar.business.abstracts.IAdditionalService;
import com.btkAkademi.rentACar.business.dtos.AdditionalServiceListDto;
import com.btkAkademi.rentACar.business.requests.additionalServiceRequests.CreateAdditionalServiceRequest;
import com.btkAkademi.rentACar.core.utilities.results.DataResult;
import com.btkAkademi.rentACar.core.utilities.results.Result;

@RestController
@RequestMapping("/api/additionalservices")
public class AdditionalServicesController {
	private IAdditionalService iAdditionalService;

	public AdditionalServicesController(IAdditionalService iAdditionalService) {
		super();
		this.iAdditionalService = iAdditionalService;
	}
	
	@GetMapping("getById/{id}")
	public Result getById(@PathVariable int id) 
	{
		return iAdditionalService.getByAdditionalServiceId(id);	
	}
	
	@GetMapping("getall")
	public DataResult<List<AdditionalServiceListDto>> getAll()
	{
		return this.iAdditionalService.getAll();
	}

	
	@PostMapping("add")
	public Result add(@RequestBody @Valid CreateAdditionalServiceRequest createAdditionalServiceRequest) 
	{
		return this.iAdditionalService.add(createAdditionalServiceRequest);
	}
	
	@DeleteMapping("delete/{id}")
	public Result update(@PathVariable int id) {
		return this.iAdditionalService.delete(id);
	}
	
}
