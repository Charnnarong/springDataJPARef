package com.kone.cth.manyToManyBiDirectional.repository;


import com.kone.cth.manyToManyBiDirectional.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
