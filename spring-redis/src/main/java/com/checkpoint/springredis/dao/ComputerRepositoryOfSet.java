package com.checkpoint.springredis.dao;

import com.checkpoint.springredis.model.Computer;

import java.util.Collection;

public interface ComputerRepositoryOfSet {

    public Collection<Computer> findAll();

    public Collection<Computer> findAllComputers();

    public Computer getSingleComputer(String id);

    public void saveComputer(Computer computer);

    void saveComputerUsingBytes(Computer computer);
}
