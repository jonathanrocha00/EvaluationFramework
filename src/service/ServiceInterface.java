package service;

import java.util.List;

public interface ServiceInterface <T> {
	public List<T> searchAll();
	public T search(T elemento);
	public void insert(T novo);
	public void update();
	public void delete(T elemento);
}
