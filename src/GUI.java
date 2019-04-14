import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {
	public static JFrame jf = new JFrame();
	public static JFrame jflist = new JFrame();
	String lineSeparator = System.getProperty("line.separator");
	JPanel panel = new JPanel();
	//Box box1 = Box.createVerticalBox();
	JLabel jl = new JLabel("Введи кол-во символов в паролях: ");
	JTextField jtf = new JTextField();
	JTextArea jta1 = new JTextArea();
	JTextArea jta2 = new JTextArea();
	JLabel list = new JLabel();
	
	JMenuBar menuBar = new JMenuBar();
	JButton jb = new JButton("Сгенерировать пароль");
	JCheckBox symb = new JCheckBox("Использовать сиволы");
	JCheckBox blb = new JCheckBox("Использовать большие латинские буквы");
	JCheckBox mlb = new JCheckBox("Использовать маленькие латинские буквы");
	JCheckBox nums = new JCheckBox("Использовать числа");
    
    static boolean symbb;
    static boolean blbb;
    static boolean mlbb;
    static boolean numsb;
    
	public void startGUI() {
		jf.setDefaultCloseOperation(3);
		JPanel panel = new JPanel();
		jf.setSize(450, 190);
		jf.setResizable(false);
		jf.setTitle("PasswordGP 1.6 Graph | Java Edition");
		
		JMenu pgp = new JMenu("Программа");
		JMenuItem info = new JMenuItem("Сведенья");
		pgp.add(info);
		menuBar.add(pgp);
		
		jl.setSize(270,20);
		jl.setLocation(0,0);
		
	    jtf.setSize(100, 20);
	    jtf.setLocation(271,2);
	    //jtf.setVisible(true);
	    
	    symb.setSize(200,20);
	    symb.setLocation(0, 50);
	    
	    blb.setSize(350,20);
	    blb.setLocation(0, 80);
	    
	    mlb.setSize(350,20);
	    mlb.setLocation(0, 110);
	    
	    nums.setSize(350,20);
	    nums.setLocation(0, 140);
	    
	    jta1.setSize(430,300);
	    jta1.setLocation(0, 165);
		
		/*jta2.setSize(220,270);
		jta2.setLocation(230, 180);
		jta2.setText("Nodffnjhfdgkjndfgjn;fbjgnbjgbkngjblnvbjxncjbhxkbnkjvxchbkjnvlzfhvljvfogjpavsfhgosfdsvsfgsgsdgsgsgne");*/
		
		jb.setSize(200,20);
		jb.setLocation(0,25);
		jb.setVisible(true);
	    
		panel.setLayout(null);
		panel.add(jl);
		panel.add(jtf);
		panel.add(symb);
		panel.add(blb);
		panel.add(mlb);
		panel.add(nums);
		panel.add(jta1);
		panel.add(jb);
		
		jf.setJMenuBar(menuBar);
		jf.setContentPane(panel);
		jf.setVisible(true);
		
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(info, "PasswordGP 1.6 Graph | Java Edition" + lineSeparator
						+ "Программа создана программистом Aleser" + lineSeparator
						+ "PasswordGP 1.53 со встроенным графическим интерфейсом" + lineSeparator
						+ "Чтобы открыть консольную программу, нужно запустить PasswordGP через терминал или командную консоль","Система оповещения", JOptionPane.INFORMATION_MESSAGE);
			}
			});
		
		symb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	if (symbb == false) {
            		symbb = true;
            	} else 
                if (symbb == true) {
            		symbb = false;
            	}
   
            }
		});
		blb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (blbb == false) {
                    blbb = true;
                	} else
                	if (blbb == true) {
                		blbb = false;
                	}
            }
		});
		mlb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (mlbb == false) {
                    mlbb = true;
                	} else
                	if (mlbb == true) {
                		mlbb = false;
                	}
            }
		});
		nums.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (numsb == false) {
                    numsb = true;
                	} else
                	if (numsb == true) {
                		numsb = false;
                	}
            }
		});
		jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	jf.setSize(450, 490);
            	try {
            	if (Integer.parseInt(jtf.getText()) < 41) {
            	Lib l = new Lib();
            	String password = "";
        
            	for (int i = 1; i < 21; i++) {
            		if (i < 10) {
            			password += "["+ i + "]          " + l.kernelGenPassword(Integer.parseInt(jtf.getText()), symbb, blbb, mlbb, numsb) + lineSeparator;
            		}
            		if (i > 9) {
            			password += "["+ i + "]        " + l.kernelGenPassword(Integer.parseInt(jtf.getText()), symbb, blbb, mlbb, numsb) + lineSeparator;
            		}
            	}
            	
            	//list.setText(password);
                jta1.setText(password);
            	} else {
					JOptionPane.showMessageDialog(jb, "Невозможно сгенерировать пароль с текущими параметрами!","Система оповещения", JOptionPane.WARNING_MESSAGE);
					}
            	} catch (Exception ex) {
            		JOptionPane.showMessageDialog(jb, ex.getMessage() + lineSeparator + ex.getStackTrace() + lineSeparator + ex.getCause(),"Система оповещения", JOptionPane.WARNING_MESSAGE);
            	}
            }
            
		});
		
		
	}
}
