package com.mobiliya.springdemo.Mycrud.service;

import com.mobiliya.springdemo.Mycrud.entity.Machine;

import java.util.List;

public interface MachineService {

    public List<Machine> findAll();
    public Machine getMachine(int theId);
    public void deleteMachine(int theId);
    public void updateMachine(Machine theMachine);
    public void addMachine(Machine theMachine);


}
