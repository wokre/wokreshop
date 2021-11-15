package co.kr.wokreshop.backpac.controller;

import co.kr.wokreshop.backpac.dto.MemberDTO;
import co.kr.wokreshop.backpac.entity.Member;
import co.kr.wokreshop.backpac.exception.BackPacException;
import co.kr.wokreshop.backpac.params.MemberParam;
import co.kr.wokreshop.backpac.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created By bohyun on 2021/11/13
 */
@Tag(name = "회원 페이지")
@RestController
@RequestMapping(value = "member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping(value = "/join", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "회원가입", description = "회원 가입을 위한 정보 입력")
    public ResponseEntity join(@RequestBody @Valid MemberDTO memberDTO) {
        try {
            Member member = memberService.join(memberDTO);
            return new ResponseEntity(member, HttpStatus.OK);
        }
        catch (BackPacException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/login")
    @Operation(summary = "로그인")
    public ResponseEntity login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return ResponseEntity.ok("로그인 성공");
    }

    @PostMapping(value = "/logout")
    @Operation(summary = "로그아웃")
    public ResponseEntity logout() {
        return ResponseEntity.ok("로그아웃 했습니다.");
    }

    @GetMapping("/detail/{memberId}")
    @Operation(summary = "단일 회원 상세 조회", description = "단일 회원 정보 표시")
    public ResponseEntity memberDetail(@PathVariable("memberId") String memberId) {
        try {
            Member member = memberService.getMember(memberId);
            return ResponseEntity.ok(member);
        }
        catch (IllegalArgumentException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    @Operation(summary = "회원 조회", description = "전체 회원 조회 및 마지막 주문 정보 표시")
    public ResponseEntity memberList(@RequestParam(value = "limit", defaultValue = "25") int limit,
                                     @RequestParam(value = "page", defaultValue = "0") int page,
                                     @RequestParam(value = "name", required = false) String name,
                                     @RequestParam(value = "email", required = false) String email) {
        MemberParam params = new MemberParam();
        params.setName(name);
        params.setEmail(email);
        Pageable pageable = PageRequest.of(page, limit);
        Page<Member> memberPage = memberService.getList(params, pageable);
        return ResponseEntity.ok(memberPage);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
