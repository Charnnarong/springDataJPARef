package com.kone.cth.oneToOneUniDirectional.repository;


import com.kone.cth.oneToOneUniDirectional.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
