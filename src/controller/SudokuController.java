package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Sudoku;

public class SudokuController implements ActionListener{
	public SudokuController(Sudoku model, MasterController master)
	{
		this.model = model;
		this.master = master;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}
	
	private Sudoku model;
	private MasterController master;
}
