package com.atguigu.service.impl;

import com.atguigu.dao.CustomerDao;
import com.atguigu.domain.Customer;
import com.atguigu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    RedisTemplate redisTemplate;


    @Override
    public List<Customer> findCustomer() {
        String key = "allCustomer";
        List<Customer> list = (List<Customer>)redisTemplate.boundValueOps(key).get();
        if (list!=null){
            System.out.println("redis list = " + list);
            return  list;
        }
        list = customerDao.findAll();
        System.out.println("findAll list = " + list);
        redisTemplate.boundValueOps(key).set(list);
        return list;
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerDao.getOne(id);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerDao.deleteById(id);
    }
}
