package nc.opt.telecom.sdk.phonenumber.validator;

import com.google.i18n.phonenumbers.NumberParseException;
import nc.opt.telecom.sdk.phonenumber.validator.util.PhoneNumberValidator;

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
        System.out.println("Type de numéro : " + PhoneNumberValidator.getPhoneType(mobilePhoneNumber));
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
        System.out.println("Type de numéro : " + PhoneNumberValidator.getPhoneType(invalidPhoneNumber));
        System.out.println("Mobile ? : " + (PhoneNumberValidator.isMobile(invalidPhoneNumber) ? "oui" : "non"));
        System.out.println("Fixe ? : " + (PhoneNumberValidator.isFixe(invalidPhoneNumber) ? "oui" : "non"));

        System.out.println("");

        String specialNumber = PhoneNumberValidator.format("1000");
        System.out.println("Numéro de téléphone formatté : " + specialNumber);
        System.out.println("Numéro valide ? " + (PhoneNumberValidator.isPossible(specialNumber) ? "oui" : "non"));
        System.out.println("Type de numéro : " + PhoneNumberValidator.getPhoneType(specialNumber));
        System.out.println("Mobile ? : " + (PhoneNumberValidator.isMobile(specialNumber) ? "oui" : "non"));
        System.out.println("Fixe ? : " + (PhoneNumberValidator.isFixe(specialNumber) ? "oui" : "non"));
        System.out.println("Special ? : " + (PhoneNumberValidator.isSpecial(specialNumber) ? "oui" : "non"));
        System.out.println("Attribué ? : " + PhoneNumberValidator.getSpecialNumberLabel(specialNumber) );

        System.out.println("");

        specialNumber = PhoneNumberValidator.format("15");
        System.out.println("Numéro de téléphone formatté : " + specialNumber);
        System.out.println("Numéro valide ? " + (PhoneNumberValidator.isPossible(specialNumber) ? "oui" : "non"));
        System.out.println("Type de numéro : " + PhoneNumberValidator.getPhoneType(specialNumber));
        System.out.println("Mobile ? : " + (PhoneNumberValidator.isMobile(specialNumber) ? "oui" : "non"));
        System.out.println("Fixe ? : " + (PhoneNumberValidator.isFixe(specialNumber) ? "oui" : "non"));
        System.out.println("Special ? : " + (PhoneNumberValidator.isSpecial(specialNumber) ? "oui" : "non"));
        System.out.println("Attribué ? : " + PhoneNumberValidator.getSpecialNumberLabel(specialNumber) );

        System.out.println("");

        specialNumber = PhoneNumberValidator.format("053030");
        System.out.println("Numéro de téléphone formatté : " + specialNumber);
        System.out.println("Numéro valide ? " + (PhoneNumberValidator.isPossible(specialNumber) ? "oui" : "non"));
        System.out.println("Type de numéro : " + PhoneNumberValidator.getPhoneType(specialNumber));
        System.out.println("Mobile ? : " + (PhoneNumberValidator.isMobile(specialNumber) ? "oui" : "non"));
        System.out.println("Fixe ? : " + (PhoneNumberValidator.isFixe(specialNumber) ? "oui" : "non"));
        System.out.println("Special ? : " + (PhoneNumberValidator.isSpecial(specialNumber) ? "oui" : "non"));
        System.out.println("Attribué ? : " + PhoneNumberValidator.getSpecialNumberLabel(specialNumber) );
    }
}
