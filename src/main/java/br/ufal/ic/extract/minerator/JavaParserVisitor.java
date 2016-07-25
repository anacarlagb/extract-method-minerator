package br.ufal.ic.extract.minerator;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import br.com.metricminer2.domain.Commit;
import br.com.metricminer2.parser.jdt.JDTRunner;
import br.com.metricminer2.persistence.PersistenceMechanism;
import br.com.metricminer2.scm.CommitVisitor;
import br.com.metricminer2.scm.RepositoryFile;
import br.com.metricminer2.scm.SCMRepository;
import br.ufal.ic.stats.MethodStats;
import br.ufal.ic.stats.ProjectStats;

public class JavaParserVisitor implements CommitVisitor {
	
	private ProjectStats projectStats = new ProjectStats("projectName");

	public void process(SCMRepository repo, Commit commit, PersistenceMechanism writer) {
		try {
			repo.getScm().checkout(commit.getHash());
		
			List<RepositoryFile> files = repo.getScm().files();
			
			for(RepositoryFile file : files) {
				if(!file.fileNameEndsWith("java")) continue;
				
				File soFile = file.getFile();
				
				MethodVisitor visitor = new MethodVisitor();
				new JDTRunner().visit(visitor, new ByteArrayInputStream(readFile(soFile).getBytes()));
				projectStats.setMethod(commit.getHash(), 
									   visitor.getMethodName(),
									   visitor.getNumberOfStatements());
				
				writer.write(
						commit.getHash(),
						file.getFullName()
				);
				
			}
			
		} finally {
			repo.getScm().reset();
		}
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