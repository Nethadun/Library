package com.ijse.libSystem.rest;


import com.ijse.libSystem.dto.MemberDto;
import com.ijse.libSystem.dto.response.ResponseDto;
import com.ijse.libSystem.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/ijse/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping
    public ResponseDto addMember(@RequestBody MemberDto memberDto){
        Long id=null;
        String message=null;
        int status =0;

        try {
            id= memberService.add(memberDto);
            message="Member Created";
            status=200;

        }catch (NullPointerException e){
            message="Member Not Created";
            status=400;
            e.printStackTrace();
        }
        return new ResponseDto(id,status,message);
    }

    @PutMapping
    public ResponseDto updateMember(@RequestBody MemberDto memberDto){
        Long id=null;
        String message=null;
        int status =0;

        try {
            id= memberService.add(memberDto);
            message="Member Updated";
            status=200;

        }catch (NullPointerException e){
            message="Member Not Updated";
            status=400;
            e.printStackTrace();
        }
        return new ResponseDto(id,status,message);
    }


    @GetMapping("/{mid}")
    public MemberDto getId(@PathVariable("mid")Long id){
        return memberService.get(id);
    }

    @GetMapping
    public List<MemberDto> searchMember(
            @RequestParam(value = "text",required = true) String text,
            @RequestParam(value = "count",required = true) Integer count,
            @RequestParam(value = "page",required = true) Integer page){
        return memberService.searchLike(text,count,page);
    }

    @DeleteMapping("/{mid}")
    public Long deleteMember(@PathVariable("mid")Long id){
        return memberService.delete(id);
    }
}
