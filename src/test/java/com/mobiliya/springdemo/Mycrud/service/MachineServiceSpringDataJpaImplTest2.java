package com.mobiliya.springdemo.Mycrud.service;


import com.mobiliya.springdemo.Mycrud.entity.Location;
import com.mobiliya.springdemo.Mycrud.entity.Machine;
import com.mobiliya.springdemo.Mycrud.repository.MachineRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MachineServiceSpringDataJpaImplTest2 {

    @Mock
    MachineRepository machineRepository;
    @Mock
    MachineServiceSpringDataJpaImpl machineServiceSpringDataJpa;

    Location location = new Location(1, "Awalgaon", 458963);
    Machine machine = new Machine(1, "IBM CPLEX", 5, (float) 458.5, 1, location);
    String json_format = "[{\"machine_id\":1,\"name\":\"IBM CPLEX\",\"parts_count\":5,\"price\":458.5,\"location_id\":1,\"location\":{\"location_id\":1,\"city\":\"Awalgaon\",\"area_code\":458963}}]";
    List<Machine> machines = new ArrayList<>();

    @Test
    public void deleteMachine_Basic(){
        doNothing().when(machineServiceSpringDataJpa).deleteMachine(isA(Integer.class));
        machineServiceSpringDataJpa.deleteMachine(1);
        verify(machineServiceSpringDataJpa,times(1)).deleteMachine(1);
    }



}
