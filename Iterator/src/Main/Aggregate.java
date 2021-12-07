package Main;

public interface Aggregate 
{
	public MyIterator createIterator();
	public void add(int num);
}
