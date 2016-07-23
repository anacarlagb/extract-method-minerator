package br.ufal.ic.stats;

import java.util.ArrayList;
import java.util.List;

public class ProjectStats {
	private String nameProject;
	List<MethodStats> methodsStats;
	
	public ProjectStats(String nameProject){
		this.nameProject = nameProject;
		methodsStats = new ArrayList<MethodStats>();
	}
	
}
