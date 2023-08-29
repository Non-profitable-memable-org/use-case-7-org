package org.example.service;

import org.example.util.TestEntitiesFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerAnalyzerTest {

    private PlayerAnalyzer service = new PlayerAnalyzer();

    // Positive Test Cases:
    //Case 1: Normal Player
    //Given an array with a single player object with age 25, experience 5 years, and skills [2, 2, 2], the function should return a score of 250 (since 2552 = 250).
    @Test
    public void shouldGetNormalPlayer() {
        var player = TestEntitiesFactory.getPlayer(25, 5);
        player.setSkills(List.of(2,2,2));

        var result = service.calculateScore(List.of(player));

        assertEquals(250, result, 0);
    }
    //Case 2: Junior Player
    //Given an array with a single player object with age 15, experience 3 years, and skills [3, 3, 3], the function should return a score of 67.5 (since (1533) *0.5 = 67.5).
    @Test
    public void shouldGetJuniorPlayer() {
        var player = TestEntitiesFactory.getPlayer(15, 3);
        player.setSkills(List.of(3,3,3));

        var result = service.calculateScore(List.of(player));

        assertEquals(67.5, result, 0);
    }
    //Case 3: Senior Player
    //Given an array with a single player object with age 35, experience 15 years, and skills [4, 4, 4], the function should return a score of 2520 (since (35154) *1.2 = 2520).
    @Test
    public void shouldGetSeniorPlayer() {
        var player = TestEntitiesFactory.getPlayer(35, 15);
        player.setSkills(List.of(4,4,4));

        var result = service.calculateScore(List.of(player));

        assertEquals(2520, result, 0);
    }
    //Case 4: Multiple Players
    //Given an array with multiple player objects, the function should return the sum of their scores.
    @Test
    public void shouldGetMultiplePlayers() {
        var player1 = TestEntitiesFactory.getPlayer(25, 5);
        player1.setSkills(List.of(2,2,2));
        var player2 = TestEntitiesFactory.getPlayer(35, 15);
        player2.setSkills(List.of(4,4,4));

        var result = service.calculateScore(List.of(player1, player2));

        assertEquals(2770, result, 0);
    }
    //Negative Test Cases:
    //Case 1: Skills is null.
    //Given an array with a player where Skills property is null, the function should throw an error.
    @Test(expected = NullPointerException.class)
    public void shouldThrowError() {
        var player1 = TestEntitiesFactory.getPlayer(25, 5);
        player1.setSkills(null);

        service.calculateScore(List.of(player1));

        Assert.fail("Should've thrown NPE");
    }
    //Case 2: Empty Array
    //Given an empty array, the function should return 0 (since there are no players to contribute to the score).
    @Test
    public void shouldReturnZero() {
        var result = service.calculateScore(Collections.emptyList());

        assertEquals(0, result, 0);
    }
}
