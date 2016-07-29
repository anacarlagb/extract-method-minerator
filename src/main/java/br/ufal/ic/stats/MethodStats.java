package br.ufal.ic.stats;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.ufal.ic.extract.minerator.csv.CsvWriter;



public class MethodStats {

	private String id;
	
	private List<CommitStats> statementsPerCommit;
	
	public MethodStats(String id) {
		this.id = id;
		statementsPerCommit = new LinkedList<CommitStats>();
	}
	
	public void put(String commit, Integer numberOfStatements) {
		statementsPerCommit.add(new CommitStats(commit, numberOfStatements));
	}
	
	
	public String getId(){
		return id;
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
		return null;
	}

	
	public List<CommitStats> getStatementsPerCommit() {
		return statementsPerCommit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void writeHistoric(CsvWriter writer) throws IOException {
		// TODO Auto-generated method stub
		writer.write(id);
		int numberCommits = statementsPerCommit.size();
		for(int index = numberCommits - 1; index >= 0; index --){
			int numberOfStatements = statementsPerCommit.get(index).getNumberOfStatements();
			writer.write(Integer.toString(numberOfStatements));
		}
	}
	
	
}