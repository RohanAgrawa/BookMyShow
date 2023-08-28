package com.example.bms.repositry;

import com.example.bms.models.SeatInShow;
import com.example.bms.models.SeatTypeInShow;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatInShowRepositry  extends JpaRepository<SeatInShow, Long> {

    @Override
    List<SeatInShow> findAllById(Iterable<Long> longs);

    @Override
    SeatInShow save(SeatInShow entity);
}
