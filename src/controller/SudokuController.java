package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import backend.Answer;
import model.Sudoku;
import view.SudokuView;

public class SudokuController implements ActionListener{
	public SudokuController(Sudoku model, MasterController master)
	{
		this.model = model;
		this.master = master;
		this.setView(new SudokuView(this));
	}
	
	@Override
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
	
	public SudokuView getView() {
		return view;
	}

	public void setView(SudokuView view) {
		this.view = view;
	}

	private Sudoku model;
	private MasterController master;
	private SudokuView view;
}
