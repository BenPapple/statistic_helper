package statistichelper2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;

/**
 * Import 2 columns of sample data
 *
 */
public class ImportCSV {

	ArrayList<Integer> testDataSampleA = new ArrayList<Integer>();
	ArrayList<Integer> testDataSampleB = new ArrayList<Integer>();

	/**
	 * Constructor. Fill ArrayList with data from CSV file
	 * 
	 */
	public void createList() {
		String line = "";
		String splitBy = ",";
		String csvName = "";

		// Open csv file in file explorer
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV FILES", "csv");
		fileChooser.setFileFilter(filter);

		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Downloads/"));
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			System.out.println("Opening file " + fileChooser.getSelectedFile().getName() + ".");
			csvName = fileChooser.getSelectedFile().getName();
		}

		// Read csv file into ArrayLists
		try (BufferedReader br = new BufferedReader(new FileReader(csvName))) {
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
