package dao;

import java.util.List;

import model.User;

public class UserDao implements DaoInterface<User>{
	
	private Dao<User> daoAdapter = new Dao<User>(User.class);

	@Override
	public List<User> searchAll() {
		return daoAdapter.findAll();
	}

	@Override
	public User search(int elemento) {
		return daoAdapter.findById(elemento);
	}

	@Override
	public void insert(User novo) {
		daoAdapter.saveOrUpdate(novo);
	}

	@Override
	public void update(User elemento) {
		daoAdapter.saveOrUpdate(elemento);
	}

	@Override
	public void delete(User elemento) {
		daoAdapter.delete(elemento);
	}
	
	


}
