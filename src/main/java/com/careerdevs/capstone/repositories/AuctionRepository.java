package com.careerdevs.capstone.repositories;

import com.careerdevs.capstone.models.Auction;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuctionRepository {
    // findBySerial
    Optional<Auction> findBySerialId(Long serialNumber);
}
