package br.ufal.ic.extract.minerator;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import br.ufal.ic.stats.MethodStats;

public class MethodVisitor extends ASTVisitor {

	private String methodName;
	private int numberOfStatements = 0;

	public boolean visit(MethodDeclaration node) {
		String[] parameter = {"("};
		if(node.parameters() != null){
			node.parameters().forEach( n -> {
				parameter[0] +=  n.toString() + ",";
				});		
		}
		if(parameter[0].length() > 1){
			parameter[0] = parameter[0].substring(0, parameter[0].length() - 1);
		}
		
		parameter[0] += ")";
		methodName = node.getName() + parameter[0];

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