package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.MeetBooking;

@Repository
public interface MeetBookingRepository extends JpaRepository<MeetBooking, Integer>{

}