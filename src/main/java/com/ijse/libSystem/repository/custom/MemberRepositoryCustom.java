package com.ijse.libSystem.repository.custom;

import com.ijse.libSystem.entity.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> search(String searchText, Integer count, Integer page);
}
