package com.example.exercisecontrolleradvise.Repository;

import com.example.exercisecontrolleradvise.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

    Vehicle findVehicleById(Integer id);

    List<Vehicle> findVehicleByUserid(Integer userid);
}
