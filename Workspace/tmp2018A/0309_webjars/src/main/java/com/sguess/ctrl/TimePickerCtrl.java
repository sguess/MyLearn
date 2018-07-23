package com.sguess.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/timepicker")
public class TimePickerCtrl {
    private static final Logger LOG = LoggerFactory.getLogger(TimePickerCtrl.class);
    private static final String TIMEPICKER = "timepicker";

    @RequestMapping("")
    public String homePage() {
        LOG.info("access timepick homepage");
        return TIMEPICKER + "/index";
    }
}

