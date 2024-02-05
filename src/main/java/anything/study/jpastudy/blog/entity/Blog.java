package anything.study.jpastudy.blog.entity;

import anything.study.jpastudy.blog.type.BlogStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Builder.Default
    private BlogStatus status = BlogStatus.DRAFT;

    @Builder.Default
    private Long viewCount = 0L;

    public Blog(Long viewCount) {
        if (viewCount < 0) {
            throw new IllegalArgumentException("view count는 0 보다 커야합니다.");
        }
        this.viewCount = viewCount;
    }

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    @Builder.Default
    private List<BlogTerms> blogTerms = new ArrayList<>();
}
