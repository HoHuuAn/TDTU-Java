package com.hohuuan.Exercise3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//2 interface in same relationship: extends

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
