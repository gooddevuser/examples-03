package lab.gui;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyFrame05 extends JFrame {
	
	JButton selectNumbersButton;
	JTextField[] numbersField = new JTextField[6];
	JTextField meanField;
				
	//생성자 메서드 (constructor) : 객체가 만들어질 때(new 할 때) 자동으로 호출되는 메서드 / 초기화
	public MyFrame05() {
		//윈도우가 닫히면 프로그램도 종료하는 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//윈도우에 포함된 구성요소의 위치 관리를 위해 절대 크기와 좌표를 사용
		setLayout(null);		
		//윈도우 속성 설정 (제목, 크기, ....)
		setTitle("로또");
		setSize(675, 370);
		
		setResizable(false); // 윈도우 크기 변경 금지
		
		Font font = new Font("맑은 고딕", Font.BOLD, 40);		
		
		selectNumbersButton = new JButton("당첨 예상 번호 뽑기");
		selectNumbersButton.setSize(650, 100);
		selectNumbersButton.setLocation(10, 10); // 좌측 상단 좌표
		selectNumbersButton.setFont(font);
		add(selectNumbersButton);
		
//		ButtonClickHandler l = new ButtonClickHandler();
//		selectNumbersButton.addActionListener(l);
		selectNumbersButton.addActionListener(new ButtonClickHandler());
		
		for (int i = 0; i < numbersField.length; i++) {
			numbersField[i] = new JTextField();
			numbersField[i].setSize(100, 100);
			numbersField[i].setLocation(10 + 110 * i, 120);
			numbersField[i].setEditable(false);
			numbersField[i].setHorizontalAlignment(JTextField.CENTER);
			numbersField[i].setFont(font);
			add(numbersField[i]);
		}
		
		meanField = new JTextField();
		meanField.setSize(210, 100);
		meanField.setLocation(450, 230);
		meanField.setEditable(false);
		meanField.setHorizontalAlignment(JTextField.CENTER);
		meanField.setFont(font);
				
		add(meanField);
		
	}
	
	class ButtonClickHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
					
			//1. 번호 뽑기
			Lotto lotto = new Lotto();
			int[] numbers = lotto.selectWinningNumbers();
			
			
			//2. 번호 표시하기
			int sum = 0;
			for (int i = 0; i < numbers.length; i++) {
				numbersField[i].setText(String.valueOf(numbers[i]));
				sum += numbers[i];
			}
			meanField.setText(String.valueOf(sum / numbers.length));
			
		}
		
	}
	
	public static void main(String[] args) {				
		
		MyFrame05 frame = new MyFrame05();
		frame.setVisible(true);
	}

}






