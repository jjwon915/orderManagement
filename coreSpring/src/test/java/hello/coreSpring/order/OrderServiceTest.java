package hello.coreSpring.order;

import hello.coreSpring.AppConfig;
import hello.coreSpring.member.Grade;
import hello.coreSpring.member.Member;
import hello.coreSpring.member.MemberService;
import hello.coreSpring.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VVIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 15000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(3000);
    }
}
