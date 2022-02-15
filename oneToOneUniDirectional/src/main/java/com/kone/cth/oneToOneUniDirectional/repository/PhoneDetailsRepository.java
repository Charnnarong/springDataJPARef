package com.kone.cth.oneToOneUniDirectional.repository;


import com.kone.cth.oneToOneUniDirectional.entities.PhoneDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneDetailsRepository extends JpaRepository<PhoneDetails, Long> {
}
