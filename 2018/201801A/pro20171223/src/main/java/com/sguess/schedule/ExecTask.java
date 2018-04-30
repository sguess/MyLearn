package com.sguess.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by PeiXingzhou on 2018-01-14.
 */
public class ExecTask implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        SimpleDateFormat sf=new SimpleDateFormat("HH:mm:ss");
        System.out.println("--------------------------------"+sf.format(new Date()));
    }
}
