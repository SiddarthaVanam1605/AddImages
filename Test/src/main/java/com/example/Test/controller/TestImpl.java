package com.example.Test.controller;



import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestImpl implements  TestInter{


    @Override
    public String getVideo(List<String> imagePaths) throws IOException {

        String image1 = imagePaths.get(0);
        String image2 = imagePaths.get(1);

        BufferedImage a = ImageIO.read(new File(image1, "a.png"));
        BufferedImage b = ImageIO.read(new File(image2, "b.png"));
        BufferedImage c = new BufferedImage(a.getWidth(), a.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics g = c.getGraphics();
        g.drawImage(a, 0, 0, null);
        g.drawImage(b, 0, 0, null);

        String filePath = "output";
        File fileP = new File(filePath);

        String commands = "D:\\ffmpeg-win32-static\\bin\\ffmpeg -f c -i "
                + fileP + "\\image%5d.png " + fileP + "\\video.mp4";
        System.out.println(commands);
        Runtime.getRuntime().exec(commands);
        System.out.println(fileP.getAbsolutePath());

        return fileP.getAbsolutePath();
    }

}
