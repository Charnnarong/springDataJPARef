package com.kone.cth.oneToMany.repository;

import com.kone.cth.oneToMany.entities.Person;
import com.kone.cth.oneToMany.entities.Phone;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@ActiveProfiles("onetomany")
class OneToManyBiDirectionalRepositoryTest {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PhoneRepository phoneRepository;


    @Test
    public void getTheFirstRecord() {
        var persons = personRepository.findAll();
        assertThat(persons.size()).isEqualTo(1);
        Person person = persons.get(0);
        assertThat(person.getId()).isEqualTo(1);
        assertThat(person.getPhones().size()).isEqualTo(2);
    }

    @Test
    public void createAndGetPhoneRecord() {
        var person = Person.builder().id(2l).build();
        person.setPhones(List.of(
                Phone.builder().number("123").person(person).build(),
                Phone.builder().number("456").build(),
                Phone.builder().number("789").build()
        ));

        personRepository.save(person);
        personRepository.findById(2l).ifPresent(p -> {
            var phones = p.getPhones();
            assertThat(phones.size()).isEqualTo(3);
            assertThat(phones.get(0).getNumber()).isEqualTo("123");
            assertThat(phones.get(1).getNumber()).isEqualTo("456");
            assertThat(phones.get(2).getNumber()).isEqualTo("789");
        });

        // Phone's id 4 has person but not 5. That is why we need until on Person entity
        // such as
        //        public void addPhone(Phone phone) {
        //            phones.add(phone);
        //            phone.setPerson(this);
        //        }
        // rather than setting it manually like
        // Phone.builder().number("123").person(person).build(),
        assertThat(phoneRepository.getById(4l).getPerson().getId()).isEqualTo(2l);
        assertThat(phoneRepository.getById(5l).getPerson()).isNull();

    }

    @Test
    public void WhenDeletPhoneThenPersonPhoneIsEmpty() {
        phoneRepository.deleteById(2l);
        phoneRepository.flush();
        var person = personRepository.getById(1l);
        assertThat(person.getPhones().size()).isEqualTo(1);

    }

    @Test
    /**
     * Failed if  orphanRemoval = false in Person's phones
     */
    public void WhenDeletPersonPhone_thenPhoneIsAlsoDeleted() {

        var person = personRepository.getById(1l);
        person.getPhones().remove(0);
        assertThat(phoneRepository.findAll().size()).isEqualTo(1);

    }



}