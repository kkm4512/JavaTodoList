package WebProjectStudy.uilityClass;

import WebProjectStudy.dto.MemberDTO;
import WebProjectStudy.dto.MemberLoginDTO;
import WebProjectStudy.entity.MemberEntity;
import WebProjectStudy.exception.HandleCheckIdMember;
import WebProjectStudy.exception.HandleMemberDuplicateException;
import WebProjectStudy.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class Utility {

    private final MemberRepository memberRepository;
    /***
     * DTO -> Entity
     */
    public MemberEntity dtoToEntity(MemberDTO memberDTO){
        return new MemberEntity(memberDTO.getName(),memberDTO.getPassword(),memberDTO.getNickname());
    }

    /***
     * Entity -> DTO
     */
    public MemberDTO entityToDto(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName(memberEntity.getName());
        memberDTO.setNickname(memberEntity.getNickname());
        memberDTO.setPassword(memberEntity.getPassword());
        return memberDTO;
    }

    /***
     * LoginDTO
     * DTO -> Entity
     */
    public MemberEntity dtoToEntityLogin(MemberLoginDTO memberDTO){
        return new MemberEntity(memberDTO.getName(),memberDTO.getPassword());
    }

    /***
     * LoginDTO
     * Entity -> DTO
     */
    public MemberLoginDTO entityToDtoLogin(MemberEntity memberEntity){
        MemberLoginDTO memberDTO = new MemberLoginDTO();
        memberDTO.setName(memberEntity.getName());
        memberDTO.setPassword(memberEntity.getPassword());
        return memberDTO;
    }

    /***
     * Member 중복 체크
     */
    public void duplicateMemberCheck(MemberDTO member){
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new HandleMemberDuplicateException("중복된 회원입니다");
        });
    }

    /***
     * Member 존재하는 회원인지 ID로 체크
     */
    public void checkIdMemberExistsOrThrow(MemberEntity member){
        memberRepository.findById(member.getId()).ifPresent(m -> { throw new HandleCheckIdMember("존재하지 않는 회원입니다."); });
    }

    /***
     * LoginDTO
     * Member 중복 체크
     */
    public void duplicateMemberCheckLogin(MemberLoginDTO member){
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new HandleMemberDuplicateException("중복된 회원입니다");
        });
    }
}
