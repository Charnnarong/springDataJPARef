package com.kone.cth.manyToManyUniDirectional.repository;

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
    AddressRepository addressRepository;
    @Autowired
    PersonRepository personRepository;

    @Test
    public void givenACorrectSetup_thenAnEntityManagerWillBeAvailable() {
        assertNotNull(personRepository);
        assertNotNull(addressRepository);
    }

    @Test
    public void getPhoneDetailFirstRecord() {
        var addresses = addressRepository.findAll();
        assertThat(addresses.size()).isEqualTo(2);
    }

    @Test
    public void getFirstPhoneRecord(){
        var person = personRepository.findAll();
        assertThat(person.get(0).getId()).isEqualTo(1);
        assertThat(person.get(0).getAddresses().size()).isEqualTo(2);
    }

    @Test
    public void udpateAddress_thenReflectToPerson(){
        var address = addressRepository.findById(2l).get();
        var newStreet = "Baker ST";
        address.setStreet(newStreet);
        var people = personRepository.findAll();
        assertThat(people.get(0).getAddresses().get(0).getStreet()).isEqualTo(newStreet);
        assertThat(people.get(1).getAddresses().get(0).getStreet()).isEqualTo(newStreet);
    }

    @Test
    public void deleteAddress_thenShouldNotPropagate(){
        var person1 = personRepository.findById(1l).get();
        person1.getAddresses().remove(0);
        var address = addressRepository.findAll();
        assertThat(address.size()).isEqualTo(2);
        var person2 = personRepository.findById(4l).get();
        assertThat(person2.getAddresses().get(0).getStreet()).isEqualTo("12th Avenue");
    }

    @Test
    public void deleteAddress(){
        addressRepository.deleteById(2l);
        var addresses = addressRepository.findAll();
        assertThat(addresses.size()).isEqualTo(1l);

        var people = personRepository.findAll();
        assertThat(people.get(1).getAddresses().size()).isEqualTo(0);
        assertThat(people.get(0).getAddresses().size()).isEqualTo(1);

    }
}