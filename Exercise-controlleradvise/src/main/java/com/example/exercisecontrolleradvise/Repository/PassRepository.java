package com.example.exercisecontrolleradvise.Repository;

import com.example.exercisecontrolleradvise.Model.Pass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PassRepository extends JpaRepository<Pass,Integer> {

    Pass findPassById(Integer id);

    List<Pass> findPassByState(String state);
    List<Pass> findPassByUseridAndState(Integer userid,String state);
    @Query("select p from Pass p where p.expired_date>?1 and p.expired_date<?2")
    List<Pass> PassByExpired_dateBetween(LocalDateTime start , LocalDateTime end);
}
