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

}
