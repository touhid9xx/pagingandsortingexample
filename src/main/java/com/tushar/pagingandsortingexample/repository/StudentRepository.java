package com.tushar.pagingandsortingexample.repository;

import com.tushar.pagingandsortingexample.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student,Long> {
}
