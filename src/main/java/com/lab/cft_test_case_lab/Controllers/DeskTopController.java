package com.lab.cft_test_case_lab.Controllers;

import com.lab.cft_test_case_lab.Model.Entity.DeskTop;
import com.lab.cft_test_case_lab.Repository.DeskTopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DeskTopController {
    @Autowired
    DeskTopRepository deskTopRepository;

    @PostMapping("/desktop/add")
    public ResponseEntity<?> addProduct(@RequestBody DeskTop deskTop) {
        deskTopRepository.save(deskTop);
        return new ResponseEntity<>(deskTop, HttpStatus.OK);
    }

    @PatchMapping("/desktop/change/{id}")
    public ResponseEntity<?> changeProduct(@PathVariable Long id, @RequestBody DeskTop deskTop) {
        deskTopRepository.delete(deskTopRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        deskTopRepository.save(deskTop);
        return new ResponseEntity<>(deskTop, HttpStatus.OK);
    }

    @DeleteMapping("/desktop/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        deskTopRepository.delete(deskTopRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/desktop/see")
    public ResponseEntity<?> seeProduct() {
        return new ResponseEntity<>(deskTopRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/desktop/see/{id}")
    public ResponseEntity<?> seeOneProduct(@PathVariable Long id) {
        return new ResponseEntity<>(deskTopRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), HttpStatus.OK);
    }

}
