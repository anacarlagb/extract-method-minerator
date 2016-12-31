package br.ufal.ic.method.historic.minerator;

import java.io.IOException;

import br.com.metricminer2.MetricMiner2;
import br.com.metricminer2.RepositoryMining;
import br.com.metricminer2.Study;
import br.com.metricminer2.persistence.csv.CSVFile;
import br.com.metricminer2.scm.GitRepository;
import br.com.metricminer2.scm.commitrange.Commits;
import utils.Utils;

public class MyStudy implements Study{
	
	
	public static void main(String[] args) {
		new MetricMiner2().start(new MyStudy());
	}
	
	public void execute() {
		JavaParserVisitor visitor = new JavaParserVisitor();
		new RepositoryMining()
		.in(GitRepository.singleProject(Utils.CLIP_URL))
		.through(Commits.all())
		.process(visitor, new CSVFile(Utils.RESOURCE))
		.mine();
		
		try {
			
			JavaParserVisitor.getProjectStats().createHistoricBackup(Utils.CLIP_CSV_BACKUP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
