/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horisoes;


import java.sql.*;


public class HORISOES {

    public static void main(String[] args) {
      String url ="jdbc:postgresql://localhost:5432/tienda";
      String usuario="postgres";
      String contrasenia="123";
        
        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url, usuario, contrasenia);
            java.sql.Statement st=conexion.createStatement();
            String sql
                    = "select idcliente, nombrecliente, apellidoscliente, telefonocliente from clientes";
                    //= "insert into clientes(idcliente,nombrecliente, apellidoscliente,telefonocliente) values ('100','jose','luna','44')";
                    //= "delete from clientes where idcliente = 100"; 
                                      
                    //= "update clientes set idcliente='55', nombrecliente='AA', apellidoscliente='BB', telefonocliente='42' where idcliente='55'";
               
                    ResultSet result = st.executeQuery(sql);
        
        while (result.next()){
            String id= result.getString("idcliente");
            String nombre = result.getString("nombrecliente");
            String apellido = result.getString("apellidoscliente");
            String telefono = result.getString("telefonocliente");
            System.out.println("IDCLIENTE " + id + " NOMBRES CLIENTE " + nombre + " APELLIDO " + apellido + " TELEFONO " + telefono);
        }
            result.close();
            st.close();
            conexion.close();
        }
        
        catch (Exception e){
                System.out.println("ERROR EN LA CONEXION " + e.getMessage());
        }
    }
    
}
