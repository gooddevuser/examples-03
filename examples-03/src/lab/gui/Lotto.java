package lab.gui;

import java.util.Arrays;

public class Lotto {	

	public int[] selectWinningNumbers() {		
		int[] numbers;
		while (true) {
			numbers = selectBasicNumbers(); //기본 번호 뽑기
			boolean valid = checkMean(numbers);
			if (valid) {
				break;
			}
		}
		Arrays.sort(numbers); // 배열 정렬
		return numbers;
	}


	public boolean checkMean(int[] numbers) {
		//평균 검사 : 20 ~ 26 -> 출력 / 아니면 -> 번호 뽑기
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum = sum + numbers[i];
		}
		int mean = sum / numbers.length;
		
		if (mean >= 20 && mean <= 26) {
			return true;
		} else {
			return false;
		}		
		//return (mean >= 20 && mean <= 26);
	}
	
	public int[] selectBasicNumbers() {
		//기본 번호 뽑기(1 ~ 45, Random, 중복X, 6개)
		int[] numbers = new int[6]; // 정수 6개를 저장하는 배열
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {
				if (numbers[i] == numbers[j]) {//중복된 경우
					i--; // 또는 i = -1;
					break;
				}
			}
		}
		return numbers; //호출한 곳으로 번호 반환
	}
}