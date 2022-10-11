import java.io.*;
import java.util.Properties;

public class properties {
    static FileReader reader;

    public static void main(String[] args) {
        try {
            reader = new FileReader("config/Config.properties");

            Properties properties = new Properties();
            properties.load(reader);

            // Leer archivos del config
            String dificultad = properties.getProperty("dificultad");
            System.out.println(dificultad);

            // Escribir archivos en el config
            properties.setProperty("capullo", "melong");
            properties.store(new BufferedWriter(new FileWriter("config/Config.properties")), "Comentarios");

            // Ejemplo multidioma
            reader = new FileReader("languages/Español.properties");
            properties.load(reader);
            System.out.println(properties.getProperty("piedra"));
            reader = new FileReader("languages/English.properties");
            properties.load(reader);
            System.out.println(properties.getProperty("piedra"));

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error leyendo el fichero");
            throw new RuntimeException(e);
        }
    }
}
