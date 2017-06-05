package abstractdaos;

import java.util.List;

import model.Evaluation;

public abstract class UserDAO {
	abstract public List<Evaluation> getMadeEvaluations();
}
