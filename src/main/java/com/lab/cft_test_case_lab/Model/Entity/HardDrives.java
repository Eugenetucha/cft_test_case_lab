package com.lab.cft_test_case_lab.Model.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "drives")
@NoArgsConstructor
@AllArgsConstructor
public class HardDrives {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long id;
    @Column
    int volume;
    @Column
    Long batchNumber;
    @Column
    String manufacturer;
    @Column
    int price;
    @Column
    int amount;
}
