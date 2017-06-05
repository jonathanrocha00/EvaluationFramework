package service;

import java.util.List;

import dao.DaoInterface;
import model.Evaluation;

public class EvaluationService implements ServiceInterface<Evaluation> {

	// Attributes ====================================================
	private DaoInterface<Evaluation> evaluationDao;

	// Constructors ==================================================
	public EvaluationService(DaoInterface<Evaluation> evaluationDao) {
			this.evaluationDao = evaluationDao;
		}

	// Methods =======================================================
	public List<Evaluation> searchAll() {
		return evaluationDao.searchAll();
	}

	public Evaluation search(String elementName) {
		throw new UnsupportedOperationException("Not implemented.");
	}
	
	// Implementar a verifica��o das regras e tudo mais que est� na cria��o de uma avalia��o.
	public void insert(Evaluation newElement) {
		evaluationDao.insert(newElement);
	}

	public void update() {
		evaluationDao.update();
	}

	public void delete(Evaluation element) {
		evaluationDao.delete(element);
	}
}
