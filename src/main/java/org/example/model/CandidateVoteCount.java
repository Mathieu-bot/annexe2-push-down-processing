package org.example.model;

public class CandidateVoteCount {

    private final String candidateName;
    private final long validVoteCount;

    public CandidateVoteCount(String candidateName, long validVoteCount) {
        this.candidateName = candidateName;
        this.validVoteCount = validVoteCount;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public long getValidVoteCount() {
        return validVoteCount;
    }

    @Override
    public String toString() {
        return candidateName + "=" + validVoteCount;
    }
}
