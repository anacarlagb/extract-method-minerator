package br.ufal.ic.minerator;


import java.io.ByteArrayInputStream;

import br.com.metricminer2.domain.Commit;
import br.com.metricminer2.parser.jdt.JDTRunner;
import br.com.metricminer2.persistence.PersistenceMechanism;
import br.com.metricminer2.scm.CommitVisitor;
import br.com.metricminer2.scm.SCMRepository;

public class DevelopersVisitor implements CommitVisitor {

//	public void process(SCMRepository repo, Commit commit, PersistenceMechanism writer) {
//		
//		NumberOfMethodsVisitor visitor = new NumberOfMethodsVisitor();
//		new JDTRunner().visit(visitor, new ByteArrayInputStream(m.getSourceCode().getBytes()));
//		
//		visitor.getResult();
//		
//		writer.write(
//			commit.getHash(),
//			commit.getCommitter().getName()
//		);
//
//	}

	
	//C:\Users\Ana Carla\workspace\SweetHome3D
	public String name() {
		return "developers";
	}

	public void process(SCMRepository repo, Commit commit, PersistenceMechanism writer) {
		// TODO Auto-generated method stub
		
	}

}