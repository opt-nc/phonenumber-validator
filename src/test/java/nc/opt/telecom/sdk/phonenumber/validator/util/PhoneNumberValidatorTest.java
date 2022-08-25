package nc.opt.telecom.sdk.phonenumber.validator.util;

import com.google.i18n.phonenumbers.NumberParseException;
import nc.opt.telecom.sdk.phonenumber.validator.bean.SpecialNumber;
import nc.opt.telecom.sdk.phonenumber.validator.enumeration.PhoneNumberType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneNumberValidatorTest {

    @Test
    public void isFixeNumberTest(){
        assertTrue(PhoneNumberValidator.isFixe("+687214243"));//fixe
        assertTrue(PhoneNumberValidator.isFixe("+687314243"));//fixe
        assertTrue(PhoneNumberValidator.isFixe("+687414243"));//fixe

        assertFalse(PhoneNumberValidator.isFixe("+687514243"));//mobile
        assertFalse(PhoneNumberValidator.isFixe("+687714243"));//mobile
        assertFalse(PhoneNumberValidator.isFixe("+687814243"));//mobile
        assertFalse(PhoneNumberValidator.isFixe("+687914243"));//mobile
        assertFalse(PhoneNumberValidator.isFixe("+687114243"));
        assertFalse(PhoneNumberValidator.isFixe("+687614243"));

        assertFalse(PhoneNumberValidator.isFixe("+68715"));//urgence
        assertFalse(PhoneNumberValidator.isFixe("15"));//urgence
        assertFalse(PhoneNumberValidator.isFixe("+6871000"));//service opt
        assertFalse(PhoneNumberValidator.isFixe("1000"));//service opt
        assertFalse(PhoneNumberValidator.isFixe("+687053030"));//SOS
        assertFalse(PhoneNumberValidator.isFixe("053030"));//SOS

        assertThrowsExactly(IllegalArgumentException.class,
                () -> PhoneNumberValidator.isFixe(null), "Le numéro est invalide : null ou vide");
    }

    @Test
    public void isSpecialNumberTest() {
        assertFalse(PhoneNumberValidator.isSpecial("+687214243"));//fixe
        assertFalse(PhoneNumberValidator.isSpecial("+687314243"));//fixe
        assertFalse(PhoneNumberValidator.isSpecial("+687414243"));//fixe

        assertFalse(PhoneNumberValidator.isSpecial("+687514243"));//mobile
        assertFalse(PhoneNumberValidator.isSpecial("+687714243"));//mobile
        assertFalse(PhoneNumberValidator.isSpecial("+687814243"));//mobile
        assertFalse(PhoneNumberValidator.isSpecial("+687914243"));//mobile
        assertFalse(PhoneNumberValidator.isSpecial("+687114243"));
        assertFalse(PhoneNumberValidator.isSpecial("+687614243"));

        assertTrue(PhoneNumberValidator.isSpecial("+68715"));//urgence
        assertTrue(PhoneNumberValidator.isSpecial("15"));//urgence
        assertTrue(PhoneNumberValidator.isSpecial("+6871000"));//service opt
        assertTrue(PhoneNumberValidator.isSpecial("1000"));//service opt
        assertTrue(PhoneNumberValidator.isSpecial("+687053030"));//SOS
        assertTrue(PhoneNumberValidator.isSpecial("053030"));//SOS

        assertThrowsExactly(IllegalArgumentException.class,
                () -> PhoneNumberValidator.isSpecial(null), "Le numéro est invalide : null ou vide");
    }

    @Test
    public void getSpecialNumberTypeTest() {

        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.URGENCES),
                PhoneNumberValidator.getSpecialNumberType("+68715"));//urgence
        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.URGENCES),
                PhoneNumberValidator.getSpecialNumberType("15"));//urgence

        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.SERVICES_OPT),
                PhoneNumberValidator.getSpecialNumberType("+6871000"));//service opt
        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.SERVICES_OPT),
                PhoneNumberValidator.getSpecialNumberType("1000"));//service opt

        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.SOS),
                PhoneNumberValidator.getSpecialNumberType("+687053030"));//SOS
        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.SOS),
                PhoneNumberValidator.getSpecialNumberType("053030"));//SOS

        assertThrowsExactly(IllegalArgumentException.class,
                () -> PhoneNumberValidator.getSpecialNumberType("85"), "Ce numéro n'est pas un numéro spécial.");
        assertThrowsExactly(IllegalArgumentException.class,
                () -> PhoneNumberValidator.getSpecialNumberType("+68785"), "Ce numéro n'est pas un numéro spécial.");
        assertThrowsExactly(IllegalArgumentException.class,
                () -> PhoneNumberValidator.getSpecialNumberType("242526"), "Ce numéro n'est pas un numéro spécial.");
        assertThrowsExactly(IllegalArgumentException.class,
                () -> PhoneNumberValidator.getSpecialNumberType("+687242526"), "Ce numéro n'est pas un numéro spécial.");

    }

    @Test
    public void getSpecialNumberLabelTest() {

        assertEquals(SpecialNumber.urgences.get("15"), PhoneNumberValidator.getSpecialNumberLabel("+68715"));//urgence
        assertEquals(SpecialNumber.urgences.get("15"), PhoneNumberValidator.getSpecialNumberLabel("15"));//urgence

        assertEquals(SpecialNumber.opt_services.get("1000"), PhoneNumberValidator.getSpecialNumberLabel("+6871000"));//service opt
        assertEquals(SpecialNumber.opt_services.get("1000"), PhoneNumberValidator.getSpecialNumberLabel("1000"));//service opt

        assertEquals(SpecialNumber.sos.get("053030"), PhoneNumberValidator.getSpecialNumberLabel("+687053030"));//sos
        assertEquals(SpecialNumber.sos.get("053030"), PhoneNumberValidator.getSpecialNumberLabel("053030"));//sos

        assertThrowsExactly(IllegalArgumentException.class,
                () -> PhoneNumberValidator.getSpecialNumberLabel("85"), "Ce numéro n'est pas un numéro spécial.");
        assertThrowsExactly(IllegalArgumentException.class,
                () -> PhoneNumberValidator.getSpecialNumberLabel("+68785"), "Ce numéro n'est pas un numéro spécial.");
        assertThrowsExactly(IllegalArgumentException.class,
                () -> PhoneNumberValidator.getSpecialNumberLabel("242526"), "Ce numéro n'est pas un numéro spécial.");
        assertThrowsExactly(IllegalArgumentException.class,
                () -> PhoneNumberValidator.getSpecialNumberLabel("+687242526"), "Ce numéro n'est pas un numéro spécial.");

    }

    @Test
    public void isMobileNumberTest(){
        assertTrue(PhoneNumberValidator.isMobile("+687514243"));//mobile
        assertTrue(PhoneNumberValidator.isMobile("+687714243"));//mobile
        assertTrue(PhoneNumberValidator.isMobile("+687814243"));//mobile
        assertTrue(PhoneNumberValidator.isMobile("+687914243"));//mobile

        assertFalse(PhoneNumberValidator.isMobile("+687214243"));//fixe
        assertFalse(PhoneNumberValidator.isMobile("+687314243"));//fixe
        assertFalse(PhoneNumberValidator.isMobile("+687414243"));//fixe
        assertFalse(PhoneNumberValidator.isMobile("+687114243"));
        assertFalse(PhoneNumberValidator.isMobile("+687614243"));

        assertFalse(PhoneNumberValidator.isMobile("+68715"));//urgence
        assertFalse(PhoneNumberValidator.isMobile("15"));//urgence
        assertFalse(PhoneNumberValidator.isMobile("+6871000"));//service opt
        assertFalse(PhoneNumberValidator.isMobile("1000"));//service opt
        assertFalse(PhoneNumberValidator.isMobile("+687053030"));//SOS
        assertFalse(PhoneNumberValidator.isMobile("053030"));//SOS

        assertThrowsExactly(IllegalArgumentException.class,
                () -> PhoneNumberValidator.isMobile(null), "Le numéro est invalide : null ou vide");
    }


    @Test
    public void isPossibleNumberTest(){
        assertFalse(PhoneNumberValidator.isPossible("+687114243"));
        assertTrue(PhoneNumberValidator.isPossible("+687274268"));//fixe
        assertTrue(PhoneNumberValidator.isPossible("+687314243"));//fixe
        assertTrue(PhoneNumberValidator.isPossible("+687414243"));//fixe

        assertTrue(PhoneNumberValidator.isPossible("+687514243"));//mobile
        assertFalse(PhoneNumberValidator.isPossible("+687614243"));
        assertTrue(PhoneNumberValidator.isPossible("+687714243"));//mobile
        assertTrue(PhoneNumberValidator.isPossible("+687814243"));//mobile
        assertTrue(PhoneNumberValidator.isPossible("+687914243"));//mobile

        assertTrue(PhoneNumberValidator.isPossible("+68715"));//urgence
        assertTrue(PhoneNumberValidator.isPossible("15"));//urgence
        assertTrue(PhoneNumberValidator.isPossible("+6871000"));//service opt
        assertTrue(PhoneNumberValidator.isPossible("1000"));//service opt
        assertTrue(PhoneNumberValidator.isPossible("+687053030"));//SOS
        assertTrue(PhoneNumberValidator.isPossible("053030"));//SOS

        assertThrowsExactly(IllegalArgumentException.class,
                () -> PhoneNumberValidator.isPossible(null), "Le numéro est invalide : null ou vide");

    }

    @Test
    public void formatSuccessTest()  throws NumberParseException {
        assertEquals("+687419358", PhoneNumberValidator.format("419358"));
        assertEquals("+687419358", PhoneNumberValidator.format("419358"));
        assertEquals("+687419358", PhoneNumberValidator.format("+687419358"));
        assertEquals("+687419358", PhoneNumberValidator.format("00687419358"));
        assertEquals("+687419358", PhoneNumberValidator.format("41/93/58"));
        assertEquals("+687419358", PhoneNumberValidator.format("41.93.58"));
        assertEquals("+68715", PhoneNumberValidator.format("15"));

    }

    @Test
    public void formatFailedTest() throws NumberParseException {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> PhoneNumberValidator.format("41 9a 58"));
        assertTrue(exception.getMessage().contains("Le numéro doit être sur 10 caractères"));
    }

    @Test
    public void getPhoneNumberTypeTest(){
        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.MOBILE), PhoneNumberValidator.getPhoneType("+687514243"));//mobile
        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.MOBILE), PhoneNumberValidator.getPhoneType("+687714243"));//mobile
        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.MOBILE), PhoneNumberValidator.getPhoneType("+687814243"));//mobile
        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.MOBILE), PhoneNumberValidator.getPhoneType("+687914243"));//mobile

        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.FIXE), PhoneNumberValidator.getPhoneType("+687274268"));//fixe
        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.FIXE), PhoneNumberValidator.getPhoneType("+687314243"));//fixe
        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.FIXE), PhoneNumberValidator.getPhoneType("+687414243"));//fixe

        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.INVALIDE), PhoneNumberValidator.getPhoneType("+687114243"));
        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.INVALIDE), PhoneNumberValidator.getPhoneType("+687614243"));

        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.URGENCES),PhoneNumberValidator.getPhoneType("+68715"));//urgence
        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.URGENCES),PhoneNumberValidator.getPhoneType("15"));//urgence
        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.SERVICES_OPT),PhoneNumberValidator.getPhoneType("+6871000"));//service opt
        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.SERVICES_OPT),PhoneNumberValidator.getPhoneType("1000"));//service opt
        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.SOS),PhoneNumberValidator.getPhoneType("+687053030"));//SOS
        assertEquals(PhoneNumberType.valueOf(PhoneNumberType.SOS),PhoneNumberValidator.getPhoneType("053030"));//SOS
    }

    @Test
    public void checkPhoneNumberFailedTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> PhoneNumberValidator.checkPhoneNumber(""));
        assertTrue(exception.getMessage().contains("Le numéro est invalide : null ou vide"));

        exception = assertThrows(IllegalArgumentException.class, () -> PhoneNumberValidator.checkPhoneNumber(null));
        assertTrue(exception.getMessage().contains("Le numéro est invalide : null ou vide"));

        exception = assertThrows(IllegalArgumentException.class, () -> PhoneNumberValidator.checkPhoneNumber("419358"));
        assertTrue(exception.getMessage().contains("Le numéro doit commencer par +687"));

        exception = assertThrows(IllegalArgumentException.class, () -> PhoneNumberValidator.checkPhoneNumber("+687419358675"));
        assertTrue(exception.getMessage().contains("Le numéro doit être sur 10 caractères"));

        exception = assertThrows(IllegalArgumentException.class, () -> PhoneNumberValidator.checkPhoneNumber("+68741.93.58"));
        assertTrue(exception.getMessage().contains("Le numéro ne doit contenir que des chiffres."));

        exception = assertThrows(IllegalArgumentException.class, () -> PhoneNumberValidator.checkPhoneNumber("+68793585"));
        assertTrue(exception.getMessage().contains("Le numéro doit être sur 10 caractères"));

    }


}
