package br.ufal.ic.extract.minerator;

<<<<<<< HEAD



=======
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;
>>>>>>> 712dba9ac4e37f94caa0783f566320ec7f612f3f

import br.ufal.ic.stats.MethodStats;

public class MethodVisitor extends ASTVisitor {

	private String methodName;
	private int numberOfStatements = 0;

	public boolean visit(MethodDeclaration node) {
<<<<<<< HEAD
=======
		String parameter =  "(";
		node.parameters().parallelStream().forEach( n -> {
			parameter = parameter + "," + n.toString();
			});
>>>>>>> 712dba9ac4e37f94caa0783f566320ec7f612f3f
		methodName = node.getName().getFullyQualifiedName();
		if(node.getBody() != null){
			if(node.getBody().statements() != null){
				numberOfStatements = node.getBody().statements().size();
			}
		}
		return super.visit(node);
	}


	public String getMethodName() {
		return methodName;
	}


	public int getNumberOfStatements() {
		return numberOfStatements;
	}
	

	
}