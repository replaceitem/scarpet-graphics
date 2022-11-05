package net.replaceitem.scarpet.graphics.script.functions;

import carpet.script.annotation.ScarpetFunction;
import processing.core.PGraphics;

import static net.replaceitem.scarpet.graphics.ConstantsUtil.*;

@SuppressWarnings("unused")
public class ModeFunctions {

    @ScarpetFunction
    public void color_mode(PGraphics graphics, String mode) {
        graphics.colorMode(getColorMode(mode));
    }
    
    @ScarpetFunction
    public void image_mode(PGraphics graphics, String mode) {
        graphics.imageMode(getImageMode(mode));
    }

    @ScarpetFunction
    public void ellipse_mode(PGraphics graphics, String mode) {
        graphics.ellipseMode(getEllipseMode(mode));
    }

    @ScarpetFunction
    public void rect_mode(PGraphics graphics, String mode) {
        graphics.rectMode(getRectMode(mode));
    }
}
