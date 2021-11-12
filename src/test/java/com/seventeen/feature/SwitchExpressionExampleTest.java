package com.seventeen.feature;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static com.seventeen.feature.FootballPosition.*;

class SwitchExpressionExampleTest {

    private final Map<Integer, FootballPosition> positionMap = new HashMap<>();
    private int randomNumber;
    private FootballPosition randomPosition;
    private final SwitchExpressionExample switchExpressionExample = new SwitchExpressionExample();

    @BeforeEach
    void setUp() {
        positionMap.put(1, GOALKEEPER);
        positionMap.put(2, DEFENCE);
        positionMap.put(3, MIDFIELDER);
        positionMap.put(4, STRIKER);
        randomNumber = ThreadLocalRandom.current().nextInt(1, 6);
        randomPosition = Optional.ofNullable(positionMap.get(randomNumber)).orElse(BENCH);
    }

    @AfterEach
    void tearDown() {
        positionMap.clear();
    }

    @RepeatedTest(5)
    @Order(1)
    void exampleOldSwitch() {
        switchExpressionExample.exampleOldSwitch(randomPosition);
    }

    @RepeatedTest(5)
    @Order(2)
    void exampleNewSwitch() {
        switchExpressionExample.exampleNewSwitch(randomPosition);
    }

    @RepeatedTest(5)
    @Order(3)
    void exampleReturnWithSwitch() {
        switchExpressionExample.exampleReturnWithSwitch(randomPosition);
    }
}