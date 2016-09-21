package speltutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootApp {

    @Autowired
    private FieldValueTestBean fieldValueTestBean;

        public static void main(String[] args) {
            ApplicationContext ctx = SpringApplication.run(SpringBootApp.class, args);
            FieldValueTestBean fieldVB = ctx.getBean(FieldValueTestBean.class);
            System.out.println(fieldVB.getDefaultLocale());

        }

    }

