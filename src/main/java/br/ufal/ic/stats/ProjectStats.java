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
import utils.Utils;

public class ProjectStats {
	private String nameProject;
	private Map<String, MethodStats> methodsStatsMap;
	private Set<String> commits;
	private CsvWriter writer;
	
	public ProjectStats(String nameProject){
		this.nameProject = nameProject;
		methodsStatsMap = new LinkedHashMap<String, MethodStats>();;
		commits = new LinkedHashSet<String>();
		
	}

	public void createMethodStats(String commit, String className, String methodName, int numberOfStatements) {
		// TODO Auto-generated method stub
		String key = Utils.generateKey(className, methodName);
		if(methodsStatsMap.containsKey(key)){
			methodsStatsMap.get(key).put(commit, numberOfStatements);
		}else{
			MethodStats methodStats = new MethodStats(className, methodName);
			methodStats.put(commit, numberOfStatements);
			methodsStatsMap.put(key, methodStats);
		}
	}

	public Map<String, MethodStats>  getMethodStatsMap(){
		return methodsStatsMap;
	}

	public void writeHistoric(String projectStatsUrl) throws IOException{		
		writer = new CsvWriter(projectStatsUrl , ',', Charset.forName("ISO-8859-1"));
		List<String> commitsSet = new ArrayList<>(commits);
		writer.write("Commits\\Methods");
		
		//Writing method names
		List<String> methodsSet = new ArrayList<>(methodsStatsMap.keySet()); 
		for(int i = methodsSet.size() -1 ; i >= 0; i--){
			MethodStats method = methodsStatsMap.get(methodsSet.get(i));
			writer.write(method.getClassName());
			writer.write(method.getMethodName());
		}
		writer.endRecord();
		
		//Writing commit and numberOfStatements per commit for each method. 
		for(int idx = commitsSet.size() - 1; idx >= 0 ; idx --){
			String commit = commitsSet.get(idx);
			writer.write(commit);
			for(int i = methodsSet.size() -1 ; i >= 0; i--){
				MethodStats method = methodsStatsMap.get(methodsSet.get(i));
				int numberOfStatementsPerCommit = method.getNumberOfStatments(commit);
				writer.write(Integer.toString(numberOfStatementsPerCommit));
			}
			writer.endRecord();
		}
		
		
		writer.close();
			
	}
	
	public void createHistoricBackup(String path) throws IOException{
		writer = new CsvWriter(path , ',', Charset.forName("ISO-8859-1"));
		writer.write("fileName");
		writer.write("methodName");
		List<String> commitsSet = new ArrayList<>(commits);
		
		//Writing commit
		for(int idx = commitsSet.size() - 1; idx >= 0 ; idx --){
			System.out.print(commitsSet.get(idx) + " ");
			writer.write(commitsSet.get(idx));
		}
		writer.endRecord();
		
		//Writing method id and numberOfStatements per commit for each method. 
 		List<String> methodsSet = new ArrayList<>(methodsStatsMap.keySet());  
 		for(int i = methodsSet.size() -1 ; i >= 0; i--){
			MethodStats method = methodsStatsMap.get(methodsSet.get(i));
			method.writeHistoric(writer);
 			writer.endRecord();
 		}	
		writer.close();
		
	}
	
	public void addCommit(String commit){
		commits.add(commit);
	}
	
}
