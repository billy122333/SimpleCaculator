package java_testing;
import java.awt.*;
import java.awt.event.*;

public class KeyEventDemo extends KeyAdapter {
    Frame frame;
    Panel panel;
    Label text;
    String Num = "";
    char oper = '\0';
    int tmpNum;
    // add variables...

    public static void main(String[] args) {
        new KeyEventDemo();
    }

    public KeyEventDemo() {
        frame = new Frame("108502541"); // your student ID
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        });
        frame.setSize(400, 200);
        frame.addKeyListener(this);
        panel = new Panel();
        text = new Label("0");
        panel.add(text);
        // panel.add(text2);
        frame.add(panel);
        frame.setVisible(true);
    }

    public void keyPressed(KeyEvent e) {
        // implement here...
        int key1 = e.getKeyCode();
        char key2 = e.getKeyChar();
        switch (key1) {
            case KeyEvent.VK_ESCAPE:
                text.setText("0");
                Num = "";
                tmpNum = 0;
                break;
            case KeyEvent.VK_ADD:
            	Equal();
            	if(Num != "") {
            		tmpNum = Integer.parseInt(Num);
            		Num = "";
                	oper = '+';
            	}
                
                break;
            case KeyEvent.VK_SUBTRACT:
            	Equal();
            	if(Num != "") {
	            	tmpNum = Integer.parseInt(Num);
	                oper = '-';
	                Num = "";
            	}
                break;
            case KeyEvent.VK_MULTIPLY:
            	Equal();
            	if(Num != "") {
	                tmpNum = Integer.parseInt(Num);
	                Num = "";
	                oper = '*';
            	}
                break;
            case KeyEvent.VK_DIVIDE:
            	Equal();
            	if(Num != "") {
	            	oper = '/';
	                tmpNum = Integer.parseInt(Num);
	                Num = "";
            	}
                break;
            case KeyEvent.VK_ENTER:
                Equal();
                break;
            case KeyEvent.VK_NUMPAD0:  
            case KeyEvent.VK_NUMPAD1:
            case KeyEvent.VK_NUMPAD2:
            case KeyEvent.VK_NUMPAD3:
            case KeyEvent.VK_NUMPAD4:
            case KeyEvent.VK_NUMPAD5:
            case KeyEvent.VK_NUMPAD6:
            case KeyEvent.VK_NUMPAD7:
            case KeyEvent.VK_NUMPAD8:
            case KeyEvent.VK_NUMPAD9:
                Num += key2;
                text.setText(Num);
                //System.out.println(Num);
                break;
            default:
            	break;
        }
    }
    public void Equal() {
    	if (tmpNum != 0 && Num != "") {
        	switch(oper){
        		case '+':
        			tmpNum += Integer.parseInt(Num);
        			break;
        		case '-':
        			tmpNum -= Integer.parseInt(Num);
        			break;
        		case '*':
        			tmpNum *= Integer.parseInt(Num);
        			break;
        		case '/':
        			try {
        				tmpNum /= Integer.parseInt(Num);
        			}catch(Exception error){
        				System.out.println("Divide By Zero");
        			}
        			break;
        	}
        	Num = Integer.toString(tmpNum);
            text.setText(Num);
            
            tmpNum = 0;
        }
    }
}