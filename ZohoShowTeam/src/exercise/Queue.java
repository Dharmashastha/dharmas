package exercise;

import java.util.Objects;
import java.util.Vector;

public class Queue<E> {
	
	Vector<E> vector;
	
	public Queue() {
		vector = new Vector<>();
	}
	
	public boolean add(E e)
	{
		if(Objects.isNull(e))
		{
			throw new NullPointerException();
		}
		vector.add(e);
		return true;
	}

	public E element()
	{
		return vector.firstElement();
	}
	
	public boolean offer(E e)
	{
		if(Objects.isNull(e))
		{
			throw new NullPointerException();
		}
		vector.add(e);
		return true;
	}
	
	public E peek()
	{
		if(vector.isEmpty())
		{
			return null;
		}
		return vector.firstElement();
	}
	
	public E poll()
	{
		if(vector.isEmpty())
		{
			return null;
		}
		return vector.remove(0);
	}
	
	public E remove()
	{
		return vector.remove(0);
	}
	
	@Override
	public String toString() {
		return "Queue [vector=" + vector + "]";
	}
	
	
}
