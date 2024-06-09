package WebProjectStudy.service;

import WebProjectStudy.dto.MemberDTO;
import WebProjectStudy.entity.MemberEntity;

public interface MemberServiceInterface {
    public boolean registerUser(MemberDTO member);
}
