package com.danielpei.tw.service;

import com.danielpei.tw.beans.Conference;
import com.danielpei.tw.exception.ConferenceException;

import java.util.List;

public interface IParseService {

    List<Conference> parseDefaultData() throws ConferenceException;

    List<Conference> parseDefaultDataFromInputList(List<String> inputLineList) throws ConferenceException;

    Conference parseConferenceFromStr(String lineStr) throws ConferenceException;

}
