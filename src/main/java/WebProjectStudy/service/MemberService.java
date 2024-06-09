package WebProjectStudy.service;

import WebProjectStudy.dto.MemberDTO;
import WebProjectStudy.entity.MemberEntity;
import WebProjectStudy.repository.MemberRepository;
import WebProjectStudy.uilityClass.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberServiceInterface{

    private final MemberRepository memberRepository;
    private final Utility utility;

    @Override
    public boolean registerUser(MemberDTO member) {
        MemberEntity memberEntity = utility.dtoToEntity(member);
        MemberEntity savedEntity = memberRepository.save(memberEntity);
        return true;
    }
}
