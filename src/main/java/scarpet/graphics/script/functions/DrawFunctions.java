package scarpet.graphics.script.functions;

import carpet.script.annotation.ScarpetFunction;
import processing.core.PGraphics;
import scarpet.graphics.script.values.PixelAccessibleValue;

@SuppressWarnings("unused")
public class DrawFunctions {

    @ScarpetFunction
    public void draw_background(PGraphics graphics, int color) {
        graphics.background(color);
    }

    @ScarpetFunction
    public void draw_rect(PGraphics graphics, float a, float b, float c, float d) {
        graphics.rect(a,b,c,d);
    }
    
    @ScarpetFunction
    public void draw_ellipse(PGraphics graphics, float a, float b, float c, float d) {
        graphics.ellipse(a,b,c,d);
    }

    @ScarpetFunction
    public void draw_line(PGraphics graphics, float x1, float y1, float x2, float y2) {
        graphics.line(x1, y1, x2, y2);
    }

    @ScarpetFunction
    public void draw_image(PGraphics graphics, PixelAccessibleValue<?> image, float x, float y, float w, float h) {
        graphics.image(image.getGraphics(), x, y, w, h);
    }

    @ScarpetFunction
    public void draw_text(PGraphics graphics, String text, float x, float y) {
        graphics.text(text, x, y);
    }
}
