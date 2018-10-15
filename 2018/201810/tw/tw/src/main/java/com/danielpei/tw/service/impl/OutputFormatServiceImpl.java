package com.danielpei.tw.service.impl;

import com.danielpei.tw.beans.Conference;
import com.danielpei.tw.beans.Track;
import com.danielpei.tw.beans.TrackType;
import com.danielpei.tw.service.IOutputFormatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OutputFormatServiceImpl implements IOutputFormatService {
    private static final Logger LOG = LoggerFactory.getLogger(OutputFormatServiceImpl.class);

    @Value("${output.sign.warp}")
    private String warpSignStr = "\n";
    @Value("${output.sign.space}")
    private String spaceSignStr = "\t";

    @Override
    public String formatTrack(List<Track> trackList) {
        StringBuffer sb = new StringBuffer("Output:").append(warpSignStr);
        for (Track track : trackList) {
            if (track.getType() == TrackType.MORNING) {
                sb.append("Track ").append(track.getDay() + 1).append(": ").append(warpSignStr).append(warpSignStr);
            }
            for (Conference conference : track.getConferenceList()) {
                sb.append(spaceSignStr).append(getOutputLine(conference)).append(warpSignStr);
            }
            sb.append(warpSignStr);
        }
        return sb.toString();
    }

    private String getOutputLine(Conference conference) {
        StringBuffer sb = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mma");
        Date startTime = conference.getStartTime();
        sb.append(simpleDateFormat.format(startTime)).append(" ").append(conference.getOriginStr());
        return sb.toString();
    }
}
