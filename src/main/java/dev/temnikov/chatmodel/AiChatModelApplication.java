package dev.temnikov.chatmodel;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AiChatModelApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext run = new SpringApplicationBuilder(AiChatModelApplication.class)
				.web(WebApplicationType.SERVLET)
				.run(args);
	}

}
