package es.ies.puerto.optcg.controller;

import es.ies.puerto.optcg.utilities.TestUtilities;
import es.system.danileonpe.springboot.controller.CartasController;
import es.system.danileonpe.springboot.exception.ResourceNotFoundException;
import es.system.danileonpe.springboot.model.Carta;
import es.system.danileonpe.springboot.service.rest.CartaService;
import es.system.danileonpe.springboot.service.rest.CartaServiceInterface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CartaControllerTest extends TestUtilities {

    @Mock
    private CartaServiceInterface cartaService;;

    @InjectMocks
    CartasController cartasController;

    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void testGetAllCartas() {
        // Arrange
        List<Carta> mockCartas = Arrays.asList(
                new Carta(1, "Carta1", "Personaje", "Épica", 5, null, null, null),
                new Carta(2, "Carta2", "Barco", "Rara", 3, null, null, null)
        );
        when(cartaService.getAllCartas()).thenReturn(mockCartas);

        // Act
        List<Carta> result = cartasController.getAllCartas();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Carta1", result.get(0).getNombre());
        assertEquals("Carta2", result.get(1).getNombre());
    }

    @Test
    void testGetCartaById() throws ResourceNotFoundException {
        // Arrange
        Carta mockCarta = new Carta(1, "Test Carta", "Personaje", "Épica", 5, null, null, null);
        when(cartaService.getCartaById(1)).thenReturn(mockCarta);

        // Act
        ResponseEntity<Carta> response = cartasController.getCartaById(1);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Test Carta", response.getBody().getNombre());
    }

    @Test
    void testCreateCarta() {
        // Arrange
        Carta newCarta = new Carta(1, "Nueva Carta", "Personaje", "Legendaria", 7, null, null, null);
        when(cartaService.createCarta(newCarta)).thenReturn(newCarta);

        // Act
        Carta result = cartasController.createCarta(newCarta);

        // Assert
        assertEquals("Nueva Carta", result.getNombre());
        verify(cartaService, times(1)).createCarta(newCarta);
    }

    @Test
    void testUpdateCarta() throws ResourceNotFoundException {
        // Arrange
        Carta existingCarta = new Carta(1, "Carta Existente", "Personaje", "Épica", 5, null, null, null);
        Carta updatedDetails = new Carta(1, "Carta Actualizada", "Personaje", "Legendaria", 7, null, null, null);
        when(cartaService.updateCarta(1, updatedDetails)).thenReturn(updatedDetails);

        // Act
        ResponseEntity<Carta> response = cartasController.updateCarta(1, updatedDetails);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Carta Actualizada", response.getBody().getNombre());
        verify(cartaService, times(1)).updateCarta(1, updatedDetails);
    }


    @Test
    void testDeleteCarta() throws ResourceNotFoundException {
        // Act
        Map<String, Boolean> response = cartasController.deleteCarta(1);

        // Assert
        assertEquals(Boolean.TRUE, response.get("deleted"));
        verify(cartaService, times(1)).deleteCarta(1);
    }



}
