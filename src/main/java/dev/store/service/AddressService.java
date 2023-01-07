package dev.store.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.store.models.Address;
import dev.store.repository.JavadbRepository;

@Service
public class AddressService
{
	@Autowired
	private JavadbRepository dbRepository;

	public List<Address> getAll()
	{
		return dbRepository.findAll();
	}

	public Address getOne(int id)
	{
		return dbRepository.findAddressById(id);
	}

	public Address create(Address address)
	{
		return dbRepository.save(address);
	}

	public Address update(int id, Map<String, String> addressFields)
	{
		Address current = dbRepository.findById(id).get();
		current.setStreet(addressFields.get("street"));
		current.setNumber(Integer.parseInt(addressFields.get("number")));
		current.setPostcode(addressFields.get("postcode"));

		dbRepository.save(current);

		return current;
	}

	public void delete(int id)
	{
		dbRepository.deleteById(id);

	}
}
