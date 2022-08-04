package exercise;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

import common.CustomException;
import common.HelperUtility;

public class PhoneBookLogicLayer {
	
	Hashtable<String, Phone> hashTable = new Hashtable<>();
	
	
	public void storePhoneBook(Phone phone)
	{
		hashTable.put(phone.getName(), phone);
	}
	
	private Phone getPhoneData(String name) throws CustomException
	{
		HelperUtility.checkString(name);
		Phone phone = hashTable.get(name);
		if(Objects.isNull(phone))
		{
			throw new CustomException("Your Name is Invalid");
		}
		return phone;
	}
	
	public Phone deleteNumbers(String name) throws CustomException
	{
		HelperUtility.checkString(name);
		getPhoneData(name);
		return hashTable.remove(name);
	} 
    		
	public void updateNumber(String name,long newPhoneNumber) throws CustomException
	{
		HelperUtility.checkString(name);
		
		Phone phone = getPhoneData(name);
		phone.newBuilder().setPhoneNumber(newPhoneNumber);
		storePhoneBook(phone);
	}
	
	public void updateAddress(String name,String newAddress) throws CustomException
	{
		HelperUtility.checkString(name);
		HelperUtility.checkString(newAddress);
		
		Phone phone = getPhoneData(name);
		phone.newBuilder().setAddress(newAddress);
		storePhoneBook(phone);
	}
	
	public void updateName(String name,String newName) throws CustomException
	{
		HelperUtility.checkString(name);
		HelperUtility.checkString(newName);
		
		Phone phone = getPhoneData(name);
		phone.newBuilder().setName(newName);
		storePhoneBook(phone);
	}
	
	public TreeMap<String,Phone> listAllNumbers()
	{
		TreeMap<String,Phone> map = new TreeMap<>(hashTable);
		return map;
	}
	
	public List<String> searchName(String name) throws CustomException
	{
		HelperUtility.checkString(name);
		List<String> list = new ArrayList<>();
		
		for(String saved:hashTable.keySet())
		{
			if(saved.contains(name))
			{
				list.add(name);
			}
		}
		return list;
	}
	
	public List<String> searchNumber(long number) throws CustomException
	{
		List<String> list = new ArrayList<>();
		
		for(Phone phone:hashTable.values())
		{
			String phoneNumber = phone.getPhoneNumber() + ""; 
			if(phoneNumber.contains((number+"")))
			{
				list.add(phoneNumber);
			}
		}
		return list;
	}
	
	public List<String> searchAddress(String searchAddress) throws CustomException
	{
		List<String> list = new ArrayList<>();
		
		for(Phone phone:hashTable.values())
		{
			String address = phone.getAddress(); 
			if(address.contains(searchAddress))
			{
				list.add(address);
			}
		}
		return list;
	}
}
