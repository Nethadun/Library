package com.ijse.libSystem.repository;

import com.ijse.libSystem.entity.MemberDetails;
import com.ijse.libSystem.repository.custom.MemberDetailsRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDetailsRepository extends JpaRepository<MemberDetails ,Long>, MemberDetailsRepositoryCustom {
}
