package co.kr.wokreshop.backpac.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By bohyun on 2021/11/13
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity home() {
        return ResponseEntity.ok("connection is ok");
    }
}
