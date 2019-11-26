package com.mobiliya.springdemo.Mycrud.repository;

import com.mobiliya.springdemo.Mycrud.entity.Machine;
import com.mobiliya.springdemo.Mycrud.repository.MachineRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MachineRepositoryTest {

    @Autowired
    private MachineRepository machineRepository;

    @Test
    public void test(){

        Optional<Machine> result = machineRepository.findById(1);
        Machine machine = result.get();
        System.out.println(machine.toString());

    }

    @Test
    public void MachinefindAll_size(){
        Iterable<Machine> result = machineRepository.findAll();
        List<Machine> machines = new ArrayList<>();
        for(Machine machine :result){
            machines.add(machine);
            System.out.println(machine.toString());
        }
        Assertions.assertEquals(2, machines.size());
    }

    @Test
    public void MachineFindById_basic(){

        Optional<Machine> result = machineRepository.findById(1);
        Machine machine = result.get();
        Assertions.assertEquals(1, machine.getMachine_id());
    }

}
