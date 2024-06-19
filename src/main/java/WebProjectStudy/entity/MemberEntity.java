package WebProjectStudy.entity;

import WebProjectStudy.exception.HandleInvalidFormatException;
import WebProjectStudy.exception.HandleInvalidLengthException;
import WebProjectStudy.exception.HandleIsNotFoundException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="MemberInfo")
@Getter
@Setter
public class MemberEntity extends BaseMemberEntity{

    @Column
    private String nickname;


    public MemberEntity() {}


    public MemberEntity(String name, String password) {
        super(name, password); // BaseMemberEntity의 생성자 호출
    }

    public MemberEntity(String name, String password, String nickname) {
        super(name, password); // BaseMemberEntity의 생성자 호출
        this.nickname = nickname;
        System.out.println(nickname);
        validate();
    }


    @Override
    protected void validate(){
        super.validate();
        //공백 확인
        if (nickname == null || nickname.isEmpty()){
            throw new HandleIsNotFoundException("[Entity] 닉네임은 공백일 수 없습니다");
        }

        //올바른 형식 확인
        if(!nickname.matches("^[가-힣]+$")){
            throw new HandleInvalidFormatException("[Entity] 닉네임은 한국어만 입력 가능합니다");
        }

        //올바른 글자수로 들어왔는지 체크
        if (nickname.length()<5 || nickname.length() > 10){
            throw new HandleInvalidLengthException("[Entity] 닉네임은 최소 5글자, 최대 10글자 입니다");
        }
    }


    @Override
    public String toString() {
        return "MemberEntity{" +
                "nickname='" + nickname + '\'' +
                '}';
    }
}
