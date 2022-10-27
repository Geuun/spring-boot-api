package com.api.springbootapi.controller;

import com.api.springbootapi.domain.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
    /**
     * 5.3.1 @RequestMapping으로 구현
     */
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    /**
     * 5.3.2 @RequestBody와 Map을 활용한 POST 메서드
     * http://localhost:8080/api/v1/member
     */
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    /**
     * DTO 객체의 toString을 이용
     */
    @PostMapping("/member2")
    public String postMember(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }

    /**
     *
     */
    @PostMapping("/member3")
    public ResponseEntity<MemberDto> putmember(@RequestBody MemberDto memberDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }
}
