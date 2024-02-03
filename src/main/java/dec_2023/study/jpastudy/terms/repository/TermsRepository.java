package dec_2023.study.jpastudy.terms.repository;

import dec_2023.study.jpastudy.terms.entity.Terms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermsRepository extends JpaRepository<Terms, Long> {
}
