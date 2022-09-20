package com.lab.cft_test_case_lab.Controllers;

import com.lab.cft_test_case_lab.Model.Entity.HardDrives;
import com.lab.cft_test_case_lab.Repository.HardDrivesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DrivesController {
    @Autowired
    HardDrivesRepository hardDrivesRepository;

    @PostMapping("/drives/add")
    public ResponseEntity<?> addProduct(@RequestBody HardDrives drives) {
        hardDrivesRepository.save(drives);
        return new ResponseEntity<>(drives, HttpStatus.OK);
    }

    @PatchMapping("/drives/change/{id}")
    public ResponseEntity<?> changeProduct(@PathVariable Long id, @RequestBody HardDrives Drives) {
        hardDrivesRepository.delete(hardDrivesRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        hardDrivesRepository.save(Drives);
        return new ResponseEntity<>(Drives, HttpStatus.OK);
    }

    @DeleteMapping("/drives/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        hardDrivesRepository.delete(hardDrivesRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/drives/see")
    public ResponseEntity<?> seeProduct() {
        return new ResponseEntity<>(hardDrivesRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/drives/see/{id}")
    public ResponseEntity<?> seeOneProduct(@PathVariable Long id) {
        return new ResponseEntity<>(hardDrivesRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), HttpStatus.OK);
    }

}
