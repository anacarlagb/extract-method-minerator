package br.ufal.ic.extract_method_minerator;

import static org.junit.Assert.assertEquals;


import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.ufal.ic.extract.minerator.csv.CsvWriter;
import br.ufal.ic.stats.MethodStats;

import org.junit.Test;


import br.ufal.ic.stats.ProjectStats;

public class ProjectStatsTest {

	
	@Test
	public void shouldCreateMethodStatsMap() throws IOException{
		ProjectStats projectStats = new ProjectStats("projectTest", "C:\\Users\\Ana Carla\\ProjetosAnalisados\\TestHistoricJUnitDemo.csv");

		//populando

		projectStats.createMethodStats("commit3", "method1", 3);
		projectStats.createMethodStats("commit3", "method2", 5);
		projectStats.createMethodStats("commit3", "method3", 9);
		
		projectStats.createMethodStats("commit2", "method1", 12);
		projectStats.createMethodStats("commit2", "method2", 5);
		projectStats.createMethodStats("commit2", "method3", 3);
		
		projectStats.createMethodStats("commit1", "method1", 6);
		projectStats.createMethodStats("commit1", "method2", 8);
		projectStats.createMethodStats("commit1", "method3", 8);
		
		
		projectStats.addCommit("commit3");
		projectStats.addCommit("commit2");
		projectStats.addCommit("commit1");
		projectStats.createHistoricBackup("C:\\Users\\Ana Carla\\ProjetosAnalisados\\TestHistoricJUnitDemo.csv");;

		assertEquals(projectStats.getMethodStatsMap().size(), 3);

		assertEquals(projectStats.getMethodStatsMap()
				 	.get("method1").getNumberOfStatments("commit3").intValue(), 3);
		assertEquals(projectStats.getMethodStatsMap()
			 	.get("method1").getNumberOfStatments("commit2").intValue(), 12);
		
		assertEquals(projectStats.getMethodStatsMap()
			 	.get("method2").getNumberOfStatments("commit3").intValue(), 5);
		assertEquals(projectStats.getMethodStatsMap()
				.get("method2").getNumberOfStatments("commit2").intValue(), 5);
		
		assertEquals(projectStats.getMethodStatsMap()
			 	.get("method1").getNumberOfStatments("commit3").intValue(), 3);
		
		assertEquals(projectStats.getMethodStatsMap()
				.get("method3").getNumberOfStatments("commit1").intValue(), 8);
		

		
		//Set commit 

				
	
	}

	



}
