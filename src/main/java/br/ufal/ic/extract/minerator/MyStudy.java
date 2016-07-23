package br.ufal.ic.extract.minerator;

import org.apache.log4j.Logger;

import br.com.metricminer2.MetricMiner2;
import br.com.metricminer2.RepositoryMining;
import br.com.metricminer2.Study;
import br.com.metricminer2.persistence.csv.CSVFile;
import br.com.metricminer2.scm.GitRepository;
import br.com.metricminer2.scm.commitrange.Commits;

public class MyStudy implements Study{
	
	static Logger log = Logger.getLogger(MyStudy.class);
		public static void main(String[] args) {
			new MetricMiner2().start(new MyStudy());
		}
		
		public void execute() {
			new RepositoryMining()
			.in(GitRepository.singleProject("C:\\Users\\Ana Carla\\ProjetosAnalisados\\SweetHome3D\\"))
			.through(Commits.all())
			.process(new DevelopersVisitor(), new CSVFile("C:\\Users\\Ana Carla\\ProjetosAnalisados\\TestLog4jHistoric.csv"))
			.mine();
		}
	
}
