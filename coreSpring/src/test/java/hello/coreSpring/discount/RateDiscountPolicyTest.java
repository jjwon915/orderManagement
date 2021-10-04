package hello.coreSpring.discount;

import hello.coreSpring.member.Grade;
import hello.coreSpring.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {


    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VVIP는 15%할인 적용")
    void vvip(){
        Member member = new Member(1L, "memberVVIP", Grade.VVIP);

        int discount = rateDiscountPolicy.discount(member, 10000);

        Assertions.assertThat(discount).isEqualTo(1500);
    }

    @Test
    @DisplayName("VIP가 아닌 경우 할인 적용 X")
    void basic(){
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);

        int discount = rateDiscountPolicy.discount(member, 10000);

        Assertions.assertThat(discount).isEqualTo(0);
    }

}