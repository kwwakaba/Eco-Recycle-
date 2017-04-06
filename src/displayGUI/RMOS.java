package displayGUI;

import machine.Bottle;
import machine.Can;
import machine.Crate;
import machine.Glass;
import machine.PaperBag;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/*
 * Inner class tab that allows the admin to change the item name and
 * price of a specified item and price in an RCM
 * */ 

class ChangeItem extends JPanel implements ActionListener {
	private JPanel rcmSelect, itemChange, changeName, changePrice;
	private JLabel rcm, oldItem;
	private JRadioButton one, two;
	private ButtonGroup groupOne;
	private JButton button, name, price;
	private JTextField text, text2;
	private double id, machine;
	private int rcmCheck;
	private RCM r1, r2;
	private JComboBox<String> recycle;

	//Constructor
	public ChangeItem() {
		r1 = RCM.getOneInstance();
		r2 = RCM.getTwoInstance();

		rcmSelect = new JPanel();
		groupOne = new ButtonGroup();

		rcm = new JLabel("Select RCM: ");
		one = new JRadioButton("RCM 1");
		two = new JRadioButton("RCM 2");
		groupOne.add(one);
		groupOne.add(two);

		rcmSelect.add(rcm);
		rcmSelect.add(one);
		rcmSelect.add(two);

		one.addActionListener(this);
		two.addActionListener(this);

		/////////////////////////////////////////////////

		itemChange = new JPanel();
		oldItem = new JLabel("Select Item to Change: ");
		String[] items = new String[] { "Bottle", "Can", "Crate", "Glass", "Paper Bag", "NewsPaper", "LightBulb",
				"Plastic", "Book", "Appliance" };
		recycle = new JComboBox<String>(items);
		itemChange.add(oldItem);
		itemChange.add(recycle);

		//////////////////////////////////////////////////
		changeName = new JPanel();

		name = new JButton("Change Item Name: ");
		text = new JTextField(10);
		name.addActionListener(this);

		changeName.add(name);
		changeName.add(text);

		///////////////////////////////////////////////////
		changePrice = new JPanel();

		price = new JButton("Change Item Price: ");
		text2 = new JTextField(10);
		price.addActionListener(this);

		changePrice.add(price);
		changePrice.add(text2);

		setChangeItemLayout();
	}

