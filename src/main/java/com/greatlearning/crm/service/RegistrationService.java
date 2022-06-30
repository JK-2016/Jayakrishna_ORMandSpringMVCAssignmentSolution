package com.greatlearning.crm.service;


import com.greatlearning.crm.model.Customer;
import com.greatlearning.crm.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RegistrationService {
    @Autowired
    private final CustomerRepository customerRepository;
    public RegistrationService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer registerCustomer(Customer customer){
        return this.customerRepository.registerCustomer(customer);
    }
    public List<Customer> getRegisteredCustomers(){
        return this.customerRepository.getRegisteredCustomers();
    }
    public Customer updateCustomerDetails(int id, Customer customer){
        return this.customerRepository.updateCustomerDetails(id, customer);
    }
    public void deleteCustomer(int id){
        System.out.println("Student with the following Id is deleted: "+ id);
        this.customerRepository.deleteCustomerById(id);
        return;
    }

    public Customer getCustomer(int id) {
        return this.customerRepository.getCustomerById(id);
    }
}
