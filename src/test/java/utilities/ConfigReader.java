package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;
    static {
        String dosyaYolu="configuration.properties";
        try {
            FileInputStream fis=new FileInputStream(dosyaYolu);
            // fis dosyaYolu'nu tanimladigimiz cnfiguration.properties dosyasini okudu
            properties=new Properties();
            properties.load(fis); // fis'in okudugu bilgileri properties'e yukledi
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
        /*
        Test method'undan yolladigimiz String key degerini alip
        Properties Class'indan getProperty() method'unu kullanarak
        bu key'e ait value'yu bize getirdi.
         */
        return properties.getProperty(key);
    }
}
