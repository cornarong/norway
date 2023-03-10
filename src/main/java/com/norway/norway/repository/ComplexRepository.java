package com.norway.norway.repository;

import com.norway.norway.model.Complex;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComplexRepository extends JpaRepository<Complex, Long> {

    /** 회원 전체조회 **/
    List<Complex> findAll();

    /** 회원 단건조회 **/
    Optional<Complex> findById(Long complexId);
}
