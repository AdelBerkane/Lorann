package model;

public class Gate extends Motionless {
	public boolean open;
	/**
	 * Sets if the door is open or closed
	 * 
	 * @param state
	 * State of the door (open or closed)
	 * @param position
	 * Position of the gate
	 */
	
	public Gate(String state, Position position) {
		super(new Sprite(/*signeàmettre*/"gate_"+ state), ObstacleType.PENETRABLE, position);
		if(state == "open")
			open = true;
		else
			open = false;
	}
	
	/**
	 * Sets true for isGate
	 */
	
	public boolean isGate() {
		return true;
	}

}
