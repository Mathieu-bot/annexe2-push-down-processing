package org.example.service;

import org.example.database.DBConnection;
import org.example.model.VoteTypeCount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {

    private final DBConnection dbConnection = new DBConnection();

    public long countAllVotes() {
        String sql = "SELECT COUNT(vote_type) FROM vote;";
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
