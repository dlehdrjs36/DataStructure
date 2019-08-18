/**
 * 
 */
package Chapter2_AlgorithmAnalysis;

import java.util.Arrays;

/**
 * 선택정렬
 * 모든 요소를 검사하여 가장 작은 수 혹은 큰 수대로 정렬한다
 * 특정 요소를 선택하여 나머지 요소와 비교를하여 정렬하기 때문에 선택정렬이라고 한다.
 * 1. 특정 요소 선택
 * 2. 선택한 요소 이외의 값들과 선택한 요소 비교
 * 3. 선택한 요소의 값보다 작은 수가 존재하면, 요소의 위치변경(Swap)
 * 4. 1~3 반복
 * 
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
	 * 배열의 크기 : n
	 * 배열비교시작점 : start
	 * n-start만큼 비교 수행
	 * 선형 O(n)
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
