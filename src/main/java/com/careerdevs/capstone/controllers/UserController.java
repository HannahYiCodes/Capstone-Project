package com.careerdevs.capstone.controllers;

import com.careerdevs.capstone.models.User;
import com.careerdevs.capstone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@CrossOrigin
@RestController
@RequestMapping
public class UserController {
        @Autowired
        private UserRepository userRepository;

        @PostMapping
        public ResponseEntity<?> addOneUser(@RequestBody User newUserData) {
            try {
                User addedUser = userRepository.save(newUserData);
                return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body(e.getMessage());
            }
        }


//    @GetMapping("/token/{loginToken}")
//    public ResponseEntity<?> getAllUsersByToken(@PathVariable String loginToken) {
//        User foundUser = userRepository.findByLoginToken(loginToken).orElseThrow(
//                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
//        );
//        return new ResponseEntity<>(foundUser, HttpStatus.OK);
//    }

        @PostMapping("/login")
        public ResponseEntity<?> loginUser(@RequestBody User authUser) {
            // Find the user
            // Compare password provided with password of user account
            // Create random token & save to user record
            // Return login token

            Optional<User> foundUser = userRepository.findById(authUser.getUsername());
            if (!authUser.getPassword().equals(foundUser.get().getPassword())) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
//        Random randomNum = new Random();
            int randomNum = ThreadLocalRandom.current().nextInt();  // 2 users could have same token, one possibility to avoid this is use current day/time     OR
            // concatenate username to end of generated String
            authUser.setLoginToken(Integer.toString(randomNum) + foundUser.get().getUsername());
            userRepository.save(authUser);
            return new ResponseEntity<>(authUser.getLoginToken(), HttpStatus.OK);
        }
//    @PostMapping("/{bankId}/{loginToken}")
//    public ResponseEntity<?> createCustomer(@RequestBody Customer newCustomerData, @PathVariable Long bankId) {
//        // Find the bank by ID in the repository
//        // If bank doesn't exist return bad request
//        // If bank exist add to newCustomerData and save
//        Bank requestedBank = bankRepository.findById(bankId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST)); //user got us bad request or wrong data
//        newCustomerData.setBank(requestedBank);
//        Customer addedCustomer = customerRepository.save(newCustomerData);
//        return new ResponseEntity<>(addedCustomer, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/")
//    public ResponseEntity<?> getAllCustomersFromDB() {
//        List<Customer> allCustomers = customerRepository.findAll();
//        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
//        Customer requestedCustomer = customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//        return new ResponseEntity<>(requestedCustomer, HttpStatus.OK);
//    }

}
