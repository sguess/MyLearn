package com.sguess.jobs;

import com.sguess.condition.ICondition;

import java.util.List;

public class NewJobs {
    InfoBean infoBean;
    List<ParsedCondition> conditionList;

    public InfoBean getInfoBean() {
        return infoBean;
    }

    public void setInfoBean(InfoBean infoBean) {
        this.infoBean = infoBean;
    }

    public List<ParsedCondition> getConditionList() {
        return conditionList;
    }

    public void setConditionList(List<ParsedCondition> conditionList) {
        this.conditionList = conditionList;
    }
}
