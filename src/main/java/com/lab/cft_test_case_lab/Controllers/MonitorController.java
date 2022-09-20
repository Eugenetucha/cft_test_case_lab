package com.lab.cft_test_case_lab.Controllers;


import com.lab.cft_test_case_lab.Model.Entity.Monitor;
import com.lab.cft_test_case_lab.Repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class MonitorController {
    @Autowired
    MonitorRepository monitorRepository;

    @PostMapping("/monitor/add")
    public ResponseEntity<?> addProduct(@RequestBody Monitor monitor) {
        monitorRepository.save(monitor);
        return new ResponseEntity<>(monitor, HttpStatus.OK);
    }

    @PatchMapping("/monitor/change/{id}")
    public ResponseEntity<?> changeProduct(@PathVariable Long id, @RequestBody Monitor monitor) {
        monitorRepository.delete(monitorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        monitorRepository.save(monitor);
        return new ResponseEntity<>(monitor, HttpStatus.OK);
    }

    @DeleteMapping("/monitor/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        monitorRepository.delete(monitorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/monitor/see")
    public ResponseEntity<?> seeProduct() {
        return new ResponseEntity<>(monitorRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/monitor/see/{id}")
    public ResponseEntity<?> seeOneProduct(@PathVariable Long id) {
        return new ResponseEntity<>(monitorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), HttpStatus.OK);
    }
}
