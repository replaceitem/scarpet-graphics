package net.replaceitem.scarpet.graphics.script.values;

import carpet.script.value.Value;
import org.jetbrains.annotations.NotNull;
import processing.core.PImage;

public class ImageValue extends PixelAccessibleValue<PImage> {
    public ImageValue(PImage image) {
        super(image);
    }

    @Override
    public @NotNull String getTypeString() {
        return "image";
    }

    @Override
    public @NotNull Value deepcopy() {
        try {
            return new ImageValue((PImage) this.graphics.clone());
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
