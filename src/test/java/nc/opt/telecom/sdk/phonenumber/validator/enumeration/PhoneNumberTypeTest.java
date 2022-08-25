package nc.opt.telecom.sdk.phonenumber.validator.enumeration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PhoneNumberTypeTest {

    @Test
    public void phoneTypeLabelTest(){
        assertEquals(PhoneNumberType.FIXE, PhoneNumberType.valueOfLabel("Fixe"));
        assertEquals(PhoneNumberType.MOBILE, PhoneNumberType.valueOfLabel("Mobile"));
        assertEquals(PhoneNumberType.INVALIDE, PhoneNumberType.valueOfLabel("Invalide"));
        assertEquals(PhoneNumberType.SERVICES_OPT, PhoneNumberType.valueOfLabel("Services OPT-NC"));
        assertEquals(PhoneNumberType.SOS, PhoneNumberType.valueOfLabel("SOS"));
        assertEquals(PhoneNumberType.URGENCES, PhoneNumberType.valueOfLabel("Urgences"));
        assertNull(PhoneNumberType.valueOfLabel("fibre"));
    }

    @Test
    public void phoneTypeValueOfTest(){
        assertEquals("Fixe", PhoneNumberType.valueOf(PhoneNumberType.FIXE));
        assertEquals("Mobile", PhoneNumberType.valueOf(PhoneNumberType.MOBILE));
        assertEquals("Invalide", PhoneNumberType.valueOf(PhoneNumberType.INVALIDE));
        assertEquals("Services OPT-NC", PhoneNumberType.valueOf(PhoneNumberType.SERVICES_OPT));
        assertEquals("SOS", PhoneNumberType.valueOf(PhoneNumberType.SOS));
        assertEquals("Urgences", PhoneNumberType.valueOf(PhoneNumberType.URGENCES));
    }
}
