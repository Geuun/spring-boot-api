package com.api.springbootapi.controller;

import com.api.springbootapi.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/get-api")
public class GetController {
    /**
     * 5.2.2 매개변수가 없는 GET 메서드 구현
     * (GET) http://localhost:8080/api/v1/get-api/name
     */
    @GetMapping(value = "/name")
    public String getName() {
        return "Geun";
    }

    /**
     * 5.2.3 @PathVariable 을 활용한 GET메서드 구현
     * http://localhost:8080/api/v1/get-api/variable1/{variable}
     */
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    /**
     * ex5.5 @PathVariable에 변수명을 매핑하는 법
     * -> @PathVariable에는 변수의 이름을 특정할 수이쓴ㄴ value 요소가 존재
     */
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable(@PathVariable("variable") String var) {
        return var;
    }

    /**
     * 5.2.4 @RequestParam을 활용한 GET 메서드 구현
     *  -> 요청의 ? 이후는 쿼리스트링 시작지점 &으로 이을 수 있음
     *  http://localhost:8080/api/v1/get-api/request1?name=geun&email=email@email.com&organization=student
     */
    @GetMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String name,
                                   @RequestParam String email,
                                   @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    /**
     * ex5.7 Map객체 활용
     *  -> 웹의 특성상 어떤 값이 들어올지 특정하기 힘듬
     *  http://localhost:8080/api/v1/get-api/request2?name=geun&email=email@email.com&organization=student
     */
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    /**
     * 5.2.5 DTO 객체를 활용한 GET메서드 구현
     * http://localhost:8080/api/v1/get-api/request3?name=geun&email=email@email.com&organization=student
     */
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto) {
//        return memberDto.getName() + " " + memberDto.getEmail() + " " + memberDto.getOrganization();
        return memberDto.toString();
    }
}
