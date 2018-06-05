package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOMap extends DAOEntity<DrawMap> {
	static String strmap = "";
	public int level;

	public DAOMap(Connection connection) throws SQLException {
		super(connection);
	}

	@Override
	public boolean create(final DrawMap entity) {
		return false;
	}

	@Override
	public boolean delete(final DrawMap entity) {
		return false;
	}

	@Override
	public boolean update(final DrawMap entity) {
		return false;
	}

	/**
	 * Calling a procedure that lets use choose the level
	 * 
	 * @param level
	 * @throws SQLException
	 */
	public void setLevel(int level) throws SQLException {
		try {
			final String sql = "{call set_level(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, level);
			call.execute();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Calling a procedure that retrieves the map
	 */

	public String DrawMap(int level) {
		try {
			strmap = "";
			final String sql = "{call display_map(?)}";
			CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, level);
			call.execute();
			ResultSet result = call.getResultSet();
			while (result.next()) {
				strmap += result.getString("SPRITE");
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return strmap;
	}

	public static String getstrmap() {
		return strmap;
	}

	@Override
	public DrawMap find(int X, int Y) {
		return null;
	}

	@Override
	public DrawMap find(String SPRITE) {
		return null;
	}

	@Override
	public DrawMap find(int Id) {
		return null;
	}
}
