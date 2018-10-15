package com.sguess.condition;

import org.springframework.stereotype.Service;

@Condition(name = "sub")
@Service(value = "sub")
public class SubtractConditionImpl implements ICondition {
    @Override
    public int clac(int num1, int num2) {
        return num1 - num2;
    }
}
