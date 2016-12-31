package br.ufal.ic.method.historic.minerator;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

import br.com.metricminer2.domain.Commit;
import br.com.metricminer2.parser.jdt.JDTRunner;
import br.com.metricminer2.persistence.PersistenceMechanism;
import br.com.metricminer2.scm.CommitVisitor;
import br.com.metricminer2.scm.RepositoryFile;
import br.com.metricminer2.scm.SCMRepository;
import br.ufal.ic.method.stats.ProjectStats;

public class JavaParserVisitor implements CommitVisitor {

	private static ProjectStats projectStats = new ProjectStats("HsqlDB");
	int countMethodNull = 0;
	
	public void process(SCMRepository repo, Commit commit, PersistenceMechanism writer) {
		
		
		try {
			repo.getScm().checkout(commit.getHash());
			List<RepositoryFile> files = repo.getScm().files();
			
			for(RepositoryFile file : files) {
				if(!file.fileNameEndsWith("java")) continue;	
				File soFile = file.getFile();
				MethodVisitor visitor = new MethodVisitor();
				
				new JDTRunner().visit(visitor, new ByteArrayInputStream(readFile(soFile).getBytes()));
		
				String fileName = soFile.getPath();
				if(visitor == null){
					MethodVisitor visitor1 = visitor;
				}
				String nameMethod = visitor.getMethodName();


				if(visitor.getMethodName() == null){
					countMethodNull ++;
					nameMethod = "invalid-name-method-" + String.valueOf(countMethodNull);
				}
				
				projectStats.addCommit(commit.getHash());
				projectStats.createMethodStats(commit.getHash(), 
											   fileName,
											   nameMethod,
											   visitor.getNumberOfStatements());
				
              
			}
			
		} finally {
			repo.getScm().reset();
		}


	}
	
	
	
	public static ProjectStats getProjectStats() {
		return projectStats;
	}



	private String readFile(File f) {
		try {
			FileInputStream input = new FileInputStream(f);
			String text = IOUtils.toString(input);
			input.close();
			return text;
		} catch (Exception e) {
			throw new RuntimeException("error reading file " + f.getAbsolutePath(), e);
		}
	}
	

	public String name() {
		return "java-parser";
	}

}