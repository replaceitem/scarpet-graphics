package net.replaceitem.scarpet.graphics;

import carpet.script.exception.InternalExpressionException;
import processing.core.PConstants;

public class ConstantsUtil {
    public static int getColorMode(String mode) {
        if(mode.equalsIgnoreCase("RGB")) return PConstants.RGB;
        if(mode.equalsIgnoreCase("HSB")) return PConstants.HSB;
        throw new InternalExpressionException("Invalid color mode: " + mode);
    }

    public static int getImageMode(String mode) {
        if(mode.equalsIgnoreCase("CORNER")) return PConstants.CORNER;
        if(mode.equalsIgnoreCase("CORNERS")) return PConstants.CORNERS;
        if(mode.equalsIgnoreCase("CENTER")) return PConstants.CENTER;
        throw new InternalExpressionException("Invalid image mode: " + mode);
    }

    public static int getEllipseMode(String mode) {
        if(mode.equalsIgnoreCase("CENTER")) return PConstants.CENTER;
        if(mode.equalsIgnoreCase("RADIUS")) return PConstants.RADIUS;
        if(mode.equalsIgnoreCase("CORNER")) return PConstants.CORNER;
        if(mode.equalsIgnoreCase("CORNERS")) return PConstants.CORNERS;
        throw new InternalExpressionException("Invalid ellipse mode: " + mode);
    }

    public static int getRectMode(String mode) {
        if(mode.equalsIgnoreCase("CENTER")) return PConstants.CENTER;
        if(mode.equalsIgnoreCase("RADIUS")) return PConstants.RADIUS;
        if(mode.equalsIgnoreCase("CORNER")) return PConstants.CORNER;
        if(mode.equalsIgnoreCase("CORNERS")) return PConstants.CORNERS;
        throw new InternalExpressionException("Invalid rect mode: " + mode);
    }

    public static int getTextAlignX(String mode) {
        if(mode.equalsIgnoreCase("LEFT")) return PConstants.LEFT;
        if(mode.equalsIgnoreCase("CENTER")) return PConstants.CENTER;
        if(mode.equalsIgnoreCase("RIGHT")) return PConstants.RIGHT;
        throw new InternalExpressionException("Invalid X text align: " + mode);
    }

    public static int getTextAlignY(String mode) {
        if(mode.equalsIgnoreCase("TOP")) return PConstants.TOP;
        if(mode.equalsIgnoreCase("CENTER")) return PConstants.CENTER;
        if(mode.equalsIgnoreCase("BOTTOM")) return PConstants.BOTTOM;
        if(mode.equalsIgnoreCase("BASELINE")) return PConstants.BASELINE;
        throw new InternalExpressionException("Invalid Y text align: " + mode);
    }
}
