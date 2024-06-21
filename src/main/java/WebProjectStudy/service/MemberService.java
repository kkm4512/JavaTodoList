package WebProjectStudy.service;

import WebProjectStudy.dto.MemberDTO;
import WebProjectStudy.dto.MemberLoginDTO;
import WebProjectStudy.entity.MemberEntity;
import WebProjectStudy.exception.HandleIsNotFoundException;
import WebProjectStudy.repository.MemberRepository;
import WebProjectStudy.uilityClass.Utility;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class MemberService implements MemberServiceInterface{


    private final MemberRepository memberRepository;
    private final Utility utility;

    //회원가입
    @Override
    public boolean registerMember(MemberDTO member) {
        utility.duplicateMemberCheck(member);
        MemberEntity memberEntity = utility.dtoToEntity(member);

        memberRepository.save(memberEntity);
        return true;
    }

    @Override
    public boolean loginMember(MemberLoginDTO member) {
        MemberEntity tempMemberEntity = utility.dtoToEntityLogin(member);
        MemberEntity memberEntity = memberRepository.findByName(member.getName()).orElseThrow(() -> new HandleIsNotFoundException("존재하지 않는 회원 입니다."));
        return true;
    }

    //모든회원조회
    @Override
    public List<MemberEntity> getAllMember() {
        return memberRepository.findAll();

    }

    //회원찾기
    @Override
    public Optional<MemberDTO> getMemberById(Long id) {
        Optional<MemberEntity> getMember = memberRepository.findById(id);
        if (getMember.isEmpty()) throw new HandleIsNotFoundException("회원을 찾을 수 없습니다");
        return getMember.map(utility::entityToDto);
    }

    //회원삭제
    @Override
    public boolean deleteMember(Long id) {
        Optional<MemberEntity> getMember = memberRepository.findById(id);
        getMember.orElseThrow(() -> new HandleIsNotFoundException("회원을 찾을 수 없습니다"));
        return true;
    }

    //멤버수정
    @Override
    public boolean updateMember(Long id, MemberDTO member) {
        MemberEntity getMember = memberRepository.findById(id).orElseThrow(() -> new HandleIsNotFoundException("회원을 찾을 수 없습니다"));
        getMember.setNickname(member.getNickname());
        getMember.setName(member.getName());
        getMember.setPassword(member.getPassword());
        return true;
    }
}
