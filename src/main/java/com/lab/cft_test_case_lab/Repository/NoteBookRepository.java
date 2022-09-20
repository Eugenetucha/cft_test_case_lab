package com.lab.cft_test_case_lab.Repository;


import com.lab.cft_test_case_lab.Model.Entity.NoteBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteBookRepository extends JpaRepository<NoteBook,Long> {
}
