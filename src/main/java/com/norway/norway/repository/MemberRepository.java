package com.norway.norway.repository;

import com.norway.norway.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    /** 회원 전체조회 **/
    List<Member> findAll();

    /** 회원 단건조회 **/
    Optional<Member> findById(Long memberId);

}
