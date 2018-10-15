package com.sguess;

import com.sguess.condition.Condition;
import com.sguess.condition.ICondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;

@Service
public class ConditionService {

    @Autowired
    ApplicationContext applicationContext;

    public void test() {
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(Condition.class);
        System.err.println(beans.size());

        ICondition condition = (ICondition) applicationContext.getBean("add");

        System.err.println("rst: " + condition.clac(1, 2));
        System.out.println("isSingleton: " + applicationContext.isSingleton("add"));
    }
}
