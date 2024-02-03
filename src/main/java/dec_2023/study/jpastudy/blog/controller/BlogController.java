package dec_2023.study.jpastudy.blog.controller;

import dec_2023.study.jpastudy.blog.service.BlogService;
import dec_2023.study.jpastudy.config.swagger.GetApiResponse;
import dec_2023.study.jpastudy.config.swagger.PostApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/blog")
@RequiredArgsConstructor
@Tag(name = "Blog")
public class BlogController {

    private final BlogService blogService;

    @Operation(summary = "블로그 테스트")
    @PostApiResponse
    @PostMapping
    public ResponseEntity postBlog() {
        return new ResponseEntity(blogService.postBlog(), HttpStatus.CREATED);
    }

    @Operation(summary = "블로그 테스트")
    @PostApiResponse
    @PostMapping("{id}")
    public ResponseEntity postBlogTerms(@PathVariable("id") Long id) {
        return new ResponseEntity(blogService.postBlogTerms(id), HttpStatus.CREATED);
    }
//    @Operation(summary = "블로그 테스트")
//    @GetApiResponse
//    @GetMapping
//    public ResponseEntity getBlog() {
//        return ResponseEntity.ok(blogService.getBlog());
//    }

    @Operation(summary = "블로그 테스트")
    @GetApiResponse
    @GetMapping("/1")
    public ResponseEntity getBlog1() {
        return ResponseEntity.ok(blogService.getBlog1());
    }


}
