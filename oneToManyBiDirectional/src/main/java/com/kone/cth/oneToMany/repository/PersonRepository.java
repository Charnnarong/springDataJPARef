package com.kone.cth.oneToMany.repository;


import com.kone.cth.oneToMany.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
