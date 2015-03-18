package Cipher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
class RailFenceBasic implements CipherInterface {
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
        public static void showIntro() {

     }
 int depth;
 
  RailFenceBasic(String key, String enc, String fileName, String xyz) throws Exception{
     
	   
 
              //  RailFenceBasic rf=new RailFenceBasic(key, enc, fileName, xyz); 
                //Scanner scn=new Scanner(System.in);
                
   
                String plainText,cipherText,decryptedText;
                 
               // System.out.println("Enter plain text:");
                //plainText=this.fileName;
                 
                //System.out.println("Enter depth for Encryption:");
                //depth=scn.nextInt();
                int k = Integer.parseInt(key);
                readfile r = new readfile(fileName);
       	        r.openFile();
       	        cipher = r.readFile();
       	             	      
                if(enc.equals("ENC")){
                cipherText=Encryption(cipher,k);
                System.out.println("Encrypted text is:\n"+cipherText);
                }
                else
                {
                cipherText=Encryption(cipher,k);
                decryptedText=Decryption(cipherText, k, xyz);
                System.out.println("Decrypted text is:\n"+decryptedText);
                }
   
 }
 
 String Encryption(String plainText,int depth)throws Exception
 {
  int r=depth,len=plainText.length();
  
  int c;
  if(len %2 != 0)
		 c = ((len / depth)+1);
	else
		 c = (len / depth);
	
  
  //int c=len/depth;
  char mat[][]=new char[r][c];
  int k=0;
   
  String cipherText="";
   
  for(int i=0;i< c;i++)
  {
   for(int j=0;j< r;j++)
   {
    if(k!=len)
     mat[j][i]=plainText.charAt(k++);
    else
     mat[j][i]='X';
   }
  }
  for(int i=0;i< r;i++)
  {
   for(int j=0;j< c;j++)
   {
    cipherText+=mat[i][j];
   }
   
  }
  
  return cipherText;
  
 }
  
  
 String Decryption(String cipherText,int depth, String xyz)throws Exception
 {
  int r=depth,len=cipherText.length();
  int c=len/depth;
  char mat[][]=new char[r][c];
  int k=0;
   
  String plainText="";
   
   
  for(int i=0;i< r;i++)
  {
   for(int j=0;j< c;j++)
   {
    mat[i][j]=cipherText.charAt(k++);
   }
  }
  for(int i=0;i< c;i++)
  {
   for(int j=0;j< r;j++)
   {
    plainText+=mat[j][i];
   }
  }
 plainText = plainText.replace("X", "");
 File file = new File(xyz);
 FileWriter fw = new FileWriter(file.getAbsoluteFile());
 BufferedWriter bw = new BufferedWriter(fw);
 bw.write("Decrypted message:");
 bw.newLine();
 bw.write(plainText);
 bw.close();
  return plainText;
  
 }

 
}