package dec_2023.study.jpastudy.blog.repository;

import dec_2023.study.jpastudy.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long>, CustomBlogRepository {
}
