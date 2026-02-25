package org.example.service;

import org.example.database.DBConnection;
import org.example.model.VoteType;
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

    public List<VoteTypeCount> countVotesByType() {
        String sql = """
               SELECT vote_type, COUNT(vote_type) AS count
               FROM vote
               GROUP BY vote_type
               ORDER BY vote_type;
               """;
        List results = new ArrayList<>();

        try (Connection connection = dbConnection.getDBConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery())
        {
            while (rs.next()) {
                VoteTypeCount voteTypeCount = new VoteTypeCount(
                        VoteType.valueOf(rs.getString(1)),
                        rs.getLong(2)
                );
                results.add(voteTypeCount);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return results;
    }
}

