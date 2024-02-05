package anything.study.jpastudy.blog.entity;

import anything.study.jpastudy.terms.entity.Terms;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class BlogTerms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Blog blog;

    @ManyToOne(fetch = FetchType.LAZY)
    private Terms terms;
}
