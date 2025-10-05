package qa_java.src.test.java.practicum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import com.example.Feline; //Исправление. Добавлен импорт класса

import static org.junit.Assert.assertEquals;

public class FeilineUnitTest {
    private Feline feline;

    @Before
    public void setUp() {
        feline = new com.example.Feline();
    }

    @Test
    public void testEatMeat() throws Exception{
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Полученная еда соответствует виду животного", expectedFood, feline.eatMeat());
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensDefault() {
        assertEquals(1, feline.getKittens());
    }



    @Test
    public void testGetKittensBoundaryValues() {
        assertEquals(Integer.MAX_VALUE, feline.getKittens(Integer.MAX_VALUE));
        assertEquals(Integer.MIN_VALUE, feline.getKittens(Integer.MIN_VALUE));
    }

}
