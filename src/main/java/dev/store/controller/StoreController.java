package dev.store.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.store.models.Address;
import dev.store.service.AddressService;

@RestController
@RequestMapping("/store")
public class StoreController
{
	@Autowired
	AddressService addressService;

	@GetMapping
	public ResponseEntity<List<Address>> getAllAddresses()
	{
		return ResponseEntity.ok(addressService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Address> getSingleAddress(@PathVariable int id)
	{
		return ResponseEntity.ok(addressService.getOne(id));
	}
	
	@PostMapping("/add-address")
	public ResponseEntity<Address> createAddress(@RequestBody @Valid Address address)
	{		
		return new ResponseEntity<Address>(addressService.create(address), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable int id,@RequestBody Map<String, String> addressFields)
	{				
		return ResponseEntity.ok(addressService.update(id,addressFields));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteAddress(@PathVariable int id)
	{		
		addressService.delete(id);
						
	}
}
