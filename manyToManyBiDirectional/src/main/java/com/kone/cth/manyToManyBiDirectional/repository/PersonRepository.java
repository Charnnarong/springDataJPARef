package com.kone.cth.manyToManyBiDirectional.repository;


import com.kone.cth.manyToManyBiDirectional.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
