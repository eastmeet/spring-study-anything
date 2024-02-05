package anything.study.jpastudy.terms.entity;


import anything.study.jpastudy.blog.entity.BlogTerms;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Terms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @OneToMany(mappedBy = "terms")
    private List<BlogTerms> blogTerms;

}
