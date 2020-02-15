package com.ijse.libSystem.service.impl;

import com.ijse.libSystem.builder.DtoBuilder;
import com.ijse.libSystem.builder.EntityBuilder;
import com.ijse.libSystem.dto.MemberDto;
import com.ijse.libSystem.entity.Member;
import com.ijse.libSystem.repository.MemberRepository;
import com.ijse.libSystem.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityBuilder entityBuilder;
    @Autowired
    DtoBuilder dtoBuilder;
    @Override
    public Long add(MemberDto memberDto) {
        Member saved=memberRepository.save(entityBuilder.buildMemberEntity(new Member(), memberDto));
        return null !=saved ? saved.getMemId() : null;
    }

    @Override
    public Long update(MemberDto memberDto) {
        Member saved=memberRepository.save(entityBuilder.buildMemberEntity(new Member(), memberDto));
        return null !=saved ? saved.getMemId() : null;
    }

    @Override
    public List<MemberDto> searchLike(String searchText, Integer count, Integer page) {
        List<MemberDto> list= new ArrayList<>();

        for (Member entity : memberRepository.search(searchText, count,page)){
            list.add(dtoBuilder.buildMemberDto(entity));
        }
        return list;
    }

    @Override
    public MemberDto get(Long id) {
        System.out.println("hhhhhhhhhhh"+id);
        return dtoBuilder.buildMemberDto(memberRepository.getOne(id));
    }

    @Override
    public Long delete(Long id) {
        Member member=memberRepository.getOne(id);
        member.setIsEnable(0);
        Member saved= memberRepository.save(member);

        return null !=saved.getMemId() ? saved.getMemId() :null;
    }
}
