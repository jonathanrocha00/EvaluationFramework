package control;

import java.util.List;

import abstractdaos.UserDAO;
import model.Evaluation;

public class UserService {
	// Attributes ====================================================
	private UserDAO userDao;
	
	// Constructors ==================================================
	public UserService(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	// Methods =======================================================
	public List<Evaluation> getMadeEvaluations() {
		
		return userDao.getMadeEvaluations();
	}
}
