package dec_2023.study.jpastudy.terms.service;

import dec_2023.study.jpastudy.terms.entity.Terms;
import dec_2023.study.jpastudy.terms.repository.TermsRepository;
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
