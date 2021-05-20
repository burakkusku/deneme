package com.ksk.LinkedinSpringboot.data;


import com.ksk.LinkedinSpringboot.entity.Room;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends PagingAndSortingRepository<Room, Long> {
}
