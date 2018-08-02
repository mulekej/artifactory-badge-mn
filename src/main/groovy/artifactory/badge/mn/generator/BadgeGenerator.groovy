package artifactory.badge.mn.generator

import java.awt.*
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

        alignFont(graphics, (left + right), MAX_HEIGHT, TEXT_MARGIN)

        final def leftWidth = graphics.fontMetrics.stringWidth(left)
        final def rightWidth = graphics.fontMetrics.stringWidth(right)

        graphics.paint = GRAY
        graphics.fillRoundRect(0, 0, ROUNDED_ARC * 2, MAX_HEIGHT, ROUNDED_ARC, ROUNDED_ARC)
        graphics.fillRect(ROUNDED_ARC, 0, leftWidth + (2 * TEXT_MARGIN) - ROUNDED_ARC, MAX_HEIGHT)

        if (success) {
            graphics.paint = GREEN
        } else {
            graphics.paint = RED
        }

        graphics.fillRoundRect(leftWidth + (2 * TEXT_MARGIN), 0, rightWidth + (2 * TEXT_MARGIN), MAX_HEIGHT, ROUNDED_ARC, ROUNDED_ARC)
        graphics.fillRect(leftWidth + (2 * TEXT_MARGIN), 0, ROUNDED_ARC, MAX_HEIGHT)

        //draw text
        def lineMetrics = graphics.font.getLineMetrics(left, graphics.getFontRenderContext())

        int y = (int)lineMetrics.getAscent() + TEXT_MARGIN
        graphics.setPaint(Color.WHITE)
        graphics.drawString(left, TEXT_MARGIN, y)
        graphics.drawString(right, leftWidth + (3 * TEXT_MARGIN), y)

        graphics.dispose()
        int imageWidth = leftWidth + rightWidth + (4 * TEXT_MARGIN)
        def result = image.getSubimage(0, 0, imageWidth < MAX_WIDTH ? imageWidth : MAX_WIDTH, MAX_HEIGHT)
        result
    }

    private static void alignFont(Graphics2D graphics, String text, int height, int margin) {
        final def font = graphics.font
        final def diff = (height - (2 * margin)) / font.getLineMetrics(text, graphics.getFontRenderContext()).getHeight()

        graphics.setFont(font.deriveFont((font.getSize() * diff) as float))
    }
}
