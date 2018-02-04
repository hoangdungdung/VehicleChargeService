package sample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.example.ServiceFireBaseDung;
import com.google.firebase.example.ServiceVehicleCharge;

import sample.city.City;
 

@SpringBootApplication
public class Application {
	  private static final String DATABASE_URL = "https://verhicalcharger.firebaseio.com/";
	  
    public static void main(String[] args) {
    	

        SpringApplication.run(Application.class, args);
        


        
    	City c= new City(); 
    	c.id=1;
    	c.name="Ha noi";
    	ArrayList<City> arr=new ArrayList<City>();
    	arr.add(c);


    	System.out.println("Hello, AuthSnippets!");

        // Initialize Firebase
        try {
          // [START initialize]
        	
        	 FileInputStream serviceAccount = new FileInputStream("service-account.json");
             FirebaseOptions options;
    			try {
    				options = new FirebaseOptions.Builder()
    				        .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
    				        .setDatabaseUrl(DATABASE_URL)
    				        .build();
    				  FirebaseApp.initializeApp(options);
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
//        	
//          FileInputStream serviceAccount = new FileInputStream("service-account.json");
//          FirebaseOptions options = new FirebaseOptions.Builder()
//              .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
//              .build();//      FirebaseApp.initializeApp(options);
          // [END initialize]
        } catch (IOException e) {
          System.out.println("ERROR: invalid service account credentials. See README.");
          System.out.println(e.getMessage());

          System.exit(1);
        }
//        ServiceFireBase mn = new ServiceFireBase();
//        //mn.deleteAll();
//        mn.service();
        
        ServiceVehicleCharge serviceVehicleCharge = new ServiceVehicleCharge();
        serviceVehicleCharge.ServiceCalculate();


    	 
		
    
    
    }
}
