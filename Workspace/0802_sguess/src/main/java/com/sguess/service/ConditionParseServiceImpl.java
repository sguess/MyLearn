package com.sguess.service;

import com.sguess.condition.ICondition;
import com.sguess.jobs.InfoBean;
import com.sguess.jobs.NewJobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConditionParseServiceImpl implements IConditionParseService {

    @Autowired
    ApplicationContext applicationContext;

    public boolean parseJsonCondition(String jsonCondition) {
        InfoBean infoBean = (InfoBean) new GsonJsonParser().parseList(jsonCondition);
        System.out.println(infoBean.toString());
        return true;
    }


    /**
     * c01 && c02 || c01 && c03 ## new01## c01&& c03|| c01
     *
     * @param conditionStr
     * @return
     */
    public boolean parseCondtion(String conditionStr) {
        String[] conditions = conditionStr.split("||");
        for (String condition : conditions) {
            String[] cons = condition.split("&&");
            List<ICondition> conditionList = new ArrayList<>();
            for (String con : cons) {
                conditionList.add((ICondition) applicationContext.getBean(con));
            }
            if (execuConditionList(conditionList)) {
                return true;
            }
        }
        return false;
    }

    private boolean execuConditionList(List<ICondition> conditionList) {
        if (conditionList == null || conditionList.size() == 0) {
            return false;
        }
        for (ICondition iCondition : conditionList) {
            if (iCondition.clac(1, 2) != 3) {
                return false;
            }
        }
        return true;
    }

}
