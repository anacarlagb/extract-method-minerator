package br.ufal.ic.extract.minerator;


import br.com.metricminer2.domain.Commit;
import br.com.metricminer2.persistence.PersistenceMechanism;
import br.com.metricminer2.scm.CommitVisitor;
import br.com.metricminer2.scm.SCMRepository;

public class DevelopersVisitor implements CommitVisitor {

	public void process(SCMRepository repo, Commit commit, PersistenceMechanism writer) {
		writer.write(
			commit.getHash(),
			commit.getCommitter().getName()
		);

	}

	public String name() {
		return "developers";
	}

}