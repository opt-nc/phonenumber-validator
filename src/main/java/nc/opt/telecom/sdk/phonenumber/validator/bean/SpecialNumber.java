package nc.opt.telecom.sdk.phonenumber.validator.bean;

import java.util.HashMap;
import java.util.Map;

public class SpecialNumber {

    public static final Map<String, String> urgences = new HashMap<String, String>(){
        {
            put("15", "SAMU");
            put("16", "Secours en mer");
            put("17", "Police");
            put("18", "Pompiers");
            put("112", "Numéro d'appel d'urgence européen");
            put("114", "Numéro d'appel d'urgence malentendants");
            put("1022", "Police municipale de la ville de Nouméa");
        }
    };

    public static final Map<String, String> opt_services = new HashMap<String, String>() {
        {
            put("1000", "Service clientèle");
            put("1010", "Mobitag");
            put("1012", "Renseignements téléphoniques");
            put("1013", "Dérangements téléphonique");
            put("1016", "Agence Entreprises");
            put("1022", "");
        }
    };

    public static final Map<String, String> sos = new HashMap<String, String>() {
        {
            put("054444", "Enfance maltraitée");
            put("050006", "Familles d'accueil pour l'aide sociale  à l'enfance");
            put("051010", "SOS SIDA");
            put("051111", "SOS Violences sexuelles");
            put("053030", "SOS Ecoute");
            put("204759", "Centre de dépistage  du VUH/SIDA");
        }
    };


}
