package com.sguess.process;

import com.sguess.dao.IStatusDao;
import com.sguess.process.monitor.PMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class StrategyProgress {
    Logger LOG=LoggerFactory.getLogger(StrategyProgress.class);
    @Autowired
    private PMonitor pMonitor;

    @Autowired
    private IStatusDao statusDao;

    @Scheduled(fixedDelay = 1000)
    public void process() {
        if(statusDao.isPause()){
            LOG.info("the process status is pause at "+new Date());
            return;
        }
        System.out.println("The current time is "+new Date());
        if (pMonitor.getCurrentPricePercent().compareTo(new BigDecimal(0.3))>0){

        }
    }
    public void running(){

    }
    public static void main(String[] args) {
        BigDecimal num1=new BigDecimal("10.00");
        BigDecimal num2=new BigDecimal("9.00");
        System.out.println(num1.compareTo(num2));
        System.out.println(num1.max(num2));
    }
}
