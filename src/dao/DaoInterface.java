package dao;

import java.util.List;

public interface DaoInterface <T>{
	public List<T> searchAll();
	public T search(int element);
	public void insert(T newElement);
	public void update(T element);
	public void delete(T element);
}
