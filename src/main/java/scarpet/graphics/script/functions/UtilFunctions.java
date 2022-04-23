package scarpet.graphics.script.functions;

import carpet.script.annotation.ScarpetFunction;
import processing.core.PGraphics;

@SuppressWarnings("unused")
public class UtilFunctions {
    @ScarpetFunction
    public int color(PGraphics graphics, float v1, float v2, float v3, float v4) {
        return graphics.color(v1,v2,v3,v4);
    }

    @ScarpetFunction
    public void fill(PGraphics graphics, int col) {
        graphics.fill(col);
    }

    @ScarpetFunction
    public void no_fill(PGraphics graphics) {
        graphics.noFill();
    }

    @ScarpetFunction
    public void stroke(PGraphics graphics, int color) {
        graphics.stroke(color);
    }

    @ScarpetFunction
    public void no_stoke(PGraphics graphics) {
        graphics.noStroke();
    }

    @ScarpetFunction
    public void stroke_weight(PGraphics graphics, float weight) {
        graphics.strokeWeight(weight);
    }

    @ScarpetFunction
    public void smooth(PGraphics graphics) {
        graphics.smooth();
    }

    @ScarpetFunction
    public void no_smooth(PGraphics graphics) {
        graphics.noSmooth();
    }
}
