package com.navarro.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import com.navarro.model.Country;

/**
*
* @since 2019-06-08
* @author Francisco Navarro
*/
public class CountryTest {

    @Test
    public void testClassHasCodeProperty() {
        Country country = new Country();
        country.setCode("212");

        assertThat(country, hasProperty("code"));
        assertThat(country, hasProperty("code", is(country.getCode())));
        
        country.setCode("260");

        assertThat(country, hasProperty("code"));
        assertThat(country, hasProperty("code", is(country.getCode())));
    }

    @Test
    public void testClassHasNameProperty() {
        Country country = new Country();
        country.setName("Morocco");

        assertThat(country, hasProperty("name"));
        assertThat(country, hasProperty("name", is(country.getName())));

        country.setName("Macau");

        assertThat(country, hasProperty("name"));
        assertThat(country, hasProperty("name", is(country.getName())));
    }

}
