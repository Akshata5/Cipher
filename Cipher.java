package Cipher;

import java.io.IOException;
//import java.lang.reflect.Method;
//import java.net.URL;
//import java.net.URLClassLoader;
import java.util.*;
//import java.util.jar.Attributes;
//import java.util.jar.JarFile;
//import java.util.jar.Manifest;


//import com.sun.java.util.jar.pack.Package.File;
//import Playfair.java.*;
public class Cipher{
	
	
	public void encrypt(String args[]) throws IOException ,Exception
	{
		CipherInterface cp = null;
		 switch(args[0]){
			
			case "PLF":
				cp= new PlayFairMain(args[1],args[2],args[3],args[4]);
				//cp.SetKey();
				System.out.println("Done.");
				break;
			case "RFC":
				cp= new RailFenceBasic(args[1],args[2],args[3],args[4]);
				System.out.println("Done.");    
				break;
			case "RTS":
				cp= new RowTransposition(args[1],args[2],args[3],args[4]);
				System.out.println("Done.");     
				break;
			case "VIG":
				cp= new Vignere(args[1],args[2],args[3],args[4]);
				System.out.println("Done.");   
				break;
			case "CES":
				cp= new CeaserCipher(args[1],args[2],args[3],args[4]);
				System.out.println("Done."); 
				break;
			case "MAC":
				cp=new MonoalphabeticCipher(args[1],args[2],args[3],args[4]);
				System.out.println("Done.");
				break;
			default: System.out.println("Enter atleast one cipher name");
			         break;
				
			}
	}

	
	public void decrypt(String args[]) throws Exception
	{
		CipherInterface cp = null;
		 switch(args[0]){
			
			case "PLF":
				cp= new PlayFairMain(args[1],args[2],args[3],args[4]);
				//cp.SetKey();
				System.out.println("Done.");
				break;
			case "RFC":
			try {
				cp= new RailFenceBasic(args[1],args[2],args[3],args[4]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				System.out.println("Done.");    
				break;
			case "RTS":
				cp= new RowTransposition(args[1],args[2],args[3],args[4]);
				System.out.println("Done.");     
				break;
			case "VIG":
				cp= new Vignere(args[1],args[2],args[3],args[4]);
				System.out.println("Done.");   
				break;
			case "CES":
				cp= new CeaserCipher(args[1],args[2],args[3],args[4]);
				System.out.println("Done."); 
				break;
			case "MAC":
				cp=new MonoalphabeticCipher(args[1],args[2],args[3],args[4]);
				System.out.println("Done.");
				break;
			default: System.out.println("Enter atleast one cipher name");
			         break;
				
			}
	}
   	public static void main(String args[]) throws Exception
	{
		Cipher c = new Cipher();
		CipherInterface cp = null;
		
		if(args[2].equals("ENC"))
		{
			try {
				c.encrypt(args);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			
			c.decrypt(args);
		}
   
	


	}
}
