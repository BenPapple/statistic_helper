package statistichelper2024;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.ArrayList;

/**
 * Calculate Wilcoxon Signed-Rank Test for two rows
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
		ArrayList<Integer> testDataSampleA = new ArrayList<Integer>();
		Collections.addAll(testDataSampleA, 320, 450, 250, 700, 540, 260, 360, 530, 560, 
				                 510, 490, 370, 600, 660, 810, 730, 480, 240, 
				                 410, 640, 460, 670, 320, 200, 750, 640, 410, 
				                 1000, 940, 690, 330, 290, 330, 670, 650, 80, 
				                 680, 720, 540, 720, 370, 990, 570, 470, 490, 
				                 740, 520, 420, 360, 330);
		ArrayList<Integer> testDataSampleB = new ArrayList<Integer>();
		Collections.addAll(testDataSampleB, 440, 360, 600, 640, 480, 240, 360, 360, 520, 
				                 490, 480, 560, 360, 360, 640, 560, 560, 240, 
				                 480, 680, 480, 440, 400, 280, 370, 400, 520, 
				                 520, 480, 680, 620, 520, 480, 560, 640, 240, 
				                 440, 570, 360, 560, 400, 520, 480, 400, 400, 
				                 440, 640, 520, 440, 370);
		
		// Print sample lists A and B and count items
		String listAString = testDataSampleA.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
		String listBString = testDataSampleB.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
		System.out.println("Sample A Values: " + listAString);
		System.out.println("Number of values sample A: " + testDataSampleA.size());
		System.out.println("Sample B Values: " + listBString);
		System.out.println("Number of values sample B: " + testDataSampleB.size());

	}

}
