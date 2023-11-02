package hsw.gradle.application;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IBANTest {
    @Test void IBANDE() {
        String myIBAN = "DE68210501700012345678";
        IBAN classUnderTest = new IBAN(myIBAN);
        assertTrue(classUnderTest.check(myIBAN));
    }

    @Test void IBANWrong() {
        String myIBAN = "ZZ68210501700012345678";
        IBAN classUnderTest = new IBAN(myIBAN);
        assertFalse(classUnderTest.check(myIBAN));
    }

    @Test void IBANWrongCountry() {
        String myIBAN = "AB68210501700012345678";
        IBAN classUnderTest = new IBAN(myIBAN);
        assertFalse(classUnderTest.check(myIBAN));
    }

    @Test void IBANIgnoreCase() {
        String myIBAN = "de68210501700012345678";
        IBAN classUnderTest = new IBAN(myIBAN);
        assertTrue(classUnderTest.check(myIBAN));
    }
}
