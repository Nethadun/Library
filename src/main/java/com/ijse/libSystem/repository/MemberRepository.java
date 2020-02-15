package com.ijse.libSystem.repository;


import com.ijse.libSystem.entity.Member;
import com.ijse.libSystem.repository.custom.MemberRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long>, MemberRepositoryCustom {
}
