package exercise;


public class ExtendedsThread extends Thread
{
	Queue<Integer> queue = new Queue<>();
	
	public void addRandomNumber()
	{
		queue.add(((int)Math.random()) * 7);
	}
	
	public String checkPrimeNumber()
	{
		int checkPrime = queue.remove();
		
		boolean flag = false;
		
		if(checkPrime == 0 || checkPrime == 1)
		{
			return checkPrime + " is a not Prime Number";
		}
		
		for(int iter = 2; iter <= Math.sqrt(checkPrime); iter++)
		{
			if(checkPrime % iter == 0)
			{
				flag = true;
			}
		}
		
		if(!flag)
		{
			return checkPrime + " is a Prime Number";
		}
		
		return checkPrime + " is a not Prime Number";
	}
	
	public void run()
	{
		addRandomNumber();
		//System.out.println(queue);
		System.out.println("Thread Name:"+this.getName());
		System.out.println("Thread Priority: "+this.getPriority());
		System.out.println("Thread State: "+this.getState());
	}
}