	public void actionPerformed(ActionEvent e) {
		String input = text.getText();
		String input2 = text2.getText();
		double temp;
		// int item;

		if (e.getSource() == one) {
			rcmCheck = 1;

		} else if (e.getSource() == two) {
			rcmCheck = 2;
			System.out.println("RCM " + rcmCheck);
		}

		String checkItem = (String) recycle.getSelectedItem();

		/*
		 * If the name button was pressed, switch statement is initiated
		 * and depending on which item was selected, method is called to
		 * change the name from the old to the new inputed string
		 * */
		if (e.getSource() == name) {
			//Checks which RCM is checked
			if (rcmCheck == 1) {
				switch (checkItem) {
				case "Bottle":
					r1.setItemName(input, 1);
					break;
				case "Can":
					r1.setItemName(input, 2);
					break;
				case "Crate":
					r1.setItemName(input, 3);
					break;
				case "Glass":
					r1.setItemName(input, 4);
					break;
				case "Paper Bag":
					r1.setItemName(input, 5);
					break;
				case "NewsPaper":
					r1.setItemName(input, 6);
					break;
				case "LightBulb":
					r1.setItemName(input, 7);
					break;
				case "Plastic":
					r1.setItemName(input, 8);
					break;
				case "Book":
					r1.setItemName(input, 9);
					break;
				case "Appliance":
					r1.setItemName(input, 10);
					break;
				}

			} else if (rcmCheck == 2) {
				switch (checkItem) {
				case "Bottle":
					r2.setItemName(input, 1);
					break;
				case "Can":
					r2.setItemName(input, 2);
					break;
				case "Crate":
					r2.setItemName(input, 3);
					break;
				case "Glass":
					r2.setItemName(input, 4);
					break;
				case "Paper Bag":
					r2.setItemName(input, 5);
					break;
				case "NewsPaper":
					r2.setItemName(input, 6);
					break;
				case "LightBulb":
					r2.setItemName(input, 7);
					break;
				case "Plastic":
					r2.setItemName(input, 8);
					break;
				case "Book":
					r2.setItemName(input, 9);
					break;
				case "Appliance":
					r2.setItemName(input, 10);
					break;
				}
			}
		}

		/*
		 * If the price button was pressed, switch statement is initiated
		 * and depending on which item was selected, method is called to
		 * change the price from the old to the new inputed string
		 * */
		if (e.getSource() == price) {
			//Checks if RCM 1 is selected 
			if (rcmCheck == 1) {
				switch (checkItem) {
				case "Bottle":
					try {
						temp = Double.parseDouble(input2.trim());
						r1.setItemPrice(temp, 1);
					} catch (NumberFormatException g) {
						g.printStackTrace();
					}

					break;
				case "Can":
					try {
						temp = Double.parseDouble(input2.trim());
						r1.setItemPrice(temp, 2);
					} catch (NumberFormatException g) {
						g.printStackTrace();

					}

					break;
				case "Crate":
					try {
						temp = Double.parseDouble(input2.trim());
						r1.setItemPrice(temp, 3);
					} catch (NumberFormatException g) {
						g.printStackTrace();
					}

					break;
				case "Glass":
					try {
						temp = Double.parseDouble(input2.trim());
						r1.setItemPrice(temp, 4);
					} catch (NumberFormatException g) {
						g.printStackTrace();
					}

					break;
				case "Paper Bag":
					try {
						temp = Double.parseDouble(input2.trim());
						r1.setItemPrice(temp, 5);
					} catch (NumberFormatException g) {
						g.printStackTrace();
					}

					break;
				case "NewsPaper":
					try {
						temp = Double.parseDouble(input2.trim());
						r1.setItemPrice(temp, 6);
					} catch (NumberFormatException g) {
						g.printStackTrace();
					}
					break;
				case "LightBulb":
					try {
						temp = Double.parseDouble(input2.trim());
						r1.setItemPrice(temp, 7);
					} catch (NumberFormatException g) {
						g.printStackTrace();
					}

					break;
				case "Plastic":
					try {
						temp = Double.parseDouble(input2.trim());
						r1.setItemPrice(temp, 8);
					} catch (NumberFormatException g) {
						g.printStackTrace();
					}

					break;
				case "Book":
					try {
						temp = Double.parseDouble(input2.trim());
						r1.setItemPrice(temp, 9);
					} catch (NumberFormatException g) {
						g.printStackTrace();
					}

					break;
				case "Appliance":
					try {
						temp = Double.parseDouble(input2.trim());
						r1.setItemPrice(temp, 10);
					} catch (NumberFormatException g) {
						g.printStackTrace();
					}

					break;
				}

			} else if (rcmCheck == 2) {
				switch (checkItem) {
				case "Bottle":
					try {
						temp = Double.parseDouble(input2.trim());
						r2.setItemPrice(temp, 1);
					} catch (NumberFormatException g) {
						g.printStackTrace();
					}

					break;
				case "Can":
					try {
						temp = Double.parseDouble(input2.trim());
						r2.setItemPrice(temp, 2);
					} catch (NumberFormatException g) {
						g.printStackTrace();
					}

					break;
				case "Crate":
					try {
						temp = Double.parseDouble(input2.trim());
						r2.setItemPrice(temp, 3);
					} catch (NumberFormatException g) {
						g.printStackTrace();
					}

					break;
				case "Glass":
					try {
						temp = Double.parseDouble(input2.trim());
						r2.setItemPrice(temp, 4);
					} catch (NumberFormatException g) {
						g.printStackTrace();
					}

					break;
				case "Paper Bag":
					try {
						temp = Double.parseDouble(input2.trim());
						r2.setItemPrice(temp, 5);
					} catch (NumberFormatException g) {
						g.printStackTrace();
					}

					break;
				case "NewsPaper":
					try {
						temp = Double.parseDouble(input2.trim());
						r2.setItemPrice(temp, 6);
					} catch (NumberFormatException g) {
						g.printStackTrace();
					}

					break;
				case "LightBulb":
					try {
						temp = Double.parseDouble(input2.trim());
						r2.setItemPrice(temp, 7);
					} catch (NumberFormatException g) {
						g.printStackTrace();
					}

					break;
				case "Plastic":
					try {
						temp = Double.parseDouble(input2.trim());
						r2.setItemPrice(temp, 8);
					} catch (NumberFormatException g) {
						g.printStackTrace();
					}

					break;
				case "Book":
					try {
						temp = Double.parseDouble(input2.trim());
						r2.setItemPrice(temp, 9);
					} catch (NumberFormatException g) {
						g.printStackTrace();
					}

					break;
				case "Appliance":
					try {
						temp = Double.parseDouble(input2.trim());
						r2.setItemPrice(temp, 10);
					} catch (NumberFormatException g) {
						g.printStackTrace();
					}

					break;
				}
			}
		}
	}

