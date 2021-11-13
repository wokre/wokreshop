package co.kr.wokreshop.backpac.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By bohyun on 2021/11/13
 */
@RestController
@RequestMapping(value = "member")
public class MemberController {

    @GetMapping("/detail")
    public ResponseEntity memberDetail() {
        return new ResponseEntity(HttpStatus.OK);
    }
}
