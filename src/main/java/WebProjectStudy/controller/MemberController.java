package WebProjectStudy.controller;

import WebProjectStudy.dto.MemberDTO;
import WebProjectStudy.dto.MemberLoginDTO;
import WebProjectStudy.entity.MemberEntity;
import WebProjectStudy.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signUp")
    public boolean signUp(@Valid @RequestBody MemberDTO member) {
        return memberService.registerMember(member);
    }

    @PostMapping("/login")
    public boolean login(@Valid @RequestBody MemberLoginDTO member) {
        return memberService.loginMember(member);
    }

    @GetMapping("findAll")
    public List<MemberDTO> findAll(){
        return memberService.getAllMember();
    }

    @PostMapping("findOne")
    public Optional<MemberDTO> findOne(@RequestBody Long id){
        return memberService.getMemberById(id);
    }

    @DeleteMapping("removeMember")
    public boolean removeMember(@RequestBody Long id){
        return memberService.deleteMember(id);
    }

    @PutMapping("updateMember")
    public boolean updateMember(@RequestBody Long id, @Valid @RequestBody MemberDTO member){
        return memberService.updateMember(id,member);
    }

}
