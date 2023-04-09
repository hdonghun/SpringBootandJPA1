package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable // JPA에 내장타입, 어딘가에 내장될 수 있다? > 값을 변경하지 않는것들 > 그럼에 따라, Getter만 제공
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address(){

    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    /*
    값 타입은 변경 불가능하게 설계해야 한다.
    @Setter를 제거하고, 생성자에게 값을 모두 초기화해서 변경 불가능한 클래스를 만들자. JPA스펙상 엔티티나 임베디드 타입(@Embeddable)은 자바 기본생성자를 public 또는 protected로 설정해야 한다.
    public으로 두는 것보다는 protected로 설정하는 것이 그나마 더 안전 하다.
    JPA가 이런 제약을 두는 이유는 JPA 구현 라이브러리가 객체를 생성할 떄 리플랙션 같은 기술을 사용할 수 있도록 지원해야 하기 떄문이다.
    리플랙션?
     */


}
