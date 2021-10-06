package hello.coreSpring.beanSearch;

import hello.coreSpring.AppConfig;
import hello.coreSpring.discount.DiscountPolicy;
import hello.coreSpring.discount.FixDiscountPolicy;
import hello.coreSpring.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextExtendsSearchTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 존재하면 오류 발생")
    void findBeanByParentType(){
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 존재하면 빈 이름을 지정한다")
    void findBeanByParentTypeWithName(){
        DiscountPolicy discountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubType(){
        DiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모타입으로 모두 조회")
    void findAllBeansByParentType(){
        Map<String, DiscountPolicy> beans = ac.getBeansOfType(DiscountPolicy.class);
        for(String key : beans.keySet()){
            System.out.println("key = " + key + " value = " + beans.get(key));
        }
        org.assertj.core.api.Assertions.assertThat(beans.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회 - Object")
    void findAllBeansByObject(){
        Map<String, Object> beans = ac.getBeansOfType(Object.class);
        for(String key : beans.keySet()) {
            System.out.println("key = " + key + " value = " + beans.get(key));
        }
    }

    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }
    }
}
