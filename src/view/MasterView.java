package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MasterView extends JFrame{
	public MasterView(JPanel view)
	{
		super();
		currentView = view;
		add(currentView);
	}
	
	public void setCurrentView(JPanel view)
	{
		remove(currentView);
		currentView = view;
		add(currentView);
	}
	
	public JPanel getCurrentView()
	{
		return currentView;
	}
	
	private JPanel currentView;
}
