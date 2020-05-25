package Model.Repository;

public interface templateRepository <K,V> {
	public void add(V v);
	public void delete(K k);
	public void print();
	public V find(K k);	
}




