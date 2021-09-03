package com.example.GaiNumbers.repo;

import com.example.GaiNumbers.entity.Numbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NumberRepository extends JpaRepository<Numbers, Long> {

    @Query("select n.numberValue from Numbers n")
    List<String> findAllByNumbers();

    @Query("select n.numberId from Numbers n")
    List<Integer> findAllByNumberId();

    @Query("select max(n.numberId) from Numbers n")
    Integer findByLastId();

    @Query("select n.numberValue from Numbers n where n.numberId = (select max(n1.numberId) from Numbers n1)")
    String findLast();

    @Transactional
    @Modifying
    @Query(value = "insert into Numbers (number_id, number_values) VALUES (:id, :number_value)",
            nativeQuery = true)
    void insertNumbersValue(@Param("id") Integer id, @Param("number_value")String numberValue);
}
