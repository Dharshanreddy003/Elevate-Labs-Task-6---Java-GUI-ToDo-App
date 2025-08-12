import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoApp extends JFrame 
{
	private DefaultListModel<String> taskListModel;
    	private JList<String> taskList;
    	private JTextField taskField;
    	private JButton addButton, deleteButton;

    	public ToDoApp() 
	{
        	setTitle("To-Do List App");
        	setSize(400, 500);
        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	setLayout(new BorderLayout());

	        JLabel titleLabel = new JLabel("My To-Do List", JLabel.CENTER);
        	titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        	add(titleLabel, BorderLayout.NORTH);

	        taskListModel = new DefaultListModel<>();
        	taskList = new JList<>(taskListModel);
        	taskList.setFont(new Font("Arial", Font.PLAIN, 16));
        	add(new JScrollPane(taskList), BorderLayout.CENTER);

	        JPanel inputPanel = new JPanel(new BorderLayout());
        	taskField = new JTextField();
        	addButton = new JButton("Add Task");
        	deleteButton = new JButton("Delete Task");

        	inputPanel.add(taskField, BorderLayout.CENTER);
        	inputPanel.add(addButton, BorderLayout.EAST);
        	inputPanel.add(deleteButton, BorderLayout.SOUTH);

        	add(inputPanel, BorderLayout.SOUTH);

	        addButton.addActionListener(e -> 
		{
            		String task = taskField.getText().trim();
            		if(!task.isEmpty()) 
			{
                		taskListModel.addElement(task);
                		taskField.setText("");
            		} 
			else 
			{
                		JOptionPane.showMessageDialog(this, "Enter a task!", "Warning", JOptionPane.WARNING_MESSAGE);
            		}
        	});

        	deleteButton.addActionListener(e -> 
		{
            		int selectedIndex = taskList.getSelectedIndex();
            		if(selectedIndex != -1) 
			{
                		taskListModel.remove(selectedIndex);
            		} 
			else 
			{
                		JOptionPane.showMessageDialog(this, "Select a task to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
            		}
        	});

        	taskField.addActionListener(e -> addButton.doClick());

        	setVisible(true);
    	}

    	public static void main(String[] args) 
	{
        	SwingUtilities.invokeLater(ToDoApp::new);
    	}
}
