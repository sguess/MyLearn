package com.danielpei.tw.ctrl;

import com.danielpei.tw.beans.APIMessage;
import com.danielpei.tw.beans.Conference;
import com.danielpei.tw.beans.Track;
import com.danielpei.tw.exception.ConferenceException;
import com.danielpei.tw.service.IOutputFormatService;
import com.danielpei.tw.service.IParseService;
import com.danielpei.tw.service.IPlanningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.net.httpserver.HttpsServerImpl;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class PlanningCtrl {
    Logger LOG = LoggerFactory.getLogger(PlanningCtrl.class);
    @Autowired
    IParseService parseService;
    @Autowired
    IPlanningService planningService;

    @Autowired
    IOutputFormatService outputFormatService;

    @GetMapping("/details")
    public APIMessage details() {
        try {
            return new APIMessage(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), planningService.planConference(parseService.parseDefaultData()));
        } catch (ConferenceException e) {
            return new APIMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "");
        }
    }

    @GetMapping("/")
    public String defaultPlan() {
        List<Conference> conferenceList = null;
        try {
            conferenceList = parseService.parseDefaultData();
            for (Conference conference : conferenceList) {
                LOG.info("Parsed conf info: " + conference.toString());
            }
            List<Track> trackList = planningService.planConference(conferenceList);
            for (Track track : trackList) {
                for (Conference conference : track.getConferenceList()) {
                    LOG.info("track conf info:" + track.getDay() + "\t" + conference.getStartTime() + "\t" + conference.getOriginStr());
                }
            }
            String rstStr = outputFormatService.formatTrack(trackList);
            LOG.info("The result info is:\n " + rstStr);
            return rstStr;
        } catch (ConferenceException e) {
            LOG.error("Exception: ", e);
            return e.getMessage();
        }
    }

}
