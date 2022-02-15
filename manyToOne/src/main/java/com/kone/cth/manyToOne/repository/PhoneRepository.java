package com.kone.cth.manyToOne.repository;


import com.kone.cth.manyToOne.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
