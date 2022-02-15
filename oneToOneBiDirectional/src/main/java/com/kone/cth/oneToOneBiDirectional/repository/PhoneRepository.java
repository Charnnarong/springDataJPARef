package com.kone.cth.oneToOneBiDirectional.repository;


import com.kone.cth.oneToOneBiDirectional.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
