package com.example.bms.models;

import com.example.bms.models.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Actor extends BaseModel{

    private String name;

    private int age;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
}
