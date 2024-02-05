package anything.study.jpastudy.terms.service;

import anything.study.jpastudy.terms.entity.Terms;
import anything.study.jpastudy.terms.repository.TermsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TermsService {

    private final TermsRepository termsRepository;

    public Terms postTerms() {

        Terms terms = Terms.builder()
                .content("hahahoho")
                .build();

        return termsRepository.save(terms);
    }
}
