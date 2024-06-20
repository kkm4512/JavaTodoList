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
public class MemberEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "name")),
            @AttributeOverride(name = "password", column = @Column(name = "password"))
    })

    private BaseMemberEntity baseMemberEntity;

    @Column
    private String nickname;

    public MemberEntity() {
        this.baseMemberEntity = new BaseMemberEntity();
    }


    public MemberEntity(String name, String password) {
        this.baseMemberEntity = new BaseMemberEntity(name,password);
//        baseMemberEntity.validate();
    }

    public MemberEntity(String name, String password, String nickname) {
        this.baseMemberEntity = new BaseMemberEntity(name,password);
        this.nickname = nickname;
        validate();
    }

    protected void validate(){
        baseMemberEntity.validate();
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
                "id=" + id +
                ", baseMemberEntity=" + baseMemberEntity +
                ", nickname='" + nickname + '\'' +
                '}';
    }


}
