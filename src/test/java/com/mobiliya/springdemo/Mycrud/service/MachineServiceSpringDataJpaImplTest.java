package com.mobiliya.springdemo.Mycrud.service;


import com.mobiliya.springdemo.Mycrud.entity.Location;
import com.mobiliya.springdemo.Mycrud.entity.Machine;
import com.mobiliya.springdemo.Mycrud.repository.MachineRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MachineServiceSpringDataJpaImplTest {

    @Mock
    MachineRepository machineRepository;

    @InjectMocks
    private MachineServiceSpringDataJpaImpl machineServiceSpringDataJpa ;

    Location location = new Location(1, "Awalgaon", 458963);
    Machine machine = new Machine(1, "IBM CPLEX", 5, (float) 458.5, 1, location);

    String json_format = "[{\"machine_id\":1,\"name\":\"IBM CPLEX\",\"parts_count\":5,\"price\":458.5,\"location_id\":1,\"location\":{\"location_id\":1,\"city\":\"Awalgaon\",\"area_code\":458963}}]";

    List<Machine> machines = new ArrayList<>();


    @Test
    public void findAll_basic(){
        machines.add(machine);
        when(machineRepository.findAll()).thenReturn(machines);
        List<Machine> machines_result =machineServiceSpringDataJpa.findAll();
        System.out.println();
        Assertions.assertEquals(2292.5, machines_result.get(0).getSum());
        Assertions.assertEquals(1, machines_result.size());
    }

    @Test
    public void getMachine_Basic(){
        machines.add(machine);
        when(machineRepository.findById(1)).thenReturn(java.util.Optional.of(machine));
        Machine machines_result =machineServiceSpringDataJpa.getMachine(1);
        Assertions.assertEquals(2292.5, machines_result.getSum());
    }

}
