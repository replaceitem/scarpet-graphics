package net.replaceitem.scarpet.graphics.script.values;

import carpet.script.value.Value;
import net.minecraft.nbt.NbtElement;
import processing.core.PFont;

public class FontValue extends Value {
    
    private final PFont font;
    
    public PFont getFont() {
        return this.font;
    }
    
    public FontValue(PFont font) {
        this.font = font;
    }
    
    @Override
    public String getString() {
        return font.getName();
    }

    @Override
    public String getTypeString() {
        return "font";
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
