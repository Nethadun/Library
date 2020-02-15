package com.ijse.libSystem.repository.custom.impl;


import com.ijse.libSystem.entity.Member;
import com.ijse.libSystem.repository.custom.MemberRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Member> search(String searchText, Integer count, Integer page) {
        Query q=entityManager.createNativeQuery("select m.* from member  m where (m.mem_name like :searchText ) and m.is_enable=1", Member.class);
        q.setParameter("searchText","%"+ searchText + "%");
        q.setFirstResult(page * count);
        q.setMaxResults(count);
        return q.getResultList();
    }
}

//how to add this in that query
//m ORDER by m.mem_id DESC LIMIT 2
