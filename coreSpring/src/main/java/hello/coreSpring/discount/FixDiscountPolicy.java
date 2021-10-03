package hello.coreSpring.discount;

import hello.coreSpring.member.Grade;
import hello.coreSpring.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmountVIP = 2000;
    private int discountFixAmountVVIP = 3000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmountVIP;
        }
        else if(member.getGrade() == Grade.VVIP){
            return discountFixAmountVVIP;
        }
        else {
            return 0;
        }
    }
}
