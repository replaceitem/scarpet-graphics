package net.replaceitem.scarpet.graphics.script.functions;

import carpet.script.Context;
import carpet.script.annotation.ScarpetFunction;
import carpet.script.argument.FileArgument;
import net.replaceitem.scarpet.graphics.script.values.PixelAccessibleValue;
import org.apache.commons.lang3.tuple.Pair;
import org.jspecify.annotations.Nullable;
import processing.awt.PGraphicsJava2D;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;
import net.replaceitem.scarpet.graphics.ScarpetGraphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Optional;

@SuppressWarnings({"unused", "OptionalUsedAsFieldOrParameterType"})
public class GraphicsFunctions {
    @ScarpetFunction(maxParams = 2)
    @Nullable
    public PImage load_image(Context c, String location, Optional<Boolean> shared) {
        try {
            try {
                URL url = URI.create(location).toURL();
                return new PImage(ImageIO.read(url));
            } catch (MalformedURLException | IllegalArgumentException e) {
                Pair<String, String> resource = FileArgument.recognizeResource(location, false, FileArgument.Type.ANY);
                FileArgument fileArgument = new FileArgument(resource.getLeft(), FileArgument.Type.ANY, resource.getRight(), false, shared.orElse(false), FileArgument.Reason.READ, c.host);
                if(c.host.main == null) return null;
                @Nullable BufferedImage[] img = new @Nullable BufferedImage[]{null};
                fileArgument.findPathAndApply(c.host.main, path -> {
                    try {
                        img[0] = ImageIO.read(path.toAbsolutePath().toFile());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
                return new PImage(img[0]);
            }
        } catch (IOException e) {
            ScarpetGraphics.LOGGER.error(e);
            return null;
        }
    }

    @ScarpetFunction(maxParams = 3)
    public void save_image(Context c, PixelAccessibleValue<?> image, String location, Optional<Boolean> shared) {
        Pair<String, String> resource = FileArgument.recognizeResource(location, false, FileArgument.Type.ANY);
        FileArgument fileArgument = new FileArgument(resource.getLeft(), FileArgument.Type.ANY, resource.getRight(), false, shared.orElse(false), FileArgument.Reason.READ, c.host);
        if(c.host.main == null) return;
        fileArgument.findPathAndApply(c.host.main, path -> {
            image.getGraphics().save(path.toAbsolutePath().toString());
        });
    }

    @ScarpetFunction
    public PGraphics create_graphics(int w, int h) {
        PGraphicsJava2D pg = new PGraphicsJava2D();
        pg.setPrimary(false);
        pg.setSize(w, h);
        pg.colorMode(PConstants.RGB,255,255,255,255);
        return pg;
    }

    @ScarpetFunction
    public void copy_image(PixelAccessibleValue<?> source, PixelAccessibleValue<?> destination, int sourceX, int sourceY, int sourceW, int sourceH, int destinationX, int destinationY, int destinationW, int destinationH) {
        destination.getGraphics().copy(source.getGraphics(), sourceX, sourceY, sourceW, sourceH, destinationX, destinationY, destinationW, destinationH);
    }

    @ScarpetFunction
    public int get_pixel(PixelAccessibleValue<?> graphics, int x, int y) {
        return graphics.getColorAt(x,y);
    }

    @ScarpetFunction
    public void set_pixel(PixelAccessibleValue<?> graphics, int x, int y, int color) {
        graphics.getGraphics().set(x, y, color);
    }

    @ScarpetFunction
    public void begin_draw(PGraphics graphics) {
        graphics.beginDraw();
    }

    @ScarpetFunction
    public void end_draw(PGraphics graphics) {
        graphics.endDraw();
    }
}
