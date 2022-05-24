/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionDAO;
import DTO.Datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public class Conexion {
    
    Connection conexion;
     List<Datos> listaDatos = new ArrayList<Datos>();
     
     private void Abrir(){
       String user="root";
        String password="root";
        String url="jdbc:mysql://localhost:3306/G4S21ARZ?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex){
    ex.printStackTrace();
        }
    }
     public void cerrar(){
         try{
             conexion.close();
         }catch(SQLException ex){
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
         }
     }
     public boolean insertar(Datos datos) {
       boolean estado = true;
       
       try{
           Abrir();
           PreparedStatement ps = conexion.prepareStatement("insert into Datos (nombre,telefono,cell,direccion) value (?,?,?,?)");
           ps.setString(1,datos.getNombre());
           ps.setInt(2,datos.getTelefono());
           ps.setInt(3,datos.getCell());
            ps.setString(4,datos.getDireccion());
           ps.execute();
           
       }catch(SQLException ex){
           ex.printStackTrace();
           estado =false;
       }finally{
           cerrar();
       }
       return estado;
   }
     public boolean cargar(){
       boolean estado = true;
       Datos datos;
       try{
           Abrir();
           PreparedStatement ps = conexion.prepareStatement("select * from Datos");
           ResultSet rs = ps.executeQuery();
    
                 while(rs.next()){
               datos = new Datos (rs.getString("nombre"),rs.getInt("telefono"),rs.getInt("cell"),rs.getString("direccion"));
               listaDatos.add(datos);               
           }
       }catch(SQLException ex){
           estado = false;
       }finally{
           cerrar();
       }
       return estado;
   }
      public List<Datos> getListaDatos(){
        return listaDatos;
      }
      public boolean  actualizar(Datos datos){
       boolean estado = true;
       try{
           Abrir();
           PreparedStatement ps = conexion.prepareCall("update Datos set nombre = ?, telefono = ?, cell = ?, direccion = ?");
         ps.setString(1, datos.getNombre());
         ps.setInt(2, datos.getTelefono());
         ps.setInt(3, datos.getCell());
         ps.setString(4,datos.getDireccion());
         ps.executeUpdate();
         
       }catch(SQLException ex){
          estado = false;
       }finally{
           cerrar();
       }
       return estado;
   }
    public boolean eliminar(Datos datos){
        boolean estado = true;
    try{
    
    PreparedStatement ps = conexion.prepareStatement("delete from Datos ");
    ps. execute();
}catch(SQLException ex){
    estado = false;
}finally{
    cerrar();
}
return estado;
}
    
}
