package com.checkpoint.springredis.dao;

import com.checkpoint.springredis.model.Computer;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

@Repository
public interface ComputerRepository {

    public Map<String, Computer> findAll();

    public Collection<Computer> findAllComputers();

    public Computer getSingleComputer(String id);

    public void saveComputer(Computer computer);




}
