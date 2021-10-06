package hello.coreSpring.beanSearch;

import hello.coreSpring.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void searchAllBean(){
        String[] beanInfoNames =  ac.getBeanDefinitionNames();
        for (String beanInfoName : beanInfoNames) {
            Object bean = ac.getBean(beanInfoName);
            System.out.println("bean = " + beanInfoName + " object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력")
    void searchApplicationBean(){
        String[] beanInfoNames =  ac.getBeanDefinitionNames();
        for (String beanInfoName : beanInfoNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanInfoName);

            // ROLE_APPLICATION = 직접 등록한 애플리케이션 빈
            // ROLE_INFRASTRUCTURE = 스프링 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanInfoName);
                System.out.println("bean = " + beanInfoName + " object = " + bean);
            }
        }
    }
}
