package controller;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

import backend.SudokuGenerator;
import backend.SudokuIO;
import model.Sudoku;
import view.MasterView;

/**
 * Master controller that controls almost everything
 * @author Programmerryoki
 *
 */
public class MasterController {
	/**
	 * Ctor that creates master controller and sets the view to sudoku
	 */
	public MasterController()
	{
		Sudoku example = new Sudoku();
		example = SudokuGenerator.generateSudoku();
//		example.setOriginal(SudokuIO.getRandomGrid());
//		example.setOriginal(SudokuIO.readFile("question 1"));
		sudoku = new SudokuController(example, this);
//		sudoku = new SudokuController(new Sudoku(), this);
		mainView = new MasterView(sudoku.getView());
		mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainView.setSize(SIZE, SIZE);
		mainView.setResizable(false);
		mainView.setVisible(true);
		stack = new Stack<>();
		stack.push(sudoku.getView());
	}
	
	/**
	 * Change the view back
	 */
	public void back()
	{
		stack.pop();
		JPanel view = stack.peek();
		mainView.setCurrentView(view);
		updateMainView();
	}
	
	/**
	 * Updates the view by re changing size
	 */
	public void updateMainView()
	{
		mainView.setSize(SIZE-1, SIZE-1);
		mainView.setSize(SIZE, SIZE);
	}
	
	/**
	 * Sets the current view to given sudoku
	 * @param sudo The sudoku to be shown
	 */
	public void setCurrentView(Sudoku sudo)
	{
		sudoku = new SudokuController(sudo, this);
		mainView.setCurrentView(sudoku.getView());
		updateMainView();
		stack.push(sudoku.getView());
	}
	
	private MasterView mainView;
	private SudokuController sudoku;
	private Stack<JPanel> stack;
	private int SIZE = 500;
}
