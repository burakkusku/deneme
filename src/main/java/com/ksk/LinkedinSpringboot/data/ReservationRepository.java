package com.ksk.LinkedinSpringboot.data;

import com.ksk.LinkedinSpringboot.entity.Reservation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ReservationRepository extends PagingAndSortingRepository<Reservation, Long> {

    Iterable<Reservation> findByResDate(Date date);

}
