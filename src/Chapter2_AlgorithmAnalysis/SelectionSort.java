/**
 * 
 */
package Chapter2_AlgorithmAnalysis;

import java.util.Arrays;

/**
 * <p><strong>selectionSort() 내부 for문 비교 횟수</strong></p>                       
 * 0, 1 , ... , n-1, n                                                   
 * <p><strong>indexLowest() 비교 횟수</strong></p>                                 
 * n, n-1, ... , 1, 0                                                    
 * <p><strong>swapElements() 비교 횟수</strong></p>                                
 * O(1)                                                                  
 *                                                                       
 * <h1>selectionSort for문 + indexLowest 수행시간(S(n))</h1>                  
 * <b>S(n)=n(n+1)/2 ∈  O(n²)</b>                                      
 *                                                                       
 * <h1>selectionSort() 수행시간(T(n))</h1>                                   
 * <b>T(n)=O(n²)+O(1) ∈  O(n²)<b>                                          
 * <b>∴ O(n²)<b>                                                                
 *
 */
public class SelectionSort {

	/**
	 * Swaps the elements at indexes i and j.
	 * i와 j의 위치에 있는 값을 서로 바꾼다.
	 * 상수 시간 연산 O(1)
	 */
	public static void swapElements(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * Finds the index of the lowest value
	 * between indices low and high (inclusive).
	 * start로부터 시작하는 최솟값의 위치를 찾고(start 포함) 배열의 마지막 위치로 이동한다.
	 * 선형 (n-start) O(n)
	 */
	public static int indexLowest(int[] array, int start) {
		int lowIndex = start;
		for (int i = start; i < array.length; i++) {
			if (array[i] < array[lowIndex]) {
				lowIndex = i;
			}
		}
		return lowIndex;
	}

	/**
	 * Sorts the cards (in place) using selection sort.
	 * 선택 정렬을 사용하여 요소를 정렬한다.
	 * 
	 */
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int j = indexLowest(array, i);
			swapElements(array, i, j);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {2, 5, 6, 1, 3};
		selectionSort(array);
		System.out.println(Arrays.toString(array));
	}

}
