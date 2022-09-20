package com.lab.cft_test_case_lab.Controllers;

import com.lab.cft_test_case_lab.Model.Entity.NoteBook;
import com.lab.cft_test_case_lab.Repository.NoteBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class NoteBookController {
    @Autowired
    NoteBookRepository noteBookRepository;

    @PostMapping("/noteBook/add")
    public ResponseEntity<?> addProduct(@RequestBody NoteBook noteBook) {
        noteBookRepository.save(noteBook);
        return new ResponseEntity<>(noteBook, HttpStatus.OK);
    }

    @PatchMapping("/noteBook/change/{id}")
    public ResponseEntity<?> changeProduct(@PathVariable Long id, @RequestBody NoteBook noteBook) {
        noteBookRepository.delete(noteBookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        noteBookRepository.save(noteBook);
        return new ResponseEntity<>(noteBook, HttpStatus.OK);
    }

    @DeleteMapping("/noteBook/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        noteBookRepository.delete(noteBookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/noteBook/see")
    public ResponseEntity<?> seeProduct() {
        return new ResponseEntity<>(noteBookRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/noteBook/see/{id}")
    public ResponseEntity<?> seeOneProduct(@PathVariable Long id) {
        return new ResponseEntity<>(noteBookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), HttpStatus.OK);
    }
}
