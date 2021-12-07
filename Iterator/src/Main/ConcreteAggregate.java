package Main;

import java.util.ArrayList;

public class ConcreteAggregate implements Aggregate
{
	private ArrayList<Integer> list;
	public ConcreteAggregate()
	{
		list=new ArrayList<Integer>();
	}
	@Override
	public MyIterator createIterator() /*mi serve per poter accedere alla lista senza esporne il contenuto*/
	{
		return new ConcreteIterator(list); 
	}

	@Override
	public void add(int num) 
	{
		list.add(num);
	}

}