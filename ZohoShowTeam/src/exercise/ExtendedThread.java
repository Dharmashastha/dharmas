package exercise;

public class ExtendedThread extends Thread
{
	private long sleep;
	private int number = 1;
	
	public ExtendedThread(long sleep)
	{
		this.sleep = sleep;
	}
	
	private boolean checkPrime(int number)
	{
		boolean flag = false;
		if(number <= 1)
		{
			flag = true;
		}
		
		for(int iter = 2; iter <= Math.sqrt(number); iter++)
		{
			if(number % iter == 0)
			{
				flag = true;
			}
		}
		return flag;
	}
	
	public void run()
	{
		while(number <= 100)
		{
			if(!checkPrime(number))
			{
				System.out.println(number);
				try {
					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			number++;
		}	
	}
}
