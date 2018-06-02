package model;

import java.io.StringWriter;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import javax.imageio.ImageIO;

/**
 * Class Sprite
 * 
 * @author adel
 *
 */

public class Sprite extends StringWriter implements ISprite {
	private Image image;

	/**
	 * replaces character with corresponding image
	 * 
	 * @param c
	 *            Stores the image
	 * @param image
	 *            Gets the image which corresponds to the sprite
	 */

	public Sprite(final String c, final String image) {
		this.write(c);
		try {
			this.image = ImageIO.read(new File("sprite/" + image + ".png"));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Search the sprite vertical_bone
	 * 
	 * @param c
	 *            Stores the image
	 */
	
	public Sprite(final String c) {
		this(c, "vertical_bone");
	}
	
	public Image getImage() {
		
		return null;
	}
	/**
	 * Set the String 'image' to the sprite in which it corresponds.
	 */
	
	public void setImage(String image) {
		try {
			this.image = ImageIO.read(new File("sprite/" + image +".png"));
		} catch (final IOException e) {
			e.printStackTrace();
		}
		
	}

}
