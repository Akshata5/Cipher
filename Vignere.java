package Cipher;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

	public class Vignere implements  CipherInterface {
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
		/**
		06
		     * @param args
		07
		     */
		Vignere(String key, String enc, String fileName, String xyz) throws Exception

		 {	        // TODO Auto-generated method stub
		
		        Scanner in=new Scanner(System.in);
		
		        String p="",c="",k="",l="abcdefghijklmnopqrstuvwxyz";
		
		        //System.out.print("wat d u want/ p 1 to enc or 2 to dec?");
		
		         
		
		        //int m=in.nextInt();
		
		         
		
		           // System.out.print("give the pl text");
		//
		           // p=in.nextLine();
		
		             
		         //   System.out.print("give the key");
		
		         //   k=in.nextLine();
		        
		      //  int k = Integer.parseInt(key);
                readfile r1 = new readfile(fileName);
       	        r1.openFile();
       	        cipher = r1.readFile();
       	             	      
        	     	
        	     //System.out.print("give the pl text");
        	     
        	                // p=in.nextLine();
        	     
        	                 //System.out.print("give the key");
        	     
        	                // k=in.nextLine();
        	     
        	                int ky=key.length();
        	     
        	                 int pln=cipher.length();
        	     
        	             String  y =key;
        	     
        	             int m = pln%ky;
        	             for( int i=1; i<pln/ky ; i++)
        	     
        	                 {
        	     
        	                     //if(i>=ky)
        	     
        	                        //i=0;
        	     
        	                     key=key+y;
        	     
        	                      
        	     
        	                     //x.charAt((x.indexOf(K.charAt(j)) + x.indexOf(p1.charAt(j)))%27);
        	     
        	                 }
        	     
        	             key=key+key.substring(0,m);  
        	     
        	                 //System.out.println(k);
        	     
        	             for (int j=0; j<pln; j++ ){
        	     
        	                 c=c + l.charAt((l.indexOf(key.charAt(j)) + l.indexOf(cipher.charAt(j)))%26);
        	     
        	             }
        	     
        	             c=c.toUpperCase();
        	             if(enc.equals("ENC")){
        	     
        	             System.out.println("Ciphertext : "+c);
        	             }
        	             // Decryption
        	     
        	             c = c.toLowerCase();
        	     
        	             String pl = "";
        	    
        	             for (int r=0; r<pln; r++ ){
        	     
        	                 pl=pl + l.charAt(((l.indexOf(c.charAt(r)) - l.indexOf(key.charAt(r))) +26 )%26);
        	     
        	             }  
        	             if(enc.equals("DEC")){
        	     System.out.println("decipher: "+pl);}
		      	 File file = new File(xyz);
		      	 FileWriter fw = new FileWriter(file.getAbsoluteFile());
		      	 BufferedWriter bw = new BufferedWriter(fw);
		      	 bw.write("Decrypted message:");
		      	 bw.newLine();
		      	 bw.write(pl);
		      	 bw.close();
		        }
		    }
		
	
