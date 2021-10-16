package pl.adamd.unit_tests.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void newAccountShouldNotBeActiveAfterCreation(){
        //given
        Account newAccount = new Account();
        //then
        assertFalse(newAccount.isActive());
    }

    @Test
    void accountShouldBeActiveAfterActivation(){
        //given
        Account newAccount = new Account();
        //when
        newAccount.activate();
        //then
        assertTrue(newAccount.isActive());
    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet(){
        //given
        Account newAccount = new Account();
        //when
        Address address = newAccount.getDefaultDeliveryAddress();
        //then
        assertNull(address);
    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet(){
        //given
        Address address = new Address("Konstytucji", "12");
        Account newAccount = new Account();
        newAccount.setDefaultDeliveryAddress(address);
        //when
        Address defaultAddress = newAccount.getDefaultDeliveryAddress();
        //then
        assertNotNull(defaultAddress);
    }



}
