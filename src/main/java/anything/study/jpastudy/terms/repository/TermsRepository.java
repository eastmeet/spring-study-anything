package anything.study.jpastudy.terms.repository;

import anything.study.jpastudy.terms.entity.Terms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermsRepository extends JpaRepository<Terms, Long> {
}
