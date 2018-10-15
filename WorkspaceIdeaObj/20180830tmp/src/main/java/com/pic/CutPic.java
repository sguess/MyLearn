package com.pic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

public class CutPic {
    public static void main(String[] args) {
        try {
            String filePath = "S:\\myLearn\\WorkspaceIdeaObj\\20180830tmp\\res\\";
            String inFile = filePath + "a.jpg";
            String outFile = filePath + "output";
            String fileType = "jpg";
            fileType = "png";
            splitImage(inFile, outFile, fileType);
//            mergeImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void splitImage(String inFile, String outFile, String fileType) throws Exception {
        String originalImg = inFile;
        File file = new File(originalImg);
        FileInputStream fis = new FileInputStream(file);
        BufferedImage image = ImageIO.read(fis);
        int rows = 2;
        int cols = 2;
        int chunks = rows * cols;
        int chunkWidth = image.getWidth() / cols;
        int chunkHeight = image.getHeight() / rows;
        int count = 0;
        BufferedImage[] imgs = new BufferedImage[chunks];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());
                Graphics2D gr = imgs[count++].createGraphics();
                gr.drawImage(image, 0, 0, chunkWidth, chunkHeight,
                        chunkWidth * y, chunkHeight * x,
                        chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
                gr.dispose();
            }
        }
        for (int i = 0; i < imgs.length; i++) {
            ImageIO.write(imgs[i], fileType, new File(outFile + i + "." + fileType));
        }

    }


}

