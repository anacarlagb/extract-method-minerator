package br.ufal.ic.extract_method_minerator;

import static org.junit.Assert.assertEquals;

<<<<<<< HEAD
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.ufal.ic.extract.minerator.csv.CsvWriter;
import br.ufal.ic.stats.MethodStats;
=======
import org.junit.Test;

>>>>>>> 712dba9ac4e37f94caa0783f566320ec7f612f3f
import br.ufal.ic.stats.ProjectStats;

public class ProjectStatsTest {

	
	@Test
	public void shouldCreateMethodStatsMap(){
		ProjectStats projectStats = new ProjectStats("projectTest");
<<<<<<< HEAD
		//populando
=======
>>>>>>> 712dba9ac4e37f94caa0783f566320ec7f612f3f
		projectStats.createMethodStats("commit1", "method1", 3);
		projectStats.createMethodStats("commit1", "method2", 5);
		projectStats.createMethodStats("commit1", "method3", 9);
		
		projectStats.createMethodStats("commit2", "method1", 12);
		projectStats.createMethodStats("commit2", "method2", 5);
		projectStats.createMethodStats("commit2", "method3", 3);
		
		projectStats.createMethodStats("commit3", "method1", 6);
		projectStats.createMethodStats("commit3", "method2", 8);
		projectStats.createMethodStats("commit3", "method3", 8);
		
		assertEquals(projectStats.getMethodStatsMap().size(), 3);
<<<<<<< HEAD
		
		
=======
>>>>>>> 712dba9ac4e37f94caa0783f566320ec7f612f3f
		assertEquals(projectStats.getMethodStatsMap()
				 	.get("method1").getNumberOfStatments("commit1").intValue(), 3);
		assertEquals(projectStats.getMethodStatsMap()
			 	.get("method1").getNumberOfStatments("commit2").intValue(), 12);
		
		assertEquals(projectStats.getMethodStatsMap()
			 	.get("method2").getNumberOfStatments("commit1").intValue(), 5);
		assertEquals(projectStats.getMethodStatsMap()
				.get("method2").getNumberOfStatments("commit2").intValue(), 5);
		
		assertEquals(projectStats.getMethodStatsMap()
			 	.get("method1").getNumberOfStatments("commit1").intValue(), 3);
		
		assertEquals(projectStats.getMethodStatsMap()
				.get("method3").getNumberOfStatments("commit3").intValue(), 8);
		
<<<<<<< HEAD
		
		//Set commit 
=======
>>>>>>> 712dba9ac4e37f94caa0783f566320ec7f612f3f
		projectStats.addCommit("commit1");
		projectStats.addCommit("commit2");
		projectStats.addCommit("commit3");
		projectStats.writeHistoric();
		
	
	}
<<<<<<< HEAD
	
	
	@Test
	public void shouldCreateMethodStatsMap2(){
		ProjectStats projectStats = new ProjectStats("projectTest");
		//populando
		projectStats.createMethodStats("commit1", "method1", 3);
		projectStats.createMethodStats("commit1", "method2", 5);
		projectStats.createMethodStats("commit1", "method3", 9);
		
		projectStats.createMethodStats("commit2", "method1", 12);
		projectStats.createMethodStats("commit2", "method2", 5);
		projectStats.createMethodStats("commit2", "method3", 3);
		
		projectStats.createMethodStats("commit3", "method1", 6);
		projectStats.createMethodStats("commit3", "method2", 8);
		projectStats.createMethodStats("commit3", "method3", 8);
		
		//Set commit 
		projectStats.addCommit("commit1");
		projectStats.addCommit("commit2");
		projectStats.addCommit("commit3");
		projectStats.writeHistoric();
		
		 CsvWriter wr = new CsvWriter("D:\\arq.csv");
		 
		 projectStats.getMethodStatsMap().entrySet().forEach(
				  methodsStats -> {
					  
					  methodsStats.getKey(); // nome do metodo;
					  methodsStats.getValue(); // corpo do metodo
					  
					  methodsStats
					  .getValue()
					  .getStatementsPerCommit()
					  .entrySet()
					  .forEach( methodStats ->{
						methodStats.getKey(); //commit 
						methodStats.getValue();  // numero de linhas do metodo no commit
						 try {
							writer.write(methodStats.getKey());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  });
				  }
				 );
		
//	     objTests.readCSV();
//	     objTests.fill();
//	     objTests.writeCSV(methodsProject.toString());
		
	
	}
	
	@Test
	public void shouldWriteMethodsInCSV(){
		List<MethodStats> methodsProject = new ArrayList<MethodStats>();
		MethodStats  method1 = new MethodStats("print()");
		method1.put("commit1", 5);
		method1.put("commit2", 10);
		method1.put("commit3", 11);
		method1.put("commit4", 40);
		methodsProject.add(method1);
		
		MethodStats  method2 = new MethodStats("run()");
		method2.put("commit1",5);
		method2.put("commit2",13);
		method2.put("commit3", 15);
		methodsProject.add(method2);
		
		for(int i = 0; i< methodsProject.size() ; i++){
			System.out.print(methodsProject.get(i).getId() + ",");
			methodsProject.get(i).getStatementsPerCommit().entrySet()
	        .forEach( statementPerCommit -> {
	        	System.out.print(statementPerCommit.getValue() + "   |");
	        });
		
		 CsvWriter writer = new CsvWriter("D:\\arq.csv");
//		 writer.write(methodsProject);
//	     objTests.readCSV();
//	     objTests.fill();
//	     objTests.writeCSV(methodsProject.toString());
//				
	}
}

=======
>>>>>>> 712dba9ac4e37f94caa0783f566320ec7f612f3f
}
