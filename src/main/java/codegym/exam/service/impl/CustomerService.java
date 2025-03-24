package codegym.exam.service.impl;

import codegym.exam.model.Customer;
import codegym.exam.repository.ICustomerRepository;
import codegym.exam.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer s) {
    }

    public void update(Long id, Customer s) {

    }

    public void remove(Long id) {

    }
}
