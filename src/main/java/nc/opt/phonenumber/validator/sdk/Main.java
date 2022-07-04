package nc.opt.phonenumber.validator.sdk;

import com.google.i18n.phonenumbers.NumberParseException;
import nc.opt.phonenumber.validator.sdk.validator.PhoneNumberValidator;

public class Main
{
    public static void main( String[] args ) throws NumberParseException {


        System.out.println("Numéro de téléphone saisi : 514243" );
        try {
            PhoneNumberValidator.checkPhoneNumber("514243");
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
        String mobilePhoneNumber = PhoneNumberValidator.format("514243");
        System.out.println("Numéro de téléphone formatté : " + mobilePhoneNumber);
        System.out.println("Numéro valide ? " + (PhoneNumberValidator.isPossible(mobilePhoneNumber) ? "oui" : "non"));
        System.out.println("Type de numéro : " + PhoneNumberValidator.getPhoneType(mobilePhoneNumber).name());
        System.out.println("Mobile ? : " + (PhoneNumberValidator.isMobile(mobilePhoneNumber) ? "oui" : "non"));
        System.out.println("Fixe ? : " + (PhoneNumberValidator.isFixe(mobilePhoneNumber) ? "oui" : "non"));

        System.out.println("");

        System.out.println("Numéro de téléphone saisi : 114243" );
        try {
            PhoneNumberValidator.checkPhoneNumber("114243");
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
        String invalidPhoneNumber = PhoneNumberValidator.format("114243");
        System.out.println("Numéro de téléphone formatté : " + invalidPhoneNumber);
        System.out.println("Numéro valide ? " + (PhoneNumberValidator.isPossible(invalidPhoneNumber) ? "oui" : "non"));
        System.out.println("Type de numéro : " + PhoneNumberValidator.getPhoneType(invalidPhoneNumber).name());
        System.out.println("Mobile ? : " + (PhoneNumberValidator.isMobile(invalidPhoneNumber) ? "oui" : "non"));
        System.out.println("Fixe ? : " + (PhoneNumberValidator.isFixe(invalidPhoneNumber) ? "oui" : "non"));

    }
}
