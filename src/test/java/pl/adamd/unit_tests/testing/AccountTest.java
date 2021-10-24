package pl.adamd.unit_tests.testing;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class AccountTest {

    @Test
    void newAccountShouldNotBeActiveAfterCreation() {
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
    void accountShouldBeActiveAfterActivation() {
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
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet() {
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
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet() {
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

    @RepeatedTest(5)
    void newAccountWithNotNullAddressShouldByActive() {
        //given
        Address address = new Address("Wall Street", "11");
        //when
        Account account = new Account(address);
        //then
        assumingThat(address != null, () -> {
            assertTrue(account.isActive());
        });
    }

    @Test
    void invalidEmailShouldThrowException(){
        //given
        Account account = new Account();
        //when
        //given
        assertThrows(IllegalArgumentException.class, ()-> account.setEmail("wrongEmail"));
    }

    @Test
    void validEmailShouldBeSet(){
        //given
        Account account = new Account();
        //when
        account.setEmail("adam.drozdz1987@gmail.com");
        //then
        assertThat(account.getEmail(), is("adam.drozdz1987@gmail.com"));
    }


}
