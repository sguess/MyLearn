package com.sguess.statistics;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.junit.Test;

public class DescriptiveStatisticsTest {

    @Test
    public void test01() {
        // Get a DescriptiveStatisticsDemo instance
        DescriptiveStatistics stats = new DescriptiveStatistics();

        // Add the data from the array
        int[] inputArray = {1, 2, 3, 1, 4};
        for (int i = 0; i < inputArray.length; i++) {
            stats.addValue(inputArray[i]);
        }
        // Compute some statistics
        double mean = stats.getMean();
        double std = stats.getStandardDeviation();
        double median = stats.getPercentile(50);
        System.out.println(mean);
        System.out.println(std);
        System.out.println(median);
    }

    @Test
    public void test02() {
        // Get a SummaryStatistics instance
        SummaryStatistics stats = new SummaryStatistics();
        double[] data = {1.1, 1.4, 1.5};
        for (int i = 0; i < data.length; i++) {
            stats.addValue(data[i]);
        }
        double mean = stats.getMean();
        double std = stats.getStandardDeviation();
        System.out.println(mean);
        System.out.println(std);
    }

}