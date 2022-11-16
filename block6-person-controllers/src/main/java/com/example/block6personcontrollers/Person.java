package com.example.block6personcontrollers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

        private String name;
        private String city;
        private int age;

        public Person(String name, String city, int age) {
            this.name = name;
            this.city = city;
            this.age = age;
        }
    }


