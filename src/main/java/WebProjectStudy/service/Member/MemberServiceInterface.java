package WebProjectStudy.service.Member;

import WebProjectStudy.dto.Member.MemberDTO;
import WebProjectStudy.dto.Member.MemberLoginDTO;
import WebProjectStudy.entity.MemberEntity;


import java.util.List;
import java.util.Optional;

public interface MemberServiceInterface {
    public boolean registerMember(MemberDTO member);
    public boolean loginMember(MemberLoginDTO member);
    public List<MemberEntity> getAllMember();
    public Optional<MemberEntity> getMemberById(Long id);
    public boolean deleteMember(Long id);
    public boolean updateMember(MemberDTO member);

}
