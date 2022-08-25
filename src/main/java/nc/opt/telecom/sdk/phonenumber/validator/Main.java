package nc.opt.telecom.sdk.phonenumber.validator;

import com.google.i18n.phonenumbers.NumberParseException;
import nc.opt.telecom.sdk.phonenumber.validator.util.PhoneNumberValidator;

public class Main
{
    public static void main( String[] args ) throws NumberParseException {


        System.out.println("Numéro de téléphone saisi : 514243");
        try {
            PhoneNumberValidator.checkPhoneNumber("514243");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        displayPhoneNumberInfo("514243");

        displayPhoneNumberInfo("114243");
        displayPhoneNumberInfo("1000");
        displayPhoneNumberInfo("15");
        displayPhoneNumberInfo("053030");

    }

    private static void displayPhoneNumberInfo (String phoneNumber) throws NumberParseException {
        phoneNumber = PhoneNumberValidator.format(phoneNumber);
        System.out.println("Numéro de téléphone formatté : " + phoneNumber);
        System.out.println("Numéro valide ? " + (PhoneNumberValidator.isPossible(phoneNumber) ? "oui" : "non"));
        System.out.println("Type de numéro : " + PhoneNumberValidator.getPhoneType(phoneNumber));
        System.out.println("Mobile ? : " + (PhoneNumberValidator.isMobile(phoneNumber) ? "oui" : "non"));
        System.out.println("Fixe ? : " + (PhoneNumberValidator.isFixe(phoneNumber) ? "oui" : "non"));
        System.out.println("Special ? : " + (PhoneNumberValidator.isSpecial(phoneNumber) ? "oui" : "non"));
        if(PhoneNumberValidator.isSpecial(phoneNumber))
            System.out.println("Attribué : " + PhoneNumberValidator.getSpecialNumberLabel(phoneNumber));

        System.out.println("");
    }
}
