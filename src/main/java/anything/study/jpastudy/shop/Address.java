package anything.study.jpastudy.shop;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    private String country;

    private Integer postalCode;

    private String province;

    private String detailAddress;

}
