package com.greatlearning.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="students")
public class Student {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String name;
    String department;
    String country;
}
