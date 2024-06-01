import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivos {
    public void guardarJson(ConvercionDePeticio convercionDePeticio)throws IOException{
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        FileWriter fileWriter =new FileWriter(convercionDePeticio.conversion_rates()+"json");
        fileWriter.write(gson.toJson(convercionDePeticio));
        fileWriter.close();
    }
}
