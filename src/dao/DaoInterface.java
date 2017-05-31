package dao;

import java.util.List;

public interface DaoInterface <T>{
	public List<T> searchAll();
	public T search(int elemento);
	public void insert(T novo);
	public void update();
	public void delete(T elemento);
}
