package dec_2023.study.jpastudy.blog.repository;

import dec_2023.study.jpastudy.blog.dto.BlogRes;
import dec_2023.study.jpastudy.blog.entity.Blog;

import java.util.List;

public interface CustomBlogRepository {

    List<Blog> findAllByCommon();

    List<BlogRes> findAllByCommon1();

}
