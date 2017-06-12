package model;

public interface EvaluationRule<T, U> {
	public boolean validateEvaluation(T item, U user);
}

