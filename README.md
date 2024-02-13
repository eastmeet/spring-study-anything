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

    UserDao <|.. DaoFactory: <<생성>>
    DaoFactory <|.. ApplicationContext: <<생성요청>>
    ApplicationContext <|.. DaoFactory: <<등록>>
    UserDao <|.. Client: 사용
    ApplicationContext <|.. Client: <<요청>> "userDao"

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
    ConnectionMaker <.. UserDao: <<사용>>
    ConnectionMaker <|.. DConnectionMaker
```