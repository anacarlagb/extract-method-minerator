package br.ufal.ic.extract.minerator;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import br.ufal.ic.stats.MethodStats;

public class MethodVisitor extends ASTVisitor {

	private String methodName;
	private int numberOfStatements;

	public boolean visit(MethodDeclaration node) {
		methodName = node.getName().getFullyQualifiedName();
		numberOfStatements = node.getBody().getLength();
		return super.visit(node);
	}


	public String getMethodName() {
		return methodName;
	}


	public int getNumberOfStatements() {
		return numberOfStatements;
	}
	

	
}