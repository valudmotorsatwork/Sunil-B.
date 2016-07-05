package world.app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import world.dao.CityDAO;
import world.domain.City;
import world.view.CityTableModel;

public class MainGUI extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CityDAO cityDao = new CityDAO();
	public static final String APP_TITLE ="City Browser";
	private CityTableModel tableModel;
	private JTextField cityNameInput;
	private JTextField cityNameSearchInput;
	private JTextField cityDisrictInput;
	private JTextField cityCountryCodeInput;
	private JTextField cityPopulationInput;
	private JButton addButton;
	private JButton searchButton;
	private JButton deleteButton;
	private JButton updateButton;
	JTable resultTable = new JTable();
	JScrollPane scrollPane = new JScrollPane(resultTable);
	public MainGUI() 
	{
		super(APP_TITLE);
		List<City> cityList = cityDao.loadCities();
		tableModel= new CityTableModel();
		tableModel.setCities(cityList);
		setLayout(new BorderLayout(4, 4));
		add(searchFieldsPanel(), BorderLayout.NORTH);
		add(addFieldsPanel(), BorderLayout.SOUTH);
		resultTable = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(resultTable);
		add(scrollPane, BorderLayout.CENTER);
		addListners();
		pack();
		setVisible(true);
	}
//Insert Fields Panel
private JPanel addFieldsPanel() 
{
	JPanel inputFieldsPanel = new JPanel();
	inputFieldsPanel.setLayout(new FlowLayout());
	JLabel cityLabel = new JLabel("City Name :");
    inputFieldsPanel.add(cityLabel);
    cityNameInput = new JTextField(10);
    inputFieldsPanel.add(cityNameInput);
    JLabel districtLabel = new JLabel("District :");
    inputFieldsPanel.add(districtLabel);
    cityDisrictInput = new JTextField(10);
    inputFieldsPanel.add(cityDisrictInput);
    JLabel countryLabel = new JLabel("Country :");
    inputFieldsPanel.add(countryLabel);
    cityCountryCodeInput = new JTextField(10);
    inputFieldsPanel.add(cityCountryCodeInput);
    JLabel populationLabel = new JLabel("Population :");
    inputFieldsPanel.add(populationLabel);
    cityPopulationInput = new JTextField(10); 
    inputFieldsPanel.add(cityPopulationInput);
    inputFieldsPanel.add(addControlPanel());
    return inputFieldsPanel;
}
//Search Fields Panel
private JPanel searchFieldsPanel() 
{
	JPanel inputFieldsPanel = new JPanel();
	inputFieldsPanel.setLayout(new FlowLayout());
	JLabel cityLabel = new JLabel("City Name :");
    inputFieldsPanel.add(cityLabel);
    cityNameSearchInput = new JTextField(10);
    inputFieldsPanel.add(cityNameSearchInput);
    inputFieldsPanel.add(searchControlPanel());
    return inputFieldsPanel;
}
//Save,Delete and Update Control Panel
private JPanel addControlPanel() 
{
	JPanel contolPanel = new JPanel();
	contolPanel.setLayout(new BoxLayout(contolPanel, BoxLayout.X_AXIS));
	addButton = new JButton("Save");
	contolPanel.add(addButton);
	deleteButton = new JButton("Delete");
	contolPanel.add(deleteButton);
	updateButton = new JButton("Update");
	contolPanel.add(updateButton);
	return contolPanel;
}
// Search Control Panel
private JPanel searchControlPanel() 
{
	JPanel contolPanel = new JPanel();
	contolPanel.setLayout(new BoxLayout(contolPanel, BoxLayout.X_AXIS));
	searchButton = new JButton("Search");
	contolPanel.add(searchButton);
	return contolPanel;
}
// Reset the text fields
private void resetFields() 
{
	cityNameInput.setText("");
	cityDisrictInput.setText("");
	cityCountryCodeInput.setText("");
	cityPopulationInput.setText("");
}
private void addListners() 
{
	// Action Listener for Search method
	searchButton.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			try 
			{
				List<City> cities =null;
				String search=cityNameSearchInput.getText();
				if(search.equals(""))
				search=" ";	
				if(cityNameSearchInput.getText().equals(""))
				cities = cityDao.loadCities();
				else
				cities = cityDao.findByName(search);
				if(cities.size()==0)
				{
					JOptionPane.showMessageDialog (null, "No Records Found", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
				tableModel.setCities(cities);
				
			}
			catch (Exception e) 
			{
				System.out.println(e);
				e.printStackTrace();
			}
		}
	});
	// Action Listener for Save method
	addButton.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			try 
			{
				City city = new City();
				city.setCityName(cityNameInput.getText());
				city.setCityDistrict(cityDisrictInput.getText());
				city.setCityCountryCode(cityCountryCodeInput.getText());
				city.setCityPopulation(Integer.parseInt(cityPopulationInput.getText()));
				cityDao.save(city);
				resetFields();
				JOptionPane.showMessageDialog (null, "Record Saved Successful", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
			catch (Exception e) 
			{
				System.out.println(e);
				e.printStackTrace();
			}
		}
	});
	// Action Listener for Delete method
	deleteButton.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			try 
			{
				List<City> cities =null;
				City city1 =  cityDao.findByName(cityNameInput.getText()).get(0);
				int id = city1.getCityId();
				cityDao.delete(id);
				cities = cityDao.loadCities();
				tableModel.setCities(cities);
				JOptionPane.showMessageDialog (null, "Record Delete Successful", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
			catch (Exception e) 
			{
				System.out.println(e);
				e.printStackTrace();
			}
		}
	});
	// Action Listener for Update method 
	updateButton.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			try 
			{
				City city = new City();
				City city1 =  cityDao.findByName(cityNameInput.getText()).get(0);
				int id = city1.getCityId();
				city.setCityName(cityNameInput.getText());
				city.setCityDistrict(cityDisrictInput.getText());
				city.setCityCountryCode(cityCountryCodeInput.getText());
				city.setCityPopulation(Integer.parseInt(cityPopulationInput.getText()));
				city.setCityId(id);
				cityDao.update(city);
				JOptionPane.showMessageDialog (null, "Record Updated Successful", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
			catch (Exception e) 
			{
				System.out.println(e);
				e.printStackTrace();
			}
		}
	});
	// retrieve the selected record from Jtable
	resultTable.getSelectionModel().addListSelectionListener(new ListSelectionListener()
	{
        public void valueChanged(ListSelectionEvent event) 
        {
        	try
        	{
        		String str=" ";
        		boolean b=isEmpty(resultTable);
        		if(!b)
        		{
        			str=resultTable.getValueAt(resultTable.getSelectedRow(), 0).toString();
        		}
        		List<City> cities=cityDao.findByName(str);
        		if(cities.size()>0)
        		{
        			cityNameInput.setText(""+cities.get(0).getCityName());
        			cityDisrictInput.setText(""+cities.get(0).getCityDistrict());
        			cityCountryCodeInput.setText(""+cities.get(0).getCityCountryCode());
        			cityPopulationInput.setText(""+cities.get(0).getCityPopulation());
        		}
        	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        }
    });
	}
	//Checking Jtable values null or not
	public static boolean isEmpty(JTable jTable) 
	{
	    if (jTable != null && jTable.getModel() != null) 
	    {
	        return jTable.getModel().getRowCount()<=0?true:false;
	    }
	    return false;
	}

}
