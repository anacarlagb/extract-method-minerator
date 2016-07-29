package br.ufal.ic.stats;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;

import br.ufal.ic.extract.minerator.csv.CsvWriter;

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

	public void writeHistoric() throws IOException{		
		CsvWriter writer = new CsvWriter("C:\\Users\\Ana Carla\\ProjetosAnalisados\\TestHistoricJUnitDemo.csv" , ',', Charset.forName("ISO-8859-1"));
		List<String> commitsSet = new ArrayList<>(commits);
		System.out.print(" ");
		for(int idx = commitsSet.size() - 1; idx >= 0 ; idx --){
			System.out.print(commitsSet.get(idx) + " ");
			writer.write(commitsSet.get(idx));
		}
		System.out.println();
		writer.endRecord();
		List<String> methodsSet = new ArrayList<>(methodsStatsMap.keySet());  
		for(int i = methodsSet.size() -1 ; i >= 0; i--){
			MethodStats method = methodsStatsMap.get(methodsSet.get(i));
			method.writeHistoric(writer);
			System.out.println();
			writer.endRecord();
		}
		
		writer.close();
				
	
		
	}
	
	public void addCommit(String commit){
		commits.add(commit);
	}
	
}
