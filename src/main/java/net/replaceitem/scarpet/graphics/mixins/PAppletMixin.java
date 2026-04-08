package net.replaceitem.scarpet.graphics.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import processing.core.PApplet;

@Mixin(PApplet.class)
public class PAppletMixin {
    @WrapOperation(method = "<clinit>", at = @At(value = "INVOKE", target = "Ljava/lang/String;indexOf(I)I"))
    private static int fixVersionParsingJava(String instance, int ch, Operation<Integer> original) {
        int index = original.call(instance, ch);
        if(index == -1) return instance.length();
        return index;
    }
}
