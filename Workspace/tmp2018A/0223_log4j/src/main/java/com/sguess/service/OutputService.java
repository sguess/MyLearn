package com.sguess.service;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class OutputService {
    private Logger LOG = Logger.getLogger(OutputService.class);

    @PostConstruct
    public void printLog() {
        LOG.info("--------------org.apache.log4j.Logger");
    }

}
