package br.ufal.ic.method.stats;

public class CommitStats {
	private String commitHash;
	private int numberOfStatements;
	
	public CommitStats(String commitHash, int numberOfStatements) {
		super();
		this.commitHash = commitHash;
		this.numberOfStatements = numberOfStatements;
	}

	public String getCommitHash() {
		return commitHash;
	}

	public int getNumberOfStatements() {
		return numberOfStatements;
	}
	
	
	
}
