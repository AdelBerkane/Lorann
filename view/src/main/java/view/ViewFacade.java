package view;

import javax.swing.JOptionPane;
import java.util.Observable;
import javax.swing.SwingUtilities;

import controller.ControllerOrder;
import model.IModel;
import showboard.BoardFrame;
import controller.IController;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView, Runnable {
	private final GraphicsBuilder graphicsBuilder;
	private final Eventperformer eventPerformer;
	private final Observable observable;
	private BoardFrame boardframe;

    /**
     * Instantiates a new view.
     * @param orderPerformer	user order
     * @param buildgraph	Model
     * @param observale		Allows the frame to be observable
     */
    public ViewFacade(final IController orderPerformer, final IModel buildgraph, final Observable observable) {
        this.observable = observable;
        this.graphicsBuilder = new GraphicsBuilder(buildgraph);
        this.eventPerformer = new Eventperformer(orderPerformer);
        SwingUtilities.invokeLater(this);
    }
    
    /**
     * Runs a new frame
     */
    
    public void run() {
    	this.boardframe = new BoardFrame("Lorann");
    }
  
    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final  void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    public void closeAll() {
    	this.boardframe.dispose();
    }

}
