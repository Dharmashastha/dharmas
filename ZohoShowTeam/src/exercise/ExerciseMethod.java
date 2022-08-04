package exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import common.CustomException;
import common.HelperUtility;
import common.InputCenter;

public class ExerciseMethod {
	
	InputCenter inputCenter = new InputCenter();
	
	public String dataInputStreamMethod(int dataInt,char dataChar,double dataDouble)
	{
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("datainput.dat")))
		{
			dos.writeInt(dataInt);
			dos.writeChar(dataChar);
			dos.writeDouble(dataDouble);
		}
		catch(IOException e)
		{
			return e.getMessage();
		}
		
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream("dataInput.dat")))
		{
			dataInt = dis.readInt();
			dataChar = dis.readChar();
			dataDouble = dis.readDouble();
		}
		catch(IOException e)
		{
			return e.getMessage();
		}
		
		return dataInt + " "+ dataChar + " " + dataDouble;
	}
	
	
	public int numbersOfCharacters(BufferedReader stdin) throws IOException 
	{	
		return stdin.readLine().length();
	}
	
	private int min(int number1,int number2)
	{
		if(number1 < number2)
		{
			return number1;
		}
		return number2;
	}
	
	private int max(int number1,int number2)
	{
		if(number1 < number2)
		{
			return number2;
		}
		return number1;
	}

	public void matrix(PrintStream stdOut)
	{
		int[][][] array = new int[4][5][8];
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				for(int k = 0; k < 8; k++)
				{
					array[i][j][k] = (int) (Math.random() * 10);
				}
			}
		}
		
		int minValue = array[0][0][0];
		
		int maxValue = array[0][0][0];
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				for(int k = 0; k < 8; k++)
				{
					if(min(array[i][j][k],minValue) < minValue)
					{
						minValue = array[i][j][k];
					}
					
					if(max(array[i][j][k],maxValue) > maxValue)
					{
						maxValue = array[i][j][k];
					}
				}
			}
		}
		
		stdOut.println("Array is " + Arrays.deepToString(array));
		
		stdOut.println("Largest Value  is a " + maxValue);
		
		stdOut.println("Smallest Value is a "+ minValue);
	}
	
	public int fibonacci(int number)
	{
		if(number == 0)
		{
			return 0;
		}
		
		if(number == 1 || number == 2)
		{
			return 1;
		}
		
		return fibonacci(number - 2) + fibonacci(number - 1);
	}
	
	public String dateMethod()
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z YYYY");
		
		Date date = new Date(System.currentTimeMillis());
		
		String dateData = dateformat.format(date);
		
		return dateData;
	}
	
	public String copyFile(String inputfile,String outputFile) throws CustomException
	{	
		HelperUtility.checkString(inputfile);
		HelperUtility.checkString(outputFile);
		
		String saved = null;
		
		try(FileInputStream fis = new FileInputStream(inputfile);
				FileOutputStream fos = new FileOutputStream(outputFile);)
		{
			int copy;
			
			while((copy = fis.read()) != -1)
			{
				fos.write(copy);
			}
			saved = "copied the file successfully";
			
		}
		catch(IOException e)
		{
			saved = e.getMessage();
		}
		return saved;
	}
	
	
	public String writeFile(String fileName,BufferedReader stdin) throws CustomException
	{
		HelperUtility.checkString(fileName);
		
		String saved = null;
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName)))
		{
			int count = 1;
			StringBuilder builder = new StringBuilder();
			String line =  stdin.readLine();
			
			while(!line.equals("stop"))
			{
				builder.append(count++);
				builder.append(". " + line);
				builder.append("\n");
				bw.write(builder.toString());
				bw.flush();
				line = stdin.readLine();
				builder.delete(0, builder.length());
			}
			saved = "Write the file successfully";
		}
		catch(IOException e)
		{
			saved = e.getMessage();
		}
	return saved;	
	}
	
	public String writeFileMethod(String inputfile,String outputfile,BufferedReader stdin) throws CustomException
	{
		HelperUtility.checkString(inputfile);
		HelperUtility.checkString(outputfile);
		
		String saved = null;
		
		try(BufferedReader br = new BufferedReader(new FileReader(inputfile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputfile));
			LineNumberReader lnr = new LineNumberReader(new FileReader(inputfile)))
		{
			StringBuilder builder = new StringBuilder();
			String line =  stdin.readLine();
			
			while(!line.equals("stop"))
			{
				builder.append(lnr.getLineNumber());
				builder.append(". " + br.read());
				builder.append("\n");
				bw.write(builder.toString());
				line = stdin.readLine();
				bw.flush();
				builder.delete(0, builder.length());
			}
			saved = "copied the file successfully";
		}
		catch(IOException e)
		{
			saved = e.getMessage();
		}
	return saved;	
	}
	
	
	public SecretKey generateKey(int keySize) throws NoSuchAlgorithmException
	{
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(keySize);
		return keyGenerator.generateKey();
	}
	
	public IvParameterSpec generateIv()
	{
		byte[] iv = new byte[16];
		new SecureRandom().nextBytes(iv);
		return new IvParameterSpec(iv);
	}
	
	public String encrypt(String algorithm,String input,SecretKey key,IvParameterSpec iv) throws CustomException, NoSuchAlgorithmException, 
	NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
	{
		HelperUtility.checkString(algorithm);
		HelperUtility.checkString(input);
		
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, key,iv);
		byte[] cipherText = cipher.doFinal(input.getBytes());
		return Base64.getEncoder().encodeToString(cipherText);
	}
	
	public String decrypt(String algorithm,String cipherText,SecretKey key,IvParameterSpec iv) throws CustomException, NoSuchAlgorithmException, 
	NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
	{
		HelperUtility.checkString(algorithm);
		HelperUtility.checkString(cipherText);
		
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, key,iv);
		byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
		return new String(plainText);
	}
	
	public void getDataInXml(String fileName,PrintStream stdout,String tagName) throws ParserConfigurationException, SAXException, IOException
	{
		File file = new File(fileName);
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		org.w3c.dom.Document document = db.parse(file);
		
		NodeList nodeList = document.getElementsByTagName(tagName);
		
		int nodeLen = nodeList.getLength();
		
		for(int iter = 0; iter < nodeLen; iter++)
		{
			Node node = nodeList.item(iter);
			
			if(node.getNodeType() == Node.ELEMENT_NODE)
			{
				Element element = (Element) node;
				
				stdout.println("UserName : " + element.getElementsByTagName("username").item(0).getTextContent());
				stdout.println("Password : " + element.getElementsByTagName("password").item(0).getTextContent());
				stdout.println("Name : " + element.getElementsByTagName("name").item(0).getTextContent());
				stdout.println("Mobile : " + element.getElementsByTagName("mobile").item(0).getTextContent());
				stdout.println("credit : " + element.getElementsByTagName("credit").item(0).getTextContent());
			}
		}
	}

	
}
