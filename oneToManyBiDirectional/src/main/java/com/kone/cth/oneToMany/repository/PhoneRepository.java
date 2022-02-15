package com.kone.cth.oneToMany.repository;


import com.kone.cth.oneToMany.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
