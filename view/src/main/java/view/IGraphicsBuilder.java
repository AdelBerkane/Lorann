package view;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
public interface IGraphicsBuilder {
	public void applyModelToGraphic(Graphics graphics, ImageObserver observer);
	public int getGlobalWidth();
	public int getGlobalHeoght();
	

}
