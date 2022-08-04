package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.InputMismatchException;
import java.util.TreeMap;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import common.CustomException;
import common.HelperUtility;
import common.InputCenter;

public class Controller {

		InputCenter inputCenter = new InputCenter();
		
		ExerciseMethod exerciseMethod = new ExerciseMethod();
		
		PhoneBookLogicLayer phoneBookLogicLayer = new PhoneBookLogicLayer();
		
		public void dataInput() throws CustomException
		{
			System.out.println("Enter the int number");
				
			int intNumber = inputCenter.getInt();
		
			System.out.println("Enter the double number");
				
			double doubleNumber = inputCenter.getDouble();
				
			System.out.println("Enter the character");
			
			char saved = inputCenter.getString().charAt(0);
				
			System.out.println(exerciseMethod.dataInputStreamMethod(intNumber, saved, doubleNumber));
		}
		
		public void queueMethod() throws CustomException
		{
			
			Queue<Integer> queue = new Queue<>();
			
			boolean flag = false;
			
			while(!flag)
			{
				System.out.println("1.Enqueue\n2.Dequeue\n3.List\n4.Exit");
				System.out.println("Enter the Choice");
				
				int choice = inputCenter.getInt();
				
				switch(choice)
				{
					case 1:
					{
						System.out.println("Enter the number");
						
						queue.add(inputCenter.getInt());
						break;
					}
					
					case 2:
					{
						System.out.println("Dequeue is a " + queue.remove());
						break;
					}
					
					case 3:
					{
						System.out.println(queue);
						break;
					}
					
					case 4:
					{
						flag = true;
						break;
					}
					
					default:
					{
						System.out.println("Enter the valid choice");
					}
				}
			}
		}
		
		private Phone newPhone() throws CustomException
		{
			Phone.Builder phone = Phone.newBuilder();
			
			System.out.println("Enter Your Name");
			
			phone.setName(inputCenter.getString());
			
			System.out.println("Enter Your PhoneNumber");
			
			phone.setPhoneNumber(inputCenter.getLong());
			
			System.out.println("Enter Your Address");
			
			phone.setAddress(inputCenter.getString());
			
			Phone phoneBook = phone.build();
			
			phoneBookLogicLayer.storePhoneBook(phoneBook);
			
			return phoneBook;
		}
		
		public void deletePhone() throws CustomException
		{
			String name = inputCenter.getString();
			
			phoneBookLogicLayer.deleteNumbers(name);
		}
		
		
		public void listAllNumbers()
		{
			TreeMap<String,Phone> treeMap = phoneBookLogicLayer.listAllNumbers();
			
			for(Phone phone:treeMap.values())
			{
				System.out.println(phone);
			}
		}
		
		public void search() throws CustomException
		{
			boolean flag = false;
			
			while(!flag)
			{
				System.out.println("1.Search by Names\n2.search by Numbers\n3.Search by Address\n4.Exit");
				
				System.out.println("Enter Your Choice ");
				
				int choice = inputCenter.getInt();
				
				switch(choice)
				{
					case 1:
					{
						System.out.println("Enter Your Name");
						System.out.println(phoneBookLogicLayer.searchName(inputCenter.getString()));
						break;
					}
					
					case 2:
					{
						System.out.println("Enter the Numbers");
						System.out.println(phoneBookLogicLayer.searchNumber(inputCenter.getLong()));
						break;
					}
					
					case 3:
					{
						System.out.println("Enter the Address");
						System.out.println(phoneBookLogicLayer.searchAddress(inputCenter.getString()));
						break;
					}
					
					case 4:
					{
						flag = true;
						break;
					}
					
					default:
					{
						System.out.println("Enter the valid choice");
						break;
					}
				}
			}
		}
		
		public void update() throws CustomException
		{
			boolean flag = false;
			
			while(!flag)
			{
				System.out.println("1.UpdateNames\n2.UpdateNumbers\n3.UpdateAddress\n4.Exit");
				
				System.out.println("Enter Your Choice ");
				
				int choice = inputCenter.getInt();
				
				switch(choice)
				{
					case 1:
					{
						System.out.println("Enter Your Old Name");
						
						String oldName = inputCenter.getString();
						
						System.out.println("Enter Your New Name");
						
						String newName = inputCenter.getString();
						
						phoneBookLogicLayer.updateName(oldName, newName);
						
						System.out.println("Sucessfully Updated");
						break;
					}
					
					case 2:
					{
						System.out.println("Enter Your Name");
						
						String name = inputCenter.getString();
						
						System.out.println("Enter Your New Number");
						
						long number = inputCenter.getLong();
						
						phoneBookLogicLayer.updateNumber(name, number);;
						
						System.out.println("Sucessfully Updated");
						break;
					}
					
					case 3:
					{
						System.out.println("Enter Your Old Name");
						
						String oldName = inputCenter.getString();
						
						System.out.println("Enter Your New Address");
						
						String address = inputCenter.getString();
						
						phoneBookLogicLayer.updateAddress(oldName, address);
						
						System.out.println("Sucessfully Updated");
						break;
					}
					
					case 4:
					{
						flag = true;
						break;
					}
					
					default:
					{
						System.out.println("Enter the valid choice");
						break;
					}
				}
			}
		}
		
