package br.ufal.ic.extract_method_minerator;

import static org.junit.Assert.assertEquals;


import java.io.IOException;

import org.junit.Test;


import br.ufal.ic.method.stats.ProjectStats;
import utils.Utils;

public class ProjectStatsTest {

	
	@Test
	public void shouldCreateMethodStatsMap() throws IOException{
		ProjectStats projectStats = new ProjectStats("projectTest");

		//populando

		projectStats.createMethodStats("commit3", null, "method1", 3);
		projectStats.createMethodStats("commit3", null, "method2", 5);
		projectStats.createMethodStats("commit3", null, "method3", 9);
		
		projectStats.createMethodStats("commit2", null, "method1", 12);
		projectStats.createMethodStats("commit2", null, "method2", 5);
		projectStats.createMethodStats("commit2", null, "method3", 3);
		
		projectStats.createMethodStats("commit1", null, "method1", 6);
		projectStats.createMethodStats("commit1", null, "method2", 8);
		projectStats.createMethodStats("commit1", null, "method3", 8);
		
		
		projectStats.addCommit("commit3");
		projectStats.addCommit("commit2");
		projectStats.addCommit("commit1");
		projectStats.createHistoricBackup(Utils.RESOURCE);

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
		

	

				
	
	}

	



}
