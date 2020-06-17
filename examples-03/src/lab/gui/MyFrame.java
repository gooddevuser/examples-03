package lab.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyFrame extends JFrame {

	private JTextField numbers[] = new JTextField[6], Mean;
	private JButton Lotto;

	private ButtonClickHandler a = new ButtonClickHandler();

	// 생성자 메서드 (constructor) : 객체가 만들어질 때(new 할 때) 자동으로 호출되는 메서드 / 초기화
	public MyFrame() {
		// 윈도우가 닫히면 프로그램도 종료하는 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 윈도우에 포함된 구성요소의 위치 관리를 위해 절대 크기와 좌표를 사용
		setLayout(null);
		// 윈도우 속성 설정 (제목, 크기, ....)
		setTitle("로또게임");
		setSize(500, 160);
		setResizable(false); // 윈도우의 크기 변경

		Lotto = new JButton("당첨예상번호뽑기");
		Lotto.setSize(470, 50);
		Lotto.setLocation(10, 10);
		Lotto.addActionListener(a);
		add(Lotto);

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = new JTextField();
			numbers[i].setSize(50, 50);
			numbers[i].setLocation(10 + 60 * i, 70); // 버튼의 좌측 상단 포인트의 좌표
			add(numbers[i]);
		}

		Mean = new JTextField();
		Mean.setSize(110, 50);
		Mean.setLocation(370, 70);
		Mean.setEditable(false); // 편집할 수 없도록 설정
		add(Mean);

	}

	class ButtonClickHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// 버튼이 클릭되면 KRW -> USD or USD -> KRW 처리
			int[] numbers2 = new int[6]; // 정수 6개를 저장하는 배열
			for (int i = 0; i < numbers2.length; i++) {
				numbers2[i] = (int) (Math.random() * 45) + 1;
				for (int j = 0; j < i; j++) {
					if (numbers2[i] == numbers2[j]) {// 중복된 경우
						i--; // 또는 i = -1;
						break;
					}
				}
			}

			for (int i = 0; i < numbers2.length; i++) {
				numbers[i].setText(String.valueOf(numbers2[i]));

			}
			// int mean = numbers2[0] + numbers2[1] + numbers2[2] + numbers2[3] +
			// numbers2[4] + numbers2[5]
			int sum = 0;
			for (int i = 0; i < numbers2.length; i++) {
				sum = sum + numbers2[i];
			}
			int mean = sum / numbers2.length;

			Mean.setText(String.valueOf(mean));

		}
	}

	public static void main(String[] args) {

		MyFrame frame = new MyFrame();
		frame.setVisible(true);
	}

}
