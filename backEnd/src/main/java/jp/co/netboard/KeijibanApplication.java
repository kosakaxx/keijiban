package jp.co.netboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KeijibanApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeijibanApplication.class, args);
    }
}
