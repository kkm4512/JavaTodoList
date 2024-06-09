package WebProjectStudy;

import WebProjectStudy.uilityClass.Utility;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public Utility utility(){
        return new Utility();
    }
}
