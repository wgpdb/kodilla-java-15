package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("sesame")
                .burgers(3)
                .ingredient("tomato")
                .ingredient("salad")
                .ingredient("pickled cucumber")
                .ingredient("cheese")
                .sauce("standard")
                .build();

        System.out.println(bigmac);

        //When
        int howManyIngredients = bigmac.getIngredients().size();
        int howManyBurgers = bigmac.getBurgers();
        String whatSauce = bigmac.getSauce();

        //Then
        assertEquals(4, howManyIngredients);
        assertEquals(3, howManyBurgers);
        assertEquals("standard", whatSauce);
    }
}