package dao;

import java.util.List;

public interface DaoInterface <T>{
	public List<T> searchAll();
	public T search(String elementName);
	public void insert(T newElement);
	public void update();
	public void delete(T element);
}