	//Sets the layout of the tab
	private void setChangeItemLayout() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(rcmSelect);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(itemChange);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(changeName);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(changePrice);
		add(Box.createRigidArea(new Dimension(0, 20)));

	}

}

/***********************************************************************/

/*
 * Inner Class tab that allows th admin to add or remove a specified item to
 * an RCM
 * */
class AddItem extends JPanel implements ActionListener {
	private JPanel rcmSelect, itemChange, addItem, removeItem;
	private JLabel rcm, oldItem, name, price;
	private JRadioButton one, two;
	private JButton adds, removes;
	private ButtonGroup groupOne;
	private JComboBox recycle, recycle2;
	private double id, machine;
	private int rcmCheck;
	private RCM r1, r2;

	JButton button;

	//Constructor 
	public AddItem() {
		r1 = RCM.getOneInstance();
		r2 = RCM.getTwoInstance();
		rcmSelect = new JPanel();
		groupOne = new ButtonGroup();

		rcm = new JLabel("Select RCM: ");
		one = new JRadioButton("RCM 1");
		two = new JRadioButton("RCM 2");
		groupOne.add(one);
		groupOne.add(two);

		rcmSelect.add(rcm);
		rcmSelect.add(one);
		rcmSelect.add(two);

		one.addActionListener(this);
		two.addActionListener(this);

		//////////////////////////////////////////////////
		addItem = new JPanel();

		name = new JLabel("Select Item to add: ");
		String[] items = new String[] { "Bottle", "Can", "Crate", "Glass", "Paper Bag", "NewsPaper", "LightBulb",
				"Plastic", "Book", "Appliance" };
		recycle = new JComboBox<String>(items);
		adds = new JButton("Add Item");

		addItem.add(name);
		addItem.add(recycle);
		addItem.add(adds);
		adds.addActionListener(this);

		///////////////////////////////////////////////////
		removeItem = new JPanel();

		price = new JLabel("Select Item to remove: ");
		recycle2 = new JComboBox<String>(items);
		removes = new JButton("Remove Item");

		removeItem.add(price);
		removeItem.add(recycle2);
		removeItem.add(removes);
		removes.addActionListener(this);

		setChangeItemLayout();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == one) {
			rcmCheck = 1;
			System.out.println("RCM " + rcmCheck);
		} else if (e.getSource() == two) {
			rcmCheck = 2;
			System.out.println("RCM " + rcmCheck);
		}

		String checkItem = (String) recycle.getSelectedItem();
		String checkItem2 = (String) recycle2.getSelectedItem();

