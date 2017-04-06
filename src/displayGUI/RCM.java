package displayGUI;

import java.io.*;

import machine.Bottle;
import machine.Can;
import machine.Crate;
import machine.Glass;
import machine.PaperBag;
import machine.NewsPaper;
import machine.LightBulb;
import machine.Plastic;
import machine.Book;
import machine.Appliance;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/*
 * Main class that creates the components that go into the RCM as well
 * as all the methods needed to manipulate the RCM and get the values 
 * */
public class RCM extends JPanel implements ActionListener {
	private Can pop = new Can();
	private Bottle bot = new Bottle();
	private Crate box = new Crate();
	private PaperBag bag = new PaperBag();
	private Glass cup = new Glass();
	private NewsPaper paper = new NewsPaper();
	private LightBulb bulb = new LightBulb();
	private Plastic plas = new Plastic();
	private Book read = new Book();
	private Appliance ply = new Appliance();

	private static RCM r1 = new RCM();
	private static RCM r2 = new RCM();

	private double ID, Machine;
	private double trueTotalItems = 0.0;
	private double totalItems = 0.0;
	private double totalPrice = 0.0;
	private double money = 0.0;
	private double weightCapacity = 0.0;
	private double weightCount = 0.0;

	private JLabel weight, currWeight, currMoney, machine, id;

	JLabel b1 = new JLabel("Bottle");
	JLabel c1 = new JLabel("Can");
	JLabel c2 = new JLabel("Crate");
	JLabel g1 = new JLabel("Glass");
	JLabel pb1 = new JLabel("Paper Bag");
	JLabel np = new JLabel("N.Paper");
	JLabel lb = new JLabel("LightBulb");
	JLabel p1 = new JLabel("Plastic");
	JLabel b2 = new JLabel("Book");
	JLabel app = new JLabel("Appliance");

	NumberFormat formatter = new DecimalFormat("#0.00");

	ImageIcon cans = new ImageIcon("ButtonImages/can.jpg");
	ImageIcon bottles = new ImageIcon("ButtonImages/bottle.jpg");
	ImageIcon crates = new ImageIcon("ButtonImages/crate.jpg");
	ImageIcon bags = new ImageIcon("ButtonImages/paperbag.jpg");
	ImageIcon glasses = new ImageIcon("ButtonImages/glass.jpg");
	ImageIcon papers = new ImageIcon("ButtonImages/newspaper.jpg");
	ImageIcon bulbs = new ImageIcon("ButtonImages/lightbulb.jpg");
	ImageIcon plastics = new ImageIcon("ButtonImages/plastic.jpg");
	ImageIcon books = new ImageIcon("ButtonImages/book.jpg");
	ImageIcon appliances = new ImageIcon("ButtonImages/appliance.jpg");

	JButton slot1 = new JButton(b1.getText() + " $" + bot.getPrice());
	JButton slot2 = new JButton(c1.getText() + " $" + pop.getPrice());
	JButton slot3 = new JButton(c2.getText() + " $" + box.getPrice());
	JButton slot4 = new JButton(g1.getText() + " $" + cup.getPrice());
	JButton slot5 = new JButton(pb1.getText() + " $" + bag.getPrice());
	JButton slot6 = new JButton(np.getText() + " $" + paper.getPrice());
	JButton slot7 = new JButton(lb.getText() + " $" + bulb.getPrice());
	JButton slot8 = new JButton(p1.getText() + " $" + plas.getPrice());
	JButton slot9 = new JButton(b2.getText() + " $" + read.getPrice());
	JButton slot10 = new JButton(app.getText() + " $" + ply.getPrice());

	JPanel panel, panel2, panel3, panel4, big;

	// creating the JText area for the printing of the receipt
	JTextArea output = new JTextArea(10, 20);
	JScrollPane scrollPane = new JScrollPane(output);
	JTextArea output2 = new JTextArea(10, 20);
	JScrollPane scrollPane2 = new JScrollPane(output2);

	JButton receipt = new JButton("Receipt");
	JButton clear = new JButton("Clear Text");

