package br.ufal.ic.stats;

import java.util.HashMap;
import java.util.Map;

public class MethodStats {

	private String id;
	
	private Map<String, Integer> statementsPerCommit = new HashMap<String, Integer>();
	
	public MethodStats(String id) {
		this.id = id;
	}
	
	public void put(String commit, Integer numberOfStatements) {
		statementsPerCommit.put(commit, numberOfStatements);
	}
	
	
	public String getId(){
		return id;
	}
	
	public Integer getNumberOfStatments(String commit){
		return statementsPerCommit.get(commit);
	}
}