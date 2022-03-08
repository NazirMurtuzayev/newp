package com.nextbasecrm.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1- Create the object of
    private static Properties properties = new Properties();

    static {



        try {
            //2- We need to open the file in java memory: FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");
            //3- Load the properties object using FileInputStreamObject
            properties.load(file);
            //close the file
            file.close();

        } catch (IOException e) {
            System.out.println("File not found in the ConfigurationReader class.");
            e.getStackTrace();
        }




    }


    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
