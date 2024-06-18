package WebProjectStudy;

import WebProjectStudy.repository.MemberRepository;
import WebProjectStudy.service.MemberService;
import WebProjectStudy.uilityClass.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class SpringConfig implements WebMvcConfigurer {

    private final MemberRepository memberRepository;

    @Bean
    public Utility utility(){
        return new Utility(memberRepository);
    }

    @Override
    public void addCorsMappings(final CorsRegistry registry) {
    }
}
