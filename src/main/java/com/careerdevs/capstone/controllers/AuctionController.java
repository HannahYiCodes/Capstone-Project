package com.careerdevs.capstone.controllers;

import com.careerdevs.capstone.models.Auction;
import com.careerdevs.capstone.repositories.AuctionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/auction")
public class AuctionController {

    // I am the auction master: everyone must obey me!
    // every other user/player below me does not have administrative control
    // there should be a middle ground to not full administrative access
}
