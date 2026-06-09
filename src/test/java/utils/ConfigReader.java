package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String read(String key){
        return read(key,Constants.Config_File_Path);

    }

    public static String read(String key,String filePath){

        Properties properties=new Properties();
        try{
            FileInputStream fis=new FileInputStream(filePath);
            properties.load(fis);
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
        return properties.getProperty(key);
    }

}
