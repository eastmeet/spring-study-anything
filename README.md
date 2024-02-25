### 템플릿 메소드 패턴(template method pattern)

```mermaid
classDiagram
    class UserDao {
        <<abstract>>
        +add(User user)
        +get(String id)
        +getConnection()
    }
    class NUserDao {
        +getConnection()
    }
    class DUserDao {
        +getConnection()
    }

    UserDao <|-- NUserDao: extends
    UserDao <|-- DUserDao: extends
```

### 인터페이스 도입

```mermaid
classDiagram
    class UserDao {
        connectionMaker
        +add(User user)
        +get(String id)
    }
    class ConnectionMaker {
        <<interface>>
        makeConnection()
    }

    class NConnectionMaker {
        makeConnection()
    }
    class DConnectionMaker {
        makeConnection()
    }

    ConnectionMaker <|.. UserDao
    ConnectionMaker <|.. NConnectionMaker
    ConnectionMaker <|.. DConnectionMaker

```

### 관계 설정과 책임 p83.

- 개방 폐쇄 원칙, Open-closed Principle
- 전략 패턴

```mermaid
classDiagram
    class UserDaoTest {
    }
    class UserDao {
    }

    class DConnectionMaker {
    }

    UserDao <|.. UserDaoTest: 생성/제공
    UserDao <|.. UserDaoTest: 사용
    ConnectionMaker <|.. UserDao
    ConnectionMaker <|.. DConnectionMaker
    DConnectionMaker <|.. UserDaoTest: 생성
```

### 팩토리 도입

```mermaid
classDiagram
    class Client {
    }
    class UserDao {
    }
    class DaoFactory {
    }
    class ConnectionMaker {
    }
    class DConnectionMaker {
    }

    ConnectionMaker <|.. DConnectionMaker
    DConnectionMaker <|.. DaoFactory: 생성
    UserDao <|.. DaoFactory: 생성
    ConnectionMaker <|.. UserDao: 사용
    DaoFactory <|.. Client: 요청
    UserDao <|.. Client: 사용
```

### 애플리케이션 컨텍스트 도입

```mermaid
classDiagram
    class Client {
    }
    class UserDao {
    }
    class ApplicationContext {
        bean: userDao, ...
        +getBean()
    }
    class DaoFactory {
        @Configuration
        @Bean userDao
    }

    UserDao <|.. DaoFactory: 생성
    DaoFactory <|.. ApplicationContext: 생성요청
    ApplicationContext <|.. DaoFactory: 등록
    UserDao <|.. Client: 사용
    ApplicationContext <|.. Client: 요청 "userDao"

```

### 의존 관계
```mermaid
classDiagram
    class UserDao {
    }
    class ConnectionMaker {
    }
    class DConnectionMaker {
    }
    ConnectionMaker <.. UserDao: 사용
    ConnectionMaker <|.. DConnectionMaker
```


### 부가 기능 추가
```mermaid
classDiagram
    class UserDao {
    }
    class CountingConnectionMaker {
    }
    class DConnectionMaker {
    }
    CountingConnectionMaker <.. UserDao: 사용
    DConnectionMaker <.. CountingConnectionMaker: 사용
```


### TDD: 선 테스트 작성 후 기능 구현
- 복잡도가 낮은, 테스트 가능한 코드로 구현 가능
- 쉽게 발견하기 어려운 엣지(Edge)케이스를 놓치지 않게 해준다.
- 구현에 대한 빠른 피드백을 받을 수 있다.
- 과감한 리팩토링이 가능해진다.