		/*
		 * IF the add button is pressed, depending on the RCM picked and 
		 * the item selected, the specified item will be added to the RCM
		 * */
		if (e.getSource() == adds) {
			if (rcmCheck == 1) {
				switch (checkItem) {
				case "Bottle":
					r1.addButton(1);
					break;
				case "Can":
					r1.addButton(2);
					break;
				case "Crate":
					r1.addButton(3);
					break;
				case "Glass":
					r1.addButton(4);
					break;
				case "Paper Bag":
					r1.addButton(5);
					break;
				case "NewsPaper":
					r1.addButton(6);
					break;
				case "LightBulb":
					r1.addButton(7);
					break;
				case "Plastic":
					r1.addButton(8);
					break;
				case "Book":
					r1.addButton(9);
					break;
				case "Appliance":
					r1.addButton(10);
					break;
				}

			} else if (rcmCheck == 2) {
				switch (checkItem) {
				case "Bottle":
					r2.addButton(1);
					break;
				case "Can":
					r2.addButton(2);
					break;
				case "Crate":
					r2.addButton(3);
					break;
				case "Glass":
					r2.addButton(4);
					break;
				case "Paper Bag":
					r2.addButton(5);
					break;
				case "NewsPaper":
					r2.addButton(6);
					break;
				case "LightBulb":
					r2.addButton(7);
					break;
				case "Plastic":
					r2.addButton(8);
					break;
				case "Book":
					r2.addButton(9);
					break;
				case "Appliance":
					r2.addButton(10);
					break;
				}
			}
		}

		/*
		 * If the remove button is pressed, depending on the RCM picked and 
		 * the item selected, the specified item will be removed from the RCM
		 * */
		if (e.getSource() == removes) {
			if (rcmCheck == 1) {
				switch (checkItem2) {
				case "Bottle":
					r1.removeButton("Bottle");
					break;
				case "Can":
					r1.removeButton("Can");
					break;
				case "Crate":
					r1.removeButton("Crate");
					break;
				case "Glass":
					r1.removeButton("Glass");
					break;
				case "Paper Bag":
					r1.removeButton("Paper Bag");
					break;
				case "NewsPaper":
					r1.removeButton("NewsPaper");
					break;
				case "LightBulb":
					r1.removeButton("LightBulb");
					break;
				case "Plastic":
					r1.removeButton("Plastic");
					break;
				case "Book":
					r1.removeButton("Book");
					break;
				case "Appliance":
					r1.removeButton("Appliance");
					break;
				}

			} else if (rcmCheck == 2) {
				switch (checkItem2) {
				case "Bottle":
					r2.removeButton("Bottle");
					break;
				case "Can":
					r2.removeButton("Can");
					break;
				case "Crate":
					r2.removeButton("Crate");
					break;
				case "Glass":
					r2.removeButton("Glass");
					break;
				case "Paper Bag":
					r2.removeButton("Paper Bag");
					break;
				case "NewsPaper":
					r2.removeButton("NewsPaper");
					break;
				case "LightBulb":
					r2.removeButton("LightBulb");
					break;
				case "Plastic":
					r2.removeButton("Plastic");
					break;
				case "Book":
					r2.removeButton("Book");
					break;
				case "Appliance":
					r2.removeButton("Appliance");
					break;
				}
			}
		}
	}
	
	//sets the layout of the tab
	private void setChangeItemLayout() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(rcmSelect);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(addItem);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(removeItem);
		add(Box.createRigidArea(new Dimension(0, 20)));

	}
}

/***********************************************************************/

/*
 * Inner class tab that sets and displays the weight and capacity of and RCM.
 * Also has a button to update the RCM as well as empty an RCM
 * */
class WeightAndCapacity extends JPanel implements ActionListener {
	private JPanel rcmSelect, weight, capacity, newCapacity, money, setMoney, dump;
	private JLabel rcm;
	private JButton currWeight, currCapacity, newCap, funds, newFunds, empty, update;
	private JTextField text, text2, text3, text4, text5;
	private JRadioButton one, two;
	private ButtonGroup groupOne;
	private RCM r1, r2;
	private double id, machine;
	private int rcmCheck;

	NumberFormat formatter = new DecimalFormat("#0.00");

