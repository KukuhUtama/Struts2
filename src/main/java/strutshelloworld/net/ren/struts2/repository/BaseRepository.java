package strutshelloworld.net.ren.struts2.repository;

import java.util.List;

public interface BaseRepository<T> {

	public  void add(T entity);

	public void deleteById(int id);

	public  T getById(int id);

	public  List<T> getAll();

}
