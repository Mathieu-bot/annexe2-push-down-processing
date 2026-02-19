package org.example.model;

public class VoteTypeCount {

    private final VoteType voteType;
    private final long count;

    public VoteTypeCount(VoteType voteType, long count) {
        this.voteType = voteType;
        this.count = count;
    }

    public VoteType getVoteType() {
        return voteType;
    }

    public long getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "VoteTypeCount{" +
                "voteType=" + voteType +
                ", count=" + count +
                '}';
    }
}
