package model.dao;
import java.sql.*;

import model.ReturnHighScore;


public class DAOScore extends DAOEntity<ReturnHighScore> {
	private int scoregame;
	
	
	public DAOScore(Connection connection) throws SQLException{
		super(connection);
	}
	
	@Override
	public boolean create(final ReturnHighScore entity) {
		return false;
	}
	@Override public boolean delete(final ReturnHighScore entity) {
		return false;
	}
	@Override
	public boolean update(final ReturnHighScore entity) {
		return false;
	}
	
	public int returnHighScore() {
		try
		{final String sql = "{call get_score()}";
		final CallableStatement call = this.getConnnection().prepareCall(sql);
		call.execute();
		final ResultSet result = call.getResultSet();
		while(result.next())
		{
			scoregame += result.getInt("Score");
		}
		}
		catch (final SQLException e) {
			e.printStackTrace();
		}
		return scoregame;
	}
	
	public void saveScore(int scoregame, int resurrectiongame, int levelgame) throws SQLException{
		try {
			final String sql = "{call set_score(?,?,?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1,  scoregame);
			call.setInt(2, resurrectiongame);
			call.setInt(3, levelgame);
			
			call.execute();
		}
		catch (final SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getscore() {
		return this.scoregame;
	}
	public model.ReturnHighScore find1(int score){
		return null;
	}
	@Override
	public model.ReturnHighScore find(int id){
		return null;
	}
	@Override
	public model.ReturnHighScore find(String SPRITE){
		return null;
	}
}
