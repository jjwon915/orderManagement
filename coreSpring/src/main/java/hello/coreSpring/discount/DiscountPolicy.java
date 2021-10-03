package hello.coreSpring.discount;

import hello.coreSpring.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
