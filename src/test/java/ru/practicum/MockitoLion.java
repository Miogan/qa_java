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
public class MockitoLion {
    @Mock
    private Feline feline;

    @Test
    public void testLionConstructor() throws Exception {
        // Создаем объект
        Lion lion = new Lion("Самец");

        // Проверяем, что объект создался
        assertNotNull(lion);
    }

    @Test
    public void testMaleLionConstructor() throws Exception {
        // Создаем объект
        Lion lion = new Lion("Самец");

        // Проверяем присвоенный пол с ожидаемым
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testFemaleLionConstructor() throws Exception {
        // Создаем объект
        Lion lion = new Lion("Самка");

        // Проверяем присвоенный пол с ожидаемым
        assertFalse(lion.doesHaveMane());
    }
    //
    @Test(expected = Exception.class)
    public void testInvalidSexConstructor() throws Exception {
        // Создаем объект
        new Lion("оно");
    }

    @Test(expected = Exception.class)
    public void testEmptySexConstructor() throws Exception {
        // Создаем объект
        new Lion("");
    }

    @Test
    public void testGetKittens() throws Exception {
        // Создаем объект
        Lion lion = new Lion("Самец");
        lion.setFeline(feline);
        int expectedCount = 3;
        when(feline.getKittens()).thenReturn(expectedCount);

        // Проверяем возвращаемое значение с ожидаемым
        assertEquals(expectedCount, lion.getKittens());
        // Удален verify
    }

    @Test
    public void testGetFood() throws Exception {
        // Создаем объект
        Lion lion = new Lion("Самка");
        lion.setFeline(feline);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);

        // Проверяем возвращаемое значение с ожидаемым
        assertEquals(expectedFood, lion.getFood());
        // Удален verify
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsException() throws Exception {
        // Создаем объект
        Lion lion = new Lion("Самец");
        lion.setFeline(feline);
        when(feline.getFood("Хищник")).thenThrow(new Exception("Не удалось получить еду"));

        // Вызываем метод
        lion.getFood();
    }

    @Test
    public void testSetFeline() throws Exception {
        // Создаем объект
        Lion lion = new Lion("Самец");
        Feline newFeline = mock(Feline.class);

        lion.setFeline(newFeline);
        // Подменяем получаемое значение
        when(newFeline.getKittens()).thenReturn(5);

        // Проверяем что филин создался и отрабатывает свой хлеб
        assertEquals(5, lion.getKittens());
        // Удален verify
    }
}
