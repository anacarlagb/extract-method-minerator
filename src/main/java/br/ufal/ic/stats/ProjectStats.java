package br.ufal.ic.stats;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class ProjectStats {
	private String nameProject;
	Set<MethodStats> methodsStats;
	Set<String> commits;
	
	public ProjectStats(String nameProject){
		this.nameProject = nameProject;
		methodsStats = new HashSet<MethodStats>();
		commits = new HashSet<String>();
	}

	public void setMethod(String hash, String methodName, int numberOfStatements) {
		// TODO Auto-generated method stub
		MethodStats methodStats = new MethodStats(methodName); 
		if(methodsStats.contains(methodStats)){
			
//			methodsStats
//			.stream()
//			.filter( savedMethod -> savedMethod.equals(methodStats))
//			.map(savedMet -> savedMet.put(hash, numberOfStatements));
		}
	
	}
	
}
