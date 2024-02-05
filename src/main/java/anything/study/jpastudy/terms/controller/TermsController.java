package anything.study.jpastudy.terms.controller;

import anything.study.jpastudy.config.swagger.PostApiResponse;
import anything.study.jpastudy.terms.service.TermsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Terms")
@RequestMapping("/api/v1/terms")
public class TermsController {

    private final TermsService termsService;

    @Operation(summary = "텀즈 테스트")
    @PostApiResponse
    @PostMapping
    public ResponseEntity postTerms() {
        return new ResponseEntity(termsService.postTerms(), HttpStatus.CREATED);
    }
}
