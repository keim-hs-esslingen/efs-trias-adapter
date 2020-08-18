/*
 * MIT License
 * 
 * Copyright (c) 2020 Hochschule Esslingen
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE. 
 */
package de.hsesslingen.keim.efs.trias;

import de.hsesslingen.keim.efs.middleware.common.Leg;
import de.hsesslingen.keim.efs.mobility.service.Mode;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author keim
 */
public class TriasResponseFactoryTest {

    public TriasResponseFactoryTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test_getLastNonWalkLeg() {
        var factory = new TriasResponseFactory();

        // Test 1
        var expected = new Leg().setMode(Mode.BUS);

        var legs = List.of(
                new Leg().setMode(Mode.WALK),
                new Leg().setMode(Mode.BUS),
                new Leg().setMode(Mode.TRANSIT),
                expected,
                new Leg().setMode(Mode.WALK)
        );

        var actual = factory.getLastNonWalkLeg(legs);
        
        assertEquals(expected, actual);
        
        
        // Test 2
        expected = new Leg().setMode(Mode.CAR);

        legs = List.of(
                new Leg().setMode(Mode.WALK),
                new Leg().setMode(Mode.BUS),
                new Leg().setMode(Mode.TRANSIT),
                new Leg().setMode(Mode.WALK),
                expected
        );

        actual = factory.getLastNonWalkLeg(legs);
        
        assertEquals(expected, actual);
        
        
        // Test 3
        expected = new Leg().setMode(Mode.TRANSIT);

        legs = List.of(
                new Leg().setMode(Mode.WALK),
                new Leg().setMode(Mode.BUS),
                new Leg().setMode(Mode.TRANSIT),
                expected,
                new Leg().setMode(Mode.WALK),
                new Leg().setMode(Mode.WALK),
                new Leg().setMode(Mode.WALK),
                new Leg().setMode(Mode.WALK)
        );

        actual = factory.getLastNonWalkLeg(legs);
        
        assertEquals(expected, actual);
    }

}
