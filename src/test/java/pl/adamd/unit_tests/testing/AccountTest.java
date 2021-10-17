package pl.adamd.unit_tests.testing;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void newAccountShouldNotBeActiveAfterCreation(){
        //given
        Account newAccount = new Account();
        //then
        assertFalse(newAccount.isActive());
/*
hamcrest:
        assertThat(newAccount.isActive(), equalTo(false));
        assertThat(newAccount.isActive(), is(false));
*/
/*
assertj-core:
        assertThat(newAccount.isActive()).isFalse();
*/
    }

    @Test
    void accountShouldBeActiveAfterActivation(){
        //given
        Account newAccount = new Account();
        //when
        newAccount.activate();
        //then
        assertTrue(newAccount.isActive());
/*
hamcrest:
        assertThat(newAccount.isActive(), equalTo(true));
*/
/*
assertj-core:
       assertThat(newAccount.isActive()).isTrue();
*/
    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet(){
        //given
        Account newAccount = new Account();
        //when
        Address address = newAccount.getDefaultDeliveryAddress();
        //then
        assertNull(address);
/*
hamcrest:
        assertThat(address, nullValue());
*/
/*
assertj-core:
        assertThat(address).isNull();
*/
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
/*
hamcrest:
        assertThat(defaultAddress, is(notNullValue()));
*/
/*
assertj-core:
        assertThat(defaultAddress).isNotNull();
*/

    }
}
