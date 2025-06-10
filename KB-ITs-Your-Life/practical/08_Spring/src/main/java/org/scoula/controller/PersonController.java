package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.dto.Person;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/person")
@Log4j2
public class PersonController {

    // 입력 화면 띄우기
    @GetMapping("")
    public String create() {
        //

        return "person";
    }

    // 이렇게 하는 경우는 없음. 제일 구린 방법
//    @PostMapping("/create1")
//    public void getPerson(@RequestParam String name,
//                          @RequestParam int age,
//                          @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday, // dto에는 datetimeformat 필요x
//                          @RequestParam List<String> hobby) {
//        log.info("=================> getPerson() : " + name + " " + age + " " + birthday + hobby);
////        return "index";
//    }

    // 이 때는 dto에 @DateTimeFormat 필요함
    @PostMapping("/create1")
    public String getPerson(Person person) { // @ModelAttribute가 되어 있어서 model을 심은 것처럼 화면에 person의 필드를 보낼 수 있다.
        log.info("=================> getPerson() : " + person);
        return "result";
    }

    // http://localhost:8080/person/page?num=5 이걸 처리하는 메소드!
    @GetMapping("/page")
    public void getNum(@RequestParam int num) {
        log.info("================> getNum() : " + num);
    }

    @GetMapping("/model")
    public String sendData(Model model) {
        model.addAttribute("num", 1); // attributeName은 출력할 때 쓰고, attributeValue는 실제 화면에 출력된다(?)
        model.addAttribute("hello", "안녕하세요");
        model.addAttribute("yn", true);
        model.addAttribute("person", Person.builder()
                                                    .name("임미영")
                                                    .age(30)
                                                    .birthday(new Date())
                                                    .hobby(Arrays.asList("게임", "드라마 시청"))
                                                    .build());
        // return "result";
        return "redirect:/person/page";
    }

    // JSON 으로 응답하기
    // http://localhost:8080/person/list1
    @GetMapping("/list1")
    public @ResponseBody List<Person> getPersons1() {
        List<Person> list = new ArrayList<>();

        list.add(Person.builder()
                .name("홍길동")
                .age(25)
                .birthday(new Date())
                .hobby(Arrays.asList("독서", "운동"))
                .build());

        list.add(Person.builder()
                .name("김삿갓")
                .age(23)
                .birthday(new Date())
                .hobby(Arrays.asList("음악", "여행"))
                .build());

        return list;
    }

    // JSON 으로 응답하기
    // http://localhost:8080/person/list2
    @GetMapping("/list2")
    public ResponseEntity<List<Person>> getPersons() {

        List<Person> list = new ArrayList<>();

        list.add(Person.builder()
                .name("홍길동")
                .age(25)
                .birthday(new Date())
                .hobby(Arrays.asList("독서", "운동", "잠자기"))
                .build());

        list.add(Person.builder()
                .name("김삿갓")
                .age(23)
                .birthday(new Date())
                .hobby(Arrays.asList("음악", "여행"))
                .build());

        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "application/json;charset=UTF-8");

        return new ResponseEntity<>(list, header, HttpStatus.OK);
    }
}
