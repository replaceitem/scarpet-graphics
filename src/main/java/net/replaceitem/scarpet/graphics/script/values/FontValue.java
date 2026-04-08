package net.replaceitem.scarpet.graphics.script.values;

import carpet.script.value.Value;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
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
    public Tag toTag(boolean force, RegistryAccess regs) {
        return StringTag.valueOf(getString());
    }
}
