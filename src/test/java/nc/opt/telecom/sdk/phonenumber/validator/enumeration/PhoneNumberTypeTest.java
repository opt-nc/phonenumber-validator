package nc.opt.telecom.sdk.phonenumber.validator.enumeration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PhoneNumberTypeTest {

    @Test
    public void phoneTypeLabelTest(){
        assertEquals(PhoneNumberType.FIXE, PhoneNumberType.valueOfLabel("Fixe"));
        assertEquals(PhoneNumberType.MOBILE, PhoneNumberType.valueOfLabel("Mobile"));
        assertEquals(PhoneNumberType.INVALIDE, PhoneNumberType.valueOfLabel("Invalide"));
        assertNull(PhoneNumberType.valueOfLabel("fibre"));
    }
}
