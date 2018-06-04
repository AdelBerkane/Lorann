package view;

import java.awt.event.KeyEvent;
import controller.ControllerOrder;
import controller.IController;

public class Eventperformer implements IEventperformer {
	
	private final IController orderPerformer;
	
	/**
	 * Sets the orderPerformer as the current orderperformer
	 * @param orderPerformer the user order
	 */
	public Eventperformer(final IController orderPerformer) {
		this.orderPerformer = orderPerformer;
	}
	
	
	/**
	 * Sends the current keyCode at KeyCodeToUserOrder when a KeyEvent appears
	 * @param KeyCode Press on keyboard
	 */
	
	public void eventPerform(final KeyEvent keyCode) {
		this.keyCodeToUserOrder(keyCode.getKeyCode());
	}
	
	/**
	 * allows to recover keystrokes of the user and to set this KeyEvent as the order of the user.
	 * @param keyCode Press on keyboard
	 */
	
	private void keyCodeToUserOrder(final int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_UP:
			orderPerformer.orderPerform(ControllerOrder.UP);
			break;
		case KeyEvent.VK_DOWN:
			orderPerformer.orderPerform(ControllerOrder.DOWN);
			break;
		case KeyEvent.VK_RIGHT:
			orderPerformer.orderPerform(ControllerOrder.RIGHT);
			break;
		case KeyEvent.VK_LEFT:
			orderPerformer.orderPerform(ControllerOrder.LEFT);
			break;
		case KeyEvent.VK_SPACE:
			orderPerformer.orderPerform(ControllerOrder.SHOOT);
			break;
		case KeyEvent.VK_Z:
			orderPerformer.orderPerform(ControllerOrder.UP);
			break;
		case KeyEvent.VK_S:
			orderPerformer.orderPerform(ControllerOrder.DOWN);
			break;
		case KeyEvent.VK_Q:
			orderPerformer.orderPerform(ControllerOrder.LEFT);
			break;
		case KeyEvent.VK_D:
			orderPerformer.orderPerform(ControllerOrder.RIGHT);
			break;
		}
	}

	
}
