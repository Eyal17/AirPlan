package Model.Repository;
import java.util.ArrayList;

public interface TemplateRepository <K,V> {
	public void add(V v);
	public void delete(K k);
	public ArrayList<V> getTable();
	public int getMaxID();
	//public void print();
	//public V find(K k);
}



