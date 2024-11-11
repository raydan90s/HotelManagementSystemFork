package myclasses;

import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageLoader {

    public static ImageIcon loadImageIcon(String path, int width, int height) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(Objects.requireNonNull(ImageLoader.class.getResource(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (image == null) {
            throw new IllegalArgumentException("Image could not be loaded from path: " + path);
        }
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
}