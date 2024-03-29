package anything.study.jpastudy.blog.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogRes {


    private Long id;

    private String title;

    private List<BlogTermsRes> terms;
}
