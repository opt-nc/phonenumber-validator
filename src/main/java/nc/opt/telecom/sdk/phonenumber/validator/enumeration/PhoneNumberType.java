package nc.opt.telecom.sdk.phonenumber.validator.enumeration;

public enum PhoneNumberType {
    FIXE ("Fixe"),
    MOBILE ("Mobile"),
    URGENCES ("Urgences"),
    SOS("SOS"),
    SERVICES_OPT("Services OPT-NC"),
    INVALIDE("Invalide");

    private final String label;

    PhoneNumberType(String label){
        this.label = label;
    }

    public static PhoneNumberType valueOfLabel(String label) {
        for (PhoneNumberType e : values()) {
            if (e.label.equals(label)) {
                return e;
            }
        }
        return null;
    }

    public static String valueOf(PhoneNumberType type) {
        String label = null;
        for (PhoneNumberType e : values()) {
            if (e.name().equals(type.name())) {
                label = e.label;
            }
        }
        return label;
    }

}
