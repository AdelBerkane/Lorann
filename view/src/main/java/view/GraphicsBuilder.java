package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import model.IModel;
import model.*;

public class GraphicsBuilder implements IGraphicsBuilder {
	private final IModel buildgraph;
	
	/**
	 * Constructor of the graphicsBuilder, allows to recover information from the model and display them
	 * 
	 * @param buildgraph retrieve the movel
	 */
	
	public GraphicsBuilder(final IModel buildgraph) {
		this.buildgraph = buildgraph;
	}
	
	/**
	 * allows to display every elements of the map
	 * 
	 * @param graphics drawing tool
	 * @param observer Allows to be an observer of the model
	 */
	
	public void applyModelToGraphic(final Graphics graphics, final ImageObserver observer) {
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, this.buildgraph, getWidth()*32, this.buildgraph.getWidth()*32+40);
		
		for (int y=0; y < this.getGlobalHeight(); y++) {
			for (int x = 0; x < this.getGlobalWidth(); x++) {
				graphics.drawImage(this.buildgraph.getImageByPosition(x,y), x*32, y*32, 32, 32, null);
			}
		}
		graphics.setColor(Color.GREEN);
		graphics.setFont(new Font("Helvetica", Font.BOLD, 24));
		graphics.drawString("resurrection :" + this.buildgraph.getResurection() + "score :" + this.buildgraph.getScore(), 15, 415);
	}
	/**
	 * Allows to recover the global width of the map, used to put the element at the right position
	 * returns the global width
	 */
	
	public int getGlobalWidth() {
		return this.buildgraph.getWidth();
	}
	
	/**
	 * Allow to recover the global height of the map, used to put the element at the right position
	 * returns the global height
	 */
	
	public int getGlobalHeight() {
		return this.buildgraph.getHeight();
	}

}
