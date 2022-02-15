package com.kone.cth.manyToManyUniDirectional.repository;


import com.kone.cth.manyToManyUniDirectional.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
