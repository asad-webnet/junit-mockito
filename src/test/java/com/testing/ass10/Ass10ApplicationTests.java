package com.testing.ass10;

import com.testing.ass10.Service.ArrayFlatenerService;
import com.testing.ass10.Service.ArrayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@SpringBootTest
class Ass10ApplicationTests {

	@Autowired
	private ArrayService arrayService;

	@MockBean
	ArrayFlatenerService arrayFlatenerService;

	@Test
	public void testFlatteningArray() {
		// Declare and initialize a 2D array
		int[][] twoDimArray = {
				{1, 2},
				{3}
		};
		int[] expectedOutput = {1,2,3};
		assertThat(arrayService.ArrayFlattener(twoDimArray)).isEqualTo(expectedOutput);
	}

	@Test
	public void whenNull() {
		assertThat(arrayService.ArrayFlattener(null)).isEqualTo(null);
	}

	@Test
	public void testingRemoteService() {
		// Arrange
		when(arrayFlatenerService.flattenArray(new int[][]{{1, 2}, {3}})).thenReturn(new int[]{1, 2, 3});

		// Act
		int[] result = arrayFlatenerService.flattenArray(new int[][]{{1, 2}, {3}});

		// Assert
		assertThat(result).containsExactly(1, 2, 3);
	}



}
