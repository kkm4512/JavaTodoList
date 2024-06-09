package WebProjectStudy.entity;

import WebProjectStudy.exception.InvalidFormatException;
import WebProjectStudy.exception.InvalidLengthException;
import WebProjectStudy.exception.IsNotFoundException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="MemberInfo")
@Getter
@Setter
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String nickname;

    public MemberEntity() {}

    public MemberEntity(String name, String password, String nickname) {
        this.name = name;
        this.password = password;
        this.nickname = nickname;
        validate();
    }

    private void validate(){
        //공백 확인
        if (name == null || name.isEmpty()){
            throw new IsNotFoundException("이름은 공백일 수 없습니다");
        }

        if (password == null || password.isEmpty()){
            throw new IsNotFoundException("비밀번호는 공백일 수 없습니다");
        }

        if (nickname == null || nickname.isEmpty()){
            throw new IsNotFoundException("닉네임은 공백일 수 없습니다");
        }

        //올바른 형식인지 체크
        if(!name.matches("^[a-zA-Z0-9]+$")){
            throw new InvalidFormatException("이름은 숫자와, 영문자로만 구성 가능합니다");
        }

        if(!password.matches("^[a-zA-Z0-9!@#$%^&*()_+=]+$")){
            throw new InvalidFormatException("비밀번호는 숫자와, 영문자,특수문자만 구성 가능합니다");
        }

        if(!nickname.matches("^[가-힣]+$")){
            throw new InvalidFormatException("닉네임은 한국어만 입력 가능합니다");
        }

        //올바른 글자수로 들어왔는지 체크
        if (name.length()<5 || name.length() > 10){
            throw new InvalidLengthException("이름은 최소 5글자, 최대 10글자 입니다");
        }

        if (password.length()<5 || password.length() > 20){
            throw new InvalidLengthException("비밀번호는 최소 5글자, 최대 10글자 입니다");
        }

        if (nickname.length()<5 || nickname.length() > 10){
            throw new InvalidLengthException("닉네임은 최소 5글자, 최대 10글자 입니다");
        }
    }
}
