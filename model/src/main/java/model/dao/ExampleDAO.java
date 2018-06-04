package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Example;

/**
 * <h1>The Class ExampleDAO.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class ExampleDAO extends AbstractDAO {

	private static String sqlLevelbyId = "{call LevelbyId(?,?)}";

	/** The id column index. */
	private static int idColumnIndex = 1;

	/** The name column index. */
	private static int symboleColumnIndex = 2;

	/**
	 * Gets the level by
	 *
	 * @param id
	 *            the id
	 * @return the example by id
	 * @throws SQLException
	 *             the SQL exception
	 */
	
	// just change <Example> by table name
	public static ArrayList<Example> getLevel(final int id1, final int id2) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlLevelbyId);
		final ArrayList<Example> examples = new ArrayList<Example>();
		callStatement.setInt(1, id1);
		callStatement.setInt(2, id2);

		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
				examples.add(new Example(result.getInt(idColumnIndex), result.getString(symboleColumnIndex)));
			}

			result.close();
		}
		return examples;
	}
}
