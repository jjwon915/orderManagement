package hello.coreSpring;

import hello.coreSpring.member.Grade;
import hello.coreSpring.member.Member;
import hello.coreSpring.member.MemberService;
import hello.coreSpring.member.MemberServiceImpl;
import hello.coreSpring.order.Order;
import hello.coreSpring.order.OrderService;
import hello.coreSpring.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args){
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VVIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order : " + order.toString());
        System.out.println(order.calculatePrice());
    }
}
