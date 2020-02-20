package kr.co.fastcampus.eatgo.domain;

//import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
//import org.junit.Test;
//import static org.junit.Assert.*;

//import static org.hamcrest.MatcherAssert.assertThat;

class RestaurantTests {

    @Test
    public void creation() {
        Restaurant restaurant = new Restaurant(1004L, "Bob zip", "");
        assertThat(restaurant.getName(), is("Bob zip"));
        assertThat(restaurant.getId(), is(1004L));
    }

    @Test
    public void information(){
        Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");

        assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));
    }
}