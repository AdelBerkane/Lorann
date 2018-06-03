package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

final class LorannBDDConnector {

    
    private static LorannBDDConnector instance;                                                           /** The instance */
    private static String                  user     = "root";                                             /** The login */
    private static String                  password = "*E3F7432FB55072A66CD348BA29012F0A17010426";        /** The password */
    private static String                  url      = "jdbc:mysql://localhost/lorann?useSSL=false&serverTimezone=UTC"; /**The url*/
    private Connection                     connection;                                                    /** The connection */
    private Statement                                                                                     /** The statement */
    statement;
    
    private LorannBDDConnector() { /**Instantiates a new boulder dash BDD connector*/
        this.open();
    }
    public static LorannBDDConnector getInstance() {
        if (instance == null) {                                   /**Gets the single instance of BoulderDashBDDConnector.*/
            setInstance(new LorannBDDConnector());
        }
        return instance;
    }
    private static void setInstance(final LorannBDDConnector instance) {            /**Sets the instance*/
        LorannBDDConnector.instance = instance;
    }
         private boolean open() {
        try {
            this.connection = DriverManager.getConnection(LorannBDDConnector.url, LorannBDDConnector.user,
                    LorannBDDConnector.password);
            this.statement = this.connection.createStatement();         /**Open*/

            return true;
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }
    public ResultSet executeQuery(final String query) {
        try {                                                                 /**Execute query*/
            return this.getStatement().executeQuery(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public java.sql.CallableStatement prepareCall(final String query) {    /**Prepare call.*/
        try {
            return this.getConnection().prepareCall(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int executeUpdate(final String query) {         /**Execute update.*/
        try {
            return this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public Connection getConnection() {   /**Gets the connection*/
        return this.connection;
    }
    public void setConnection(final Connection connection) {  /**Sets the connection*/
        this.connection = connection;
    }
    public Statement getStatement() {  /**Gets the statement*/
        return this.statement;
    }
    public void setStatement(final Statement statement) {  /**Sets the statement.*/
        this.statement = statement;
    }

}
