package com.kone.cth.manyToOne.repository;


import com.kone.cth.manyToOne.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
