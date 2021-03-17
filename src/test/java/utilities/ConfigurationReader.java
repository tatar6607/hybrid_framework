package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    // Bu Classin amaci ==> configuration.properties dosyasindaki verilerini okumaktir.

    // 1.Adim ==> Static olacak sekilde Properties variablesi olusturuyoruz.
    private static Properties properties;

    // en once calismasi icin ve diger classlardan ulasmak icin static class kullandik.
    static {
        // config dosyasinin yolunu istersek uzun istersek te proje icinde bulundugu icin kisaca yazbiliriz.
        //String pasth = "C:\\Users\\TTR\\IdeaProjects\\mytestNgframework\\configuration.properties";
        String path = "configuration.properties";

        try {
            FileInputStream file = new FileInputStream(path);
            properties =  new Properties();
            properties.load(file);
        } catch (IOException e) {
            System.out.println("Config file yok baba :)");
            e.printStackTrace();
        }
    }

    // baska sayfalarda kullanmak icin static method olusturduk.
    // bu method config dosyasindaki valueleri getirir.
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

//    public static void main(String[] args) {
//        System.out.println(getProperties("valid_password"));
//    }

}