	//Constructor to create the RCM
	private RCM() {
		super();
		ID = Math.round(Math.random() * 10);
		Machine = Math.round(Math.random() * 10);
		JFrame frame = new JFrame("EcoRe");
		panel = new JPanel();
		panel2 = new JPanel(new GridLayout(0, 1));
		panel3 = new JPanel(new GridLayout(0, 1));
		panel4 = new JPanel();

		panel2.setPreferredSize(new Dimension(20, -50));
		panel3.setPreferredSize(new Dimension(20, -50));

		setMoney(100);
		setWeight(50);
		currWeight = new JLabel(
				"Current Weight: " + formatter.format(weightCount) + " Lbs. (" + formatter.format(weightCount * 0.454)
						+ " in Kg) (Max = " + weightCapacity + "Lbs / " + weightCapacity * 0.456 + "Kg)",
				SwingConstants.CENTER);
		currWeight.setFont(new Font("Serif", Font.PLAIN, 15));

		currMoney = new JLabel("Money in Machine: $" + money, SwingConstants.CENTER);
		currMoney.setFont(new Font("Serif", Font.PLAIN, 15));

		machine = new JLabel("Machine #" + formatter.format(Machine), SwingConstants.CENTER);
		id = new JLabel("ID #" + formatter.format(ID), SwingConstants.CENTER);

		panel4.add(slot1);
		panel4.add(slot2);
		panel4.add(slot3);
		panel4.add(slot4);
		panel4.add(slot5);
		panel4.add(slot6);
		panel4.add(slot7);
		panel4.add(slot8);
		panel4.add(slot9);
		panel4.add(slot10);

		setButtons(slot1);
		setButtons(slot2);
		setButtons(slot3);
		setButtons(slot4);
		setButtons(slot5);
		setButtons(slot6);
		setButtons(slot7);
		setButtons(slot8);
		setButtons(slot9);
		setButtons(slot10);

		slot1.setIcon(bottles);
		slot2.setIcon(cans);
		slot3.setIcon(crates);
		slot4.setIcon(glasses);
		slot5.setIcon(bags);
		slot6.setIcon(papers);
		slot7.setIcon(bulbs);
		slot8.setIcon(plastics);
		slot9.setIcon(books);
		slot10.setIcon(appliances);

		slot1.addActionListener(this);
		slot2.addActionListener(this);
		slot3.addActionListener(this);
		slot4.addActionListener(this);
		slot5.addActionListener(this);
		slot6.addActionListener(this);
		slot7.addActionListener(this);
		slot8.addActionListener(this);
		slot9.addActionListener(this);
		slot10.addActionListener(this);
		receipt.addActionListener(this);
		clear.addActionListener(this);

		output.setEditable(false);
		output2.setEditable(false);

		// adding the text area within the scroll pane to the panel
		// scrollPane.setPreferredSize(20,20);

		panel.add(scrollPane);
		panel.add(receipt);
		panel.add(scrollPane2);
		panel.add(clear);
		panel2.add(currWeight);
		panel2.add(currMoney);
		panel3.add(machine);
		panel3.add(id);

		this.setPreferredSize(new Dimension(650, 550));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setVisible(true);

		setRCMLayout();
	}

