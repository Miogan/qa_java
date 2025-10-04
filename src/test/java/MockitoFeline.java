package qa_java.src.test.java.practicum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.Feline;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoFeline {

    @Mock
    private Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);

        // Проверяем возвращаемое значение с ожидаемым
        assertEquals(expectedFood, feline.eatMeat());
        verify(feline, times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testEatMeatThrowsException() throws Exception {
        // Подменяем возвращаемое значение
        when(feline.eatMeat()).thenThrow(new Exception("Не удалось получить еду"));

        // Вызываем метод
        feline.eatMeat();
        verify(feline, times(1)).eatMeat();
    }

    @Test
    public void testGetFamily() {
        // Подменяем возвращаемое значение
        when(feline.getFamily()).thenReturn("Кошачьи");

        // Проверяем возвразаемое значение
        assertEquals("Кошачьи", feline.getFamily());
        verify(feline, times(1)).getFamily();
    }

    @Test
    public void testGetKittensWithoutParameters() {
        // Подменяем возвращаемое значение

        when(feline.getKittens()).thenReturn(1);

        // // Проверяем возвращаемое значение с ожидаемым
        assertEquals(1, feline.getKittens());
        verify(feline, times(1)).getKittens();
    }

    @Test
    public void testGetKittensWithParameters() {
        // Подменяем возвращаемое значение
        int expectedCount = 5;
        when(feline.getKittens(expectedCount)).thenReturn(expectedCount);

        // Проверяем возвращаемое значение с ожидаемым
        assertEquals(expectedCount, feline.getKittens(expectedCount));
        verify(feline, times(1)).getKittens(expectedCount);
    }

    @Test
    public void testGetKittensWithZero() {
        // Подменяем возвращаемое значение
        when(feline.getKittens(0)).thenReturn(0);

        // // Проверяем возвращаемое значение с ожидаемым
        assertEquals(0, feline.getKittens(0));
        verify(feline, times(1)).getKittens(0);
    }

    @Test
    public void testGetKittensWithNegativeNumber() {
        // Подменяем возвращаемое значение
        int expectedCount = -3;
        when(feline.getKittens(expectedCount)).thenReturn(expectedCount);

        //  // Проверяем возвращаемое значение с ожидаемым
        assertEquals(expectedCount, feline.getKittens(expectedCount));
        verify(feline, times(1)).getKittens(expectedCount);
    }
}

