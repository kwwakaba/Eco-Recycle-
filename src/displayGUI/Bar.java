package displayGUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Public Class that gather the information from the text files containing
 * the total weights emptied and the total weight deposited, reads them into
 * vectors, and then using other methods, sends those vectors to the RCM to be
 * used to generate the data tables 
 * */
public class Bar {
	private DefaultTableModel model2 = new DefaultTableModel();

	private Vector<Integer> temps = new Vector<Integer>();
	private Vector<Integer> temps2 = new Vector<Integer>();
	private Vector<Double> temps3 = new Vector<Double>();
	private Vector<Double> kg = new Vector<Double>();
	private Vector<Double> kg2 = new Vector<Double>();

	//Constructor 
	public Bar() {

		JTable tables = new JTable(model2);

		BufferedReader reader = null;
		BufferedReader reader2 = null;
		BufferedReader reader3 = null;
		int lineCnt = 0;
		try {
			File inFile = new File("TotalWeight1.txt");
			reader = new BufferedReader(new FileReader(inFile));

			File inFile2 = new File("TotalWeight2.txt");
			reader2 = new BufferedReader(new FileReader(inFile2));

			File inFile3 = new File("TotalPrice.txt");
			reader3 = new BufferedReader(new FileReader(inFile3));

			String line = null;
			String line2 = null;
			String line3 = null;

			double value;
			double kilg, kilg2;
			//Loops to read in the files into vectors 
			try {
				String last = "", lines = "";
				while ((line = reader.readLine()) != null) {
					// split each line into tokens
					String[] fields = line.split(":");

					// the String to int conversion happens here
					String hour = fields[0].trim();
					int weightAmount = Integer.parseInt(fields[1].trim());
					kilg = weightAmount * 0.454;
					temps.add(weightAmount);
					kg.add(kilg);
					++lineCnt;
				}

				while ((line2 = reader2.readLine()) != null) {
					// split each line into tokens
					String[] fields = line2.split(":");

					// the String to int conversion happens here
					String hour = fields[0].trim();
					int weightAmount = Integer.parseInt(fields[1].trim());
					kilg2 = weightAmount * 0.454;
					temps2.add(weightAmount);
					kg2.add(kilg2);

					++lineCnt;
				}

				while ((line3 = reader3.readLine()) != null) {
					last = line3;
					value = Double.parseDouble(last);
					temps3.add(value);
				}

			} finally {
				reader.close();
				reader2.close();
				reader3.close();
			}
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		} catch (NumberFormatException e) {

			System.out.println("NumberFormatException: ");
		}

	}

	//Method to return the weight one vector
	public Vector<Integer> getWeightOneVector() {
		return temps;
	}

	//Method to return the weight two vector 
	public Vector<Integer> getWeightTwoVector() {
		return temps2;
	}

	//Method to return the weight one vector in Kilos
	public Vector<Double> getKiloOneVector() {
		return kg;
	}

	//Method to return the weight two vector in kilos
	public Vector<Double> getKiloTwoVector() {
		return kg2;
	}

	//Method to return the total price vector
	public Vector<Double> getTotalPriceVector() {
		return temps3;
	}

}
