package com.ijse.libSystem.rest;

import com.ijse.libSystem.dto.BookDetailsDto;
import com.ijse.libSystem.dto.response.ResponseDto;
import com.ijse.libSystem.service.BookDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/libsys/bookDetails")
public class BookDetailsController {
    @Autowired
    BookDetailsService bookDetailsService;
    @PostMapping
    public ResponseDto addBook(@RequestBody BookDetailsDto bookDetailsDto){
        Long id=null;
        String message=null;
        int status =0;

        try {
            id= bookDetailsService.add(bookDetailsDto);
            message="Borrowed Created";
            status=200;

        }catch (NullPointerException e){
            message="Borrowed Not Created";
            status=400;
            e.printStackTrace();
        }
        return new ResponseDto(id,status,message);
    }

    @PutMapping
    public ResponseDto updateBook(@RequestBody BookDetailsDto bookDetailsDto){
        Long id=null;
        String message=null;
        int status =0;

        try {
            id= bookDetailsService.update(bookDetailsDto);
            message="Borrowed Updated";
            status=200;

        }catch (NullPointerException e){
            message="Borrowed Not Updated";
            status=400;
            e.printStackTrace();
        }
        return new ResponseDto(id,status,message);
    }

}
