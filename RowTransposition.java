package Cipher;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Scanner;

public class RowTransposition implements  CipherInterface {
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
	  RowTransposition (String key, String enc, String fileName, String xyz) throws Exception{
	 
		  readfile r1 = new readfile(fileName);
	       r1.openFile();
	       cipher = r1.readFile();
	  
	 // String key;
	  String message;
	  String encryptedMessage; 
	  // Letters in the x-axis
	  int x=0; 
	  // Letters in the y-axis
	  int y=0; 


	  // Prompt the user
	  //System.out.print( "Type your Key : " );


	  // Read a line of text from the user.

	 // Scanner scan = new Scanner(System.in);
	 // key = scan.nextLine();

	  // Display the input back to the user.
	 // System.out.println( "Your Key is " + key );


	  //Prompt the user
	 // System.out.print( "Type your Message : " );


	  //Read a line of text from the user.
	  //message = scan.nextLine();

	  //Display the input back to the user.
	 // System.out.println( "Your Message is " + message );


	  int msgchar = cipher.length();
	  int keycahr = key.length();

	  if (!((msgchar % keycahr) == 0)){

	  do{
		  cipher = cipher + "x";
	  msgchar = cipher.length();
	  }while(!((msgchar % keycahr) == 0));

	  }


	  encryptedMessage = "";

	  // To set the temp as [x][y]
	  char temp[][]=new char [key.length()][cipher.length()];
	  char msg[] = cipher.toCharArray();
	  // To populate the array
	  x=0;
	  y=0;
	  // To convert the message into an array of char
	  for (int i=0; i< msg.length;i++)
	  {
	  temp[x][y]=msg[i];
	  if (x==(key.length()-1)) 
	  {
	  x=0;
	  y=y+1;
	  } // Close if 
	  else 
	  {
	  x++;
	  }
	  } // Close for loop

	  // To sort the key
	  char t[]=new char [key.length()];
	  t=key.toCharArray();
	  Arrays.sort(t);

	  for (int j=0;j<y;j++)
	  {
	  for (int i=0;i<key.length();i++)
	  {
	  System.out.print(temp[i][j]);
	  }
	  System.out.println();
	  }

	  System.out.println();

	  // To print out row by row (i.e. y)
	  for (int j=0;j<y;j++){ 
	  // To compare the the sorted Key with the key
	  // For char in the key
	  for (int i=0;i<key.length();i++){ 
	  int pos=0;
	  // To get the position of key.charAt(i) from sorted key
	  for (pos=0;pos<t.length;pos++){ 
	  if (key.charAt(i)==t[pos]){ 
	  // To break the for loop once the key is found
	  break;
	  }
	  }
	  System.out.print(temp[pos][j]);
	  encryptedMessage+=temp[pos][j];
	  }
	  System.out.println();
	  }
      if(enc.equals("ENC")){
    	  
	     System.out.println(encryptedMessage);}
	  else
	  { 
		  encryptedMessage=encryptedMessage.replace("x", "");
		  System.out.println(encryptedMessage);
	   }
      File file = new File(xyz);
  	 FileWriter fw = new FileWriter(file.getAbsoluteFile());
  	 BufferedWriter bw = new BufferedWriter(fw);
  	 bw.write("Decrypted message:");
  	 bw.newLine();
  	 bw.write(encryptedMessage);
  	 bw.close();
	  }
	  
	  	  
	  public String selectedKey;
	  public char sortedKey[];
	  public int  sortedKeyPos[];
	  

	  //default constructor define the default key
	  public String TranspositionCipher()
	  {
	   selectedKey="megabuck";
	   sortedKeyPos =new int[selectedKey.length()];
	   sortedKey =selectedKey.toCharArray();
	   return selectedKey;
	  }
	  
	  //Parameterized constructor define the custom key
	  public String TranspositionCipher(String myKey)
	  {
	   selectedKey=myKey;
	   sortedKeyPos=new int[selectedKey.length()];
	   sortedKey=selectedKey.toCharArray();
	   return selectedKey;
	  }
	  
