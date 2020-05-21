package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import backend.Answer;
import model.Sudoku;
import view.SudokuView;

/**
 * Controller for the Sudoku view
 * @author Programmerryoki
 *
 */
public class SudokuController implements ActionListener{
	/**
	 * Creates a new controller
	 * @param model The sudoku to be shown
	 * @param master The master controller
	 */
	public SudokuController(Sudoku model, MasterController master)
	{
		this.model = model;
		this.master = master;
		this.setView(new SudokuView(this));
		view.fixGridNumbers(model.getOriginal());
	}
	
	@Override
	/**
	 * If the action starts with grid, changes the grid at that position to 
	 * selected number
	 * 
	 * If the action is Check, it will check if the grid is solved or not
	 */
	public void actionPerformed(ActionEvent e)
	{
		String action = e.getActionCommand();
		if (action.substring(0, 4).equals("Grid"))
		{
			int i = action.charAt(4) - '0';
			int j = action.charAt(5) - '0';
			if (view.getSelectedNumber() != 0)
				view.setGridAt(i, j, "" + view.getSelectedNumber());
			else
				view.setGridAt(i, j, "");
		}
		else if (action.equals("Check"))
		{
			int[][] check = view.getGridNumbers();
			if (Answer.solved(check))
				JOptionPane.showMessageDialog(view, "It is Correct!");
			else
				JOptionPane.showMessageDialog(null, "It is Wrong");
		}
	}
	
	/**
	 * Gets the view
	 * @return The view
	 */
	public SudokuView getView() {
		return view;
	}

	/**
	 * Sets the view
	 * @param view The view to set
	 */
	public void setView(SudokuView view) {
		this.view = view;
	}

	private Sudoku model;
	private MasterController master;
	private SudokuView view;
}
