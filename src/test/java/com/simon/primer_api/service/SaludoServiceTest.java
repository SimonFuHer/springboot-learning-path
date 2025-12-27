package com.simon.primer_api.service;

import com.simon.primer_api.model.Saludo;
import com.simon.primer_api.repository.SaludoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import java.util.Optional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

// 1. @ExtendWith: Le dice a JUnit que vamos a usar Mockito para simular cosas
@ExtendWith(MockitoExtension.class)
public class SaludoServiceTest {

    // 2. @Mock: Crea un "Repository Falso". No conecta a la BD real.
    @Mock
    private SaludoRepository saludoRepository;

    // 3. @InjectMocks: Crea el Servicio real e INYECTA dentro el repositorio falso de arriba.
    @InjectMocks
    private SaludoService saludoService;

    // 4. @Test: Indica que esto es una prueba
    @Test
    public void guardarSaludo_DeberiaDevolverElSaludoGuardado() {
        // --- ARRANGE (Preparar el escenario) ---
        // Creamos un saludo de mentira para la prueba
        Saludo saludoEntrada = new Saludo("Hola Test", "Simon Tester", "Contenido Test");

        // Configuración del Mock (El guion de la película):
        // "Cuando alguien llame al repositorio.save() con este saludo...
        // entonces devuelve el mismo saludo".
        when(saludoRepository.save(saludoEntrada)).thenReturn(saludoEntrada);

        // --- ACT (Acción) ---
        // Ejecutamos el método real que queremos probar
        Saludo resultado = saludoService.procesarSaludoRecibido(saludoEntrada);

        // --- ASSERT (Verificación) ---
        // Comprobamos si el resultado es el esperado
        // "Espero que el título del resultado sea 'Hola Test'"
        assertEquals("Hola Test", resultado.getTitulo());
    }

    @Test
    public void listarSaludos_DeberiaDevolverListaDeSaludos() {
        // --- ARRANGE ---
        // Preparamos una lista ficticia de 2 saludos
        Saludo s1 = new Saludo("Hola 1", "Autor 1", "Contenido 1");
        Saludo s2 = new Saludo("Hola 2", "Autor 2", "Contenido 2");
        List<Saludo> listaFicticia = Arrays.asList(s1, s2);

        // Guion: "Cuando alguien pida findAll(), devuelve esta lista ficticia"
        when(saludoRepository.findAll()).thenReturn(listaFicticia);

        // --- ACT ---
        // Llamamos al método real del servicio (asegúrate de que se llame así en tu Service)
        List<Saludo> resultado = saludoService.obtenerTodosLosSaludos();

        // --- ASSERT ---
        // Verificamos que nos ha devuelto 2 cosas
        assertEquals(2, resultado.size()); // Esperamos 2 elementos
        assertEquals("Hola 1", resultado.getFirst().getTitulo()); // El primero debe ser "Hola 1"
    }

    @Test
    public void borrarSaludo_DeberiaLlamarAlRepositorioParaBorrar() {
        // --- ARRANGE ---
        Long id = 1L;

        // --- ACT ---
        saludoService.borrarSaludo(id);

        // --- ASSERT ---
        // Necesitarás importar: static org.mockito.Mockito.verify;
        // y también: static org.mockito.Mockito.times;
        // Fíjate que ahora ya no ponemos 'org.mockito.Mockito...' Delante.
        // Al tener el import arriba, podemos usar 'verify' y 'times' directamente.
        verify(saludoRepository, times(1)).deleteById(id);
    }

    @Test
    public void actualizarSaludo_DeberiaDevolverSaludoModificado() {
        // --- ARRANGE ---
        Long id = 1L;
        // 1. Preparamos el saludo "viejo" que ya existe en la BD
        Saludo saludoAntiguo = new Saludo("Viejo Titulo", "Viejo Autor", "Viejo Contenido");

        // 2. Preparamos los datos nuevos que queremos poner
        Saludo nuevosDatos = new Saludo("Nuevo Titulo", "Nuevo Autor", "Nuevo Contenido");

        // 3. El Guion:
        // "Si buscan el ID 1, devuelve el saludo antiguo (¡importante usar Optional.of!)"
        // (Necesitarás importar java.util.Optional)
        when(saludoRepository.findById(id)).thenReturn(Optional.of(saludoAntiguo));

        // "Si mandan a guardar el saludo antiguo (que ya habremos modificado), devuélvelo"
        when(saludoRepository.save(saludoAntiguo)).thenReturn(saludoAntiguo);

        // --- ACT ---
        // Llamamos al método real (asegúrate que se llame así en tu servicio)
        Saludo resultado = saludoService.actualizarSaludo(id, nuevosDatos);

        // --- ASSERT ---
        // Verificamos que el resultado tenga el título NUEVO
        assertEquals("Nuevo Titulo", resultado.getTitulo());
    }
}