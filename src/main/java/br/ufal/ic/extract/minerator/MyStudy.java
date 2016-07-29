package br.ufal.ic.extract.minerator;

import java.io.IOException;

import br.com.metricminer2.MetricMiner2;
import br.com.metricminer2.RepositoryMining;
import br.com.metricminer2.Study;
import br.com.metricminer2.persistence.csv.CSVFile;
import br.com.metricminer2.scm.GitRepository;
import br.com.metricminer2.scm.commitrange.Commits;

public class MyStudy implements Study{
	
	
	public static void main(String[] args) {
		new MetricMiner2().start(new MyStudy());
	}
	
	public void execute() {
		JavaParserVisitor visitor = new JavaParserVisitor();
		new RepositoryMining()
		.in(GitRepository.singleProject("C:\\Users\\Ana Carla\\Dropbox\\UFAL\\junitdemo"))
		.through(Commits.all())
		.process(visitor, new CSVFile("C:\\Users\\Ana Carla\\ProjetosAnalisados\\TestHistoricJUnitDemo.csv"))
		.mine();
		
		try {
			visitor.getProjectStats().writeHistoric();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
