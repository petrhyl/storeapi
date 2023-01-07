package dev.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.store.models.Address;

public interface JavadbRepository extends JpaRepository<Address, Integer>
{
	Address findAddressById(int id);
}
