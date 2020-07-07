package Model.Repository;
import java.util.ArrayList;

/* A generic class for the repositories  */
public interface TemplateRepository <K,V> {
	public void add(V v);
	public void delete(K k);
	public ArrayList<V> getTable();
	public int getMaxID();
}



