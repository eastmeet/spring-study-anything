package dec_2023.study.jpastudy.blog.repository;

import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.ListPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dec_2023.study.jpastudy.blog.dto.BlogRes;
import dec_2023.study.jpastudy.blog.dto.BlogTermsRes;
import dec_2023.study.jpastudy.blog.dto.QBlogTermsRes;
import dec_2023.study.jpastudy.blog.entity.Blog;
import dec_2023.study.jpastudy.blog.entity.QBlogTerms;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

import static dec_2023.study.jpastudy.blog.entity.QBlog.blog;
import static dec_2023.study.jpastudy.blog.entity.QBlogTerms.blogTerms;


@Repository
@RequiredArgsConstructor
public class CustomBlogRepositoryImpl implements CustomBlogRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Blog> findAllByCommon() {

        List<Blog> blogs = jpaQueryFactory.selectFrom(
                blog)
                .leftJoin(blog.blogTerms, blogTerms).fetchJoin()
                .fetch();


        return blogs;
    }

    public List<BlogRes> findAllByCommon1() {

        return jpaQueryFactory.selectFrom(blog)
                .leftJoin(blog.blogTerms, blogTerms)
                .transform(
                        GroupBy.groupBy(blog.id).list(
                                Projections.constructor(BlogRes.class,
                                        blog.id,
                                        blog.title,
                                        GroupBy.list(
                                                Projections.constructor(BlogTermsRes.class,
                                                        blogTerms.id
                                                )
                                        )
                                )
                        )
                );
    }

}