	//Constructor
	public WeightAndCapacity() {
		r1 = RCM.getOneInstance();
		r2 = RCM.getTwoInstance();
		rcmSelect = new JPanel();
		groupOne = new ButtonGroup();

		rcm = new JLabel("Select RCM: ");
		one = new JRadioButton("RCM 1");
		two = new JRadioButton("RCM 2");
		one.addActionListener(this);
		two.addActionListener(this);
		groupOne.add(one);
		groupOne.add(two);

		rcmSelect.add(rcm);
		rcmSelect.add(one);
		rcmSelect.add(two);

		////////////////////////////////////////////

		weight = new JPanel();
		currWeight = new JButton("Get Current Weight");
		text = new JTextField(10);
		text.setEditable(false);
		weight.add(currWeight);
		weight.add(text);
		currWeight.addActionListener(this);

		////////////////////////////////////////////

		capacity = new JPanel();
		currCapacity = new JButton("Get Current Capacity ");
		text2 = new JTextField(10);
		text2.setEditable(false);
		capacity.add(currCapacity);
		capacity.add(text2);
		currCapacity.addActionListener(this);

		////////////////////////////////////////////

		newCapacity = new JPanel();
		newCap = new JButton("Set Capacity ");
		text3 = new JTextField(10);
		newCapacity.add(newCap);
		newCapacity.add(text3);
		newCap.addActionListener(this);

		////////////////////////////////////////////

		money = new JPanel();
		funds = new JButton("Get Amount in Machine ");
		text4 = new JTextField(10);
		text4.setEditable(false);
		money.add(funds);
		money.add(text4);
		funds.addActionListener(this);

		////////////////////////////////////////////

		setMoney = new JPanel();
		newFunds = new JButton("Set Amount in Machine ");
		text5 = new JTextField(10);
		setMoney.add(newFunds);
		setMoney.add(text5);
		newFunds.addActionListener(this);

		////////////////////////////////////////////

		dump = new JPanel();
		empty = new JButton("Empty Machine");
		update = new JButton("Update Machine");
		dump.add(empty);
		dump.add(update);
		empty.addActionListener(this);
		update.addActionListener(this);

		setWeightAndCapacityLayout();
	}

