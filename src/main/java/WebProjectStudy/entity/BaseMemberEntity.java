package WebProjectStudy.entity;

import WebProjectStudy.exception.HandleInvalidFormatException;
import WebProjectStudy.exception.HandleInvalidLengthException;
import WebProjectStudy.exception.HandleIsNotFoundException;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Embeddable
public class BaseMemberEntity {
    private String name;
    private String password;

    public BaseMemberEntity() {}

    public BaseMemberEntity(String name, String password) {
        this.name = name;
        this.password = password;
        validate();
    }

    protected void validate(){
        //공백 확인
        if (name == null || name.isEmpty()){
            throw new HandleIsNotFoundException("[Entity] 이름은 공백일 수 없습니다");
        }

        if (password == null || password.isEmpty()){
            throw new HandleIsNotFoundException("[Entity] 비밀번호는 공백일 수 없습니다");
        }


        //올바른 형식인지 체크
        if(!name.matches("^[a-zA-Z0-9]+$")){
            throw new HandleInvalidFormatException("[Entity] 이름은 숫자와, 영문자로만 구성 가능합니다");
        }

        if(!password.matches("^[a-zA-Z0-9!@#$%^&*()_+=]+$")){
            throw new HandleInvalidFormatException("[Entity] 비밀번호는 숫자와, 영문자,특수문자만 구성 가능합니다");
        }

        //올바른 글자수로 들어왔는지 체크
        if (name.length()<5 || name.length() > 10){
            throw new HandleInvalidLengthException("[Entity] 이름은 최소 5글자, 최대 10글자 입니다");
        }

        if (password.length()<5 || password.length() > 20){
            throw new HandleInvalidLengthException("[Entity] 비밀번호는 최소 5글자, 최대 20글자 입니다");
        }
    }
}