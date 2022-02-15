package com.kone.cth.oneToManyUniDirectional.repository;


import com.kone.cth.oneToManyUniDirectional.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
