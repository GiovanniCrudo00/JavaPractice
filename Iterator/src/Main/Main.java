package Main;

public class Main {

	public static void main(String[] args) 
	{
		Aggregate agg = new ConcreteAggregate();
		agg.add(5);agg.add(23);agg.add(35);
		MyIterator iterator = agg.createIterator(); /*Creo l' iterator del mio aggregate*/
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}
