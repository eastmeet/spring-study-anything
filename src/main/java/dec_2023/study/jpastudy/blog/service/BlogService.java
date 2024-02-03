package dec_2023.study.jpastudy.blog.service;

import dec_2023.study.jpastudy.blog.dto.BlogRes;
import dec_2023.study.jpastudy.blog.dto.BlogTermsRes;
import dec_2023.study.jpastudy.blog.entity.Blog;
import dec_2023.study.jpastudy.blog.entity.BlogTerms;
import dec_2023.study.jpastudy.blog.repository.BlogRepository;
import dec_2023.study.jpastudy.blog.repository.BlogTermsRepository;
import dec_2023.study.jpastudy.terms.entity.Terms;
import dec_2023.study.jpastudy.terms.repository.TermsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BlogService {

    private final BlogRepository blogRepository;

    private final TermsRepository termsRepository;

    private final BlogTermsRepository blogTermsRepository;

    public Blog postBlog() {

        Blog blog = Blog.builder()
                .title("haha")
                .build();

        return blogRepository.save(blog);


    }

//    public Blog getBlog(Long fromId, Long toId, String title) {
//
//    }

//    public List<BlogRes> getBlog() {
//        List<Blog> allByCommon = blogRepository.findAllByCommon();
//
////        for (Blog blog : allByCommon) {
////            for (BlogTerms blogTerms : blog.getBlogTerms()) {
////                BlogTermsRes blogTermsRes = new BlogTermsRes(blogTerms.getId());
////                blogTermsResList.add(blogTermsRes);
////            }
////        }
//
//        return allByCommon.stream().map(blog -> {
//            List<BlogTermsRes> blogTermsResList = blog.getBlogTerms().stream()
//                    .map(blogTerms -> new BlogTermsRes(blogTerms.getId()))
//                    .collect(Collectors.toList());
//            return new BlogRes(blog.getId(), blog.getTitle(), blogTermsResList);
//        }).collect(Collectors.toList());
//
//    }

    public List<BlogRes> getBlog1() {
        return blogRepository.findAllByCommon1();
    }


    public BlogTerms postBlogTerms(Long id) {

        Blog blog = blogRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Blog entry not found for ID: " + id)
                );

        Terms terms = termsRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Terms entry not found for ID: " + id)
                );


        BlogTerms blogTerms = BlogTerms.builder()
                .blog(blog)
                .terms(terms)
                .build();

        return blogTermsRepository.save(blogTerms);
    }
}
