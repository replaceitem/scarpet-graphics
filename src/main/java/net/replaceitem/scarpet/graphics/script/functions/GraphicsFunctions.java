package net.replaceitem.scarpet.graphics.script.functions;

import carpet.script.annotation.ScarpetFunction;
import net.replaceitem.scarpet.graphics.script.values.PixelAccessibleValue;
import processing.awt.PGraphicsJava2D;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;
import net.replaceitem.scarpet.graphics.ScarpetGraphics;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@SuppressWarnings("unused")
public class GraphicsFunctions {
    @ScarpetFunction
    public PImage load_image(String location) {
        try {
            try {
                URL url = new URL(location);
                return new PImage(ImageIO.read(url));
            } catch (MalformedURLException e) {
                File file = new File(location);
                return new PImage(ImageIO.read(file));
            }
        } catch (IOException e) {
            ScarpetGraphics.LOGGER.error(e);
            return null;
        }
    }

    @ScarpetFunction
    public void save_image(PixelAccessibleValue<?> image, String location) {
        image.getGraphics().save(location);
    }

    @ScarpetFunction
    public PGraphics create_graphics(int w, int h) {
        PGraphicsJava2D pg = new PGraphicsJava2D();
        pg.setPrimary(false);
        pg.setSize(w, h);
        pg.colorMode(PConstants.RGB,255,255,255,255);
        return pg;
    }

    @ScarpetFunction
    public void copy_image(PixelAccessibleValue<?> source, PixelAccessibleValue<?> destination, int sourceX, int sourceY, int sourceW, int sourceH, int destinationX, int destinationY, int destinationW, int destinationH) {
        destination.getGraphics().copy(source.getGraphics(), sourceX, sourceY, sourceW, sourceH, destinationX, destinationY, destinationW, destinationH);
    }

    @ScarpetFunction
    public int get_pixel(PixelAccessibleValue<?> graphics, int x, int y) {
        return graphics.getColorAt(x,y);
    }

    @ScarpetFunction
    public void set_pixel(PixelAccessibleValue<?> graphics, int x, int y, int color) {
        graphics.getGraphics().set(x, y, color);
    }

    @ScarpetFunction
    public void begin_draw(PGraphics graphics) {
        graphics.beginDraw();
    }

    @ScarpetFunction
    public void end_draw(PGraphics graphics) {
        graphics.endDraw();
    }
}
