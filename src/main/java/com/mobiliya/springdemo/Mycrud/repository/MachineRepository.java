package com.mobiliya.springdemo.Mycrud.repository;

import com.mobiliya.springdemo.Mycrud.entity.Location;
import com.mobiliya.springdemo.Mycrud.entity.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineRepository extends JpaRepository<Machine,Integer> {

//    @Query("Select * from Machine join Location on Machine.location_id=Location.location_id")
//    public List<Machine> FindAllWithDescriptionQuery();

    //custom code here


}
