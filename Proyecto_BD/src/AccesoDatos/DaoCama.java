/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Logica.Camas;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin
 */
public class DaoCama {
    
    FachadaBD fachada;

    public DaoCama() {
        fachada = new FachadaBD();
    }
    
    public int Insert_camas(Camas camas){
        
        String sql_guardar;
        int numFilas=0;

        sql_guardar="INSERT INTO usuario "
                + "VALUES ('"
                + camas.getNumeroCama()+"', '"
                + camas.getEstado()+"', '"
                + camas.getDescripcion()+"', '"
                + camas.getCodigoArea()+"' "
                + ")";
        try{
            Connection con= fachada.getConnetion();
            Statement sentencia = con.createStatement();
            
            numFilas = sentencia.executeUpdate(sql_guardar);            
            System.out.println("up " + numFilas);
            return numFilas;
            
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        return -1;
    }
    
     public int Update_camas(Camas camas){
        String sql_select;
        int numFilas=0;
        sql_select="UPDATE camas SET "
                + "numero_cama = '"+camas.getNumeroCama()+"', "
                + "estado = '"+camas.getEstado()+"', "
                + "descripcion = '"+camas.getDescripcion()+"', "
                + "codigo_area = '"+camas.getCodigoArea()+"' ";
        
         try{
          
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            numFilas = sentencia.executeUpdate(sql_select);
            
            return numFilas;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
         return -1;
         
    }
   
}
