package com.ksk.LinkedinSpringboot.data;


import com.ksk.LinkedinSpringboot.entity.Guest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends PagingAndSortingRepository<Guest,Long> {
}
