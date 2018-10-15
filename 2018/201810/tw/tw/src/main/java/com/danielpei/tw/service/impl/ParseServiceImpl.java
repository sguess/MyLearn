package com.danielpei.tw.service.impl;

import com.danielpei.tw.beans.Conference;
import com.danielpei.tw.beans.ConferenceType;
import com.danielpei.tw.exception.ConferenceException;
import com.danielpei.tw.service.IParseService;
import com.danielpei.tw.utils.InputUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Service
public class ParseServiceImpl implements IParseService {
    Logger LOG = LoggerFactory.getLogger(ParseServiceImpl.class);
    private static final String defaultFilePath = "data/input.txt";
    private long trackMaxDuration = 0;
    @Value("${time.track.track.morning.start.hour}")
    int trackMorningStartHour = 9;
    @Value("${time.track.track.morning.end.hour}")
    int trackMorningEndHour = 12;
    @Value("${time.track.track.afternoon.start.hour}")
    int trackAfternoonStartHour = 13;
    @Value("${time.track.track.afternoon.end.hour}")
    int trackAfternoonEndHour = 17;

    @PostConstruct
    public long initTrackMaxDuration() {
        long moringDuration = getTrackTime(trackMorningEndHour) - getTrackTime(trackMorningStartHour);
        LOG.info("Morning track max duration is " + moringDuration);
        long afternoonDuration = getTrackTime(trackAfternoonEndHour) - getTrackTime(trackAfternoonStartHour);
        LOG.info("Afternoon track max duration is " + afternoonDuration);
        trackMaxDuration = Math.max(moringDuration, afternoonDuration);
        LOG.info("The max duration is" + trackMaxDuration);
        return trackMaxDuration;
    }

    private long getTrackTime(int hour) {
        Calendar time = Calendar.getInstance();
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        time.set(Calendar.MILLISECOND, 0);
        time.set(Calendar.HOUR_OF_DAY, hour);
        return time.getTimeInMillis();
    }

    @Override
    public List<Conference> parseDefaultData() throws ConferenceException {
        List<String> inputLineList = parseFile();
        if (inputLineList == null || inputLineList.size() == 0) {
            inputLineList.add("Writing Fast Tests Against Enterprise Rails 60min");
            inputLineList.add("Overdoing it in Python 45min");
            inputLineList.add("Lua for the Masses 30min");
            inputLineList.add("Ruby Errors from Mismatched Gem Versions 45min");
            inputLineList.add("Common Ruby Errors 45min");
            inputLineList.add("Rails for Python Developers lightning");
            inputLineList.add("Communicating Over Distance 60min");
            inputLineList.add("Accounting-Driven Development 45min");
            inputLineList.add("Woah 30min");
            inputLineList.add("Sit Down and Write 30min");
            inputLineList.add("Pair Programming vs Noise 45min");
            inputLineList.add("Rails Magic 60min");
            inputLineList.add("Ruby on Rails: Why We Should Move On 60min");
            inputLineList.add("Clojure Ate Scala (on my project) 45min");
            inputLineList.add("Programming in the Boondocks of Seattle 30min");
            inputLineList.add("Ruby vs. Clojure for Back-End Development 30min");
            inputLineList.add("Ruby on Rails Legacy App Maintenance 60min");
            inputLineList.add("A World Without HackerNews 30min");
            inputLineList.add("User Interface CSS in Rails Apps 30min");
        }
        List<Conference> rstList = parseDefaultDataFromInputList(inputLineList);
        return rstList;
    }

    private List<String> parseFile() {
        File file = null;
        file = new File(ClassUtils.getDefaultClassLoader().getResource("").getPath() + defaultFilePath);
        List<String> inputLineList = new ArrayList();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String lineStr = "";
            while ((lineStr = reader.readLine()) != null) {
                inputLineList.add(lineStr);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputLineList;
    }

    @Override
    public List<Conference> parseDefaultDataFromInputList(List<String> inputLineList) throws ConferenceException {
        if (inputLineList == null || inputLineList.size() == 0) {
            LOG.error("Input line Str is empty!");
            return new ArrayList<>();
        }
        LOG.info("input Line str size is " + inputLineList.size());
        List<Conference> rstList = new ArrayList<>();
        for (String lineStr : inputLineList) {
            Conference conference = parseConferenceFromStr(lineStr);
            LOG.info("Get a conference from " + lineStr);
            rstList.add(conference);
        }
        return rstList;
    }


    @Override
    public Conference parseConferenceFromStr(String lineStr) throws ConferenceException {
        if (!InputUtils.isCorrectFormat(lineStr)) {
            LOG.error("The input conference information is not correct. " + lineStr);
            throw new ConferenceException("The input conference information is not correct. " + lineStr);
        }
        Conference conference = new Conference();
        lineStr = lineStr.trim();
        int lastSpaceIndex = lineStr.lastIndexOf(" ");
        conference.setName(lineStr.substring(0, lastSpaceIndex));
        if (lineStr.endsWith("lightning")) {
            conference.setDuration(5 * 60 * 1000);
            conference.setType(ConferenceType.LIGHTNING);
        } else {
            long durationMins = Long.parseLong(lineStr.substring(lastSpaceIndex + 1).replace("min", ""));
            conference.setDuration(durationMins * 60 * 1000);
            if (conference.getDuration() > trackMaxDuration) {
                LOG.error("A conference max time should less than " + trackMaxDuration / 1000 / 60 + "mins. " + lineStr);
                throw new ConferenceException("A conference max time should less than " + trackMaxDuration / 1000 / 60 + "mins. " + lineStr);
            }
            conference.setType(ConferenceType.NORMAL);
        }
        conference.setOriginStr(lineStr);
        return conference;
    }

}
