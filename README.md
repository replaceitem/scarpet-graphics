# scarpet-graphics

A wrapper of [Processing](https://processing.org) for scarpet

## Values

This extension adds two new scarpet values:

* `image`: Wrapper for [PImage](https://processing.org/reference/PImage.html)
* `graphics`: Wrapper for [PGraphics](https://processing.org/reference/PGraphics.html), extends `image` value (meaning it can be used in the same way `image` can)

Colors are handled using numbers (0xRRGGBBAA in hex), but can be constructed from RGB and HSB using the `color` function.

## Functions

**For a more detailed documentation for these functions, see the [Processing reference](https://processing.org/reference)**
Most functions are just a wrapper function for the internal processing function.
Sometimes they may have slightly different names than the original Processing functions, due to the name being already used by scarpet (e.g. `copy()`) or to group them (all `draw_?()` functions).

### Graphics and Image functions

#### `load_image(location)`

Loads an image from the specified `location` (string).
Can be a URL, or file path (absolute path, does not work like scarpe's `read_file`)
Returns an `image` value.

#### `save_image(image, location)`

Saves the `image` in the specified `location` (also an absolute path)

#### `create_graphics(width, height)`

Creates a new `graphics` object with the specified dimensions.

#### `copy_image(source, desination, sourceX, sourceY, sourceW, sourceH, destinationX, destinationY, destinationW, destinationH)`

Copies pixels from one image/graphics to another.

#### `get_pixel(image, x, y)`

Returns the color of a certain pixel.

#### `set_pixel(image, x, y, color)`

Sets the pixel on the image to the color.

#### `begin_draw(graphics)`

Prepares the graphics object for doing drawing operations on it.

#### `end_draw(graphics)`

To be called when done drawing.

### Drawing functions

See the [2D Primitives](https://processing.org/reference/#shape) section in the processing reference. (The scarpet functions have `draw_` prefixed with the processing function names)

#### `draw_background(graphics, color)`
#### `draw_rect(graphics, a, b, c, d)`
#### `draw_ellipse(graphics, a, b, c, d)`
#### `draw_line(graphics, x1, y1, x2, y2)`
#### `draw_image(graphics, a, b, c, d)`

### Mode functions

#### `color_mode(graphics, mode)`

`mode`s: `'RGB'`, `'HSB'`

#### `image_mode(graphics, mode)`

`mode`s: `'CORNER'`, `'CORNERS'`, `'CENTER'`

#### `ellipse_mode(graphics, mode)`

`mode`s: `'CORNER'`, `'CORNERS'`, `'CENTER'`, `'RADIUS'`

#### `rect_mode(graphics, mode)`

`mode`s: `'CORNER'`, `'CORNERS'`, `'CENTER'`, `'RADIUS'`

### Utility functions

#### `color(graphics, v1, v2, v3, alpha)`

Depending on the `color_mode()` set, v1,v2,v3 are either r,g,b or h,s,b values

#### `fill(graphics, color)`
#### `no_fill(graphics)`
#### `stroken(graphics, color)`
#### `no_stroke(graphics)`
#### `stroke_weight(graphics, weight)`
#### `smooth(graphics)`
#### `no_smooth(graphics)`