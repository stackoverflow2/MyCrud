package com.mobiliya.springdemo.Mycrud.repository;

import com.mobiliya.springdemo.Mycrud.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer> {

    //custom code
}
