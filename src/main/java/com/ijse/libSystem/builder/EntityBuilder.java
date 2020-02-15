package com.ijse.libSystem.builder;

import com.ijse.libSystem.dto.BookDto;
import com.ijse.libSystem.dto.MemberDto;
import com.ijse.libSystem.entity.Book;
import com.ijse.libSystem.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class EntityBuilder {
    public Book buildBookEntity(Book book, BookDto bookDto){
        if(bookDto == null){
            return null;
        }

        book.setBid(bookDto.getBid());
        book.setBookTitle(bookDto.getBookTitle());
        book.setPrice(bookDto.getPrice());
        book.setQty(bookDto.getQty());
        book.setIsEnable(1);

        return book;
    }

    public Member buildMemberEntity(Member member, MemberDto memberDto){
        if(memberDto == null){
            return null;
        }

        member.setMemId(memberDto.getMemId());
        member.setMemDate(memberDto.getMemDate());
        member.setMemType(memberDto.getMemType());
        member.setMemName(memberDto.getMemName());
        member.setAddress(memberDto.getAddress());
        member.setTel(memberDto.getTel());
        member.setIsEnable(1);

        return member;
    }


//    public Borrowed buildBorrowedEntity(Borrowed borrowed, BorrowedDto borrowedDto){
//        if (borrowedDto==null){
//            return null;
//        }
//
//        borrowed.setId(borrowedDto.getId());
//        borrowed.setBookList();
//    }
}
