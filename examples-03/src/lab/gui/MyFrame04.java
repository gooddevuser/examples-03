package lab.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyFrame04 extends JFrame {
	
	private JTextField fromKrw, fromUsd, toKrw, toUsd;
	private JButton krwToUsd, usdToKrw;
	
	private ButtonClickHandler l = new ButtonClickHandler();
	
		
	//생성자 메서드 (constructor) : 객체가 만들어질 때(new 할 때) 자동으로 호출되는 메서드 / 초기화
	public MyFrame04() {
		//윈도우가 닫히면 프로그램도 종료하는 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//윈도우에 포함된 구성요소의 위치 관리를 위해 절대 크기와 좌표를 사용
		setLayout(null);		
		//윈도우 속성 설정 (제목, 크기, ....)
		setTitle("환율 계산기");
		setSize(505, 165);
		
		setResizable(false); // 윈도우 크기 변경 금지
		
		fromKrw = new JTextField();
		fromKrw.setSize(150, 50);
		fromKrw.setLocation(10, 10);
		add(fromKrw);
		
		krwToUsd = new JButton("KRW TO USD");
		krwToUsd.setSize(150, 50);
		krwToUsd.setLocation(170, 10);
		krwToUsd.addActionListener(l);
		add(krwToUsd);		
		
		toUsd = new JTextField();
		toUsd.setSize(150, 50);
		toUsd.setLocation(330, 10);
		toUsd.setEditable(false); // 편집할 수 없도록 설정
		add(toUsd);
		
		////////////////////////////////////
		
		fromUsd = new JTextField();
		fromUsd.setSize(150, 50);
		fromUsd.setLocation(10, 70);
		add(fromUsd);
		
		usdToKrw = new JButton("USD TO KRW");
		usdToKrw.setSize(150, 50);
		usdToKrw.setLocation(170, 70);
		usdToKrw.addActionListener(l);
		add(usdToKrw);		
		
		toKrw = new JTextField();
		toKrw.setSize(150, 50);
		toKrw.setLocation(330, 70);
		toKrw.setEditable(false); // 편집할 수 없도록 설정
		add(toKrw);
	}
	
	class ButtonClickHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			// 클릭된 버튼 가져오기 (이벤트를 발생시킨 객체 가져오기)
			JButton clickedButton = (JButton)e.getSource();

			//클릭된 버튼에 따라 KRW -> USD or USD -> KRW 처리
			String text = clickedButton.getText(); // 버튼에 표시된 텍스트 문자열 가져오기
			
				toUsd.setText((text));
		}
		
	}
	
	public static void main(String[] args) {
		
		MyFrame04 frame = new MyFrame04();
		frame.setVisible(true);
	}

}






