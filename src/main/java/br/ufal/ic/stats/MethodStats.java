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
	
	
}