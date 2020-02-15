package com.ijse.libSystem.dto;

import java.util.List;

public class BookDetailsDto {
    private Long id;
    List<Long> bookList;
    MemberDetailsDto memberDetailsDto;
    private Integer qty;
    private Integer isEnable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getBookList() {
        return bookList;
    }

    public void setBookList(List<Long> bookList) {
        this.bookList = bookList;
    }

    public MemberDetailsDto getMemberDetailsDto() {
        return memberDetailsDto;
    }

    public void setMemberDetailsDto(MemberDetailsDto memberDetailsDto) {
        this.memberDetailsDto = memberDetailsDto;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }
}
