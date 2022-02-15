package com.kone.cth.oneToOneBiDirectional.repository;


import com.kone.cth.oneToOneBiDirectional.entities.PhoneDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneDetailsRepository extends JpaRepository<PhoneDetails, Long> {
}
