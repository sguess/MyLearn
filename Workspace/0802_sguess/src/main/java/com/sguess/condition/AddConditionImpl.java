package com.sguess.condition;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Condition(name = "add")
@Component(value = "add")
public class AddConditionImpl implements ICondition {
    @Override
    public int clac(int num1, int num2) {
        return num1 + num2;
    }
}
