package anything.study.jpastudy.blog.repository;

import anything.study.jpastudy.blog.dto.BlogRes;
import anything.study.jpastudy.blog.entity.Blog;

import java.util.List;

public interface CustomBlogRepository {

    List<Blog> findAllByCommon();

    List<BlogRes> findAllByCommon1();

}
