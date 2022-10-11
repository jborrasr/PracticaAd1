import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;



public class Main {

    static File sp = new File("languages/Español.properties");
    static File en = new File("languages/English.properties");

    static File conf = new File("config/Config.properties");
    static Scanner sc = new Scanner(System.in);

    static final Logger logger = LoggerFactory.getLogger(Main.class);
    static FileReader reader;


    static Properties properties = new Properties();
    static Properties propertiesConfig = new Properties();



    public static void main(String[] args) throws IOException {

        while(true){
            int opcion = 0;

            //Configuracion Inicial
            logger.trace("Leemos el archivo de configuración");
            reader = new FileReader(conf);
            propertiesConfig.load(reader);
            logger.trace("Leemos la configuración de idioma y la cargamos");
            if (propertiesConfig.getProperty("Idioma").equals("es")) {
                // Español
                reader = new FileReader(sp);
                properties.load(reader);
            } else if (propertiesConfig.getProperty("Idioma").equals("en")) {
                // Inglés
                reader = new FileReader(en);
                properties.load(reader);

            switch (opcion){

                case 1: PlantillaPiedraPapelTijera.getOpcion();

            }
        }







        PlantillaPiedraPapelTijera obj = new PlantillaPiedraPapelTijera();
        int salida = 0;

        int parseOpcion;
        int contador;


            while (true) {
                System.out.println(properties.getProperty("nivelNormal"));
                System.out.println(properties.getProperty("nivelDificil"));
                try {
                    parseOpcion = sc.nextInt();
                    if (parseOpcion < 1 || parseOpcion > 2) {

                        System.out.println(properties.getProperty("opcionValida"));
                        continue;
                    } else {
                        break;
                    }
                } catch (Throwable exc) {

                    System.out.println(properties.getProperty("opcionValida"));
                }
            }
            switch (parseOpcion) {

                case 1:
                    System.out.println(properties.getProperty("nivelNormalElegido"));
                    while (salida == 0){

                            System.out.println(properties.getProperty("Piedra"));
                            System.out.println(properties.getProperty("Papel"));
                            System.out.println(properties.getProperty("Tijera"));
                            System.out.println(properties.getProperty("Salir"));

                            try{
                                opcion = Integer.parseInt(sc.nextLine());
                                parseOpcion = Integer.parseInt(String.valueOf(opcion));
                                if(parseOpcion < 1 || parseOpcion > 4) {
                                    System.out.println(properties.getProperty("opcionValida"));
                                    continue;
                                }else {
                                    break;
                                }
                            }catch(Throwable exc) {
                                System.out.println(properties.getProperty("opcionValida"));
                            }
                        opcion = Integer.parseInt(sc.nextLine());
                        parseOpcion = Integer.parseInt(String.valueOf(opcion));


                        switch(parseOpcion) {
                            case 1:
                                obj.piedra();
                                break;
                            case 2:
                                obj.papel();
                                break;
                            case 3:
                                obj.tijera();
                                break;

                        }
                            }



                    break;


                case 2:
                    System.out.println(properties.getProperty("nivelDificilElegido"));



                    break;





            }


        }
    }
}








