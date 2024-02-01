package dec_2023.study.jpastudy.blog.dto;


import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class BlogTermsRes {

    private Long id;

    @QueryProjection
    public BlogTermsRes(Long id) {
        this.id = id;
    }
}
