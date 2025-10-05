package ru.practicum;

import org.junit.Before;
import org.junit.Test;

import com.example.Feline;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParamTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }


    @Parameterized.Parameter
    public int KittensCount; // количество котиков

    @Parameterized.Parameters(name = "KittensCount")
    public static Object[][] GetKittensCount() {
        return new Object[][]{
                {0},
                {3},
                {10},
                {-2}
        };
    }

    @Test
    public void testGetKittensWithDifferentValues(){
        assertEquals(KittensCount, feline.getKittens(KittensCount));
    }
}
