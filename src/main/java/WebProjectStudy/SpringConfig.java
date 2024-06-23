package WebProjectStudy;

import WebProjectStudy.repository.Member.MemberRepository;
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
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000") // 클라이언트의 도메인 주소
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
