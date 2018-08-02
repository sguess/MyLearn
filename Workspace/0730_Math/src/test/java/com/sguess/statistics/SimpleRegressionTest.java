package com.sguess.statistics;

import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.junit.Test;

public class SimpleRegressionTest {
    @Test
    public void test01() {
        //y = intercept + slope * x
        SimpleRegression regression = new SimpleRegression(true);
        regression.addData(1d, 2d);
        // At this point, with only one observation,
        // all regression statistics will return NaN

        regression.addData(3d, 3d);
        // With only two observations,
        // slope and intercept can be computed
        // but inference statistics will return NaN

        regression.addData(2d, 2.5d);
        // Now all statistics are defined.
        System.out.println(regression.getIntercept());
        // displays intercept of regression line

        System.out.println(regression.getSlope());
        // displays slope of regression line

        System.out.println(regression.getSlopeStdErr());
        // displays slope standard error
        System.out.println(regression.predict(1.5d));
        System.out.println(regression.predict(0));
        System.out.println(regression.predict(1));
        System.out.println(regression.predict(2));
        System.out.println(regression.predict(3));
    }
}
