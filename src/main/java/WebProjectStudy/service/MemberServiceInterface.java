package WebProjectStudy.service;

import WebProjectStudy.dto.MemberDTO;
import WebProjectStudy.dto.MemberLoginDTO;

import java.util.List;
import java.util.Optional;

public interface MemberServiceInterface {
    public boolean registerMember(MemberDTO member);
    public boolean loginMember(MemberLoginDTO member);
    public List<MemberDTO> getAllMember();
    public Optional<MemberDTO> getMemberById(Long id);
    public boolean deleteMember(Long id);
    public boolean updateMember(Long id,MemberDTO member);

}
