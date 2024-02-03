package dec_2023.study.jpastudy.blog.service;

import dec_2023.study.jpastudy.blog.entity.Blog;
import dec_2023.study.jpastudy.blog.type.BlogStatus;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
// DisplayNameGeneration 보다는 DisplayName 기법이 더 명확함
class BlogServiceTest {

    @DisplayName("블로그 만들기 \uD83D\uDE31")
    @Test
    void create_new_blog() {
        Blog blog = new Blog();
        System.out.println("create");

        assertAll(
                () -> assertNotNull(blog),
                () -> assertEquals(BlogStatus.DRAFT, blog.getStatus(),
                        () -> "blog 초기 상태는" + BlogStatus.DRAFT + "여야 한다"),
                () -> assertNull(blog.getId())
        );

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Blog(-1L));
        String message = exception.getMessage();
        assertEquals(message, "view count는 0 보다 커야합니다.");
        assertTimeoutPreemptively(Duration.ofNanos(1), () -> {
                    new Blog();
                }
        ); // Thread local
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before Each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After Each");
    }


}