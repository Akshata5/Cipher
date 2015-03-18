package Cipher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class MonoalphabeticCipher implements  CipherInterface {
	String cipher;
	
	public boolean SetKey(String key) {
		
		//Add some errorchecking
		//this.table = this.cipherTable(key);
		
		return true;
	  }
	 
		
	  public String Encrypt(String str)
	  {
	    return str; 
	  }
	  
    public static char p[]  = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z' };
    public static char ch[] = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
            'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C',
            'V', 'B', 'N', 'M' };
    MonoalphabeticCipher(String key, String enc, String fileName, String xyz) throws Exception{
    
       // Scanner sc = new Scanner(System.in);
       // System.out.println("Enter the message: ");
    	readfile r1 = new readfile(fileName);
        r1.openFile();
        cipher = r1.readFile();
        String en = doEncryption(cipher.toLowerCase());
        if(enc.equals("ENC"))
        System.out.println("Encrypted message: " + en);
        else{
        	//String en = doEncryption(cipher.toLowerCase());
        	System.out.println("Decrypted message: " + doDecryption(en, xyz));
            //sc.close();
        }
        
    }
 
    public static String doEncryption(String s)
    {
        char c[] = new char[(s.length())];
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < 26; j++)
            {
                if (p[j] == s.charAt(i))
                {
                    c[i] = ch[j];
                    break;
                }
            }
        }
        return (new String(c));
    }
 
    public static String doDecryption(String s, String xyz) throws IOException
    {
        char p1[] = new char[(s.length())];
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < 26; j++)
            {
                if (ch[j] == s.charAt(i))
                {
                    p1[i] = p[j];
                    break;
                }
            }
        }
        File file = new File(xyz);
    	 FileWriter fw = new FileWriter(file.getAbsoluteFile());
    	 BufferedWriter bw = new BufferedWriter(fw);
    	 bw.write("Decrypted message:");
    	 bw.newLine();
    	 bw.write(p1);
    	 bw.close();
        return (new String(p1));
    }
 
    
}