	//Method to set the layout of the RCM
	private void setRCMLayout() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(panel3);
		add(panel4);
		add(panel);
		add(panel2);
	}

	//Method to return an instance of RCM 1
	public static RCM getOneInstance() {
		return r1;
	}

	//Method to return an instance of RCM 2
	public static RCM getTwoInstance() {
		return r2;
	}

	//Method to get the ID of an rcm
	public double getId() {
		return Math.round(this.ID);
	}

	//Method that returns the machine number of an RCM
	public double getMachine() {
		return Math.round(this.Machine);
	}

	//Method to return the money count of transaction
	public double getMoneyCount() {
		return totalPrice;
	}

	//Method to set the button properties of the RCM
	public void setButtons(JButton button) {
		button.setPreferredSize(new Dimension(120, 90));
		button.setHorizontalTextPosition(AbstractButton.CENTER);
		button.setVerticalTextPosition(AbstractButton.BOTTOM);
	}

	//Method to set the weight of an RCM
	public void setWeight(double weight) {
		weightCapacity = weight;
	}

	//Method to return the current weight of an RCM
	public double getWeight() {
		return weightCount;
	}

	//Method to return the current capacity of an RCM
	public double getCapacity() {
		return weightCapacity;
	}

	//Method to set the amount of money in an RCM
	public void setMoney(double cash) {
		money = cash;
	}

	//Method to return the current money capacity in machine 
	public double getMoney() {
		return money;
	}
	
	//Method to return the total number of items deposited in transaction
	public double getTotalItems() {
		return totalItems;
	}

	//Method to return teh total number of items deposited over a preriod of time
	public double getTrueTotal() {
		return trueTotalItems;
	}

	//Method that adds a button to an RCM
	public void addButton(int item) {
		switch (item) {
		case 1:
			slot1.setVisible(true);
			break;
		case 2:
			slot2.setVisible(true);
			break;
		case 3:
			slot3.setVisible(true);
			break;
		case 4:
			slot4.setVisible(true);
			break;
		case 5:
			slot5.setVisible(true);
			break;
		case 6:
			slot6.setVisible(true);
			break;
		case 7:
			slot7.setVisible(true);
			break;
		case 8:
			slot8.setVisible(true);
			break;
		case 9:
			slot9.setVisible(true);
			break;
		case 10:
			slot10.setVisible(true);
			break;
		}
	}

	//Method that removes a button from an RCM
	public void removeButton(String item) {
		switch (item) {
		case "Bottle":
			slot1.setVisible(false);
			break;
		case "Can":
			slot2.setVisible(false);
			break;
		case "Crate":
			slot3.setVisible(false);
			break;
		case "Glass":
			slot4.setVisible(false);
			break;
		case "Paper Bag":
			slot5.setVisible(false);
			break;
		case "NewsPaper":
			slot6.setVisible(false);
			break;
		case "LightBulb":
			slot7.setVisible(false);
			break;
		case "Plastic":
			slot8.setVisible(false);
			break;
		case "Book":
			slot9.setVisible(false);
			break;
		case "Appliance":
			slot10.setVisible(false);
			break;
		}
	}

	//Method that sets the item price in an RCM
	public void setItemPrice(Double newPrice, int item) {
		switch (item) {
		case 1:
			bot.setPrice(newPrice);
			slot1.setText(b1.getText() + " $" + bot.getPrice());
			break;
		case 2:
			pop.setPrice(newPrice);
			slot2.setText(c1.getText() + " $" + pop.getPrice());
			break;
		case 3:
			box.setPrice(newPrice);
			slot3.setText(c2.getText() + " $" + box.getPrice());
			break;
		case 4:
			cup.setPrice(newPrice);
			slot4.setText(g1.getText() + " $" + cup.getPrice());
			break;
		case 5:
			bag.setPrice(newPrice);
			slot5.setText(pb1.getText() + " $" + bag.getPrice());
			break;
		case 6:
			paper.setPrice(newPrice);
			slot6.setText(np.getText() + " $" + paper.getPrice());
			break;
		case 7:
			bulb.setPrice(newPrice);
			slot7.setText(lb.getText() + " $" + bulb.getPrice());
			break;
		case 8:
			plas.setPrice(newPrice);
			slot8.setText(p1.getText() + " $" + plas.getPrice());
			break;
		case 9:
			read.setPrice(newPrice);
			slot9.setText(b2.getText() + " $" + read.getPrice());
			break;
		case 10:
			ply.setPrice(newPrice);
			slot10.setText(app.getText() + " $" + ply.getPrice());
			break;
		}

	}

	//Method that sets the item name in an RCM
	public void setItemName(String newName, int item) {
		String temp;
		switch (item) {
		case 1:
			b1.setText(newName);
			slot1.setText(b1.getText() + " $" + bot.getPrice());
			break;
		case 2:
			c1.setText(newName);
			slot2.setText(c1.getText() + " $" + pop.getPrice());
			break;
		case 3:
			c2.setText(newName);
			slot3.setText(c2.getText() + " $" + box.getPrice());
			break;
		case 4:
			g1.setText(newName);
			slot4.setText(g1.getText() + " $" + cup.getPrice());
			break;
		case 5:
			pb1.setText(newName);
			slot5.setText(pb1.getText() + " $" + bag.getPrice());
			break;
		case 6:
			np.setText(newName);
			slot6.setText(np.getText() + " $" + paper.getPrice());
			break;
		case 7:
			lb.setText(newName);
			slot7.setText(lb.getText() + " $" + bulb.getPrice());
			break;
		case 8:
			p1.setText(newName);
			slot8.setText(p1.getText() + " $" + plas.getPrice());
			break;
		case 9:
			b2.setText(newName);
			slot9.setText(b2.getText() + " $" + read.getPrice());
			break;
		case 10:
			app.setText(newName);
			slot10.setText(app.getText() + " $" + ply.getPrice());
			break;
		}

	}

	//Method that updates the RCM display
	public void updateRCM(int rcm) {
		if (rcm == 1) {
			currWeight.setText("Current Weight: " + formatter.format(r1.getWeight()) + " Lbs. ("
					+ formatter.format(r1.getWeight() * 0.454) + " in Kg) (Max = " + r1.getCapacity() + "Lbs / "
					+ r1.getCapacity() * 0.456 + "Kg)");
			currMoney.setText("Money in Machine: $" + r1.getMoney());
		} else if (rcm == 2) {
			currWeight.setText("Current Weight: " + formatter.format(r2.getWeight()) + " Lbs. ("
					+ formatter.format(r2.getWeight() * 0.454) + " in Kg) (Max = " + r2.getCapacity() + "Lbs / "
					+ r2.getCapacity() * 0.456 + "Kg)");
			currMoney.setText("Money in Machine: $" + r2.getMoney());
		}

	}

	//Method that empties the machine
	public void emptyMachine(int rcm) {

		LocalDateTime now = LocalDateTime.now();

		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		
		//Before emptying machine, the total weights and timestamp are written into files
		try {
			if (rcm == 1) {
				// Always wrap FileWriter in BufferedWriter.
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("RCM1.txt", true));
				bufferedWriter.append(month + "-" + day + "-" + year + "  " + hour + ":" + minute + ":" + second);
				bufferedWriter.newLine();

				// Always wrap FileWriter in BufferedWriter.
				BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("TotalWeight1.txt", true));
				bufferedWriter2.append(hour + ":" + Math.round(r1.getWeight()));
				bufferedWriter2.newLine();

				// Always close files.
				bufferedWriter.close();
				bufferedWriter2.close();
			} else if (rcm == 2) {

				// Always wrap FileWriter in BufferedWriter.
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("RCM2.txt", true));
				bufferedWriter.append(month + "-" + day + "-" + year + "  " + hour + ":" + minute + ":" + second);
				bufferedWriter.newLine();

				// Always wrap FileWriter in BufferedWriter.
				BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("TotalWeight2.txt", true));
				bufferedWriter2.append(hour + ":" + Math.round(r2.getWeight()));
				bufferedWriter2.newLine();

				// Always close files.
				bufferedWriter.close();
				bufferedWriter2.close();
			}

		} catch (IOException ex) {
			System.out.println("Error writing to file");
		}

		weightCount = 0.0;
		currWeight.setText(
				"Current Weight: " + formatter.format(weightCount) + " Lbs. (" + formatter.format(weightCount * 0.454)
						+ " in Kg) (Max = " + weightCapacity + "Lbs / " + weightCapacity * 0.456 + "Kg)");
		currMoney.setText("Money in Machine: $" + money);
		output.setText(null);
		output2.setText(null);
	}

	public void actionPerformed(ActionEvent e) {
		int bottleCount = 0, canCount = 0, crateCount = 0, paperBagCount = 0, glassCount = 0, newsCount = 0,
				lightCount = 0, plasticCount = 0, bookCount = 0, applianceCount = 0;
		if (e.getSource().equals(slot1)) {
			if (weightCount < weightCapacity) {
				weightCount += bot.getWeight();
				money -= bot.getPrice();
				currWeight.setText("Current Weight: " + formatter.format(weightCount) + " Lbs. ("
						+ formatter.format(weightCount * 0.454) + " in Kg) (Max = " + weightCapacity + "Lbs / "
						+ weightCapacity * 0.456 + "Kg)");
				totalItems++;
				trueTotalItems++;
				bottleCount = bot.getCount();
				totalPrice += bot.getPrice();
				currMoney.setText("Money in RCM After Transaction: $" + money);
				output.append(b1.getText() + "(s) Entered: " + bottleCount + "\n");
				output2.append("Total Price $" + totalPrice + "\n");
			} else {
				output.append("\nRCM has reached maximum weight " + "\n" + "capacity. Please visit one of our other locations\n");
			}

		} else if (e.getSource().equals(slot2)) {
			if (weightCount < weightCapacity) {
				weightCount += pop.getWeight();
				money -= pop.getPrice();
				currWeight.setText("Current Weight: " + formatter.format(weightCount) + " Lbs. ("
						+ formatter.format(weightCount * 0.454) + " in Kg) (Max = " + weightCapacity + "Lbs / "
						+ weightCapacity * 0.456 + "Kg)");
				totalItems++;
				trueTotalItems++;
				canCount = pop.getCount();
				totalPrice += pop.getPrice();
				currMoney.setText("Money in RCM After Transaction: $" + money);
				output.append(c1.getText() + "(s) Entered: " + canCount + "\n");
				output2.append("Total Price $" + totalPrice + "\n");
			} else {
				output.append("\nRCM has reached maximum weight " + "\n" + "capacity. Please visit one of our other locations\n");
			}
		} else if (e.getSource().equals(slot3)) {
			if (weightCount < weightCapacity) {
				weightCount += box.getWeight();
				money -= box.getPrice();
				currWeight.setText("Current Weight: " + formatter.format(weightCount) + " Lbs. ("
						+ formatter.format(weightCount * 0.454) + " in Kg) (Max = " + weightCapacity + "Lbs / "
						+ weightCapacity * 0.456 + "Kg)");
				totalItems++;
				trueTotalItems++;
				crateCount = box.getCount();
				totalPrice += box.getPrice();
				currMoney.setText("Money in RCM After Transaction: $" + money);
				output.append(c2.getText() + "(s) Entered: " + crateCount + "\n");
				output2.append("Total Price $" + totalPrice + "\n");
			} else {
				output.append("\nRCM has reached maximum weight " + "\n" + "capacity. Please visit one of our other locations\n");
			}
		} else if (e.getSource().equals(slot4)) {
			if (weightCount < weightCapacity) {
				weightCount += cup.getWeight();
				money -= cup.getPrice();
				currWeight.setText("Current Weight: " + formatter.format(weightCount) + " Lbs. ("
						+ formatter.format(weightCount * 0.454) + " in Kg) (Max = " + weightCapacity + "Lbs / "
						+ weightCapacity * 0.456 + "Kg)");
				totalItems++;
				trueTotalItems++;
				glassCount = cup.getCount();
				totalPrice += cup.getPrice();
				currMoney.setText("Money in RCM After Transaction: $" + money);
				output.append(g1.getText() + "(s) Entered: " + glassCount + "\n");
				output2.append("Total Price $" + totalPrice + "\n");
			} else {
				output.append("\nRCM has reached maximum weight " + "\n" + "capacity. Please visit one of our other locations\n");
			}
		} else if (e.getSource().equals(slot5)) {
			if (weightCount < weightCapacity) {
				weightCount += bag.getWeight();
				money -= bag.getPrice();
				currWeight.setText("Current Weight: " + formatter.format(weightCount) + " Lbs. ("
						+ formatter.format(weightCount * 0.454) + " in Kg) (Max = " + weightCapacity + "Lbs / "
						+ weightCapacity * 0.456 + "Kg)");
				totalItems++;
				trueTotalItems++;
				paperBagCount = bag.getCount();
				totalPrice += bag.getPrice();
				currMoney.setText("Money in RCM After Transaction: $" + money);
				output.append(pb1.getText() + "(s) Entered: " + paperBagCount + "\n");
				output2.append("Total Price $" + totalPrice + "\n");
			} else {
				output.append("\nRCM has reached maximum weight " + "\n" + "capacity. Please visit one of our other locations\n");
			}
		} else if (e.getSource().equals(slot6)) {
			if (weightCount < weightCapacity) {
				weightCount += paper.getWeight();
				money -= paper.getPrice();
				currWeight.setText("Current Weight: " + formatter.format(weightCount) + " Lbs. ("
						+ formatter.format(weightCount * 0.454) + " in Kg) (Max = " + weightCapacity + "Lbs / "
						+ weightCapacity * 0.456 + "Kg)");
				totalItems++;
				trueTotalItems++;
				newsCount = paper.getCount();
				totalPrice += paper.getPrice();
				currMoney.setText("Money in RCM After Transaction: $" + money);
				output.append(np.getText() + "(s) Entered: " + newsCount + "\n");
				output2.append("Total Price $" + totalPrice + "\n");
			} else {
				output.append("\nRCM has reached maximum weight " + "\n" + "capacity. Please visit one of our other locations\n");
			}
		} else if (e.getSource().equals(slot7)) {
			if (weightCount < weightCapacity) {
				weightCount += bulb.getWeight();
				money -= bulb.getPrice();
				currWeight.setText("Current Weight: " + formatter.format(weightCount) + " Lbs. ("
						+ formatter.format(weightCount * 0.454) + " in Kg) (Max = " + weightCapacity + "Lbs / "
						+ weightCapacity * 0.456 + "Kg)");
				totalItems++;
				trueTotalItems++;
				lightCount = bulb.getCount();
				totalPrice += bulb.getPrice();
				currMoney.setText("Money in RCM After Transaction: $" + money);
				output.append(lb.getText() + "(s) Entered: " + lightCount + "\n");
				output2.append("Total Price $" + totalPrice + "\n");
			} else {
				output.append("\nRCM has reached maximum weight " + "\n" + "capacity. Please visit one of our other locations\n");
			}
		} else if (e.getSource().equals(slot8)) {
			if (weightCount < weightCapacity) {
				weightCount += plas.getWeight();
				money -= plas.getPrice();
				currWeight.setText("Current Weight: " + formatter.format(weightCount) + " Lbs. ("
						+ formatter.format(weightCount * 0.454) + " in Kg) (Max = " + weightCapacity + "Lbs / "
						+ weightCapacity * 0.456 + "Kg)");
				totalItems++;
				trueTotalItems++;
				plasticCount = plas.getCount();
				totalPrice += plas.getPrice();
				currMoney.setText("Money in RCM After Transaction: $" + money);
				output.append(p1.getText() + "(s) Entered: " + plasticCount + "\n");
				output2.append("Total Price $" + totalPrice + "\n");
			} else {
				output.append("\nRCM has reached maximum weight " + "\n" + "capacity. Please visit one of our other locations\n");
			}
		} else if (e.getSource().equals(slot9)) {
			if (weightCount < weightCapacity) {
				weightCount += read.getWeight();
				money -= read.getPrice();
				currWeight.setText(
						"Current Weight: " + formatter.format(weightCount) + " Lbs. (Max = " + weightCapacity + ")");
				totalItems++;
				trueTotalItems++;
				bookCount = read.getCount();
				totalPrice += read.getPrice();
				currMoney.setText("Money in RCM After Transaction: $" + money);
				output.append(b2.getText() + "(s) Entered: " + bookCount + "\n");
				output2.append("Total Price $" + totalPrice + "\n");
			} else {
				output.append("\nRCM has reached maximum weight " + "\n" + "capacity. Please visit one of our other locations\n");
			}
		} else if (e.getSource().equals(slot10)) {
			if (weightCount < weightCapacity) {
				weightCount += ply.getWeight();
				money -= ply.getPrice();
				currWeight.setText(
						"Current Weight: " + formatter.format(weightCount) + " Lbs. (Max = " + weightCapacity + ")");
				totalItems++;
				trueTotalItems++;
				applianceCount = ply.getCount();
				totalPrice += ply.getPrice();
				currMoney.setText("Money in RCM After Transaction: $" + money);
				output.append(app.getText() + "(s) Entered: " + applianceCount + "\n");
				output2.append("Total Price $" + totalPrice + "\n");
			} else {
				output.append("\nRCM has reached maximum weight " + "\n" + "capacity. Please visit one of our other locations\n");
			}
		} else if (e.getSource().equals(receipt)) {
			if (weightCount < weightCapacity){
				if (totalPrice < money) {
					output2.append("\n" + "\n" + "You deposited " + totalItems + " items." + "\n"
							+ "Your Total in cash is $" + totalPrice + "\n" + "\n");
				} else {
					output2.append("\n" + "\n" + "Not enough cash in RCM for transaction." + "\n"
							+ "Please Accept this Coupon" + "\n");
				}
				BufferedWriter bufferedWriter;
				try {
					bufferedWriter = new BufferedWriter(new FileWriter("TotalPrice.txt", true));
					bufferedWriter.append(Double.toString(totalPrice));
					bufferedWriter.newLine();
					bufferedWriter.close();
					System.out.println(totalPrice + " written in");
				} catch (IOException e2) {
					e2.printStackTrace();
					System.out.println("666");
				}
				bot.clearCount();
				pop.clearCount();
				box.clearCount();
				bag.clearCount();
				cup.clearCount();
				paper.clearCount();
				bulb.clearCount();
				plas.clearCount();
				read.clearCount();
				ply.clearCount();
				totalItems = 0.0;
				totalPrice = 0.0;
			} else{
				output.append("\nRCM has reached maximum weight " + "\n" + "capacity. Please visit one of our other locations\n");
			}
			
			
		} else if (e.getSource().equals(clear)) {
			output.setText(null);
			output2.setText(null);
			currWeight.setText(
					"Current Weight: " + formatter.format(weightCount) + " Lbs. (Max = " + weightCapacity + ")");
			currMoney.setText("Money in RCM: $" + money);
		}
	}

	public static void main(String args[]) {
		new RCM();
	}

}
