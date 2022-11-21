package com.careerdevs.capstone.repositories;

import com.careerdevs.capstone.models.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    // findBySerial
    Optional<Auction> findBySerialId(Long serialNumber);
}
