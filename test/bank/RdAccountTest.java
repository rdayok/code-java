package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RdAccountTest {

    RdAccount rdAccount;
    @BeforeEach public void beforeEach(){
        rdAccount = new RdAccount("firstName", "lastName", "0123",  2000, "07031005737");
    }

    @Test public void testAccountObjectExist(){
        assertNotNull(rdAccount);
    }

    @Test public void testDepositingIntoAccount(){
        rdAccount.deposit(1000);

        assertEquals(3000, rdAccount.checkBalance("0123"));
    }

    @Test public void testDepositingIntoAccountTwice(){
        rdAccount.deposit(1000);
        rdAccount.deposit(2000);

        assertEquals(5000, rdAccount.checkBalance("0123"));
    }

    @Test public void testWithDrawingFromAccount(){
        rdAccount.deposit(1000);

        rdAccount.withdraw(2000, "0123");

        assertEquals(1000, rdAccount.checkBalance("0123"));
    }

    @Test public void testWithDrawingFromAccountTwice(){
        rdAccount.deposit(1000);

        rdAccount.withdraw(1000, "0123");
        rdAccount.withdraw(1000, "0123");

        assertEquals(1000, rdAccount.checkBalance("0123"));
    }

    @Test public void testWithdrawingNegativeAmount(){

        assertThrows(IllegalArgumentException.class, () -> rdAccount.withdraw(-1000, "0123" ));
        assertEquals(2000, rdAccount.checkBalance("0123"));
    }

    @Test public void testWithdrawingAmountGreaterThanAccountBalance(){

        assertThrows(IllegalArgumentException.class, () -> rdAccount.withdraw(5000, "0123"));
        assertEquals(2000, rdAccount.checkBalance("0123"));
    }

    @Test public void testCheckingBalanceWithWrongPin(){
        assertThrows(IllegalArgumentException.class, () -> rdAccount.checkBalance("0111"));
    }

    @Test public void testWithdrawingWithWrongPin(){

        assertThrows(IllegalArgumentException.class, () -> rdAccount.withdraw(2000, "0126"));
        assertEquals(2000, rdAccount.checkBalance("0123"));
    }

    @Test public void testDepositingNegativeAmount(){

        assertThrows(IllegalArgumentException.class, () -> rdAccount.deposit(-1000));
        assertEquals(2000, rdAccount.checkBalance("0123"));
    }

}
