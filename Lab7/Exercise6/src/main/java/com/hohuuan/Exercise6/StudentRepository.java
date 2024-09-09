package com.hohuuan.Exercise6;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//2 interface in same relationship: extends

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>, PagingAndSortingRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE s.age >= :age")
    List<Student> AgeGreaterThanOrEqual(@Param("age") int age);

    @Query("SELECT COUNT(s) FROM Student s WHERE s.ieltsScore = :ieltsScore")
    int IeltsScore(@Param("ieltsScore") double ieltsScore);

    @Query("SELECT s FROM Student s WHERE LOWER(s.name) LIKE %:keyword%")
    List<Student> NameContain(@Param("keyword") String keyword);

    List<Student> findAllByOrderByAgeDescIeltsScoreAsc();

}
