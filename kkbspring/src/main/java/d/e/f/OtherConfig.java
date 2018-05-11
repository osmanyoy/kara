package d.e.f;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtherConfig {

	@Bean
	public MyOtherBean myOtherBean() {
		return new MyOtherBean();
		
	}
}
