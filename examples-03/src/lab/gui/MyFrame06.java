package lab.gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame06 extends JFrame {

	JButton[] buttons = new JButton[3];
	JButton uPanel, cPanel, rPanel;
	String[] imagePaths = { "scissors.png", "rock.png", "paper.png" };

	ButtonClickHandler l = new ButtonClickHandler();

	// 생성자 메서드 (constructor) : 객체가 만들어질 때(new 할 때) 자동으로 호출되는 메서드 / 초기화
	public MyFrame06() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("가위바위보");
		setSize(500, 240);
		setResizable(false); // 윈도우 크기 변경 금지

		try {
			for (int i = 0; i < buttons.length; i++) {
				Image img = ImageIO.read(new File(imagePaths[i]));
				img = img.getScaledInstance(150, 84, Image.SCALE_SMOOTH); // 이미지의 크기 변경
				ImageIcon icon = new ImageIcon(img);// 버튼 등의 컴포넌트에 부착할 수 있는 이미지 객체
				buttons[i] = new JButton(icon);
				buttons[i].setSize(150, 84);
				buttons[i].setLocation(10 + 160 * i, 10);
				buttons[i].addActionListener(l);
				add(buttons[i]);
			}
		} catch (Exception ex) {
		}

		uPanel = new JButton();
		uPanel.setSize(150, 84);
		uPanel.setLocation(10, 105);
		uPanel.setEnabled(false);
		add(uPanel);
		cPanel = new JButton();
		cPanel.setSize(150, 84);
		cPanel.setLocation(170, 105);
		cPanel.setEnabled(false);
		add(cPanel);
		
		rPanel = new JButton();
		rPanel.setSize(150, 84);
		rPanel.setLocation(330, 105);
		rPanel.setEnabled(false);
		add(rPanel);
	}

	class ButtonClickHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			// 1. 사용자가 선택한 버튼의 이미지를 uPanel에 적용
			JButton selectedButton = (JButton) e.getSource();
			uPanel.setIcon(selectedButton.getIcon());

			// 2. Random하게 선택한 번호에 따라 이미지를 cPanel에 적용
			int cNo = (int) (Math.random() * 3);
			cPanel.setIcon(buttons[cNo].getIcon());

			// 3. 두 선택을 비교해서 결과 출력
			int uNo = -1;
			for (int i = 0; i < buttons.length; i++) { // 사용자가 선택한 버튼의 순서 번호 찾기
				if (buttons[i].getIcon() == selectedButton.getIcon()) {
					uNo = i;
					break;
				}
			}
			// 0: 가위, 1: 바위, 2: 보
			if (uNo == 0 && cNo == 2 || uNo == 1 && cNo == 0 || uNo == 2 && cNo == 1) {
				rPanel.setText("YOU WIN");
			} else if (uNo == cNo) {
				rPanel.setText("DRAW");
			} else {
				rPanel.setText("YOU LOSE");
			}
		}
	}

	public static void main(String[] args) {

		MyFrame06 frame = new MyFrame06();
		frame.setVisible(true);
	}

}