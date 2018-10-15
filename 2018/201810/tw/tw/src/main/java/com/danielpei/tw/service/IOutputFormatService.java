package com.danielpei.tw.service;

import com.danielpei.tw.beans.Track;

import java.util.List;

public interface IOutputFormatService {

    String formatTrack(List<Track> trackList);
}
