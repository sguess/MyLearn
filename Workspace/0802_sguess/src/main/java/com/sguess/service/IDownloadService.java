package com.sguess.service;

import java.io.IOException;
import java.util.Date;

public interface IDownloadService {
    boolean downloadInDayPeriod(String name, Date startDay, Date endDay) throws IOException;

    boolean downloadByMonth(String name, Date monthDay) throws IOException;
}
