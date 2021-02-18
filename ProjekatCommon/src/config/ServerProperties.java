/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Marija
 */
public class ServerProperties {
    Properties properties;

    public ServerProperties() throws FileNotFoundException, IOException  {
        properties = new Properties();
        properties.load(new FileInputStream("config/serverconfig.properties"));
    }
    public String returnServerURL(){
        return properties.getProperty(ServerConstant.URL);
    }
    public String returnServerPort(){
        return properties.getProperty(ServerConstant.PORT);
    }
    
    
}
