package nc.opt.telecom.sdk.phonenumber.validator.util;

import com.google.i18n.phonenumbers.NumberParseException;
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

    }

    @Test
    public void formatSuccessTest()  throws NumberParseException {
        assertEquals("+687419358", PhoneNumberValidator.format("419358"));
        assertEquals("+687419358", PhoneNumberValidator.format("419358"));
        assertEquals("+687419358", PhoneNumberValidator.format("+687419358"));
        assertEquals("+687419358", PhoneNumberValidator.format("00687419358"));

    }

    @Test
    public void formatFailedTest() {
        assertThrows(NumberFormatException.class, () -> PhoneNumberValidator.format("41.93.58"));
        assertThrows(NumberFormatException.class, () -> PhoneNumberValidator.format("41/93/58"));
        assertThrows(NumberFormatException.class, () -> PhoneNumberValidator.format("41 93 58"));
        assertThrows(NumberFormatException.class, () -> PhoneNumberValidator.format("41 9a 58"));
    }

    @Test
    public void getPhoneNumberTypeTest(){
        assertEquals(PhoneNumberType.MOBILE, PhoneNumberValidator.getPhoneType("+687514243"));//mobile
        assertEquals(PhoneNumberType.MOBILE, PhoneNumberValidator.getPhoneType("+687714243"));//mobile
        assertEquals(PhoneNumberType.MOBILE, PhoneNumberValidator.getPhoneType("+687814243"));//mobile
        assertEquals(PhoneNumberType.MOBILE, PhoneNumberValidator.getPhoneType("+687914243"));//mobile

        assertEquals(PhoneNumberType.FIXE, PhoneNumberValidator.getPhoneType("+687274268"));//fixe
        assertEquals(PhoneNumberType.FIXE, PhoneNumberValidator.getPhoneType("+687314243"));//fixe
        assertEquals(PhoneNumberType.FIXE, PhoneNumberValidator.getPhoneType("+687414243"));//fixe

        assertEquals(PhoneNumberType.INVALIDE, PhoneNumberValidator.getPhoneType("+687114243"));
        assertEquals(PhoneNumberType.INVALIDE, PhoneNumberValidator.getPhoneType("+687614243"));
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
        assertTrue(exception.getMessage().contains("Le numéro doit être sur 10 caractères"));

        exception = assertThrows(IllegalArgumentException.class, () -> PhoneNumberValidator.checkPhoneNumber("+687.93.58"));
        assertTrue(exception.getMessage().contains("Le numéro ne doit contenir que des chiffres."));
    }
}
