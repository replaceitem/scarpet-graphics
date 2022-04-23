package scarpet.graphics.script.values;

import carpet.script.value.NumericValue;
import carpet.script.value.Value;
import net.minecraft.nbt.NbtElement;
import processing.core.PImage;
import scarpet.graphics.PixelPos;

public abstract class PixelAccessibleValue<T extends PImage> extends Value {
    protected final T graphics;

    public PixelAccessibleValue(T graphics) {
        this.graphics = graphics;
    }

    public T getGraphics() {
        return graphics;
    }

    protected Value getProperty(String property) {
        return switch (property) {
            case "width", "w" -> NumericValue.of(graphics.width);
            case "height", "h" -> NumericValue.of(graphics.height);
            default -> Value.NULL;
        };
    }

    public int getColorAt(PixelPos pixelPos) {
        return getColorAt(pixelPos.x,pixelPos.y);
    }

    public int getColorAt(int x, int y) {
        return graphics.get(x,y);
    }

    @Override
    public Value in(Value value1) {
        PixelPos pixelPos = PixelPos.ofValue(value1);
        if(pixelPos != null) {
            return NumericValue.of(getColorAt(pixelPos));
        }
        return getProperty(value1.getString());
    }

    @Override
    public String getString() {
        return getTypeString();
    }

    @Override
    public int length() {
        return graphics.width*graphics.height;
    }

    @Override
    public boolean getBoolean() {
        return true;
    }

    @Override
    public NbtElement toTag(boolean force) {
        return null;
    }
}
