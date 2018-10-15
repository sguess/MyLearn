package com.sguess.tmp;


import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.junit.Test;

import java.io.IOException;

public class SevenZip {

    @Test
    public void testCompress() throws IOException {
        String cmdTool = "7z";
        CommandLine cmdLine = new CommandLine(cmdTool);
        cmdLine.addArgument("a");
        cmdLine.addArgument("S:/tmp/download/d.7z");
        cmdLine.addArgument("S:/tmp/download/a");
        cmdLine.addArgument("S:/tmp/download/b");
        cmdLine.addArgument("S:/tmp/download/c");
        cmdLine.addArgument("S:/tmp/download/d");
        DefaultExecutor executor = new DefaultExecutor();
        int exitValue = executor.execute(cmdLine);
        System.out.println(exitValue);
    }

    @Test
    public void testDeCompress() throws IOException {
        String cmdTool = "7z";
        CommandLine cmdLine = new CommandLine(cmdTool);
        // Set the output directory is S:/tmp/download/output/
        cmdLine.addArgument("-oS:/tmp/download/output/");
        //x      eXtract with full paths.
        // Please notice if you set the command parameter is e, that is means only Extract to without of full path.
        cmdLine.addArgument("x");
        cmdLine.addArgument("S:/tmp/download/a.7z");
        DefaultExecutor executor = new DefaultExecutor();
        int exitValue = executor.execute(cmdLine);
        System.out.println(exitValue);
    }

}
