import java.util.Map;

public record ConvercionDePeticio (    String result,
                                       String provider,
                                       String documentation,
                                       String terms_of_use,
                                       long time_last_update_unix,
                                       String time_last_update_utc,
                                       long time_next_update_unix,
                                       String time_next_update_utc,
                                       String base_code,
                                       Map<String, Double> conversion_rates)/*String result,
                                  String documentation,
                                  String terms_of_use,
                                  long time_last_update_inix,
                                  String time_last_update_utc,
                                  long time_next_update_unix,
                                  String time_next_update_utc,
                                  String base_code,
                                  String conversion_rates,
                                   Map<String, Double> rates*/ {
}
