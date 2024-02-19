package anything.study.jpastudy.shop;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String country;

    private Integer postalCode;

    private String province;

    private String detailAddress;

    @Override
    public String toString() {
        return "\"address\": {" +
                "\"country\"=" + '"' + country + '"' +
                ", \"postalCode\"=" + '"' + postalCode + '"' +
                ", \"province\"=" + '"' + province + '"' +
                ", \"detailAddress\"=" + '"' + detailAddress + '"' +
                '}';
    }
}
