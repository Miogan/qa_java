package qa_java.src.test.java.practicum;

import com.example.Cat; //Исправление. Добавлен импорт класса. Возможно, слетел при решении проблем с PR гит
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import com.example.Feline; //Исправление. Добавлен импорт класса

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoCat {

    @Mock
    private Feline feline;

    @Test
    public void testConstructorInjection() {
        // Создаем
        Cat cat = new Cat(feline);

        // Проверяем, что объект создался
        assertNotNull(cat);
    }

    @Test
    public void testGetSound() {
        // Вызываем метод
        Cat cat = new Cat(feline);

        // Проверяем возвращаемое значение с ожидаемым
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        // Создаем объект
        Cat cat = new Cat(feline);

        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");

        // Подменяем возвращаемое значение
        when(cat.getFood()).thenReturn(expectedFood);

        // Проверяем возвращаемое значение с ожидаемым
        assertEquals(expectedFood, cat.getFood());
        verify(feline, times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsException() throws Exception {
        // Создаем объект
        Cat cat = new Cat(feline);

        // Подменяем возвращаемое значение
        when(cat.getFood()).thenThrow(new Exception("Не удалось получить еду"));

        // Вызываем метод
        cat.getFood();
    }

    @Test
    public void testGetFoodWithEmptyList() throws Exception {
        // Создаем объект
        Cat cat = new Cat(feline);

        List<String> expectedFood = Arrays.asList();
        when(cat.getFood()).thenReturn(expectedFood);

        // Проверяем возвращаемое значение с ожидаемым
        assertEquals(expectedFood, cat.getFood());
        verify(feline, times(1)).eatMeat();
    }

}
