package com.kone.cth.oneToOneUniDirectional.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "phonesdetails")
@Entity(name = "phonesdetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "provider")
    private String provider;

    @Column(name = "technology")
    private String technology;

}
