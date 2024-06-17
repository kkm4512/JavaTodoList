package WebProjectStudy;

import WebProjectStudy.repository.MemberRepository;
import WebProjectStudy.service.MemberService;
import WebProjectStudy.uilityClass.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Bean
    public Utility utility(){
        return new Utility(memberRepository);
    }
}
