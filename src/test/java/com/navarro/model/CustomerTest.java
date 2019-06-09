package com.navarro.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import com.navarro.model.Country;
import com.navarro.model.Customer;

/**
*
* @since 2019-06-08
* @author Francisco Navarro
*/
public class CustomerTest {

    @Test
    public void testClassHasIdProperty() {
        Customer customer = new Customer();
        customer.setId(1L);

        assertThat(customer, hasProperty("id"));
        assertThat(customer, hasProperty("id", is(customer.getId())));
    }

    @Test
    public void testClassHasNameProperty() {
        Customer customer = new Customer();
        customer.setName("Navarro");

        assertThat(customer, hasProperty("name"));
        assertThat(customer, hasProperty("name", is(customer.getName())));
        
        customer.setName("Solo");

        assertThat(customer, hasProperty("name"));
        assertThat(customer, hasProperty("name", is(customer.getName())));
    }

    @Test
    public void testClassHasPhoneProperty() {
        Customer customer = new Customer();
        customer.setPhone("(212) 99999999");

        assertThat(customer, hasProperty("phone"));
        assertThat(customer, hasProperty("phone", is(customer.getPhone())));
    }

    @Test
    public void testClassHasPhoneCountryCodeProperty() {
        Customer customer = new Customer();
        customer.setPhoneCountryCode("212");

        assertThat(customer, hasProperty("phoneCountryCode"));
        assertThat(customer, hasProperty("phoneCountryCode", is(customer.getPhoneCountryCode())));
    }

    @Test
    public void testClassHasStateProperty() {
        Customer customer = new Customer();
        customer.setState(true);

        assertThat(customer, hasProperty("state"));
        assertThat(customer, hasProperty("state", is(customer.getState())));
    }

    @Test
    public void testClassHasCountryProperty() {
        Customer customer = new Customer();
        customer.setCountry(new Country());

        assertThat(customer, hasProperty("country"));
        assertThat(customer, hasProperty("country", is(customer.getCountry())));
    }

}
