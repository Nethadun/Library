package com.ijse.libSystem.rest;

import com.ijse.libSystem.dto.BookDto;
import com.ijse.libSystem.dto.response.ResponseDto;
import com.ijse.libSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/ijse/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseDto addBook(@RequestBody BookDto bookDto){
        Long id=null;
        String message=null;
        int status =0;

        try {
            id= bookService.add(bookDto);
            message="Book Created";
            status=200;

        }catch (NullPointerException e){
            message="Book Not Created";
            status=400;
            e.printStackTrace();
        }
        return new ResponseDto(id,status,message);
    }

    @PutMapping
    public ResponseDto updateBook(@RequestBody BookDto bookDto){
        Long id=null;
        String message=null;
        int status =0;

        try {
            id= bookService.add(bookDto);
            message="Book Updated";
            status=200;

        }catch (NullPointerException e){
            message="Book Not Updated";
            status=400;
            e.printStackTrace();
        }
        return new ResponseDto(id,status,message);
    }

    @GetMapping("/{bid}")
    public BookDto getId(@PathVariable("bid")Long id){
        return bookService.get(id);
    }
    @GetMapping

    public List<BookDto> searchBook(
            @RequestParam(value = "text",required = true) String text,
            @RequestParam(value = "count",required = true) Integer count,
            @RequestParam(value = "page",required = true) Integer page){
        return bookService.searchLike(text,count,page);
    }
    @DeleteMapping("/{bid}")
    public Long deleteBook(@PathVariable("bid")Long id){
        return bookService.delete(id);
    }
}
