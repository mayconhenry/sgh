package Logicas;

import Dados.vProdutos;
import Dados.vsuites;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MayconHenry
 */
public class freservas {
    
    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Tipo", "Numero", "Andar", "Descrição", "Preço", "Status"};
        String[] registro = new String[7];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select *from suite where piso like '%" + buscar + "%' order by idsuites";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idsuites");
                registro[1] = rs.getString("tipoSuites");
                registro[2] = rs.getString("numero");
                registro[3] = rs.getString("piso");
                registro[4] = rs.getString("descricao");
                registro[5] = rs.getString("precoDiario");
                registro[6] = rs.getString("status");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    
    
}
