package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class that is going to show JPanel
 * @author Programmerryoki
 *
 */
public class MasterView extends JFrame{
	/**
	 * Creates a view using given view
	 * @param view The view to show
	 */
	public MasterView(JPanel view)
	{
		super();
		currentView = view;
		add(currentView);
	}
	
	/**
	 * Sets the current view to the given view
	 * @param view The view to set
	 */
	public void setCurrentView(JPanel view)
	{
		remove(currentView);
		currentView = view;
		add(currentView);
	}
	
	/**
	 * Gets the current view
	 * @return The current view
	 */
	public JPanel getCurrentView()
	{
		return currentView;
	}
	
	private JPanel currentView;
}
