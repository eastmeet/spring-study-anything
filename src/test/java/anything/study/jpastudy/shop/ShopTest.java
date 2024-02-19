package anything.study.jpastudy.shop;


import anything.study.jpastudy.shop.repository.ShopRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShopTest {

    @Autowired
    private ShopRepository shopRepository;

    @Test
    void convertTest() {

        shopRepository.deleteAll();

        Address address = Address.builder()
                .country("대한민국")
                .postalCode(1111)
                .province("서울")
                .detailAddress("은평구")
                .build();

        Shop shop = new Shop(1L, address);
        Shop save = shopRepository.save(shop);

        System.out.println(save.getAddress());

        Assertions.assertThat(save.getAddress().getCountry()).isEqualTo("대한민국");
    }
  
}