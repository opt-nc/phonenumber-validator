package nc.opt.telecom.sdk.phonenumber.validator.util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import nc.opt.telecom.sdk.phonenumber.validator.enumeration.PhoneNumberType;

import java.util.Objects;

public class PhoneNumberValidator {

    public static final String INDICATIF = "+687";
    public static final int NUMBER_LENGTH = 10;
    public static final int NATIONAL_NUMBER_INDEX = 4;
    public static final String PATTERN_FIXE = "^(2|3|4)[0-9]{5}";
    public static final String PATTERN_MOBILE = "^(5|7|8|9)[0-9]{5}";
    public static final int NEW_CAL_COUNTRY_CODE = 687;



    public static boolean isFixe(String phoneNumber){
        checkPhoneNumber(phoneNumber);

        String nationalNumber = phoneNumber.substring(NATIONAL_NUMBER_INDEX);
        if(nationalNumber.matches(PATTERN_FIXE))
            return true;

        return false;
    }

    public static boolean isMobile(String phoneNumber){
        checkPhoneNumber(phoneNumber);

        String nationalNumber = phoneNumber.substring(NATIONAL_NUMBER_INDEX);
        if(nationalNumber.matches(PATTERN_MOBILE))
            return true;

        return false;
    }

    public static boolean isPossible(String phoneNumber){
        checkPhoneNumber(phoneNumber);
        return isMobile(phoneNumber) || isFixe(phoneNumber);
    }

    public static final PhoneNumberType getPhoneType(String phoneNumber){
        if(isFixe(phoneNumber))
            return PhoneNumberType.FIXE;
        if(isMobile(phoneNumber))
            return PhoneNumberType.MOBILE;
        return PhoneNumberType.INVALIDE;
    }

    public static void checkPhoneNumber(String phoneNumber) {
        if (Objects.isNull(phoneNumber) || phoneNumber.isEmpty())
            throw new IllegalArgumentException("Le numéro est invalide : null ou vide");

        if (!phoneNumber.startsWith(INDICATIF))
            throw new IllegalArgumentException("Le numéro doit commencer par +687");

        if (phoneNumber.length() != NUMBER_LENGTH)
            throw new IllegalArgumentException("Le numéro doit être sur 10 caractères");

        String nationalNumber = phoneNumber.substring(NATIONAL_NUMBER_INDEX);
        if (!isNumeric(nationalNumber))
            throw new IllegalArgumentException("Le numéro ne doit contenir que des chiffres.");
    }

    public static String format(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber number = new Phonenumber.PhoneNumber();
        String nationalNumber = phoneNumber.substring(NATIONAL_NUMBER_INDEX);
        number.setCountryCode(NEW_CAL_COUNTRY_CODE).setNationalNumber(Long.valueOf(nationalNumber));
        String regionCode = PhoneNumberUtil.getInstance().getRegionCodeForCountryCode(NEW_CAL_COUNTRY_CODE);

        PhoneNumberUtil.getInstance().parse(phoneNumber, regionCode, number);
        return PhoneNumberUtil.getInstance().format(number, PhoneNumberUtil.PhoneNumberFormat.E164);
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
