import java.util.List;

import dao.Dao;
import dao.UserDao;
import model.User;

public class EvaluationFramework {
	
	public static void main(String[] args) throws InterruptedException {
		
		/* Exemplo com Dao */
		UserDao userDao = new UserDao();
		
		User user = new User();
		user.setName("Mariah");
		user.setDescription("Description Mariah");		
		userDao.insert(user);
		
		/* Exemplo Dao Generico */
		Dao<User> dao = new Dao<User>(User.class);
		
		User novoUser = new User();
		novoUser.setName("Joseh");
		novoUser.setDescription("Description Joseh");
		dao.saveOrUpdate(novoUser);
		
		/* Consulta */
		List<User> users = userDao.searchAll();
		
		System.out.println("Usuários no banco de dados");
		for (User u : users){
			System.out.println("User id=" + u.getId() + " " + u.getName() + " " + u.getDescription());
		}
		
		
		
	}

}
