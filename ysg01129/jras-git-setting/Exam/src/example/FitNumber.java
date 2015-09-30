package example;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.security.auth.kerberos.KerberosKey;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FitNumber extends JFrame implements KeyListener {

	private JFrame jframe = new JFrame();
	private JTextArea jtaResult = new JTextArea();
	private JTextField jtfInput = new JTextField();
	private JScrollPane jscp = new JScrollPane(jtaResult);
	
	private int max = 100;
	private int min = 1;
	private int input = 0;
	private int count = 0;
	private static int answer = 0;
	
	private FitNumber() {
		// TODO Auto-generated constructor stub
		super("정보검색");
		Container container = jframe.getContentPane();
		
		jtaResult.setEditable(false);
		jtfInput.addKeyListener(this);
		jtfInput.setFocusable(true);

		jframe.add(jscp,"Center");
		jframe.add(jtfInput, "South");
		jframe.setSize(500,500);
		jframe.setLocation(300,300);	
		jframe.setVisible(true);
		
		jframe.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				jtfInput.setFocusable(true);
				jtaResult.append("숫자 맞추기 게임을 시작하겠습니다. \r\n");
				jtaResult.append(min + "과 " + max + "사이의 숫자를 입력하세요. \r\n");
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyChar() == KeyEvent.VK_ENTER) {
			count++;
			input = Integer.parseInt(jtfInput.getText().toString().trim());
			matching(input);
			jtfInput.setText("");			
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void matching(int input) {
		if(input == answer) {
			jtaResult.append("정답입니다. \r\n");
			jtaResult.append("시도 횟수는 " + count +"번 입니다.");
		} else if(input < answer) {
			jtaResult.append("더 큰 수를 입력하세요. \r\n");
			min = input;
			jtaResult.append(min + "과 " + max + "사이의 숫자를 입력하세요. \r\n");
		} else if(input > answer){
			jtaResult.append("더 작은 수를 입력하세요. \r\n");
			max = input;
			jtaResult.append(min + "과 " + max + "사이의 숫자를 입력하세요. \r\n");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		answer = (int) (Math.random() * 100) + 1;
		FitNumber fitNumber = new FitNumber();

	}

}

