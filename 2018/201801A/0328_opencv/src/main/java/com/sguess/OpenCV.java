package com.sguess;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;
import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class OpenCV {
//	private static Logger log = LoggerFactory.getLogger(OpenCV.class);
	static Log log=LogFactory.getLog(OpenCV.class);

	public static void main(String[] args) {
		String path = "C:/tmp/";
		OpenCV openCv = new OpenCV();
		String srcImgPathStr = path + "tomcat.png";
		String descImgPathStr = path + "tomcat1.png";
		double matchRate = 0.9;
		boolean b1 = openCv.run(srcImgPathStr, descImgPathStr, matchRate);
		log.info("rst:"+b1);
	}

	public boolean run(String srcImgPathStr, String descImgPathStr, double matchRate) {
		init();
		if (!new File(srcImgPathStr).exists()) {
			log.info(srcImgPathStr + " is not exist!");
			return false;
		}
		if (!new File(descImgPathStr).exists()) {
			log.info(descImgPathStr + " is not exist!");
			return false;
		}
		Mat srcImg = Highgui.imread(srcImgPathStr);
		Mat descImg = Highgui.imread(descImgPathStr);
		if (isImgEmpty(srcImg) || isImgEmpty(descImg)) {
			return false;
		}
		int rst_cols = srcImg.cols() - descImg.cols() + 1;
		int rst_row = srcImg.rows() - descImg.rows() + 1;
		Mat rstMat = new Mat(Math.abs(rst_row), Math.abs(rst_cols), CvType.CV_32FC1);

		Imgproc.matchTemplate(srcImg, descImg, rstMat, Imgproc.TM_CCOEFF_NORMED);

		log.info("rstMat row and cols:" + rstMat.rows() + "," + rstMat.cols());
		double maxNum = -100;
		for (int i = 0; i < rstMat.rows(); i++) {
			for (int j = 0; j < rstMat.cols(); j++) {
				if (rstMat.get(i, j)[0] > maxNum) {
					maxNum = rstMat.get(i, j)[0];
				}
			}
		}
		return maxNum >= matchRate;
	}

	private void init() {
		String libname = "opencv_java249_x64";
		log.info("The lib exist:" + new File(libname).exists());
		System.loadLibrary(libname);

	}

	private boolean isImgEmpty(Mat srcImg) {
		return srcImg.cols() == 0 || srcImg.rows() == 0;
	}
}
