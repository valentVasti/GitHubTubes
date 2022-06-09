/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.util.List;
import dao.guideDAO;
import java.util.List;
import model.Guide;
import java.sql.ResultSet;
import table.TableGuide;

public class guideControl {
    private guideDAO GDao = new guideDAO();
    
    public void insertDataGuide(Guide g){
        GDao.insertGuide(g);
    }
    
    public List<Guide> showDataGuide(){
        List<Guide> dataGuide = GDao.showGuide();
        return dataGuide;
    }
    
    public TableGuide showGuide(String query) {
        
        List<Guide> dataGuide = GDao.showGuideBySearch(query);
        TableGuide tableGuide = new TableGuide(dataGuide);
        
        return tableGuide;
    }
    
    public void updateGuide(Guide gb){
        GDao.updateGuide(gb);
    }
    public void deleteGuide(String id){
        GDao.deleteGuide(id);
    }
}