	public void actionPerformed(ActionEvent e) {
		double temp;
		String input;

		//Checks which RCM was selected
		if (e.getSource() == one) {
			try {
				id = r1.getId();
				machine = r1.getMachine();
				rcmCheck = 1;
				System.out.println("RCM " + rcmCheck);
			} catch (NumberFormatException g) {
				g.printStackTrace();
			}

		} else if (e.getSource() == two) {
			try {
				id = r2.getId();
				machine = r2.getMachine();
				rcmCheck = 2;
				System.out.println("RCM " + rcmCheck);
			} catch (NumberFormatException g) {
				g.printStackTrace();
			}
		}

		/*
		 * If funds is selected, the current amount of money left
		 * in the RCM is displayed 
		 * */
		if (e.getSource() == funds) {
			if (rcmCheck == 1) {
				try {
					temp = r1.getMoney();
					text4.setText(null);
					text4.setText(formatter.format(temp));
				} catch (NumberFormatException g) {
					g.printStackTrace();
				}

			} else if (rcmCheck == 2) {
				try {
					temp = r2.getMoney();
					text4.setText(null);
					text4.setText(formatter.format(temp));
				} catch (NumberFormatException g) {
					g.printStackTrace();
				}

			}
		}

		/*
		 * If the current weight button is clicked, the current 
		 * weight of the RCM is displayed
		 * */
		if (e.getSource() == currWeight) {
			if (rcmCheck == 1) {
				try {
					temp = r1.getWeight();
					text.setText(null);
					text.setText(formatter.format(temp));
				} catch (NumberFormatException g) {
					g.printStackTrace();
				}

			} else if (rcmCheck == 2) {
				try {
					temp = r2.getWeight();
					formatter.format(temp);
					text.setText(null);
					text.setText(formatter.format(temp));
				} catch (NumberFormatException g) {
					g.printStackTrace();
				}

			}
		}

		/*
		 * If the current capacity button is clicked, the current capacity
		 * of the RCM is displayed 
		 * */
		if (e.getSource() == currCapacity) {
			if (rcmCheck == 1) {
				try {
					temp = r1.getCapacity();
					text2.setText(null);
					text2.setText(Double.toString(temp).trim());
				} catch (NumberFormatException g) {
					g.printStackTrace();
				}

			} else if (rcmCheck == 2) {
				try {
					temp = r2.getCapacity();
					text2.setText(null);
					text2.setText(Double.toString(temp).trim());
				} catch (NumberFormatException g) {
					g.printStackTrace();
				}
			}
		}

		/*
		 * If the set capacity button is clicked , the RCM capacity
		 * will be set based on the value inputed by the admin
		 * */
		if (e.getSource() == newCap) {
			if (rcmCheck == 1) {
				try {
					input = text3.getText();
					r1.setWeight(Double.parseDouble(input.trim()));
					System.out.println("Capacity updated");
				} catch (NumberFormatException g) {
					g.printStackTrace();
				}

			} else if (rcmCheck == 2) {
				try {
					input = text3.getText();
					r2.setWeight(Double.parseDouble(input.trim()));
					System.out.println("Capacity updated");
				} catch (NumberFormatException g) {
					g.printStackTrace();
				}
			}
		}

		/*
		 * If the set money button is clicked , the RCM money
		 * will be set based on the value inputed by the admin
		 * */
		if (e.getSource() == newFunds) {
			if (rcmCheck == 1) {
				try {
					input = text5.getText();
					r1.setMoney(Double.parseDouble(input.trim()));
					System.out.println("Capacity updated");
				} catch (NumberFormatException g) {
					g.printStackTrace();
				}

			} else if (rcmCheck == 2) {
				try {
					input = text5.getText();
					r2.setMoney(Double.parseDouble(input.trim()));
					System.out.println("Capacity updated");
				} catch (NumberFormatException g) {
					g.printStackTrace();
				}

			}
		}

		/*
		 * If empty machine button is pressed, the RCM will be 
		 * emptied
		 * */
		if (e.getSource() == empty) {
			if (rcmCheck == 1) {
				r1.emptyMachine(1);
			} else if (rcmCheck == 2) {
				r2.emptyMachine(2);
			}
		}

		/*
		 * If update machine button is pressed, the RCM information
		 * will be updated 
		 * */
		if (e.getSource() == update) {
			if (rcmCheck == 1) {
				r1.updateRCM(1);
			} else if (rcmCheck == 2) {
				r2.updateRCM(2);
			}
		}
	}

	//sets the layout of the tab
	private void setWeightAndCapacityLayout() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(rcmSelect);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(weight);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(money);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(setMoney);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(capacity);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(newCapacity);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(dump);
		add(Box.createRigidArea(new Dimension(0, 10)));

	}

}

/**********************************************************************/

/*
 * Inner class tab the allows the admin to get the current statistics 
 * about the specified RCM
 * */
class GetStats extends JPanel implements ActionListener {
	private JPanel rcmSelect, returned, empty, locID, charts;
	private JLabel rcm;
	private JButton itemReturn, rcmEmpty, getPlace, update1, update2;
	private JTextField text, text2, text3;
	private JRadioButton one, two;
	private ButtonGroup groupOne;
	private RCM r1, r2;
	private double id, machine;
	private int rcmCheck;

	//constructor
	public GetStats() {
		r1 = RCM.getOneInstance();
		r2 = RCM.getTwoInstance();
		rcmSelect = new JPanel();
		groupOne = new ButtonGroup();

		rcm = new JLabel("Select RCM: ");
		one = new JRadioButton("RCM 1");
		two = new JRadioButton("RCM 2");
		one.addActionListener(this);
		two.addActionListener(this);
		groupOne.add(one);
		groupOne.add(two);

		rcmSelect.add(rcm);
		rcmSelect.add(one);
		rcmSelect.add(two);
		////////////////////////////////////////////

		returned = new JPanel();
		itemReturn = new JButton("# of Items Returned");
		text = new JTextField(10);
		text.setEditable(false);
		returned.add(itemReturn);
		returned.add(text);
		itemReturn.addActionListener(this);

		////////////////////////////////////////////

		locID = new JPanel();
		getPlace = new JButton("Most Used RCM");
		text3 = new JTextField(15);
		text3.setEditable(false);
		locID.add(getPlace);
		locID.add(text3);
		getPlace.addActionListener(this);

		////////////////////////////////////////////

		empty = new JPanel();
		rcmEmpty = new JButton("Last Time Emptied");
		text2 = new JTextField(15);
		text2.setEditable(false);
		empty.add(rcmEmpty);
		empty.add(text2);
		rcmEmpty.addActionListener(this);

		////////////////////////////////////////////

		setWeightAndCapacityLayout();
	}

