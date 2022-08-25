package nc.opt.telecom.sdk.phonenumber.validator.util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import nc.opt.telecom.sdk.phonenumber.validator.bean.SpecialNumber;
import nc.opt.telecom.sdk.phonenumber.validator.enumeration.PhoneNumberType;

import java.util.Objects;
import java.util.function.Predicate;

public class PhoneNumberValidator {

    public static final String INDICATIF = "+687";
    public static final int NUMBER_LENGTH = 10;
    public static final int NATIONAL_NUMBER_INDEX = 4;
    public static final String PATTERN_FIXE = "^(2|3|4)[0-9]{5}";
    public static final String PATTERN_MOBILE = "^(5|7|8|9)[0-9]{5}";
    public static final int NEW_CAL_COUNTRY_CODE = 687;


    public static boolean isSpecial(String phoneNumber){
        checkSpecialPhoneNumber(phoneNumber);

        return SpecialNumber.urgences.keySet().stream().anyMatch(Predicate.isEqual(phoneNumber.replace(INDICATIF, ""))) ||
                SpecialNumber.opt_services.keySet().stream().anyMatch(Predicate.isEqual(phoneNumber.replace(INDICATIF, ""))) ||
                SpecialNumber.sos.keySet().stream().anyMatch(Predicate.isEqual(phoneNumber.replace(INDICATIF, "")));
    }

    public static String getSpecialNumberType(String phoneNumber){
        checkSpecialPhoneNumber(phoneNumber);

        if(SpecialNumber.urgences.keySet().stream().anyMatch(Predicate.isEqual(phoneNumber.replace(INDICATIF, ""))))
            return PhoneNumberType.valueOf(PhoneNumberType.URGENCES);

        if(SpecialNumber.opt_services.keySet().stream().anyMatch(Predicate.isEqual(phoneNumber.replace(INDICATIF, ""))))
            return PhoneNumberType.valueOf(PhoneNumberType.SERVICES_OPT);

        if(SpecialNumber.sos.keySet().stream().anyMatch(Predicate.isEqual(phoneNumber.replace(INDICATIF, ""))))
            return PhoneNumberType.valueOf(PhoneNumberType.SOS);

        throw new IllegalArgumentException("Ce numéro n'est pas un numéro spécial.");
    }

    public static String getSpecialNumberLabel(String phoneNumber){
        checkSpecialPhoneNumber(phoneNumber);

        if(SpecialNumber.urgences.keySet().stream().anyMatch(Predicate.isEqual(phoneNumber.replace(INDICATIF, ""))))
            return SpecialNumber.urgences.get(phoneNumber.replace(INDICATIF, ""));

        if(SpecialNumber.opt_services.keySet().stream().anyMatch(Predicate.isEqual(phoneNumber.replace(INDICATIF, ""))))
            return SpecialNumber.opt_services.get(phoneNumber.replace(INDICATIF, ""));

        if(SpecialNumber.sos.keySet().stream().anyMatch(Predicate.isEqual(phoneNumber.replace(INDICATIF, ""))))
            return SpecialNumber.sos.get(phoneNumber.replace(INDICATIF, ""));

        throw new IllegalArgumentException("Ce numéro n'est pas un numéro spécial.");
    }


    public static boolean isFixe(String phoneNumber){
        checkPhoneNumber(phoneNumber);

        String nationalNumber = phoneNumber.replace(INDICATIF, "");
        if(nationalNumber.matches(PATTERN_FIXE))
            return true;

        return false;
    }

    public static boolean isMobile(String phoneNumber){
        checkPhoneNumber(phoneNumber);

        String nationalNumber = phoneNumber.replace(INDICATIF, "");
        if(nationalNumber.matches(PATTERN_MOBILE))
            return true;

        return false;
    }

    public static boolean isPossible(String phoneNumber){
//        if(!isSpecial(phoneNumber))
//            checkPhoneNumber(phoneNumber);
        return isMobile(phoneNumber) || isFixe(phoneNumber) || isSpecial(phoneNumber);
    }

    public static final String getPhoneType(String phoneNumber){
        if(isFixe(phoneNumber))
            return PhoneNumberType.valueOf(PhoneNumberType.FIXE);
        if(isMobile(phoneNumber))
            return PhoneNumberType.valueOf(PhoneNumberType.MOBILE);
        if(isSpecial(phoneNumber))
            return getSpecialNumberType(phoneNumber);
        return PhoneNumberType.valueOf(PhoneNumberType.INVALIDE);
    }

    public static void checkPhoneNumber(String phoneNumber) {
        if (Objects.isNull(phoneNumber) || phoneNumber.isEmpty())
            throw new IllegalArgumentException("Le numéro est invalide : null ou vide");

        if (!phoneNumber.startsWith(INDICATIF))
            if(!isSpecial(phoneNumber))
                throw new IllegalArgumentException("Le numéro doit commencer par +687");

        String nationalNumber = phoneNumber.replace(INDICATIF, "");
        if (!isNumeric(nationalNumber))
            throw new IllegalArgumentException("Le numéro ne doit contenir que des chiffres.");

        if (phoneNumber.length() != NUMBER_LENGTH)
            if(!isSpecial(phoneNumber.replace(INDICATIF, "")))
                throw new IllegalArgumentException("Le numéro doit être sur 10 caractères");
    }

    public static void checkSpecialPhoneNumber(String phoneNumber) {
        if (Objects.isNull(phoneNumber) || phoneNumber.isEmpty())
            throw new IllegalArgumentException("Le numéro est invalide : null ou vide");

        String nationalNumber = phoneNumber.replace(INDICATIF, "");
        if (!isNumeric(nationalNumber))
            throw new IllegalArgumentException("Le numéro ne doit contenir que des chiffres.");
    }

    public static String format(String phoneNumber) throws NumberParseException {
        Phonenumber.PhoneNumber number = new Phonenumber.PhoneNumber();
        number.setCountryCode(NEW_CAL_COUNTRY_CODE);
        String regionCode = PhoneNumberUtil.getInstance().getRegionCodeForCountryCode(NEW_CAL_COUNTRY_CODE);

        PhoneNumberUtil.getInstance().parse(phoneNumber, regionCode, number);
        String formatedPhoneNumber = PhoneNumberUtil.getInstance().format(number, PhoneNumberUtil.PhoneNumberFormat.E164);
        checkPhoneNumber(formatedPhoneNumber);
        return formatedPhoneNumber;
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
