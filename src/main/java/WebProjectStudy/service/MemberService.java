package WebProjectStudy.service;

import WebProjectStudy.dto.MemberDTO;
import WebProjectStudy.dto.MemberLoginDTO;
import WebProjectStudy.entity.MemberEntity;
import WebProjectStudy.exception.HandleIsNotFoundException;
import WebProjectStudy.repository.MemberRepository;
import WebProjectStudy.uilityClass.Utility;
import com.sun.jdi.request.DuplicateRequestException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        MemberEntity memberEntity = memberRepository.findByBaseMemberEntityName(member.getName()).orElseThrow(() -> new HandleIsNotFoundException("존재하지 않는 회원 입니다."));
        return true;
    }

    //모든회원조회
    @Override
    public List<MemberDTO> getAllMember() {
        List<MemberEntity> memberEntities = memberRepository.findAll();
        if (memberEntities.isEmpty()) return List.of();
        return memberEntities.stream()
                .map(utility::entityToDto)
                .collect(Collectors.toList());
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
        getMember.setNickname(member.getNickname());
        getMember.getBaseMemberEntity().setPassword(member.getPassword());

        return true;
    }
}
