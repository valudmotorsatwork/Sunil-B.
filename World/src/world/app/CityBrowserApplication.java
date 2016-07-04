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
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import world.dao.CityDAO;
import world.domain.City;
import world.view.CityTableModel;
public class CityBrowserApplication extends JFrame
{
	private static final long serialVersionUID = 1L;
	public static final String APP_TITLE ="City Browser";
	private CityTableModel tableModel;
	private CityDAO cityDao = new CityDAO();
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
	public CityBrowserApplication() 
	{
		super(APP_TITLE);
		List<City> cityList = cityDao.loadCities();
		System.out.println("Size "+cityList.size());
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

public static void main(String[] args) 
{
	try 
	{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (Exception e) 
	{
		e.printStackTrace();
	}
	new CityBrowserApplication();		
}

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

private JPanel searchControlPanel() 
{
	JPanel contolPanel = new JPanel();
	contolPanel.setLayout(new BoxLayout(contolPanel, BoxLayout.X_AXIS));
	searchButton = new JButton("Search");
	contolPanel.add(searchButton);
	return contolPanel;
}

//private JScrollPane scrollTable(AbstractTableModel model) 
//{
//	JTable resultTable = new JTable(model);
//	JScrollPane scrollPane = new JScrollPane(resultTable);
//	return scrollPane;
//}

private void resetFields() 
{
	cityNameInput.setText("");
	cityDisrictInput.setText("");
	cityCountryCodeInput.setText("");
	cityPopulationInput.setText("");
}

private void addListners() 
{
	searchButton.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			try 
			{
				List<City> cities =null;
				
				if(cityNameSearchInput.getText().equals(""))
				cities = cityDao.loadCities();
				else
				cities = cityDao.findByName(cityNameSearchInput.getText());
				System.out.println("Search : "+cities.size());
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
//				List<City> cities = cityDao.findByName(cityNameInput.getText());
//				tableModel.setCities(cities);
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
	
	deleteButton.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			try 
			{
				List<City> cities =null;
				City city1 =  cityDao.findByName(cityNameInput.getText()).get(0);  // only one Bangkok
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
	
	
	updateButton.addActionListener(new ActionListener() 
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
				List<City> cities =null;
				cityDao.update(city);
//				cities = cityDao.loadCities();
//				tableModel.setCities(cities);
				JOptionPane.showMessageDialog (null, "Record Updated Successful", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
			catch (Exception e) 
			{
				System.out.println(e);
				e.printStackTrace();
			}
		}
	});
	
	resultTable.getSelectionModel().addListSelectionListener(new ListSelectionListener()
	{
        public void valueChanged(ListSelectionEvent event) 
        {
        	try
        	{
        		int rowIndex = resultTable.getSelectedRow();
        		int colIndex = resultTable.getSelectedColumn();
        		CityTableModel city= new CityTableModel();
        		String str="";
        		boolean b=isEmpty(resultTable);
        		System.out.println(" "+b);
        		if(!b)
        		{
        			str= resultTable.getValueAt(resultTable.getSelectedRow(), 0).toString();
        		}
        		else
        		{
        			str= resultTable.getValueAt(resultTable.getSelectedRow(), 0).toString();
        		}
        		List<City> cities=cityDao.findByName(str);
        		System.out.println("Size "+cities.size());
        		cityNameInput.setText(""+cities.get(0).getCityName());
        		cityDisrictInput.setText(""+cities.get(0).getCityDistrict());
        		cityCountryCodeInput.setText(""+cities.get(0).getCityCountryCode());
        		cityPopulationInput.setText(""+cities.get(0).getCityPopulation());
        	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        }
    });

}
public static boolean isEmpty(JTable jTable) {
    if (jTable != null && jTable.getModel() != null) {
        return jTable.getModel().getRowCount()<=0?true:false;
    }
    return false;
}

}
