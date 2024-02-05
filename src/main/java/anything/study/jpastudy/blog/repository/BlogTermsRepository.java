package anything.study.jpastudy.blog.repository;

import anything.study.jpastudy.blog.entity.Blog;
import anything.study.jpastudy.blog.entity.BlogTerms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogTermsRepository extends JpaRepository<BlogTerms, Long> {

    List<BlogTerms> findBlogTermsByBlog(Blog blog);
}
