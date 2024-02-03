package dec_2023.study.jpastudy.config;

import com.querydsl.jpa.JPQLTemplates;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class QuerydslConfig {

    @PersistenceContext
    protected EntityManager em;

    @Bean
    protected JPAQueryFactory jpaQueryFactory(EntityManager em) {
        return new JPAQueryFactory(JPQLTemplates.DEFAULT, em);
    }
}
