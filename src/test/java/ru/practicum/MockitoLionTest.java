package ru.practicum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.Feline; //Исправление. Добавлен импорт класса
import com.example.Lion;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockitoLionTest {
    @Mock
    private Feline feline;

    @Test
    public void testLionConstructor() throws Exception {
        // Создаем объект
        Lion lion = new Lion("Самец", feline);

        // Проверяем, что объект создался
        assertNotNull(lion);
    }

    @Test
    public void testMaleLionConstructor() throws Exception {
        // Создаем объект
        Lion lion = new Lion("Самец", feline);

        // Проверяем присвоенный пол с ожидаемым
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testFemaleLionConstructor() throws Exception {
        // Создаем объект
        Lion lion = new Lion("Самка", feline);

        // Проверяем присвоенный пол с ожидаемым
        assertFalse(lion.doesHaveMane());
    }

    //
    @Test(expected = Exception.class)
    public void testInvalidSexConstructor() throws Exception {
        // Создаем объект
        new Lion("оно", feline);
    }

    @Test(expected = Exception.class)
    public void testEmptySexConstructor() throws Exception {
        // Создаем объект
        new Lion("", feline);
    }

    @Test
    public void testGetKittens() throws Exception {
        // Создаем объект
        Lion lion = new Lion("Самец", feline);
        // переменная удалена
        when(feline.getKittens()).thenReturn(1);

        // Проверяем возвращаемое значение с ожидаемым
        assertEquals(1, lion.getKittens());
        // Удален verify
    }

    @Test
    public void testGetFood() throws Exception {
        // Создаем объект
        Lion lion = new Lion("Самка", feline);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба"); // Исправление. Добавлена потерянная рыба
        when(feline.getFood("Хищник")).thenReturn(expectedFood);

        // Проверяем возвращаемое значение с ожидаемым
        assertEquals(expectedFood, lion.getFood());
        // Удален verify
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsException() throws Exception {
        // Создаем объект
        Lion lion = new Lion("Самец", feline);
        when(feline.getFood("Хищник")).thenThrow(new Exception("Не удалось получить еду"));

        // Вызываем метод
        lion.getFood();
    }

}