package artifactory.badge.mn.generator

import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D
import java.awt.RenderingHints
import java.awt.image.BufferedImage

class BadgeGenerator {
    private static final def MAX_WIDTH = 200
    private static final def MAX_HEIGHT = 20
    private static final def TEXT_MARGIN = 2
    private static final def ROUNDED_ARC = 7

    private static final def GREEN = new Color(36, 188, 0)
    private static final def RED = new Color(222, 99, 71)
    private static final def GRAY = new Color(94, 94, 94)


    static BufferedImage generate(String left, String right, boolean success) {
        final def image = new BufferedImage(MAX_WIDTH, MAX_HEIGHT, BufferedImage.TYPE_INT_ARGB)
        final def graphics = image.createGraphics()

        graphics.renderingHints[RenderingHints.KEY_ANTIALIASING] = RenderingHints.VALUE_ANTIALIAS_ON

        allignFont(graphics, (left + right), MAX_HEIGHT, TEXT_MARGIN)

        final def leftWidth =
        final def rightWidth = 

        image
    }

    private static void allignFont(Graphics2D graphics, String text, int height, int margin) {
        final def font = graphics.getFont()
        final def diff = (height - (2 * margin)) / font.getLineMetrics(text, graphics.getFontRenderContext()).getHeight()

        graphics.setFont(font.deriveFont(font.getSize() * diff))
    }
}
