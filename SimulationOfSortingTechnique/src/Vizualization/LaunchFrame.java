/* 
 * Sorting algorithms demo (Java)
 * 
 * Copyright (c) Project Nayuki
 * https://www.nayuki.io/page/sorting-algorithms-demo-java
 * 
 * (MIT License)
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 * - The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 * - The Software is provided "as is", without warranty of any kind, express or
 *   implied, including but not limited to the warranties of merchantability,
 *   fitness for a particular purpose and noninfringement. In no event shall the
 *   authors or copyright holders be liable for any claim, damages or other
 *   liability, whether in an action of contract, tort or otherwise, arising from,
 *   out of or in connection with the Software or the use or other dealings in the
 *   Software.
 */

package Vizualization;

import SortingAlgorithms.BubbleSort;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


/**
 * The window (frame) for choosing which sorting algorithm, array size, etc. to launch.
 */
@SuppressWarnings("serial")
public final class LaunchFrame extends Frame {
	
	public void launchSortFrame(int size) {
		// Parse and check input numbers from text fields
		int scale = 30;
		double speed = 30;
		
		// Initialize objects and worker thread
		final VisualSortArray array = new VisualSortArray(size, scale, speed);
                
		final SortAlgorithm algorithm = new BubbleSort();
		final int startDelay = 1000;  // In milliseconds
		new Thread() {
			public Thread thread = this;
			
			public void run() {
				initFrame();
				//doSort();
			}
			
			private void initFrame() {
				// Do component layout
				final Frame sortFrame = new Frame("Algorithm name goes here");
				sortFrame.add(array.canvas);
				sortFrame.setResizable(false);
				sortFrame.pack();
				
				// Set window closing action
				sortFrame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						thread.interrupt();
						sortFrame.dispose();
					}
				});
				
				// Set window position and show
				Rectangle rect = getGraphicsConfiguration().getBounds();
				sortFrame.setLocation(
					(rect.width - sortFrame.getWidth()) / 8,
					(rect.height - sortFrame.getHeight()) / 8);
				sortFrame.setVisible(true);
			}
			
			private void doSort() {
				// Wait and sort
				try {
					Thread.sleep(startDelay);
					algorithm.sort(array);
				} catch (StopException|InterruptedException e) {
					return;
				}
				
				// Check and print
				String msg;
				try {
					array.assertSorted();
					msg = String.format("%s: %d comparisons, %d swaps",
						algorithm.getName(), array.getComparisonCount(), array.getSwapCount());
				} catch (AssertionError e) {
					msg = algorithm.getName() + ": Sorting failed";
				}
				synchronized (System.err) {
					System.err.println(msg);
				}
			}
		}.start();
	}
	
}
