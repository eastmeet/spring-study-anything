package dec_2023.study.jpastudy.blog.repository;

import dec_2023.study.jpastudy.blog.entity.Blog;
import dec_2023.study.jpastudy.blog.entity.BlogTerms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogTermsRepository extends JpaRepository<BlogTerms, Long> {

    List<BlogTerms> findBlogTermsByBlog(Blog blog);
}
