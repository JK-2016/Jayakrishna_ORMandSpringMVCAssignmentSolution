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
public class Customer {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    String fname;
    String lname;
    String email;
}
