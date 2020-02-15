package com.ijse.libSystem.builder;

import com.ijse.libSystem.dto.BookDto;
import com.ijse.libSystem.dto.MemberDetailsDto;
import com.ijse.libSystem.dto.MemberDto;
import com.ijse.libSystem.entity.Book;
import com.ijse.libSystem.entity.Member;
import com.ijse.libSystem.entity.MemberDetails;
import org.springframework.stereotype.Component;

@Component
public class DtoBuilder {
    public BookDto buildBookDto(Book book){
        if(book == null){
            return null;
        }

        BookDto bookDto =new BookDto();
        bookDto.setBid(book.getBid());
        bookDto.setBookTitle(book.getBookTitle());
        bookDto.setPrice(book.getPrice());
        bookDto.setQty(book.getQty());
        bookDto.setIsEnable(book.getIsEnable());

        return bookDto;
    }

    public MemberDto buildMemberDto(Member member){
        if(member == null){
            return null;
        }

        MemberDto memberDto=new MemberDto();
        memberDto.setMemId(member.getMemId());
        memberDto.setMemDate(member.getMemDate());
        memberDto.setMemType(member.getMemType());
        memberDto.setMemName(member.getMemName());
        memberDto.setAddress(member.getAddress());
        memberDto.setTel(member.getTel());
        memberDto.setIsEnable(member.getIsEnable());

        return memberDto;
    }

//    public BorrowedDto buildBorrowedDto(Borrowed borrowed){
//        if(borrowed ==null){
//            return null;
//        }
//        BorrowedDto borrowedDto=new BorrowedDto();
//        borrowedDto.setId(borrowed.getId());
////        borrowedDto.setBookList(borrowed.getBookList(0));
//        borrowedDto.setMemberDto(buildMemberDto(borrowed.getMember()));
//        borrowedDto.setMemberId(borrowedDto.getMemberDto().getId());
//        return borrowedDto;
//
//    }

//
//    public OrderDTO buildOrderDTO(Orders orders){
//        if(orders==null){
//            return null;
//        }
//        OrderDTO orderDTO=new OrderDTO();
//        orderDTO.setId(orders.getId());
//        orderDTO.setDate(orders.getDate());
//        orderDTO.setCustomerDTO(buildCustomerDto(orders.getCustomer()));
//        orderDTO.setCustomerId(orderDTO.getCustomerDTO().getCid());
//        orderDTO.setIsEnable(orders.getIsEnable());
//
//        return orderDTO;
//    }

    public MemberDetailsDto buildMemberDetailsDto(MemberDetails memberDetails){
        if(memberDetails ==null){
            return null;
        }

        MemberDetailsDto memberDetailsDto=new MemberDetailsDto();
        memberDetailsDto.setId(memberDetails.getId());
        memberDetailsDto.setDate(memberDetails.getDate());
        memberDetailsDto.setMemberDto(buildMemberDto(memberDetails.getMember()));
        memberDetailsDto.setMemberId(memberDetailsDto.getMemberDto().getMemId());
        memberDetailsDto.setIsEnable(memberDetails.getIsEnable());

        return memberDetailsDto;
    }
}
