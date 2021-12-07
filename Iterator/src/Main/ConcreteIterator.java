package Main;

import java.util.ArrayList;

public class ConcreteIterator implements MyIterator
{
	private ArrayList<Integer> list;
	private int current=-1;
	public ConcreteIterator(ArrayList<Integer> list)
	{
		this.list=list;
	}
	@Override
	public boolean hasNext() {
		return(current+1) < list.size();
	}

	@Override
	public int next() {
		current++;
		return list.get(current);
	}

}
