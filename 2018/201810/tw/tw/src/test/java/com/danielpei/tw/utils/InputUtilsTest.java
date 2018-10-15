package com.danielpei.tw.utils;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class InputUtilsTest {
    @Test
    public void isCorrectFormat() {
        assertFalse(InputUtils.isCorrectFormat(null));
        assertFalse(InputUtils.isCorrectFormat(""));
        assertFalse(InputUtils.isCorrectFormat(" "));
        assertTrue(InputUtils.isCorrectFormat("a 1min"));
        assertTrue(InputUtils.isCorrectFormat("abc 1min"));
        assertTrue(InputUtils.isCorrectFormat("abc 2min"));
        assertTrue(InputUtils.isCorrectFormat("abc 200min"));
        assertTrue(InputUtils.isCorrectFormat("abc abc 1min"));
        assertTrue(InputUtils.isCorrectFormat(" abc abc 1min"));
        assertTrue(InputUtils.isCorrectFormat(" abc abc lightning"));
        assertTrue(InputUtils.isCorrectFormat("abc lightning"));

        assertFalse(InputUtils.isCorrectFormat("abc 0min"));
        assertFalse(InputUtils.isCorrectFormat("abc 1minaa"));
//        assertFalse(InputUtils.isCorrectFormat(" abc abc 1 min"));
//        assertFalse(InputUtils.isCorrectFormat(" abc abc 1min "));
//
//        assertFalse(InputUtils.isCorrectFormat(" abc abc 1"));
        assertFalse(InputUtils.isCorrectFormat("1min"));
        assertFalse(InputUtils.isCorrectFormat(" 1min"));

//        assertFalse(InputUtils.isCorrectFormat("abc 1min "));
        assertFalse(InputUtils.isCorrectFormat("lightning"));
        assertFalse(InputUtils.isCorrectFormat(" lightning"));
        assertFalse(InputUtils.isCorrectFormat("abc lightningaa"));
    }

    @Test
    public void testSomeSign() {
        assertTrue(InputUtils.isCorrectFormat("abc: 1min"));
        assertTrue(InputUtils.isCorrectFormat("abc( 1min"));
        assertTrue(InputUtils.isCorrectFormat("abc) 1min"));
        assertTrue(InputUtils.isCorrectFormat("abc. 1min"));
        assertTrue(InputUtils.isCorrectFormat("abc- 1min"));
    }

    @Test
    public void testDemo() {
        assertTrue(InputUtils.isCorrectFormat("Writing Fast Tests Against Enterprise Rails 60min"));
        assertTrue(InputUtils.isCorrectFormat("Overdoing it in Python 45min"));
        assertTrue(InputUtils.isCorrectFormat("Lua for the Masses 30min"));
        assertTrue(InputUtils.isCorrectFormat("Ruby Errors from Mismatched Gem Versions 45min"));
        assertTrue(InputUtils.isCorrectFormat("Common Ruby Errors 45min"));
        assertTrue(InputUtils.isCorrectFormat("Rails for Python Developers lightning"));
        assertTrue(InputUtils.isCorrectFormat("Communicating Over Distance 60min"));
        assertTrue(InputUtils.isCorrectFormat("Accounting-Driven Development 45min"));
        assertTrue(InputUtils.isCorrectFormat("Woah 30min"));
        assertTrue(InputUtils.isCorrectFormat("Sit Down and Write 30min"));
        assertTrue(InputUtils.isCorrectFormat("Pair Programming vs Noise 45min"));
        assertTrue(InputUtils.isCorrectFormat("Rails Magic 60min"));
        assertTrue(InputUtils.isCorrectFormat("Ruby on Rails: Why We Should Move On 60min"));
        assertTrue(InputUtils.isCorrectFormat("Clojure Ate Scala (on my project) 45min"));
        assertTrue(InputUtils.isCorrectFormat("Programming in the Boondocks of Seattle 30min"));
        assertTrue(InputUtils.isCorrectFormat("Ruby vs. Clojure for Back-End Development 30min"));
        assertTrue(InputUtils.isCorrectFormat("Ruby on Rails Legacy App Maintenance 60min"));
        assertTrue(InputUtils.isCorrectFormat("A World Without HackerNews 30min"));
        assertTrue(InputUtils.isCorrectFormat("User Interface CSS in Rails Apps 30min"));

    }
}