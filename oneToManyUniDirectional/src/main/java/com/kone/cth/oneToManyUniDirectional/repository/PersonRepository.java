package com.kone.cth.oneToManyUniDirectional.repository;


import com.kone.cth.oneToManyUniDirectional.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
