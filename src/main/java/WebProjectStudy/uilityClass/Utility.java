package WebProjectStudy.uilityClass;

import WebProjectStudy.dto.Board.BoardDTO;
import WebProjectStudy.dto.Member.MemberDTO;
import WebProjectStudy.dto.Member.MemberLoginDTO;
import WebProjectStudy.entity.BoardEntity;
import WebProjectStudy.entity.MemberEntity;
import WebProjectStudy.exception.HandleMemberDuplicateException;
import WebProjectStudy.repository.Member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class Utility {

    private final MemberRepository memberRepository;
    /***
     * Member
     * DTO -> Entity
     */
    public MemberEntity dtoToEntity(MemberDTO memberDTO){
        return new MemberEntity(memberDTO.getName(),memberDTO.getPassword(),memberDTO.getNickname());
    }

    /***
     * Member
     * Entity -> DTO
     */
    public MemberDTO entityToDto(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName(memberEntity.getName());
        memberDTO.setNickname(memberEntity.getNickname());
        memberDTO.setName(memberEntity.getPassword());
        return memberDTO;
    }

    /***
     * Member
     * LoginDTO
     * DTO -> Entity
     */
    public MemberEntity dtoToEntityLogin(MemberLoginDTO memberDTO){
        return new MemberEntity(memberDTO.getName(),memberDTO.getPassword());
    }

    /***
     * Member
     * LoginDTO
     * Entity -> DTO
     */
    public MemberLoginDTO entityToDtoLogin(MemberEntity memberEntity){
        MemberLoginDTO memberDTO = new MemberLoginDTO();
        memberDTO.setName(memberEntity.getName());
        memberDTO.setName(memberEntity.getPassword());
        return memberDTO;
    }

    /***
     * Member
     * Member 중복 체크
     */
    public void duplicateMemberCheck(MemberDTO member){
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new HandleMemberDuplicateException("중복된 회원입니다");
        });
    }

    /***
     * Member
     * LoginDTO
     * Member 중복 체크
     */
    public void duplicateMemberCheckLogin(MemberLoginDTO member){
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new HandleMemberDuplicateException("중복된 회원입니다");
        });
    }

    /***
     * Board
     * BoardDTO -> BoardEntity
     */

    public BoardEntity boardDtoToEntity(BoardDTO board){
        return new BoardEntity(board);
    }

    /***
     * Board
     * BoardEntity -> BoardDTO
     */

    public void boardEntityToDto(){

    }

}
