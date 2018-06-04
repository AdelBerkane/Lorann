package model;

import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import model.Direction;
import model.IMobile;
import model.IModel;
import model.Position;


public class Model extends Observable implements IModel {
	
	private ArrayList<IMobile> mobiles = new ArrayList<IMobile>();
	public ArrayList<Elements> ListElements = new ArrayList<Elements>();
	public Elements elements[][];
	protected int Width = 20;
	protected int Height = 5;
	protected int actualMap = 0;
	protected int score = 0;
	protected int resurection = 0;
	protected boolean gameWin = false;
	protected boolean gameLose = false;
	protected Map map;
	protected String mapLevel = "";
	
	/**
	 * Sets width, height, and instanciates the array of element.
	 * @param Width
	 * @param Height
	 * @throws SQLException
	 */
	public Model(int Width, int Height) throws SQLException{
		this.Width = Width;
		this.Height = Height;
		this.elements = new Elements[this.Height][this.Width];
		
	}

	@Override
	public Example getExampleById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Example getExampleByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Example> getAllExamples() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
