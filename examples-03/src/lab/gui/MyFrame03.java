package lab.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame03 extends JFrame {
	
	//JButton redButton, orangeButton,
	JButton[] buttons = new JButton[7]; // JButton 참조 배열
	// JButton 배열에 적용할 Color 참조 배열
	Color[] colors = { 
		Color.red, Color.orange, Color.yellow, Color.green, Color.blue, 
		new Color(0, 0, 128), new Color(128, 0, 128)
	};  
	JPanel canvas = null;
	ClickHandler handler = new ClickHandler();	
	//생성자 메서드 (constructor) : 객체가 만들어질 때(new 할 때) 자동으로 호출되는 메서드 / 초기화
	public MyFrame03() {
		//윈도우가 닫히면 프로그램도 종료하는 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//윈도우에 포함된 구성요소의 위치 관리를 위해 절대 크기와 좌표를 사용
		setLayout(null);		
		//윈도우 속성 설정 (제목, 크기, ....)
		setTitle("");
		setSize(690, 600);		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setSize(85, 85);
			buttons[i].setLocation(10 + 95 * i, 10); // 버튼의 좌측 상단 포인트의 좌표
			buttons[i].setBackground(colors[i]);
			buttons[i].addActionListener(handler); // 버튼이 클릭되었을 때 호출할 메서드 연결
			add(buttons[i]);
		}
		
		canvas = new JPanel();
		canvas.setSize(655, 450);
		canvas.setLocation(10, 105);
		canvas.setBackground(Color.white);
		add(canvas);
	}
	
	// 버튼이 클릭되었을 때 호출할 약속된 메서드를 정의하는 클래스 (ActionListener 인터페이스 구현) 
	class ClickHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) { //버튼이 클릭되었을 때 버튼이 호출하는 메서드
			
			//1. 현재 클릭된 버튼 가져오기
			//   e.getSource() : 현재 이벤트 처리기 메서드를 호출한 객체 (==이벤트가 발생한 객체)
			JButton clickedButton = (JButton)e.getSource();
			
			//2. 클릭된 버튼의 배경색을 canvas에 적용
			Color color = clickedButton.getBackground();
			canvas.setBackground(color);
			
		}		
	}
	
	public static void main(String[] args) {
		
		MyFrame03 frame = new MyFrame03();
		frame.setVisible(true);
	}

}






