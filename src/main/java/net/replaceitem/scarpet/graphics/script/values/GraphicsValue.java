package net.replaceitem.scarpet.graphics.script.values;

import org.jetbrains.annotations.NotNull;
import processing.core.PGraphics;

public class GraphicsValue extends PixelAccessibleValue<PGraphics> {
    
    public GraphicsValue(PGraphics graphics) {
        super(graphics);
    }

    @Override
    public @NotNull String getTypeString() {
        return "graphics";
    }
}
