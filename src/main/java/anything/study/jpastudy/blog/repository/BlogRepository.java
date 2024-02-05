package anything.study.jpastudy.blog.repository;

import anything.study.jpastudy.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long>, CustomBlogRepository {
}
