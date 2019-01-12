package sun24;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
//음료수자판기 GUI버전
class run{
	int drink_arr[]=new int[6];  //음료수 6개의 남은 개수를 넣을 배열(콜라,사이다,레쓰비,포카리,삼다수, 암바사 순)

	public void run() {
		for(int i=0; i<drink_arr.length; i++) {
			drink_arr[i]=10;  //각 음료수의 개수 초기값은 10개
		}
	}
	public void sell(int index) {  //판매 : 몇번째 음료수가 빠졌는지 매개변수로 받아와  1씩 감소
			drink_arr[index]--;
	}
	public void buy(int index, int num) {//재고구매 : 몇번째 음료수를 몇개 샀는지 매개변수로 받아와 그만큼 증가 
		drink_arr[index]+=num;
	}
	public String view(int index) { //총 남은 개수 보여주기
		return drink_arr[index]+""; 
	}
}

class Operation extends JFrame{
	run r = new run();
	Container c = getContentPane();
	JPanel menu = new JPanel(new GridLayout(1,1,10,10));
		JButton sell = new JButton("판매");
		JButton buy = new JButton("재고구매");
		JButton view = new JButton("재고확인");
		JButton exit = new JButton("종료");
	JPanel sellopen = new JPanel(new FlowLayout());	
		JButton drink[]=new JButton[6]; //판매시 선택될 음료수버튼들
		JTextField cal = new JTextField("선택된 음료수가 없습니다."); 
		JButton finish = new JButton("선택한 음료수 뽑기");
		JLabel output = new JLabel(new ImageIcon("images/자판기.jpg")); 
		JLabel output_drink[]=new JLabel[6]; //원하는 음료수을 뽑으면 그 음료수가 나오도록 output_drink 생성
	JPanel buy_viewopen = new JPanel(new GridLayout(7,2,50,30));
		JLabel L_drink[]=new JLabel[6];
		JLabel please_choice = new JLabel("개수 입력 후 구매하기클릭-->");
		JButton buybutton = new JButton("재고 구매하기");
		JTextField totalcnt[]= new JTextField[6];
		public Operation (){
		r.run();
		setTitle("음료수 자판기 관리");
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
		
		
		drink[0]= new JButton(new ImageIcon("images/코카콜라.jpg"));
		drink[1]= new JButton(new ImageIcon("images/칠성사이다.jpg"));
		drink[2]= new JButton(new ImageIcon("images/레쓰비.jpg"));
		drink[3]= new JButton(new ImageIcon("images/포카리스웨트.jpg"));
		drink[4]= new JButton(new ImageIcon("images/삼다수.jpg"));
		drink[5]= new JButton(new ImageIcon("images/암바사.jpg"));
		for(int i=0; i<drink.length; i++) {
			drink[i].setBackground(Color.WHITE);
			sellopen.add(drink[i]);
			drink[i].addMouseListener(new MyMouseListener());
			drink[i].addActionListener(new MyActionListener());
			drink[i].setEnabled(false);
		}
		
		output_drink[0]= new JLabel(new ImageIcon("images/콜라나온다.jpg"));
		output_drink[1]= new JLabel(new ImageIcon("images/사이다나온다.jpg"));
		output_drink[2]= new JLabel(new ImageIcon("images/레쓰비나온다.jpg"));
		output_drink[3]= new JLabel(new ImageIcon("images/포카리나온다.jpg"));
		output_drink[4]= new JLabel(new ImageIcon("images/삼다수나온다.jpg"));
		output_drink[5]= new JLabel(new ImageIcon("images/암바사나온다.jpg"));

		L_drink[0]= new JLabel("코카콜라");
		L_drink[1]= new JLabel("사이다");
		L_drink[2]= new JLabel("레쓰비");
		L_drink[3]= new JLabel("포카리스웨트");
		L_drink[4]= new JLabel("삼다수");
		L_drink[5]= new JLabel("암바사");
	
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
			 cal_arr[0]="코카콜라 1500원";
			 cal_arr[1]="사이다 1200원";
			 cal_arr[2]="레쓰비 500원";
			 cal_arr[3]="포카리 800원";
			 cal_arr[4]="삼다수 700원";
			 cal_arr[5]="암바사 1100원";
			for(int i=0; i<drink.length;i++) {
				if(e.getSource()==drink[i]) {
					drink[i].setBackground(Color.RED);
					if(drink[i].getIcon().toString().equals("images/코카콜라.jpg")) {
						cal.setText(cal_arr[0]);
					}else if(drink[i].getIcon().toString().equals("images/칠성사이다.jpg")) {
						cal.setText(cal_arr[1]);
					}else if(drink[i].getIcon().toString().equals("images/레쓰비.jpg")) {
						cal.setText(cal_arr[2]);
					}else if(drink[i].getIcon().toString().equals("images/포카리스웨트.jpg")) {
						cal.setText(cal_arr[3]);
					}else if(drink[i].getIcon().toString().equals("images/삼다수.jpg")) {
						cal.setText(cal_arr[4]);
					}else if(drink[i].getIcon().toString().equals("images/암바사.jpg")) {
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
				buybutton.setText("완료");
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
			if(b.getText().equals("판매")) {
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
				cal.setText("음료수를 선택해주세요.");
			}
			if(b.getText().equals("재고구매")) {
				sellopen.hide();
				buy_viewopen.show();
				buybutton.show();
				buybutton.setEnabled(true);
				buybutton.setText("재고 구매하기");
				buy.setBackground(Color.PINK);
				view.setBackground(Color.WHITE);
				sell.setEnabled(false);
				view.setEnabled(false);
				exit.setEnabled(false);	
				for(int i=0; i<totalcnt.length; i++) {
					totalcnt[i].setText("0");
				}
				please_choice.setText("개수 입력후 구매버튼 클릭ㅡ>");
				buy_viewopen.setSize(400,450);
				buy_viewopen.setLocation(60,250);
				buybutton.setBackground(Color.WHITE);
			}if(b.getText().equals("재고확인")) {
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
			}if(b.getText().equals("종료")){
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
