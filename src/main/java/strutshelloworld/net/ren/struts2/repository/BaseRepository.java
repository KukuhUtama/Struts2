package strutshelloworld.net.ren.struts2.repository;

import java.util.List;


/**
 * The Interface BaseRepository.
 *
 * @param <T> the generic type
 */
public interface BaseRepository<T> {

	/**
	 * Adds the.
	 *
	 * @param entity the entity
	 */
	public  void add(T entity);

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	public void deleteById(int id);

	/**
	 * Gets the by id.
	 *
	 * @param id the id
	 * @return the by id
	 */
	public  T getById(int id);

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public  List<T> getAll();

}
