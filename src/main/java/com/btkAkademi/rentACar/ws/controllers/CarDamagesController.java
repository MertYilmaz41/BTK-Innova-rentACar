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

import com.btkAkademi.rentACar.business.abstracts.CarDamageService;

import com.btkAkademi.rentACar.business.dtos.CarDamageListDto;
import com.btkAkademi.rentACar.business.requests.carDamageRequests.CreateCarDamageRequest;
import com.btkAkademi.rentACar.business.requests.carDamageRequests.UpdateCarDamageRequest;
import com.btkAkademi.rentACar.core.utilities.results.DataResult;
import com.btkAkademi.rentACar.core.utilities.results.Result;

@RestController
@RequestMapping("/api/cardamages")
public class CarDamagesController {
	private CarDamageService carDamageService;

	public CarDamagesController(CarDamageService carDamageService) {
		super();
		this.carDamageService = carDamageService;
	}

	@GetMapping("getall")
	public DataResult<List<CarDamageListDto>> getAll()
	{
		return this.carDamageService.getAll();
	}
	
	@GetMapping("getById/{id}")
	public Result getById(@PathVariable int id) 
	{
		return carDamageService.getByCarDamageId(id);	
	}
	
	@PostMapping("add")
	public Result add(@RequestBody @Valid CreateCarDamageRequest createCarDamageRequest) 
	{
		return this.carDamageService.add(createCarDamageRequest);
	}

	@PostMapping("update")
	public Result update(@RequestBody @Valid UpdateCarDamageRequest updateCarDamageRequest) 
	{
		return this.carDamageService.update(updateCarDamageRequest);
	}
	
	@DeleteMapping("delete/{id}")
	public Result delete(@PathVariable int  id) {
		return this.carDamageService.delete(id);
	}
	
}
