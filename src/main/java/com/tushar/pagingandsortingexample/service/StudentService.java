package com.tushar.pagingandsortingexample.service;

import com.tushar.pagingandsortingexample.model.Student;
import com.tushar.pagingandsortingexample.model.StudentPage;
import com.tushar.pagingandsortingexample.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Page<Student> getStudents(StudentPage studentPage) {

        Sort sort = Sort.by(studentPage.getSortDirection(),studentPage.getSortBy());
        Pageable pageable = PageRequest.of(
                studentPage.getPageNumber(),
                studentPage.getPageSize(),
                sort
                );

        return studentRepository.findAll(pageable);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
}
