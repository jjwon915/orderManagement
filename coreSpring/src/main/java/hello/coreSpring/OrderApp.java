package hello.coreSpring;

import hello.coreSpring.member.Grade;
import hello.coreSpring.member.Member;
import hello.coreSpring.member.MemberService;
import hello.coreSpring.member.MemberServiceImpl;
import hello.coreSpring.order.Order;
import hello.coreSpring.order.OrderService;
import hello.coreSpring.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args){

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VVIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order : " + order.toString());
        System.out.println(order.calculatePrice());
    }
}
