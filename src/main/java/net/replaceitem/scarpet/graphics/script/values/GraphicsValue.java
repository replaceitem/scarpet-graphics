package net.replaceitem.scarpet.graphics.script.values;

import processing.core.PGraphics;

public class GraphicsValue extends PixelAccessibleValue<PGraphics> {
    
    public GraphicsValue(PGraphics graphics) {
        super(graphics);
    }

    @Override
    public String getTypeString() {
        return "graphics";
    }
}
