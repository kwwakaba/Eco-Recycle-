package displayGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Interface with function to read data from the given file
 * 
 * @author
 */
interface DataGetter {
	public void readDataFromFile(String fileName);
}

/**
 * Class with the hour and weight parameter 
 * @author
 */
class Weight {
	int hour;
	int weight;

	public Weight(int hour, int weight) {
		this.hour = hour;
		this.weight = weight;
	}

	public int getAmount() {
		return weight;
	}
}

/**
 * DataManager class reads weight data from a text file and loads a data
 * structure of type Hashmap
 * 
 * @author
 */
class DataManager implements DataGetter {
	private Map<Color, Weight> weights = new LinkedHashMap<Color, Weight>();

	private Random randomGenerator = new Random();
	private Color[] salesColors;

	/**
	 * Method from interfaces that opens up a file and puts the content into
	 * arrays that will be used to create the bar graph
	 */
	public void readDataFromFile(String fileName) {
		Weight weightByH;

		BufferedReader reader = null;
		int lineCnt = 0;
		try {
			File inFile = new File(fileName);
			reader = new BufferedReader(new FileReader(inFile));

			// ... Loop as long as there are input lines.
			String line = null;

			try {
				while ((line = reader.readLine()) != null) {

					// split each line into tokens
					String[] fields = line.split(":");

					// the String to int conversion happens here
					int hour = Integer.parseInt(fields[0].trim());
					int weightAmount = Integer.parseInt(fields[1].trim());

					weightByH = new Weight(hour, weightAmount);
					int red = randomGenerator.nextInt(256);
					int green = randomGenerator.nextInt(256);
					int blue = randomGenerator.nextInt(256);

					Color randomColor = new Color(red, green, blue);
					weights.put(randomColor, weightByH);
					++lineCnt;
				}
			} finally {
				reader.close();
			}
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException: ");
			System.exit(1);
		}
	}

	/**
	 * Method to return the sales amount with type Map
	 * 
	 * @return
	 */
	public Map<Color, Weight> getData() {
		return weights;
	}
}

/**
 * Class that creates the bar graph
 * 
 * @author
 */
class BarChart extends JPanel {
	private Map<Color, Integer> bars = new LinkedHashMap<Color, Integer>();
	private Map<Color, Weight> data;
	private DataManager datamanager, datamanager2;
	private int rcmCheck;

	/**
	 * 
	 * @param data
	 */
	public BarChart(Map<Color, Weight> data, int rcm) {
		if (rcm == 1) {
			rcmCheck = 1;
			this.datamanager = new DataManager();
			this.datamanager.readDataFromFile("TotalWeight1.txt");
			this.data = datamanager.getData();

			for (Color keyColor : data.keySet()) {
				Weight weight = data.get(keyColor);
				bars.put(keyColor, new Integer(weight.weight));
			}
		} else if (rcm == 2) {
			rcmCheck = 2;
			this.datamanager2 = new DataManager();
			this.datamanager2.readDataFromFile("TotalWeight2.txt");
			this.data = datamanager2.getData();

			for (Color keyColor : data.keySet()) {
				Weight weight = data.get(keyColor);
				bars.put(keyColor, new Integer(weight.weight));
			}
		}
	}

	/**
	 * Method that creates and displays the bar graph given the information from
	 * the file
	 */
	@Override
	protected void paintComponent(Graphics gp) {
		super.paintComponent(gp);
		// Cast the graphics objects to Graphics2D
		Graphics2D g = (Graphics2D) gp;
		// determine longest bar
		int max = Integer.MIN_VALUE;
		for (Integer value : bars.values()) {
			max = Math.max(max, value);
		}
		// paint bars

		int width = (getWidth() / bars.size()) - 2;
		int x = 1;
		for (Color color : bars.keySet()) {
			int value = bars.get(color);
			int height = (int) ((getHeight() - 5) * ((double) value / max));
			g.setColor(color);
			g.fillRect(x, getHeight() - height, width, height);
			g.setColor(Color.black);
			g.drawRect(x, getHeight() - height, width, height);
			x += (width + 2);
		}

		if (rcmCheck == 1) {
			Collection<Weight> mySales = this.datamanager.getData().values();
			int size = this.datamanager.getData().values().size();

			Font newFont;
			int startX = 680;
			int startY = -20;

			AffineTransform at = AffineTransform.getQuadrantRotateInstance(1);
			g.setTransform(at);

			for (Weight sal : mySales) {
				g.setPaint(Color.black);
				newFont = new Font("Ariel", Font.BOLD, 25);
				g.setFont(newFont);
				Color myColor = new Color(0x00, 0x00, 0x00);
				g.setColor(myColor);

				g.drawString("" + sal.hour + ":" + sal.weight, startX, startY);
				System.out.println("" + sal.hour + ":" + sal.weight);

				int step = 577 / size;
				startY -= step;
			}
		} else if (rcmCheck == 2) {
			Collection<Weight> mySales = this.datamanager2.getData().values();
			int size = this.datamanager2.getData().values().size();

			Font newFont;
			int startX = 680;
			int startY = -20;

			AffineTransform at = AffineTransform.getQuadrantRotateInstance(1);
			g.setTransform(at);

			for (Weight sal : mySales) {
				g.setPaint(Color.black);
				newFont = new Font("Ariel", Font.BOLD, 25);
				g.setFont(newFont);
				Color myColor = new Color(0x00, 0x00, 0x00);
				g.setColor(myColor);

				g.drawString("" + sal.hour + ":" + sal.weight, startX, startY);
				System.out.println("" + sal.hour + ":" + sal.weight);

				int step = 577 / size;
				startY -= step;
			}
		}

	}

	/**
	 * Method that sets the dimensions for the graph
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(bars.size() * 50 + 2, 300);
	}

	/*
	 * Method that updates the display 
	 */
	public void updateDisplay() {
		repaint();
	}
}
