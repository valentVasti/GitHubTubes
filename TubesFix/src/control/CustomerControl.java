
package Control;

import java.util.List;
import dao.customerDAO;
import java.util.List;
import model.Customer;
import java.sql.ResultSet;
import table.TableCustomer;

public class CustomerControl {
    private customerDAO CDao = new customerDAO();
    public void insertDataCustomer(Customer c){
        CDao.insertCustomer(c);
    }
    
    public List<Customer> showDataCustomer(String jenis){
        List<Customer> dataCustomer = CDao.showCustomer();
        return dataCustomer;
    }
    
    public TableCustomer showCustomer(String query) {
        
        List<Customer> dataCustomer = CDao.showCustomerBySearch(query);
        TableCustomer tableCustomer = new TableCustomer(dataCustomer);
        
        return tableCustomer;
    }
    
    public void updateCustomer(Customer c){
        CDao.updateCustomer(c);
    }
    public void deleteCustomer(String id){
        CDao.deleteCustomer(id);
    }
}
