package ru.practicum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import com.example.Feline; //Исправление. Добавлен импорт класса

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoFelineTest {

    @Mock
    private Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);

        // Проверяем возвращаемое значение с ожидаемым
        assertEquals(expectedFood, feline.eatMeat());
        // Удален verify
    }

    @Test(expected = Exception.class)
    public void testEatMeatThrowsException() throws Exception {
        // Подменяем возвращаемое значение
        when(feline.eatMeat()).thenThrow(new Exception("Не удалось получить еду"));

        // Вызываем метод
        feline.eatMeat();
        // Удален verify
    }

    @Test
    public void testGetFamily() {
        // Подменяем возвращаемое значение
        when(feline.getFamily()).thenReturn("Кошачьи");

        // Проверяем возвразаемое значение
        assertEquals("Кошачьи", feline.getFamily());
        // Удален verify
    }

    @Test
    public void testGetKittensWithoutParameters() {
        // Подменяем возвращаемое значение

        when(feline.getKittens()).thenReturn(1);

        // // Проверяем возвращаемое значение с ожидаемым
        assertEquals(1, feline.getKittens());
        // Удален verify
    }

    @Test
    public void testGetKittensWithParameters() {
        // Подменяем возвращаемое значение
        int expectedCount = 5;
        when(feline.getKittens(expectedCount)).thenReturn(expectedCount);

        // Проверяем возвращаемое значение с ожидаемым
        assertEquals(expectedCount, feline.getKittens(expectedCount));
        // Удаен verify
    }

    @Test
    public void testGetKittensWithZero() {
        // Подменяем возвращаемое значение
        when(feline.getKittens(0)).thenReturn(0);

        // // Проверяем возвращаемое значение с ожидаемым
        assertEquals(0, feline.getKittens(0));
        // Удаен verify
    }

    @Test
    public void testGetKittensWithNegativeNumber() {
        // Подменяем возвращаемое значение
        int expectedCount = -3;
        when(feline.getKittens(expectedCount)).thenReturn(expectedCount);

        //  // Проверяем возвращаемое значение с ожидаемым
        assertEquals(expectedCount, feline.getKittens(expectedCount));
        // Удаен verify
    }
}

