package controller;

import javax.swing.JFrame;

import model.Sudoku;
import view.MasterView;

public class MasterController {
	public MasterController()
	{
		mainView = new MasterView();
		sudoku = new SudokuController(new Sudoku(), this);
		mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainView.setSize(600, 600);
		mainView.setResizable(false);
		mainView.setVisible(true);
		currentView = 1;
	}
	
	public void back()
	{
		
	}
	
	public void updateMainView()
	{
		
	}
	
	public void setCurrentView(Sudoku sudo)
	{
		
	}
	
	public void setNewCurrentView(Sudoku sudo)
	{
		
	}
	
	private MasterView mainView;
	private SudokuController sudoku;
	private int currentView;
}
