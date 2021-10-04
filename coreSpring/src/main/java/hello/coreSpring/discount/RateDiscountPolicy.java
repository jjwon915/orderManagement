package hello.coreSpring.discount;

import hello.coreSpring.member.Grade;
import hello.coreSpring.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercentVIP = 10;
    private int discountPercentVVIP = 15;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VVIP){
            return price * discountPercentVVIP / 100;
        }
        else if(member.getGrade() == Grade.VIP){
            return price * discountPercentVIP / 100;
        } else {
            return 0;
        }
    }
}
