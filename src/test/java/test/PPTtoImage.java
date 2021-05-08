package test;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import org.apache.poi.hslf.model.TextRun;
import org.apache.poi.hslf.record.Slide;
import org.apache.poi.hslf.usermodel.RichTextRun;
import org.apache.poi.hslf.usermodel.SlideShow;

public class PPTtoImage {
    public static void main(String[] args) {
        // 读入PPT文件
        File file = new File("D:/poi-test/pptToImg/test.ppt");
        doPPTtoImage(file);
    }

    public static boolean doPPTtoImage(File file) {
        boolean isppt = checkFile(file);
        if (!isppt) {
            System.out.println("The image you specify don't exit!");
            return false;
        }
        try {

            FileInputStream is = new FileInputStream(file);
            SlideShow ppt = new SlideShow(is);
            is.close();
            Dimension pgsize = ppt.getPageSize();
            org.apache.poi.hslf.model.Slide[] slide = ppt.getSlides();
            for (int i = 0; i < slide.length; i++) {
                System.out.print("第" + i + "页。");

                TextRun[] truns = slide[i].getTextRuns();
                for ( int k=0;k<truns.length;k++){
                    RichTextRun[] rtruns = truns[k].getRichTextRuns();
                    for(int l=0;l<rtruns.length;l++){
                        int index = rtruns[l].getFontIndex();
                        String name = rtruns[l].getFontName();
                        rtruns[l].setFontIndex(1);
                        rtruns[l].setFontName("宋体");
//                        System.out.println(rtruns[l].getText());
                    }
                }
                BufferedImage img = new BufferedImage(pgsize.width,pgsize.height, BufferedImage.TYPE_INT_RGB);

                Graphics2D graphics = img.createGraphics();
                graphics.setPaint(Color.BLUE);
                graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
                slide[i].draw(graphics);

                // 这里设置图片的存放路径和图片的格式(jpeg,png,bmp等等),注意生成文件路径
                FileOutputStream out = new FileOutputStream("D:/poi-test/pptToImg/pict_"+ (i + 1) + ".jpeg");
                javax.imageio.ImageIO.write(img, "jpeg", out);
                out.close();

            }
            System.out.println("success!!");
            return true;
        } catch (FileNotFoundException e) {
            System.out.println(e);
            // System.out.println("Can't find the image!");
        } catch (IOException e) {
        }
        return false;
    }

    // function 检查文件是否为PPT
    public static boolean checkFile(File file) {

        boolean isppt = false;
        String filename = file.getName();
        String suffixname = null;
        if (filename != null && filename.indexOf(".") != -1) {
            suffixname = filename.substring(filename.indexOf("."));
            if (suffixname.equals(".ppt")) {
                isppt = true;
            }
            return isppt;
        } else {
            return isppt;
        }
    }

}
