package com.testing.ass10;

import com.testing.ass10.Service.ArrayFlatenerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ArrayFlatenningTest {

    @MockBean
    ArrayFlatenerService arrayFlatenerService;


    @Test
    public void testingRemoteService() {
        // Arrange
        when(arrayFlatenerService.flattenArray(Mockito.any())).thenReturn(new int[]{1, 2, 3});

        // Act
        int[] result = arrayFlatenerService.flattenArray(new int[][]{{1, 2}, {3}});

        // Assert
        assertThat(result).containsExactly(1, 2, 3);
    }
    @Test
    public void testingRemoteServiceWhenNull() {
        // Arrange
        when(arrayFlatenerService.flattenArray(Mockito.any())).thenReturn(null);

        // Act
        int[] result = arrayFlatenerService.flattenArray(new int[][]{{1, 2}, {3}});

        // Assert
        assertThat(result).isNull();
    }
}

