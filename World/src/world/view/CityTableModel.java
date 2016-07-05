package world.view;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import world.domain.City;
public class CityTableModel extends AbstractTableModel 
{
	private static final long serialVersionUID = 1L;
	/** the city data to show in JTable */
	private List<City> cities;
	/** the column names to show in JTable */
	private static final String [] FIELD_NAMES ={ "City Name", "District", "Country", "Population"};
	public CityTableModel() 
	{
	   cities = new ArrayList<City>(); // to avoid NullPointer
    }

   public String getColumnName(int column)
   {    
	   if (column < FIELD_NAMES.length) return FIELD_NAMES[column];
	   return ""; // unknown column
   }
   
   public int getColumnCount() {
      return FIELD_NAMES.length; 
   }

   public int getRowCount() {
      return cities.size( );
   } 

  public Object getValueAt( int row, int col ) 
  {
	   if (row>= cities.size())
		   return "";
	   City city =  cities.get(row);
	   switch( col ) 
	   {  // this is hacky. Use Reflection.
			case 0: return city.getCityName();
			case 1: return city.getCityDistrict();
			case 2: return city.getCityCountryCode();
			case 3: return city.getCityPopulation();
			default: return "";
	   }
   }

  public void setCities( List<City> cities ) 
  {
	   assert cities != null;
	   this.cities = cities;
	   fireTableDataChanged();
  }


}
