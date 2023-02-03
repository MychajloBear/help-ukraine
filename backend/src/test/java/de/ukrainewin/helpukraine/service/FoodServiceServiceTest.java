package de.ukrainewin.helpukraine.service;

import de.ukrainewin.helpukraine.model.Food;
import de.ukrainewin.helpukraine.repo.FoodRepo;

import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class OrderServiceTest {

    FoodRepo repo = mock(FoodRepo.class);
    IdService idService = mock(IdService.class);

    FoodService service = new FoodService(repo, idService);


    @Test
    @DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
    void testGetAllFood() {
        // GIVEN
        List<Food> expected = Collections.emptyList();

        // WHEN
        when(repo.findAll()).thenReturn(expected);
        List<Food> result = service.list();

        // THEN
        assertEquals(expected, result);
        verify(repo).findAll();
    }

    @Test
    @DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
    void testGetById() {
        // GIVEN
        Food expected = new Food(
                "222",
                "Fooood");
        repo.save(expected);

        // WHEN
        when(repo.findById("222")).thenReturn(Optional.of(expected));
        Food actual = service.findById(expected.getId());

        // THEN
        assertEquals(expected, actual);
        verify(repo).findById("222");

    }
/*
    @Test
    void saveOrder() {
        // GIVEN
        String id = "84";
        Order expectedOrder = new Order(
                id,
                "PayPal",
                Collections.emptyList(),
                "Peter"
        );

        OrderDTO OrderToSave = new OrderDTO(
                "PayPal",
                Collections.emptyList(),
                "Peter"
        );

        // WHEN
        when(repo.save(expectedOrder)).thenReturn(expectedOrder);
        when(idService.generateID()).thenReturn(id);
        Order actualProduct = service.saveOrder(OrderToSave);

        // THEN
        assertEquals(expectedOrder, actualProduct);
        verify(repo).save(expectedOrder);
    }

    @Test
    void addProductToAnOrder() {

        // GIVEN
        String id = "85";
        Order givenOrder = new Order(
                id,
                "PayPal",
                List.of(new Product(
                        "85",
                        "Haferdrink",
                        "xxxxxy",
                        "test",
                        new BigDecimal("1.50"),
                        "Haferdrink"
                )), "Hanswurst");

        Order expectedOrder = new Order(
                id,
                "PayPal",
                List.of(new Product(
                        "85",
                        "Haferdrink",
                        "xxxxxy",
                        "test",
                        new BigDecimal("1.50"),
                        "Haferdrink"

                ), new Product("85",
                        "Test",
                        "test",
                        "Geilo",
                        new BigDecimal("1.50"),
                        "Haferdrink")),
                "Hanswurst");

        // WHEN
        when(repo.findById(id)).thenReturn(Optional.of(givenOrder));
        when(repo.save(expectedOrder)).thenReturn(expectedOrder);
        when(idService.generateID()).thenReturn(id);
        Order actualProduct = service.addProductToAnOrder(id, new ProductDTO(
                "Test",
                "test",
                "Geilo",
                new BigDecimal("1.50"),
                "Haferdrink"));
        // THEN
        verify(repo).save(expectedOrder);
        assertEquals(expectedOrder, actualProduct);

    }*/
}