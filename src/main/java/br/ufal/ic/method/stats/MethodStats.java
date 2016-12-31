package br.ufal.ic.method.stats;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import br.ufal.ic.method.historic.minerator.csv.CsvWriter;



public class MethodStats {

	private String methodName;
	private String className;
	private List<CommitStats> statementsPerCommit;
	
	public MethodStats(String className, String methodName) {
		this.className =  className;
		this.methodName = methodName;
		statementsPerCommit = new LinkedList<CommitStats>();
	}
	
	public void put(String commit, Integer numberOfStatements) {
		statementsPerCommit.add(new CommitStats(commit, numberOfStatements));
	}
	
	
	public String getMethodName(){
		return methodName;
	}
	
	
	
	public String getClassName() {
		return className;
	}

	public Integer getNumberOfStatments(String commit){
		Optional<CommitStats> commitStatsOptional =  statementsPerCommit
																.stream()
																.filter(commitStatsFilter -> 
																		commitStatsFilter.getCommitHash().equals(commit))
																.findFirst();
		if(commitStatsOptional.isPresent()){
			return commitStatsOptional.get().getNumberOfStatements();
		}
		return 0;
	}

	
	public List<CommitStats> getStatementsPerCommit() {
		return statementsPerCommit;
	}
	
	public void writeHistoric(CsvWriter writer) throws IOException {
		// TODO Auto-generated method stub
		writer.write(className);
		writer.write(methodName);
		int numberCommits = statementsPerCommit.size();
		for(int index = numberCommits - 1; index >= 0; index --){
			int numberOfStatements = statementsPerCommit.get(index).getNumberOfStatements();
			
			String numberOfStatementsAsText = Integer.toString(numberOfStatements);
			if(numberOfStatementsAsText == null || numberOfStatementsAsText.isEmpty()){
				numberOfStatementsAsText = Integer.toString(0);
			}
			writer.write(numberOfStatementsAsText);
		}
	}
		

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((methodName == null) ? 0 : methodName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MethodStats other = (MethodStats) obj;
		if (methodName == null) {
			if (other.methodName != null)
				return false;
		} else if (!methodName.equals(other.methodName))
			return false;
		return true;
	}


	
}