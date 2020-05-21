package controller;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Sudoku;
import view.MasterView;

public class MasterController {
	public MasterController()
	{
		sudoku = new SudokuController(new Sudoku(), this);
		mainView = new MasterView(sudoku.getView());
		mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainView.setSize(SIZE, SIZE);
		mainView.setResizable(false);
		mainView.setVisible(true);
		stack = new Stack<>();
		stack.push(sudoku.getView());
	}
	
	public void back()
	{
		stack.pop();
		JPanel view = stack.peek();
		mainView.setCurrentView(view);
		updateMainView();
	}
	
	public void updateMainView()
	{
		mainView.setSize(SIZE-1, SIZE-1);
		mainView.setSize(SIZE, SIZE);
	}
	
	public void setCurrentView(Sudoku sudo)
	{
		sudoku = new SudokuController(sudo, this);
		mainView.setCurrentView(sudoku.getView());
		updateMainView();
		stack.push(sudoku.getView());
	}
	
//	public void setNewCurrentView(Sudoku sudo)
//	{
//		sudoku = new SudokuController(sudo, this);
//		mainView.setCurrentView(sudoku.getView());
//		updateMainView();
//		stack.push(sudoku.getView());
//	}
	
	private MasterView mainView;
	private SudokuController sudoku;
	private Stack<JPanel> stack;
	private int SIZE = 500;
}
