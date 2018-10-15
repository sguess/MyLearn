package com.sguess.condition;

import org.springframework.stereotype.Component;

@Condition
@Component
public class AConditionImpl implements ICondition {
    @Override
    public int clac(int num1, int num2) {
        return 0;
    }
}
