package org.example.service;

import org.example.database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataRetriever {

    private final DBConnection dbConnection = new DBConnection();

    public long countAllVotes() {
        String sql = "SELECT COUNT(*) FROM vote;";
        try (Connection connection = dbConnection.getDBConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery())
            {
                rs.next();
                return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
