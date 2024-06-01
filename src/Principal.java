import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner lecturaDeUsuario = new Scanner(System.in);
        FichaTecnica menu = new FichaTecnica();
        System.out.println(menu);
/*
        Peticion peticion = new Peticion();
        System.out.println(peticion.buscadorMonedas("USD"));

 */
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        Peticion peticion = new Peticion();
        List<ConvercionDePeticio> historial = new ArrayList<>();

        ConvercionDePeticio resultado = null;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el código de la moneda base (por ejemplo, USD): ");
            String monedaBase = scanner.nextLine().trim().toUpperCase();
            if (monedaBase.equalsIgnoreCase("salir")) {
                break;
            }
            try {
                resultado = peticion.buscadorMonedas(monedaBase);

                System.out.print("Ingrese el código de la moneda a la que desea convertir: ");
                String monedaObjetivo = scanner.nextLine().trim().toUpperCase();
                //Con ayuda de .conversion_rates logramos llamar el valor de la api y convertirlo.
                Double tasaConversion = resultado.conversion_rates().get(monedaObjetivo);
                if (tasaConversion != null) {
                    System.out.print("Ingrese el monto que desea convertir: ");
                    double monto = scanner.nextDouble();

                    double montoConvertido = monto * tasaConversion;
                    System.out.println("El monto convertido de " + monto + " " + monedaBase + " a " + monedaObjetivo + " es: " + montoConvertido);
                } else {
                    System.out.println("No se encontró la tasa de conversión para " + monedaObjetivo);
                }
                historial.add(resultado);
            } catch (RuntimeException e) {
                e.printStackTrace();
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
        System.out.println(resultado);
        FileWriter usuario = new FileWriter("resultado.json");
        usuario.write(gson.toJson(resultado));
        usuario.close();

        System.out.println("***El Programa finalizo, hasta luego***\n" +
                "***************************************************");

        /*
        ConvercionDePeticio resultado = peticion.buscadorMonedas(monedaBase);

        System.out.println("Ingrese el código de la moneda a la que desea convertir: ");
        String monedaObjetivo = scanner.nextLine();
        /*
        System.out.println("Ingrese el monto a convertir");
        String montoDeUsuario = scanner.nextLine();
         ////
        Double tasaConversion = resultado.conversion_rates().get(monedaObjetivo);
        if (tasaConversion != null) {
            System.out.println("La tasa de conversión de " + monedaBase + " a " + monedaObjetivo + " es: " + tasaConversion);
        } else {
            System.out.println("No se encontró la tasa de conversión para " + monedaObjetivo);
        }
        */
    }
}
