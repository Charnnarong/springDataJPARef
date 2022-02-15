package com.kone.cth.manyToManyUniDirectional.repository;


import com.kone.cth.manyToManyUniDirectional.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
