package co.kr.wokreshop.backpac.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By bohyun on 2021/11/15
 */
@Tag(name = "주문페이지")
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
}
