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
	 * 
	 * @param orderPerformer
	 *            user order
	 * @param buildgraph
	 *            Model
	 * @param observale
	 *            Allows the frame to be observable
	 */
	public ViewFacade(final IController orderPerformer, final IModel buildgraph, final Observable observable) {
		this.observable = observable;
		this.graphicsBuilder = new GraphicsBuilder(buildgraph);
		this.eventPerformer = new Eventperformer(orderPerformer);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Displays a menu at the end of the game
	 * 
	 * @param message
	 *            Win or Lose
	 */

	public ControllerOrder displayMessage(final String message) {
		Object[] possibleValues = { "Reload level", "Load level 1", "Load level 2", "Load level 3", "Load level 4",
				"Load level 5", "Quit" };
		Object selectedValue = JOptionPane.showInputDialog(null, message + ", Choose one:", message,
				JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
		return this.orderToController(selectedValue);
	}

	/**
	 * KeyEvents for controller
	 */

	private ControllerOrder orderToController(Object selectedValue) {
		if (selectedValue == "Quit") {
			return ControllerOrder.QUIT;
		} else if (selectedValue == "Reload level") {
			return ControllerOrder.AGAIN;
		} else if (selectedValue == "Load level 1") {
			return ControllerOrder.LEVEL1;
		} else if (selectedValue == "Load level 2") {
			return ControllerOrder.LEVEL2;
		} else if (selectedValue == "Load level 3") {
			return ControllerOrder.LEVEL3;
		} else if (selectedValue == "Load level 4") {
			return ControllerOrder.LEVEL4;
		} else if (selectedValue == "Load level 5") {
			return ControllerOrder.LEVEL5;
		} else {
			return ControllerOrder.QUIT;
		}
	}

	/**
	 * Runs a new frame
	 */

	public void run() {
		this.boardframe = new BoardFrame("Lorann");
	}

	public void closeAll() {
		this.boardframe.dispose();
	}

}
