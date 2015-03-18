package Cipher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class CeaserCipher implements  CipherInterface

{

String cipher, xyz;
	
	public boolean SetKey(String key) {
		
		//Add some errorchecking
		//this.table = this.cipherTable(key);
		
		return true;
	  }
	 
		
	  public String Encrypt(String str)
	  {
	    return str; 
	  }

	public CeaserCipher(String key, String enc, String fileName, String xyz) throws IOException

    {

        //gets a string to encrypt

     //   String str = (JOptionPane.showInputDialog("Input Data to encypt:"));

         

        //gets a key

       // String key = (JOptionPane.showInputDialog("Input the key:"));

        int k = Integer.parseInt(key);
        
        this.xyz=xyz;
        readfile r = new readfile(fileName);
	     r.openFile();
	      cipher = r.readFile();
	      int keyLength=cipher.length();
	      if(enc.equals("ENC")){
        String encrypted = encrypt(cipher, keyLength);

        System.out.println("Encrypted:" + encrypted);
	      }
	      else {
	    String encrypted = encrypt(cipher, keyLength);
        String decrypted = decrypt(encrypted, keyLength, xyz);

        System.out.println("Decrypted:" + decrypted);
	      }
    }

 

     String encrypt(String fileName, int key)

    {
    	
    	 
        String encrypted = "";

        for(int i = 0; i < fileName.length(); i++)

        {

            int c = fileName.charAt(i);

             

            if (Character.isUpperCase(c))

            {

                //26 letters of the alphabet so mod by 26

                c = c + (key % 26);

                if (c > 'Z')

                c = c - 26;

            }

            else if (Character.isLowerCase(c))

            {

                c = c + (key % 26);

                if (c > 'z')

                c = c - 26;

            }

            encrypted += (char) c;

        }

    return encrypted; 
    	
    	/*String text = fileName;

    	char txt[] = text.toCharArray();

    	System.out.println(" ");

    	System.out.println("  ");

    	//System.out.println("Enter the key.");

    	//int k = sc.nextInt();

    	//System.out.println("  ");

    	for(int i = 0; i< txt.length; i++)

    	{

    	if((txt[i]) >= 65 && (txt[i]) <91)

    	{

    	txt[i] = (char)((txt[i]) + key);

    	if((txt[i])>=91)

    	{

    	txt[i] = (char)(txt[i]-26);

    	}

    	}

    	if((txt[i]) >= 97 && (txt[i]) <123)

    	{

    	txt[i] = (char)((txt[i]) + key);

    	if((txt[i])>=123)

    	{

    	txt[i] = (char)((txt[i])-26);

    	}}

    	}
    	//String characterToString = Character.toString('txt');
		return text; */
    	

    }

    public static String decrypt(String fileName, int key, String xyz) throws IOException

   {

        String decrypted = "";

        for(int i = 0; i < fileName.length(); i++)

        {

            int c = fileName.charAt(i);

            if (Character.isUpperCase(c))

            {

                c = c - (key % 26);

                if (c < 'A')

                c = c + 26;

        }

           else if (Character.isLowerCase(c))

            {

                c = c - (key % 26);

                if (c < 'a')

                c = c + 26;

            }

            decrypted += (char) c;

        }
          File file = new File(xyz);
    	  FileWriter fw = new FileWriter(file.getAbsoluteFile());
          BufferedWriter bw = new BufferedWriter(fw);
          bw.write("Decrypted message:");
          bw.newLine();
          bw.write(decrypted);
          bw.close();

        return decrypted;

    }

}
