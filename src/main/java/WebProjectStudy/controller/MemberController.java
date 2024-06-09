package WebProjectStudy.controller;

import WebProjectStudy.dto.MemberDTO;
import WebProjectStudy.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signUp")
    public boolean signUp(@Valid @RequestBody MemberDTO member) {
        return memberService.registerUser(member);
    }

}
