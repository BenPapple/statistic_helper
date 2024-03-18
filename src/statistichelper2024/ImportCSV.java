package statistichelper2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Import 2 columns of sample data
 *
 */
public class ImportCSV {

	ArrayList<Integer> testDataSampleA = new ArrayList<Integer>();
	ArrayList<Integer> testDataSampleB = new ArrayList<Integer>();

	/**
	 * Constructor. Fill ArrayList with data from csv file
	 * 
	 */
	public void createList() {
		String line = "";
		String splitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader("testdata.csv"))) {
			while ((line = br.readLine()) != null) {
				String[] sample = line.split(splitBy);
				testDataSampleA.add(Integer.valueOf(sample[0]));
				testDataSampleB.add(Integer.valueOf(sample[1]));

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Returns sample A values
	 * 
	 * @return ArrayList<Integer> with sample A data
	 */
	public ArrayList<Integer> getListA() {
		return testDataSampleA;
	}

	/**
	 * Returns sample B values
	 * 
	 * @return ArrayList<Integer> with sample B data
	 */
	public ArrayList<Integer> getListB() {
		return testDataSampleB;
	}

} // class
