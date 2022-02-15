package com.kone.cth.oneToOneUniDirectional.repository;

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
    PhoneDetailsRepository phoneDetailsRepository;
    @Autowired
    PhoneRepository phoneRepository;

    @Test
    public void givenACorrectSetup_thenAnEntityManagerWillBeAvailable() {
        assertNotNull(phoneRepository);
        assertNotNull(phoneDetailsRepository);
    }

    @Test
    public void getPhoneDetailFirstRecord() {
        var phoneDetails = phoneDetailsRepository.findAll();
        assertThat(phoneDetails.size()).isEqualTo(1);
    }

    @Test
    public void getFirstPhoneRecord(){
        var phone = phoneRepository.findAll();
        assertThat(phone.get(0).getId()).isEqualTo(1);
        assertThat(phone.get(0).getDetails().getProvider()).isEqualTo("T-Mobile");
        assertThat(phone.get(0).getDetails().getTechnology()).isEqualTo("GSM");
    }


}