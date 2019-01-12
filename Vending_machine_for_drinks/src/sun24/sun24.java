package sun24;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
//��������Ǳ� GUI����
class run{
	int drink_arr[]=new int[6];  //����� 6���� ���� ������ ���� �迭(�ݶ�,���̴�,������,��ī��,��ټ�, �Ϲٻ� ��)

	public void run() {
		for(int i=0; i<drink_arr.length; i++) {
			drink_arr[i]=10;  //�� ������� ���� �ʱⰪ�� 10��
		}
	}
	public void sell(int index) {  //�Ǹ� : ���° ������� �������� �Ű������� �޾ƿ�  1�� ����
			drink_arr[index]--;
	}
	public void buy(int index, int num) {//����� : ���° ������� � ����� �Ű������� �޾ƿ� �׸�ŭ ���� 
		drink_arr[index]+=num;
	}
	public String view(int index) { //�� ���� ���� �����ֱ�
		return drink_arr[index]+""; 
	}
}

class Operation extends JFrame{
	run r = new run();
	Container c = getContentPane();
	JPanel menu = new JPanel(new GridLayout(1,1,10,10));
		JButton sell = new JButton("�Ǹ�");
		JButton buy = new JButton("�����");
		JButton view = new JButton("���Ȯ��");
		JButton exit = new JButton("����");
	JPanel sellopen = new JPanel(new FlowLayout());	
		JButton drink[]=new JButton[6]; //�ǸŽ� ���õ� �������ư��
		JTextField cal = new JTextField("���õ� ������� �����ϴ�."); 
		JButton finish = new JButton("������ ����� �̱�");
		JLabel output = new JLabel(new ImageIcon("images/���Ǳ�.jpg")); 
		JLabel output_drink[]=new JLabel[6]; //���ϴ� ������� ������ �� ������� �������� output_drink ����
	JPanel buy_viewopen = new JPanel(new GridLayout(7,2,50,30));
		JLabel L_drink[]=new JLabel[6];
		JLabel please_choice = new JLabel("���� �Է� �� �����ϱ�Ŭ��-->");
		JButton buybutton = new JButton("��� �����ϱ�");
		JTextField totalcnt[]= new JTextField[6];
		public Operation (){
		r.run();
		setTitle("����� ���Ǳ� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(null);
		c.setBackground(Color.ORANGE);
		sellopen.setBackground(Color.ORANGE);
		buy_viewopen.setBackground(Color.ORANGE);
		menu.setBackground(Color.ORANGE);
		sell.setBackground(Color.WHITE);
		buy.setBackground(Color.WHITE);
		view.setBackground(Color.WHITE);
		exit.setBackground(Color.WHITE);
		
		
		drink[0]= new JButton(new ImageIcon("images/��ī�ݶ�.jpg"));
		drink[1]= new JButton(new ImageIcon("images/ĥ�����̴�.jpg"));
		drink[2]= new JButton(new ImageIcon("images/������.jpg"));
		drink[3]= new JButton(new ImageIcon("images/��ī������Ʈ.jpg"));
		drink[4]= new JButton(new ImageIcon("images/��ټ�.jpg"));
		drink[5]= new JButton(new ImageIcon("images/�Ϲٻ�.jpg"));
		for(int i=0; i<drink.length; i++) {
			drink[i].setBackground(Color.WHITE);
			sellopen.add(drink[i]);
			drink[i].addMouseListener(new MyMouseListener());
			drink[i].addActionListener(new MyActionListener());
			drink[i].setEnabled(false);
		}
		
		output_drink[0]= new JLabel(new ImageIcon("images/�ݶ󳪿´�.jpg"));
		output_drink[1]= new JLabel(new ImageIcon("images/���̴ٳ��´�.jpg"));
		output_drink[2]= new JLabel(new ImageIcon("images/�����񳪿´�.jpg"));
		output_drink[3]= new JLabel(new ImageIcon("images/��ī�����´�.jpg"));
		output_drink[4]= new JLabel(new ImageIcon("images/��ټ����´�.jpg"));
		output_drink[5]= new JLabel(new ImageIcon("images/�Ϲٻ糪�´�.jpg"));

		L_drink[0]= new JLabel("��ī�ݶ�");
		L_drink[1]= new JLabel("���̴�");
		L_drink[2]= new JLabel("������");
		L_drink[3]= new JLabel("��ī������Ʈ");
		L_drink[4]= new JLabel("��ټ�");
		L_drink[5]= new JLabel("�Ϲٻ�");
	
		menu.add(sell);
		menu.add(buy);
		menu.add(view);
		menu.add(exit);
		menu.setSize(400,55);
		menu.setLocation(70,10);
		
		sellopen.add(cal);
		sellopen.add(finish);
		sellopen.add(output);
		sellopen.setSize(400,800);
		sellopen.setLocation(60,70);
		sell.addMouseListener(new MyMouseListener());
		buy.addMouseListener(new MyMouseListener());
		view.addMouseListener(new MyMouseListener());
		exit.addMouseListener(new MyMouseListener());
		cal.addActionListener(new MyActionListener());
		finish.addActionListener(new MyActionListener());
		buybutton.addActionListener(new MyActionListener());
		cal.setEnabled(false);
		finish.setEnabled(false);
		
		for(int i=0; i<L_drink.length; i++) {
			totalcnt[i] = new JTextField("");
			buy_viewopen.add(L_drink[i]);
			buy_viewopen.add(totalcnt[i]);
		}
		
		buy_viewopen.add(please_choice);
		buy_viewopen.add(buybutton);
		
		c.add(menu);
		c.add(sellopen);
		c.add(buy_viewopen);
		setSize(550,900);
		setVisible(true);
	}
	class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cal_arr[]=new String[6];
			 cal_arr[0]="��ī�ݶ� 1500��";
			 cal_arr[1]="���̴� 1200��";
			 cal_arr[2]="������ 500��";
			 cal_arr[3]="��ī�� 800��";
			 cal_arr[4]="��ټ� 700��";
			 cal_arr[5]="�Ϲٻ� 1100��";
			for(int i=0; i<drink.length;i++) {
				if(e.getSource()==drink[i]) {
					drink[i].setBackground(Color.RED);
					if(drink[i].getIcon().toString().equals("images/��ī�ݶ�.jpg")) {
						cal.setText(cal_arr[0]);
					}else if(drink[i].getIcon().toString().equals("images/ĥ�����̴�.jpg")) {
						cal.setText(cal_arr[1]);
					}else if(drink[i].getIcon().toString().equals("images/������.jpg")) {
						cal.setText(cal_arr[2]);
					}else if(drink[i].getIcon().toString().equals("images/��ī������Ʈ.jpg")) {
						cal.setText(cal_arr[3]);
					}else if(drink[i].getIcon().toString().equals("images/��ټ�.jpg")) {
						cal.setText(cal_arr[4]);
					}else if(drink[i].getIcon().toString().equals("images/�Ϲٻ�.jpg")) {
						cal.setText(cal_arr[5]);
					}else
						cal.setText("");
				}else {
					drink[i].setBackground(Color.WHITE);
				}
				finish.setEnabled(true);
			}
				 if(e.getSource()==finish) {
					output.hide();
					for(int i=0; i<output_drink.length; i++) {
						if(cal.getText().equals(cal_arr[i])){
							sellopen.add(output_drink[i]);
							output_drink[i].show();
							drink[i].setBackground(Color.WHITE);
							r.sell(i);
						}else {
							output_drink[i].hide();
						}
						drink[i].setEnabled(false);
					}
						cal.setEnabled(false);
						finish.setEnabled(false);
						sell.setBackground(Color.WHITE);
						view.setEnabled(true);
						buy.setEnabled(true);
						exit.setEnabled(true);
				}
			if(e.getSource()==buybutton) {
				buybutton.setBackground(Color.PINK);
				buybutton.setText("�Ϸ�");
				buybutton.setEnabled(false);
				buy.setBackground(Color.WHITE);
				view.setBackground(Color.WHITE);
				view.setEnabled(true);
				buy.setEnabled(true);
				exit.setEnabled(true);
				sell.setEnabled(true);
				for(int i=0; i<totalcnt.length; i++) {
					int num[]=new int[6];
					num[i]=Integer.parseInt(totalcnt[i].getText());
					r.buy(i,num[i]);
				}
			}
		}		
	}
	class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("�Ǹ�")) {
				buy_viewopen.hide();
				sellopen.show();
				output.show();
				sell.setBackground(Color.PINK);
				view.setBackground(Color.WHITE);
				buy.setEnabled(false);
				view.setEnabled(false);
				exit.setEnabled(false);
				for(int i=0; i<drink.length; i++) {
					drink[i].setEnabled(true);
				}
				cal.setEnabled(true);	
				cal.setText("������� �������ּ���.");
			}
			if(b.getText().equals("�����")) {
				sellopen.hide();
				buy_viewopen.show();
				buybutton.show();
				buybutton.setEnabled(true);
				buybutton.setText("��� �����ϱ�");
				buy.setBackground(Color.PINK);
				view.setBackground(Color.WHITE);
				sell.setEnabled(false);
				view.setEnabled(false);
				exit.setEnabled(false);	
				for(int i=0; i<totalcnt.length; i++) {
					totalcnt[i].setText("0");
				}
				please_choice.setText("���� �Է��� ���Ź�ư Ŭ����>");
				buy_viewopen.setSize(400,450);
				buy_viewopen.setLocation(60,250);
				buybutton.setBackground(Color.WHITE);
			}if(b.getText().equals("���Ȯ��")) {
				sellopen.hide();
				buy_viewopen.show();
				buybutton.hide();
				view.setBackground(Color.PINK);
				for(int i=0; i<totalcnt.length; i++) {
					totalcnt[i].setText(r.view(i));

				}			
				please_choice.setText("");
				buy_viewopen.setSize(400,450);
				buy_viewopen.setLocation(60,250);
			}if(b.getText().equals("����")){
				System.exit(0);
			}	
		}
	}
}
public class sun24 {
	public static void main(String[] args) {
	Operation operation = new Operation();
	}
}
