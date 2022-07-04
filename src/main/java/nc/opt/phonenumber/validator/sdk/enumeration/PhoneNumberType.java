package nc.opt.phonenumber.validator.sdk.enumeration;

public enum PhoneNumberType {
    FIXE ("Fixe"),
    MOBILE ("Mobile"),
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

}
