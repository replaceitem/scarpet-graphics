package net.replaceitem.scarpet.graphics;

import carpet.script.value.ListValue;
import carpet.script.value.NumericValue;
import carpet.script.value.Value;

import java.util.List;

public class PixelPos {
    public int x;
    public int y;
    
    public PixelPos(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public static PixelPos ofValue(Value value) {
        if(!(value instanceof ListValue listValue)) return null;
        List<Value> list = listValue.getItems();
        if(list.size() != 2) return null;
        int x = NumericValue.asNumber(list.get(0)).getInt();
        int y = NumericValue.asNumber(list.get(1)).getInt();
        return new PixelPos(x,y);
    }
}
