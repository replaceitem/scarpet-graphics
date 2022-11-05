package net.replaceitem.scarpet.graphics.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import processing.core.PApplet;
import processing.core.PGraphics;

@Mixin(PGraphics.class)
public class PGraphicsMixin {
    @Redirect(method = "createFont", at = @At(value = "FIELD",target = "Lprocessing/core/PApplet;pixelDensity:I"), remap = false)
    private int defaultPixelDensity(PApplet instance) {
        return 1;
    }
}
