package com.kone.cth.manyToOne.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
@ActiveProfiles("test")
class RepositoryTest {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PhoneRepository phoneRepository;

    @Test
    public void givenACorrectSetup_thenAnEntityManagerWillBeAvailable() {
        assertNotNull(personRepository);
    }

    @Test
    public void getTheFirstRecord() {
        var persons = personRepository.findAll();
        assertThat(persons.size()).isEqualTo(1);
        assertThat(persons.get(0).getId()).isEqualTo(1);
    }

    @Test
    public void testPhone(){
        var phoneId2 = phoneRepository.findById(2l).orElseThrow();
        assertThat(phoneId2.getPerson().getId()).isEqualTo(1l);

    }

}