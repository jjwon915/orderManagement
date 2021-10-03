package hello.coreSpring.order;

import hello.coreSpring.discount.DiscountPolicy;
import hello.coreSpring.discount.FixDiscountPolicy;
import hello.coreSpring.member.Member;
import hello.coreSpring.member.MemberRepository;
import hello.coreSpring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
