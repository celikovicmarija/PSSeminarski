/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DbProperties {
    
    Properties properties;
    
    public DbProperties() throws FileNotFoundException, IOException {
        properties = new Properties();
        properties.load(new FileInputStream("config/dbconfig.properties"));
        
    }

   public String returnDbURL() {
       return properties.getProperty(DbConstant.URL);
   }
    
     public String returnDbUser() {
       return properties.getProperty(DbConstant.USERNAME);
   }
     
      public String returnDbPassword() {
       return properties.getProperty(DbConstant.PASSWORD);
   }
      
      public String returnDbPort() {
          return properties.getProperty(DbConstant.PORT);
      }
      
}
