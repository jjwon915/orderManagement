package hello.coreSpring;

import hello.coreSpring.discount.DiscountPolicy;
import hello.coreSpring.discount.FixDiscountPolicy;
import hello.coreSpring.discount.RateDiscountPolicy;
import hello.coreSpring.member.MemberRepository;
import hello.coreSpring.member.MemberService;
import hello.coreSpring.member.MemberServiceImpl;
import hello.coreSpring.member.MemoryMemberRepository;
import hello.coreSpring.order.OrderService;
import hello.coreSpring.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