	  //To reorder data do the sorting on selected key
	  public void doProcessOnKey()
	  {
	   //Find position of each character in selected key and arrange it on alphabetical order
	   int min,i,j;
	   char orginalKey[]=selectedKey.toCharArray();
	   char temp;
	   
	   //First Sort the array of selected key
	   for(i=0;i<selectedKey.length();i++)
	   {
	    min=i;
	    
	    for(j=i;j<selectedKey.length();j++)
	    {
	     if(sortedKey[min]>sortedKey[j])
	     { 
	      min=j;
	     }
	    }
	    if(min!=i)
	    {
	     temp=sortedKey[i];
	     sortedKey[i]=sortedKey[min];
	     sortedKey[min]=temp;
	    }  
	   }  


	   // Fill the position of array according to alphabetical order
	   for(i=0;i<selectedKey.length();i++)
	   {
	    for(j=0;j<selectedKey.length();j++)
	    {
	     if(orginalKey[i]==sortedKey[j])
	      sortedKeyPos[i]=j;
	    }  
	   }
	   
	  }
	  
	  //to encrypt the targeted string
	  public String doEncryption(String plainText)
	  {
	   int min,i,j;
	   char orginalKey[]=selectedKey.toCharArray();
	   char temp;
	   
	   doProcessOnKey();

	   //Generate encrypted message by doing encryption using Transpotion Cipher
	   int row = plainText.length() / selectedKey.length();
	   int extrabit = plainText.length() % selectedKey.length();
	   
	   int exrow = (extrabit==0)?0:1;
	   
	   int rowtemp=-1,coltemp=-1;
	   int totallen=(row+exrow)*selectedKey.length();
	   char pmat[][]=new char[(row+exrow)][(selectedKey.length())];
	   char encry[]=new char[totallen];
	   int tempcnt=-1;
	   
	   row=0;
	   for(i=0;i<totallen;i++)
	   {
	    coltemp++;
	    if(i<plainText.length())
	    {
	     if(coltemp==(selectedKey.length()))
	     {
	      row++;
	      coltemp=0;
	     } 
	     pmat[row][coltemp]=plainText.charAt(i);
	     }
	    else 
	    { //do the padding ...   
	     pmat[row][coltemp]='*'; 
	    }    
	   }
	   int len=-1,k;
	   for(i=0;i<selectedKey.length();i++)
	   {
	    for(k=0;k<selectedKey.length();k++)
	    {
	     if(i==sortedKeyPos[k])
	     {
	      break;
	     }
	    } 

	    for(j=0;j<=row;j++)
	    {
	     len++;
	     encry[len]=pmat[j][k];
	     }
	   }
	   
	   String p1=new String(encry);
	   
	   return(new String(p1));
	  }
	  
	  //to decrypt the targeted string
	  public String doDecryption(String s)
	  {
	   int min,i,j,k;
	   char key[]=selectedKey.toCharArray();
	   char encry[]=s.toCharArray();
	   char temp;
	  
	   doProcessOnKey(); 
	    
	   //Now generating plain message
	   int  row = s.length() / selectedKey.length();
	   char pmat[][] = new char[row][(selectedKey.length())];
	   int  tempcnt = -1;
	   
	   for(i=0;i<selectedKey.length();i++)
	   {
	    for(k=0;k<selectedKey.length();k++)
	    {
	     if(i==sortedKeyPos[k])
	     {
	      break;
	     }
	    } 
	   
	    for(j=0;j<row;j++)
	    {
	     tempcnt++; 
	     pmat[j][k]=encry[tempcnt];
	    }
	   }
	   //store matrix character in to a single string
	   char p1[] = new char[row*selectedKey.length()];
	   k=0;
	   for(i=0;i<row;i++)
	   { 
	    for(j=0;j<selectedKey.length();j++)
	    {
	     if(pmat[i][j]!='*')
	     {
	      p1[k++]=pmat[i][j];
	     }
	    }
	   }
	   p1[k++]='\0';
	   
	  // System.out.print(p1);
	   return(new String(p1));
	  }
	  }