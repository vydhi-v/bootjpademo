package com.example.bootjpa.repo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * 
 * Used by the mock version
@Data
@AllArgsConstructor(staticName = "of")
public class Dog {
    private long id;
    private String name;
    private int age;
}
*/

@Entity
@Getter @Setter @NoArgsConstructor
public class Dog {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int age;
}
