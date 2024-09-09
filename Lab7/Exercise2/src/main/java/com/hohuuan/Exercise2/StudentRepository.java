package com.hohuuan.Exercise2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//2 interface in same relationship: extends

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
