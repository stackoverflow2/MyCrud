package com.mobiliya.springdemo.Mycrud.rest;


import com.mobiliya.springdemo.Mycrud.entity.Machine;
import com.mobiliya.springdemo.Mycrud.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MachineRestController {

    @Autowired
    @Qualifier("machineServiceSpringDataJpaImpl")
    private MachineService machineService;


    @GetMapping("/mac")
    public String Testing(){
        return  "Hello world";
    }

    @GetMapping("/machines")
    public List<Machine> findAll(){
        return  machineService.findAll();
    }

    @GetMapping("/machines/{machineId}")
    public Machine getMachineById(@PathVariable int machineId){
        return machineService.getMachine(machineId);
    }

    @PostMapping("/machines")
    public Machine AddMachine(@RequestBody Machine theMachine){
        System.out.println(theMachine.toString());
        machineService.addMachine(theMachine);
        return  theMachine;
    }

    @PutMapping("/machines")
    public Machine UpdateMachine(@RequestBody Machine theMachine){

        machineService.updateMachine(theMachine);
        return theMachine;
    }

    @DeleteMapping("/machines/{machineId}")
    public String DeleteMachine(@PathVariable int machineId){

        Machine machine = machineService.getMachine(machineId);

        if(machine==null)
            throw  new RuntimeException("Machine does not exist ...");
        machineService.deleteMachine(machineId);
        return "Deleted Machine with id  : "+machineId;
    }

}
