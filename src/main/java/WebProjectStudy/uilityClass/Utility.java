package WebProjectStudy.uilityClass;

import WebProjectStudy.dto.MemberDTO;
import WebProjectStudy.entity.MemberEntity;
import WebProjectStudy.exception.IsNotFoundException;
import WebProjectStudy.exception.MemberDuplicateException;
import WebProjectStudy.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class Utility {

    private final MemberRepository memberRepository;
    /***
     * DTO -> Entity
     */
    public MemberEntity dtoToEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setName(memberDTO.getName());
        memberEntity.setNickname(memberDTO.getNickname());
        memberEntity.setPassword(memberDTO.getPassword());
        return memberEntity;
    }

    /***
     * Entity -> DTO
     */
    public MemberDTO entityToDto(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setName(memberEntity.getName());
        memberDTO.setNickname(memberEntity.getNickname());
        memberDTO.setPassword(memberEntity.getPassword());
        return memberDTO;
    }

    /***
     * Member 중복 체크
     */
    public void duplicateMemberCheck(Long id){
        memberRepository.findById(id).ifPresent(member -> {
            throw new MemberDuplicateException("중복된 회원입니다");
        });
    }
}
