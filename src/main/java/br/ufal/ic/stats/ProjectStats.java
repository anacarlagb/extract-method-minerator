package br.ufal.ic.stats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class ProjectStats {
	private String nameProject;
	private Map<String, MethodStats> methodsStatsMap;
	private Set<String> commits;
	
	public ProjectStats(String nameProject){
		this.nameProject = nameProject;
		methodsStatsMap = new LinkedHashMap<String, MethodStats>();;
		commits = new LinkedHashSet<String>();
	}

	public void createMethodStats(String commit, String methodName, int numberOfStatements) {
		// TODO Auto-generated method stub
		if(methodsStatsMap.containsKey(methodName)){
			methodsStatsMap.get(methodName).put(commit, numberOfStatements);
		}else{
			MethodStats methodStats = new MethodStats(methodName);
			methodStats.put(commit, numberOfStatements);
			methodsStatsMap.put(methodName, methodStats);
		}
	}

	public Map<String, MethodStats>  getMethodStatsMap(){
		return methodsStatsMap;
	}

	public void writeHistoric(){
		System.out.print("           ");
		commits.forEach(commit -> System.out.print(commit + "| "));
		System.out.println();
<<<<<<< HEAD
		methodsStatsMap 
=======
		methodsStatsMap
>>>>>>> 712dba9ac4e37f94caa0783f566320ec7f612f3f
			.entrySet()
			.forEach( methodStatsMap ->{
				System.out.print(methodStatsMap.getKey() + "  |");
				methodStatsMap
				        .getValue()
				        .getStatementsPerCommit()
				        .entrySet()
				        .forEach( statementPerCommit -> {
				        	System.out.print(statementPerCommit.getValue() + "   |");
				        });
				System.out.println();
			});
		methodsStatsMap
			.entrySet()
			.forEach( methodStatsMap -> {
				methodStatsMap.getValue();
			});
	}
	
	public void addCommit(String commit){
		commits.add(commit);
	}
	
}
