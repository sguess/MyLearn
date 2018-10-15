package com.sguess.jobs;

import com.sguess.condition.ICondition;

import java.util.List;

public class ParsedCondition {

    private List<ICondition> conditionList;
    private NewJobs newJobs;

    public List<ICondition> getConditionList() {
        return conditionList;
    }

    public void setConditionList(List<ICondition> conditionList) {
        this.conditionList = conditionList;
    }

    public NewJobs getNewJobs() {
        return newJobs;
    }

    public void setNewJobs(NewJobs newJobs) {
        this.newJobs = newJobs;
    }
}
