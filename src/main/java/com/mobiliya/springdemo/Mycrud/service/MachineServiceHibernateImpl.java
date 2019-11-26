package com.mobiliya.springdemo.Mycrud.service;

import com.mobiliya.springdemo.Mycrud.dao.MachineDao;
import com.mobiliya.springdemo.Mycrud.entity.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MachineServiceHibernateImpl implements MachineService {


    @Autowired
    private MachineDao machineDao;


    @Override
    @Transactional
    public List<Machine> findAll() {
        return machineDao.findAll();
    }

    @Override
    @Transactional
    public Machine getMachine(int theId) {
        return machineDao.getMachine(theId);
    }

    @Override
    @Transactional
    public void deleteMachine(int theId) {
        machineDao.deleteMachine(theId);
    }

    @Override
    @Transactional
    public void updateMachine(Machine theMachine) {
        machineDao.updateMachine(theMachine);
    }

    @Override
    public void addMachine(Machine theMachine) {
        machineDao.addMachine(theMachine);
    }


}