	public void actionPerformed(ActionEvent e) {
		double temp;
		// String input;

		if (e.getSource() == one) {
			id = r1.getId();
			machine = r1.getMachine();
			rcmCheck = 1;
			System.out.println("RCM " + rcmCheck);
		} else if (e.getSource() == two) {
			id = r2.getId();
			machine = r2.getMachine();
			rcmCheck = 2;
			System.out.println("RCM " + rcmCheck);
		}

		/*
		 * If button pressed, returns the number of items returend 
		 * */
		if (e.getSource() == itemReturn) {
			if (rcmCheck == 1) {
				try {
					temp = r1.getTrueTotal();
					text.setText(null);
					text.setText(Double.toString(temp).trim());

				} catch (NumberFormatException g) {
					g.printStackTrace();
				}

			} else if (rcmCheck == 2) {

				try {
					temp = r2.getTrueTotal();
					text.setText(null);
					text.setText(Double.toString(temp).trim());
				} catch (NumberFormatException g) {
					g.printStackTrace();
				}
			}
		}

		/*
		 * If button pressed, returns the most used RCM location and ID
		 * */
		if (e.getSource() == getPlace) {
			if (r1.getTrueTotal() == 0 && r2.getTrueTotal() == 0) {
				text3.setText("Mahines Not Used Yet");
			} else if (r1.getTrueTotal() > r2.getTrueTotal()) {
				text3.setText(null);
				text3.setText("Machine #" + r1.getMachine() + " ID: " + r1.getId());
			} else {
				text3.setText(null);
				text3.setText("Machine #" + r2.getMachine() + " ID: " + r2.getId());
			}
		}

		/*
		 * If button pressed, returns the last time the specified RCM was emptied 
		 * */
		if (e.getSource() == rcmEmpty) {
			if (rcmCheck == 1) {
				String last = "", line;
				try {
					BufferedReader reader = new BufferedReader(new FileReader("RCM1.txt"));
					while ((line = reader.readLine()) != null) {
						last = line;
					}
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					text2.setText(last);
				}
			} else if (rcmCheck == 2) {
				String last = "", line;
				try {
					BufferedReader reader = new BufferedReader(new FileReader("RCM2.txt"));
					while ((line = reader.readLine()) != null) {
						last = line;
					}
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					text2.setText(last);
				}
			}
		}

	}

	//setst the layout of the tab
	private void setWeightAndCapacityLayout() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(rcmSelect);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(returned);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(locID);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(empty);
		add(Box.createRigidArea(new Dimension(0, 20)));

	}
}

/***********************************************************************/

/*
 * Main Class that houses all the tabs as is the main control of the RCM
 * */
public class RMOS implements ActionListener {

	private RCM r1, r2;
	private Bar b1 = new Bar();
	private JButton update, update2, update3;
	private JPanel panel, stats, one, two, three;

	DefaultTableModel model = new DefaultTableModel();
	DefaultTableModel model2 = new DefaultTableModel();
	DefaultTableModel model3 = new DefaultTableModel();

	private DataManager dataManager = new DataManager();
	private DataManager dataManager2 = new DataManager();
	private BarChart chart, chart2;

