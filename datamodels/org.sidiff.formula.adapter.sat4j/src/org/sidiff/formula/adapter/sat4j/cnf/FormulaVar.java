package org.sidiff.formula.adapter.sat4j.cnf;

final class FormulaVar extends Formula {

	final String name;

	final Var var;

	public FormulaVar(String name, Var var) {
		this.name = name;
		this.var = var;
	}

	<A> A accept(FormulaVisitor<A> visitor) {
		return visitor.visitVar(this);
	}

	@Override
	public String toString() {
		return name + "["+var.toString()+"]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final FormulaVar other = (FormulaVar) obj;
		if (this.var != other.var && (this.var == null || !this.var.equals(other.var))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 41 * hash + (this.var != null ? this.var.hashCode() : 0);
		return hash;
	}

}
