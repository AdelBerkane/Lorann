package model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import model.Entity;

public abstract class DAOEntity<E extends Entity> {
	protected final Connection connection;

	/**
	 * Instantiates a new DAO entity.
	 * 
	 * @param connection
	 * @throws SQLException
	 */
	public DAOEntity(final Connection connection) throws SQLException {
		this.connection = connection;
	}

	protected Connection getConnection() {
		return this.connection;
	}

	/**
	 * Create the entity, returns true if successful
	 *
	 */
	public abstract boolean create(E entity);

	/**
	 * Delete the entity, returns true if successful
	 */
	public abstract boolean delete(E entity);

	/**
	 * Updates the entity, returns true if successful
	 */
	public abstract boolean update(E entity);

	/**
	 * Finds the entity, returns true if successful
	 */

	public abstract E find(int Id);

	/**
	 * Finds the key
	 */

	public abstract E find(String key);

	public DrawMap find(int X, int Y) {
		return null;
	}

}