	//constructor
	public RMOS() {
		super();

		r1 = RCM.getOneInstance();
		r2 = RCM.getTwoInstance();
		panel = new JPanel();
		stats = new JPanel();

		dataManager.readDataFromFile("TotalWeight1.txt");
		dataManager2.readDataFromFile("TotalWeight2.txt");

		JTable table = new JTable(model);
		JScrollPane bar = new JScrollPane(table);
		model.addColumn("Total Weight(lbs): RCM1", b1.getWeightOneVector());
		model.addColumn("Total Weight(Kg): RCM1", b1.getKiloOneVector());

		JTable table2 = new JTable(model2);
		JScrollPane bar2 = new JScrollPane(table2);
		model2.addColumn("Total Weight(lbs): RCM2", b1.getWeightTwoVector());
		model2.addColumn("Total Weight(Kg): RCM2", b1.getKiloTwoVector());

		JTable table3 = new JTable(model3);
		JScrollPane bar3 = new JScrollPane(table3);
		model3.addColumn("Total Value Issued ($)", b1.getTotalPriceVector());

		bar.setPreferredSize(new Dimension(300, 150));
		bar2.setPreferredSize(new Dimension(300, 150));
		bar3.setPreferredSize(new Dimension(200, 150));

		one = new JPanel(new GridLayout(0, 1));
		two = new JPanel(new GridLayout(0, 1));
		three = new JPanel(new GridLayout(0, 1));

		update = new JButton("RCM Graph 1");
		update2 = new JButton("RCM Graph 2");
		update3 = new JButton("Update 3");
		update.addActionListener(this);
		update2.addActionListener(this);
		update3.addActionListener(this);

		stats.add(bar);
		stats.add(bar2);
		stats.add(bar3);

		stats.add(update);
		stats.add(update2);

		JPanel top = new JPanel(new GridLayout(0, 2));

		top.add(r1, BorderLayout.WEST);
		top.add(r2, BorderLayout.EAST);

		panel.add(r1);
		panel.add(r2);

		JFrame frame = new JFrame("EcoRe Center");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// center the mainFrame on screen
		frame.setLocationRelativeTo(null);

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Add/Remove Item", new AddItem());
		tabbedPane.addTab("Change Item", new ChangeItem());
		tabbedPane.addTab("Weight/Capacity/Funds", new WeightAndCapacity());
		tabbedPane.addTab("Get Statistics", new GetStats());
		tabbedPane.addTab("Show Statistics", stats);

		frame.setSize(1500, 1000);
		//frame.setResizable(false);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.getContentPane().add(tabbedPane, BorderLayout.SOUTH);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		/*
		 * If button pressed, displays a graph with the current total
		 * weights emptied in RCM1 
		 * */
		if (e.getSource() == update) {
			JFrame frame = new JFrame("RCM 1");
			DataManager datamanager = new DataManager();
			datamanager.readDataFromFile("TotalWeight1.txt");
			JPanel panel = new JPanel();

			JLabel label = new JLabel("Total RCM 1 Weight(lbs) Recycled by Hour");
			label.setFont(new Font("Serif", Font.BOLD, 20));

			panel.add(label);

			BarChart chart = new BarChart(datamanager.getData(), 1);
			chart.setSize(500, 700);

			frame.setSize(600, 800);
			frame.getContentPane().add(panel, BorderLayout.NORTH);
			frame.getContentPane().add(chart, BorderLayout.CENTER);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		}

		/*
		 * If button pressed, displays a graph with the current total
		 * weights emptied in RCM2 
		 * */
		if (e.getSource() == update2) {
			JFrame frame = new JFrame("RCM 2");
			DataManager datamanager2 = new DataManager();
			datamanager2.readDataFromFile("TotalWeight2.txt");
			JPanel panel2 = new JPanel();

			JLabel label2 = new JLabel("Total RCM 2 Weight(lbs) Recycled by Hour");
			label2.setFont(new Font("Serif", Font.BOLD, 20));

			panel2.add(label2);

			BarChart chart2 = new BarChart(datamanager2.getData(), 2);
			chart2.setSize(500, 700);

			frame.setSize(600, 800);
			frame.getContentPane().add(panel2, BorderLayout.NORTH);
			frame.getContentPane().add(chart2, BorderLayout.CENTER);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		}
	}

	//Main method to call RMOS in order to begin simulation
	public static void main(String args[]) {
		new RMOS();
	}

}
