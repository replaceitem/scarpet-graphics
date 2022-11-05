package net.replaceitem.scarpet.graphics.script.functions;

import carpet.script.annotation.ScarpetFunction;
import carpet.script.value.ListValue;
import carpet.script.value.StringValue;
import carpet.script.value.Value;
import processing.core.PFont;
import processing.core.PGraphics;
import net.replaceitem.scarpet.graphics.mixins.PGraphicsAccessor;

import java.util.Arrays;

import static net.replaceitem.scarpet.graphics.ConstantsUtil.*;
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
    public void no_stroke(PGraphics graphics) {
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

    @ScarpetFunction
    public Value font_list() {
        return ListValue.wrap(Arrays.stream(PFont.list()).map(StringValue::new));
    }

    @ScarpetFunction
    public void text_font(PGraphics graphics, PFont font) {
        graphics.textFont(font);
    }

    @ScarpetFunction
    public void text_size(PGraphics graphics, float size) {
        graphics.textSize(size);
    }

    @ScarpetFunction
    public PFont create_font(PGraphics graphics, String name, float size, boolean smooth) {
        return ((PGraphicsAccessor) graphics).callCreateFont(name, size, smooth, null);
    }

    @ScarpetFunction
    public void text_align(PGraphics graphics, String alignX, String alignY) {
        graphics.textAlign(getTextAlignX(alignX),getTextAlignY(alignY));
    }
}
