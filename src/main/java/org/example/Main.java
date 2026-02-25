package org.example;

import org.example.service.DataRetriever;

public class Main {
  public static void main(String[] args) {

      DataRetriever dataRetriever = new DataRetriever();
      System.out.println("totalVote= " + dataRetriever.countAllVotes());
      dataRetriever.countVotesByType().forEach(voteTypeCount -> System.out.println(voteTypeCount.getVoteType() + " | " + voteTypeCount.getCount()));  }
}
