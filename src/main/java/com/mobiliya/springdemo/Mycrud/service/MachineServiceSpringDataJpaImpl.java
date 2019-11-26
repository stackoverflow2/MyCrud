package com.mobiliya.springdemo.Mycrud.service;

import com.mobiliya.springdemo.Mycrud.entity.Machine;
import com.mobiliya.springdemo.Mycrud.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MachineServiceSpringDataJpaImpl  implements MachineService{

    @Autowired
    private MachineRepository machineRepository;

    @Override
    public List<Machine> findAll() {
        List<Machine>  machines = machineRepository.findAll();
        for(Machine machine : machines){
            machine.setSum(machine.getParts_count()*machine.getPrice());
        }
        return machines;
    }


    @Override
    public Machine getMachine(int theId) {
        Optional<Machine> result  = machineRepository.findById(theId);
        if(result==null)
            throw new RuntimeException("No machine found");
        Machine machine=  result.get();
        machine.setSum(machine.getParts_count()*machine.getPrice());
        return machine;
    }

    @Override
    public void deleteMachine(int theId) {
        machineRepository.deleteById(theId);
    }

    @Override
    public void updateMachine(Machine theMachine) {
        theMachine.setSum(theMachine.getPrice()*theMachine.getParts_count());
        machineRepository.save(theMachine);
    }

    @Override
    public void addMachine(Machine theMachine) {
        theMachine.setSum(theMachine.getPrice()*theMachine.getParts_count());
        machineRepository.save(theMachine);
    }

}