		public void phoneBook() throws CustomException
		{
			boolean flag = false;
			
			while(!flag)
			{
				System.out.println("1.Add Numbes\n2.Delete numbers\n3.List All\n4.Search\n5.Update\n6.Exit");
				
				System.out.println("Enter Your Choice ");
				
				int choice = inputCenter.getInt();
				
				switch(choice)
				{
					case 1:
					{
						newPhone();
						break;
					}
					
					case 2:
					{
						deletePhone();
						break;
					}
					
					case 3:
					{
						listAllNumbers();
						break;
					}
					
					case 4:
					{
						search();
						break;
					}
					
					case 5:
					{
						update();
						break;
					}
					
					case 6:
					{
						flag = true;
						break;
					}
					
					default:
					{
						System.out.println("Enter the valid choice");
						break;
					}
				}
			}
		}
		
		
		public void primeNumber()
		{
			ExtendedThread extendedThread = new ExtendedThread(3600);
			
			extendedThread.start();
		}
		
		public void thread()
		{
			ExtendedsThread extendedsThread = new ExtendedsThread();
			
			extendedsThread.setName("producer");
			
			extendedsThread.start();
			
			try {
				Thread.sleep(4500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			
			extendedsThread.setName("consumer");
			
			System.out.println(extendedsThread.checkPrimeNumber());
			
		}
		
		public void client(String address,int port) throws UnknownHostException, IOException, CustomException
		{
			HelperUtility.checkString(address);
			
			Socket socket = new Socket(address, port);
			
			System.out.println("Connected");
			
			phoneBook();
			
			socket.close();
		}
		
		public void server(int port) throws CustomException, IOException
		{
			Socket socket = null;
			
			ServerSocket severSocket = null;
			
			try 
			{
				severSocket = new ServerSocket(port);
			
				System.out.println("Server Started");
			
				System.out.println("Waiting for a client");
				
				socket = severSocket.accept();
				
				System.out.println("Client accepted");
				
				phoneBook();
			}
			catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
			finally {
				socket.close();
				severSocket.close();
			}
			
		}
		
	public static void main(String[] args) {
		
		
		Controller controller = new Controller();
		
		boolean flag = false;
		
		while(!flag)
		{
			System.out.println("Enter Your Choice");
			
			int choice = 0;
			
			try {
				
				 choice = Integer.parseInt(controller.inputCenter.getString());
				
				
			} catch (CustomException e) {
				e.printStackTrace();
			}
			
			switch(choice)
			{
				case 1:
				{
					try {
						controller.dataInput();
					} catch (CustomException e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				
				case 2:
				{
					try {
						System.out.println(controller.exerciseMethod.
								numbersOfCharacters(new BufferedReader(new InputStreamReader(System.in))));
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				
				case 3:
				{
					controller.exerciseMethod.matrix(System.out);
					break;
				}
				
				case 4:
				{
					try
					{
						System.out.println(controller.exerciseMethod.
							fibonacci(Integer.parseInt(args[0])));
					}
					catch(InputMismatchException e)
					{
						System.out.println(e.getMessage());
					}
					break;
				}
				
				case 5:
				{
					try
					{
						System.out.println(controller.exerciseMethod.dateMethod());
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					break;
				}
				
				case 6:
				{
					try {
						System.out.println(controller.exerciseMethod.copyFile(args[1], args[2]));
					} catch (CustomException e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				
				case 7:
				{
					try {
						System.out.println(controller.exerciseMethod.writeFile(args[3],
								new BufferedReader(new InputStreamReader(System.in))));
					} catch (CustomException e) {
						System.out.println(e.getMessage());
					}
				}
				
				case 8:
				{
					try {
						System.out.println(controller.exerciseMethod.writeFileMethod(args[4], args[5],
								new BufferedReader(new InputStreamReader(System.in))));
					} catch (CustomException e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				
				case 9:
				{
					try
					{
						SecretKey key = controller.exerciseMethod.generateKey(128);
						IvParameterSpec ivParameterSpec = controller.exerciseMethod.generateIv();
						String algorithm = "AES/CBC/PKCS5Padding";
						String encryptData = controller.exerciseMethod.encrypt
								(algorithm, args[6], key, ivParameterSpec);
						String decryptData = controller.exerciseMethod.decrypt
								(algorithm, encryptData, key, ivParameterSpec);
						System.out.println(encryptData);
						System.out.println(decryptData);
					}
					catch(NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException |
					InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException |
					CustomException e)
					{
						System.out.println(e.getMessage());
					}
					break;
				}
				
				case 10:
				{
					try {
						controller.queueMethod();
					} catch (CustomException e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				
				case 11:
				{
					try {
						controller.phoneBook();
					} catch (CustomException e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				
				case 12:
				{
					controller.primeNumber();
					break;
				}
				
				case 13:
				{
					controller.thread();
					break;
				}
				
				case 14:
				{
					System.out.println("Enter the TagName :");
					try {
						controller.exerciseMethod.getDataInXml(args[7], System.out, controller.inputCenter.getString());
					} catch (ParserConfigurationException | SAXException | IOException | CustomException e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				
				case 15:
				{
					
					break;
				}
				
				case 16:
				{
					flag = true;
					break;
				}
				
				default:
				{
					System.out.println("Enter the valid choice");
				}
			}
		}
	}

}
