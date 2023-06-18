package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RdBankTest {
    RdBank rdBank;
    @BeforeEach public void beforeEach(){
        rdBank = new RdBank();
        rdBank.registerNewCustomer("firstName", "lastName", "0123", 2000, "07031005737");
    }

    @Test public void testBankExist(){
        assertNotNull(rdBank);
    }


    @Test public void testBankCanRegisterNewCustomer(){
        assertEquals("""
                Name: firstName lastName
                AccountNumber: 7031005737
                AccountBalance: N2000
                """, rdBank.checkAndAccountDetails("7031005737", "0123"));
    }

    @Test public void testBankCanRegisterSeveralNewCustomers(){
        rdBank.registerNewCustomer("firstName", "lastName", "0124", 5000, "08034513898");

        assertEquals("""
                Name: firstName lastName
                AccountNumber: 7031005737
                AccountBalance: N2000
                """, rdBank.checkAndAccountDetails("7031005737", "0123"));

        assertEquals("""
                Name: firstName lastName
                AccountNumber: 8034513898
                AccountBalance: N5000
                """, rdBank.checkAndAccountDetails("8034513898", "0124"));
    }

    @Test public void testDepositingIntoAccount(){
        rdBank.deposit("7031005737", 1000);

        assertEquals("""
                Name: firstName lastName
                AccountNumber: 7031005737
                AccountBalance: N3000
                """, rdBank.checkAndAccountDetails("7031005737", "0123"));
    }

    @Test public void testWithdrawalFromAnAccount(){
        rdBank.withdraw("7031005737", "0123", 1000);

        assertEquals("""
                Name: firstName lastName
                AccountNumber: 7031005737
                AccountBalance: N1000
                """, rdBank.checkAndAccountDetails("7031005737", "0123"));
    }

    @Test public void testWithdrawalFromAnotherAccount(){
        rdBank.registerNewCustomer("firstName", "lastName", "0124", 5000, "08034513898");
        rdBank.withdraw("8034513898", "0124", 1300);

        assertEquals("""
                Name: firstName lastName
                AccountNumber: 8034513898
                AccountBalance: N3700
                """, rdBank.checkAndAccountDetails("8034513898", "0124"));
    }

    @Test public void testDepositingIntoAnotherAccount(){
        rdBank.registerNewCustomer("firstName", "lastName", "0124", 5000, "08034513898");
        rdBank.deposit("8034513898",  1000);

        assertEquals("""
                Name: firstName lastName
                AccountNumber: 8034513898
                AccountBalance: N6000
                """, rdBank.checkAndAccountDetails("8034513898", "0124"));
    }

    @Test public void testTransferBetweenAccounts(){
        rdBank.registerNewCustomer("firstName", "lastName", "0124", 2000, "08034513898");

        rdBank.transfer("7031005737", "0123", 1000, "8034513898");

        assertEquals("""
                Name: firstName lastName
                AccountNumber: 7031005737
                AccountBalance: N1000
                """, rdBank.checkAndAccountDetails("7031005737", "0123"));

        assertEquals("""
                Name: firstName lastName
                AccountNumber: 8034513898
                AccountBalance: N3000
                """, rdBank.checkAndAccountDetails("8034513898", "0124"));
    }

    @Test public void testRegisteringWithWrongPhoneNumber(){
        assertThrows(IllegalArgumentException.class, () ->
                rdBank.registerNewCustomer("firstName", "lastName", "0123", 2000, "0703005737"));
    }

    @Test public void testRegisteringWithPhoneNumberThatContainsAlphabet(){
        assertThrows(IllegalArgumentException.class, () ->
                rdBank.registerNewCustomer("firstName", "lastName", "0123", 2000, "0703100537a"));
    }

    @Test public void testRegisteringWithPinThatIsNotFourDigits(){
        assertThrows(IllegalArgumentException.class, () ->
                rdBank.registerNewCustomer("firstName", "lastName", "023", 2000, "07031005737"));
    }

    @Test public void testRegisteringWithPinThatContainsAlphabets(){
        assertThrows(IllegalArgumentException.class, () ->
                rdBank.registerNewCustomer("firstName", "lastName", "022Z", 2000, "07031005737"));
    }

    @Test public void testRegisteringWithAnAlreadyRegisteredPhoneNumber(){
        assertThrows(IllegalArgumentException.class, () -> rdBank.registerNewCustomer("firstName", "lastName", "0124", 2000, "07031005737"));
    }

    @Test public void testDepositingWithA_WrongAccountNumber(){
        assertThrows(IllegalArgumentException.class, () -> rdBank.deposit("70005537", 1000));
    }

    @Test public void testWithdrawalWithA_wrongPin(){
        assertThrows(IllegalArgumentException.class, () -> rdBank.withdraw("7031005737", "0023", 1000));
    }

    @Test public void testWithdrawingWithWrongAccountNumber(){
        assertThrows(IllegalArgumentException.class, () -> rdBank.withdraw("70005537", "0127", 2000));
    }

    @Test public void testTransferWithWrongReceiverAccount(){
        rdBank.registerNewCustomer("firstName", "lastName", "0124", 2000, "08034513898");

        assertThrows(IllegalArgumentException.class, () -> rdBank.transfer("7031005737", "0123", 1000, "8054513898"));

        assertEquals("""
                Name: firstName lastName
                AccountNumber: 7031005737
                AccountBalance: N2000
                """, rdBank.checkAndAccountDetails("7031005737", "0123"));

        assertEquals("""
                Name: firstName lastName
                AccountNumber: 8034513898
                AccountBalance: N2000
                """, rdBank.checkAndAccountDetails("8034513898", "0124"));
    }

    @Test public void testTransferWithWrongSenderAccount(){
        rdBank.registerNewCustomer("firstName", "lastName", "0124", 2000, "08034513898");

        assertThrows(IllegalArgumentException.class, () -> rdBank.transfer("7032005737", "0123", 1000, "8034513898"));

        assertEquals("""
                Name: firstName lastName
                AccountNumber: 7031005737
                AccountBalance: N2000
                """, rdBank.checkAndAccountDetails("7031005737", "0123"));

        assertEquals("""
                Name: firstName lastName
                AccountNumber: 8034513898
                AccountBalance: N2000
                """, rdBank.checkAndAccountDetails("8034513898", "0124"));
    }

}
