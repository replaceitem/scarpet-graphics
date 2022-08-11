package scarpet.graphics.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import processing.core.PFont;
import processing.core.PGraphics;

@Mixin(PGraphics.class)
public interface PGraphicsAccessor {
    @Invoker(remap = false)
    PFont callCreateFont(String name, float size, boolean smooth, char[] charset);
}
