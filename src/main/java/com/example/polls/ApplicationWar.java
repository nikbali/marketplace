package com.example.polls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@ServletComponentScan
@SpringBootApplication
public class ApplicationWar extends SpringBootServletInitializer {

	/**
	 * Через main приложение не запустится
	 * ТЕПЕРЬ ДЛЯ ЗАПУСКА ИСПОЛЬЗУЕМ maven плагин spring-boot:run
	 * Добавить в Run -> Edit Configuration -> Add New Conf (Maven) -> в Command Line добавить spring-boot:run
	 * Если нужен WAR-архив запускаем clean + install
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApplicationWar.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApplicationWar.class, args);
	}
}
