package statistichelper2024;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * Calculate Wilcoxon Signed-Rank Test for two lists of values
 *
 * @author BenPapple
 * @version 0.0.24.072
 */
public class Start {

	/**
	 * Start of program
	 *
	 * @param args command line input parameters
	 */
	public static void main(String[] args) {

		// hard coded test data
//		ArrayList<Integer> testDataSampleA = new ArrayList<Integer>();
//		Collections.addAll(testDataSampleA, 320, 450, 250, 700, 540, 260, 360, 530, 560, 510, 490, 370, 600, 660, 810,
//				730, 480, 240, 410, 640, 460, 670, 320, 200, 750, 640, 410, 1000, 940, 690, 330, 290, 330, 670, 650, 80,
//				680, 720, 540, 720, 370, 990, 570, 470, 490, 740, 520, 420, 360, 330);
//		ArrayList<Integer> testDataSampleB = new ArrayList<Integer>();
//		Collections.addAll(testDataSampleB, 440, 360, 600, 640, 480, 240, 360, 360, 520, 490, 480, 560, 360, 360, 640,
//				560, 560, 240, 480, 680, 480, 440, 400, 280, 370, 400, 520, 520, 480, 680, 620, 520, 480, 560, 640, 240,
//				440, 570, 360, 560, 400, 520, 480, 400, 400, 440, 640, 520, 440, 370);
		
		// expected result for hard coded test data or testdata.csv
		// Sum of negative ranks: 419.5
		// Sum of positive ranks: 756.5

		// Prepare CSV for import
		ImportCSV importedCSV = new ImportCSV();
		importedCSV.createList();

		// Import CSV data
		ArrayList<Integer> testDataSampleA = new ArrayList<Integer>(importedCSV.getListA());
		ArrayList<Integer> testDataSampleB = new ArrayList<Integer>(importedCSV.getListB());

		// Print sample lists A and B and count items
		System.out.println("++ Sample ++++++++++++++++++++++++++++++");
		String listAString = testDataSampleA.stream().map(Object::toString).collect(Collectors.joining(", "));
		String listBString = testDataSampleB.stream().map(Object::toString).collect(Collectors.joining(", "));
		System.out.println("Sample A Values: " + listAString);
		System.out.println("Number of values sample A: " + testDataSampleA.size());
		System.out.println();
		System.out.println("Sample B Values: " + listBString);
		System.out.println("Number of values sample B: " + testDataSampleB.size());

		// Subtract sample B value from sample A value
		System.out.println();
		System.out.println("++ Diff ++++++++++++++++++++++++++++++");
		Map<Integer, List<Integer>> sortedDiffs = new TreeMap<Integer, List<Integer>>();
		for (int i = 0; i < testDataSampleA.size(); i++) {

			if (testDataSampleA.get(i) - testDataSampleB.get(i) == 0) {
				// ignore samples where the difference is zero
			} else if (testDataSampleA.get(i) - testDataSampleB.get(i) < 0) {
				if (sortedDiffs.get(Math.abs(testDataSampleA.get(i) - testDataSampleB.get(i))) == null) {
					sortedDiffs.put(Math.abs(testDataSampleA.get(i) - testDataSampleB.get(i)),
							new ArrayList<Integer>());
				}
				sortedDiffs.get(Math.abs(testDataSampleA.get(i) - testDataSampleB.get(i)))
						.add(testDataSampleA.get(i) - testDataSampleB.get(i));
			} else if (testDataSampleA.get(i) - testDataSampleB.get(i) > 0) {
				if (sortedDiffs.get(Math.abs(testDataSampleA.get(i) - testDataSampleB.get(i))) == null) {
					sortedDiffs.put(Math.abs(testDataSampleA.get(i) - testDataSampleB.get(i)),
							new ArrayList<Integer>());
				}
				sortedDiffs.get(Math.abs(testDataSampleA.get(i) - testDataSampleB.get(i)))
						.add(testDataSampleA.get(i) - testDataSampleB.get(i));
			}
		}

		// Calculate rank for Wilcoxon Signed-Rank Test
		System.out.println(sortedDiffs);
		System.out.println();
		System.out.println("++ Ranks ++++++++++++++++++++++++++++++");
		Double negRank = 0.0;
		Double posRank = 0.0;
		Integer rank = 0;
		Double newRank = 0.0;
		System.out.println("Size of the map is : " + sortedDiffs.size());

		for (Entry<Integer, List<Integer>> entry : sortedDiffs.entrySet()) {
			List<List<Integer>> valueList = Arrays.asList(entry.getValue());
			for (List<Integer> item : valueList) {
				List<Integer> valueList2 = item;
				System.out.println("List: " + item);
				newRank = 0.0;
				for (int i = 0; i < valueList2.size(); i++) {
					rank += 1;
					newRank = newRank + rank;
				}
				System.out.println("Rank: " + rank);
				System.out.println("NewRank: " + newRank);
				for (Integer item1 : valueList2) {
					System.out.println("Value: " + item1);
					if (item1 < 0) {
						negRank = negRank + (newRank / valueList2.size());
						System.out.println("Calc + : " + (newRank / valueList2.size()));
						System.out.println("Diff - : " + negRank);
						System.out.println("--------------------");
					} else if (item1 > 0) {
						posRank = posRank + (newRank / valueList2.size());
						System.out.println("Calc + : " + (newRank / valueList2.size()));
						System.out.println("Diff + : " + posRank);
						System.out.println("--------------------");
					}
				} // for3
			} // for2
		} // for1

		// Wilcoxon Signed-Rank Test rank result
		System.out.println("Sum of negative ranks: " + negRank);
		System.out.println("Sum of positive ranks: " + posRank);

	} // main
} // end
