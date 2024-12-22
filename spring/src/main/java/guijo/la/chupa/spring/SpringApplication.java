package guijo.la.chupa.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EntityScan("guijo.la.chupa.spring.model")
@EnableJpaRepositories("guijo.la.chupa.spring.repos")
@EnableTransactionManagement
public class SpringApplication {

    public static void main(final String[] args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
    }

}
