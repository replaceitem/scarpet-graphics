package scarpet.graphics;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.script.CarpetExpression;
import carpet.script.annotation.AnnotationParser;
import carpet.script.annotation.OutputConverter;
import carpet.script.annotation.SimpleTypeConverter;
import carpet.script.annotation.ValueCaster;
import carpet.script.value.NumericValue;
import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.api.ModInitializer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.core.PImage;
import scarpet.graphics.script.functions.DrawFunctions;
import scarpet.graphics.script.functions.GraphicsFunctions;
import scarpet.graphics.script.functions.ModeFunctions;
import scarpet.graphics.script.functions.UtilFunctions;
import scarpet.graphics.script.values.FontValue;
import scarpet.graphics.script.values.GraphicsValue;
import scarpet.graphics.script.values.ImageValue;
import scarpet.graphics.script.values.PixelAccessibleValue;

public class ScarpetGraphics implements CarpetExtension, ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("scarpet/graphics");

	@Override
	public void onInitialize() {
		CarpetServer.manageExtension(this);
		ScarpetGraphics.LOGGER.info("scarpet-graphics loaded");
	}


	@Override
	public void onGameStarted() {
		//why is this not in SimpleTypeConverter
		SimpleTypeConverter.registerType(NumericValue.class, Float.class, NumericValue::getFloat, "number");
		
		SimpleTypeConverter.registerType(ImageValue.class, PImage.class, ImageValue::getGraphics, "image");
		SimpleTypeConverter.registerType(GraphicsValue.class, PGraphics.class, GraphicsValue::getGraphics, "graphics");
		SimpleTypeConverter.registerType(FontValue.class, PFont.class, FontValue::getFont, "font");
		
		OutputConverter.registerToValue(PImage.class, ImageValue::new);
		OutputConverter.registerToValue(PGraphics.class, GraphicsValue::new);
		OutputConverter.registerToValue(PFont.class, FontValue::new);

		ValueCaster.register(PixelAccessibleValue.class, "pixel_accessible_value");
		
		AnnotationParser.parseFunctionClass(GraphicsFunctions.class);
		AnnotationParser.parseFunctionClass(DrawFunctions.class);
		AnnotationParser.parseFunctionClass(ModeFunctions.class);
		AnnotationParser.parseFunctionClass(UtilFunctions.class);
	}

	@Override
	public void onServerLoaded(MinecraftServer server) {
		
	}

	@Override
	public void onServerClosed(MinecraftServer server) {
		
	}

	@Override
	public void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher) {
		
	}

	@Override
	public void scarpetApi(CarpetExpression expression) {
		
	}
}
