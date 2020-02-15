package com.ijse.libSystem.service.impl;

import com.ijse.libSystem.dto.BookDetailsDto;
import com.ijse.libSystem.entity.Book;
import com.ijse.libSystem.entity.BookDetails;
import com.ijse.libSystem.entity.MemberDetails;
import com.ijse.libSystem.repository.BookDetailsRepository;
import com.ijse.libSystem.repository.BookRepository;
import com.ijse.libSystem.repository.MemberDetailsRepository;
import com.ijse.libSystem.repository.MemberRepository;
import com.ijse.libSystem.service.BookDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class BookDetailsServiceImpl implements BookDetailsService {
    @Autowired
    BookDetailsRepository bookDetailsRepository;
    @Autowired
    MemberDetailsRepository memberDetailsRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    MemberRepository memberRepository;
    @Override
    public Long add(BookDetailsDto bookDetailsDto) {
        BookDetails bookDetailsSave =new BookDetails();
        List<Book>bookList=new ArrayList<>();

        MemberDetails memberDetails=new MemberDetails();
        try {
             memberDetails.setId(bookDetailsDto.getMemberDetailsDto().getId());
             memberDetails.setDate(bookDetailsDto.getMemberDetailsDto().getDate());
             memberDetails.setMember(memberRepository.getOne(bookDetailsDto.getMemberDetailsDto().getMemberId()));
             memberDetails.setIsEnable(1);
             MemberDetails memberDetailsSave= memberDetailsRepository.save(memberDetails);

            for (int i = 0; i < bookDetailsDto.getBookList().size(); i++) {
                Book book = bookRepository.getOne(bookDetailsDto.getBookList().get(i));
                bookList.add(book);
                book.setQty(book.getQty() - bookDetailsDto.getQty());
                bookRepository.save(book);
            }

            bookDetailsSave.setId(bookDetailsDto.getId());
            bookDetailsSave.setIsEnable(1);
            bookDetailsSave.setBooks(bookList);
            bookDetailsSave.setQty(bookDetailsDto.getQty());
            bookDetailsSave.setMemberDetails(memberDetailsSave);

            bookDetailsRepository.save(bookDetailsSave);
        }catch (Exception e){
            e.printStackTrace();
        }
        return bookDetailsSave.getId();
    }

    @Override
    public Long update(BookDetailsDto bookDetailsDto) {
        BookDetails bookDetailsSave =new BookDetails();
        List<Book>bookList=new ArrayList<>();

        MemberDetails memberDetails=new MemberDetails();
        try {
            memberDetails.setId(bookDetailsDto.getMemberDetailsDto().getId());
            memberDetails.setDate(bookDetailsDto.getMemberDetailsDto().getDate());
            memberDetails.setMember(memberRepository.getOne(bookDetailsDto.getMemberDetailsDto().getMemberId()));
            memberDetails.setIsEnable(1);
            MemberDetails memberDetailsSave= memberDetailsRepository.save(memberDetails);

            for (int i = 0; i < bookDetailsDto.getBookList().size(); i++) {
                Book book = bookRepository.getOne(bookDetailsDto.getBookList().get(i));
                bookList.add(book);
                book.setQty(book.getQty() + bookDetailsDto.getQty());
                bookRepository.save(book);
            }
            bookDetailsSave.setId(bookDetailsDto.getId());
            bookDetailsSave.setIsEnable(0);
            bookDetailsSave.setBooks(bookList);
            bookDetailsSave.setQty(bookDetailsDto.getQty());
            bookDetailsSave.setMemberDetails(memberDetailsSave);

            bookDetailsRepository.save(bookDetailsSave);
        }catch (Exception e){
            e.printStackTrace();
        }
        return bookDetailsSave.getId();
    }

    @Override
    public List<BookDetailsDto> searchLike(String searchText, Integer count, Integer page) {
        return null;
    }

    @Override
    public BookDetailsDto get(Long id) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }
}
