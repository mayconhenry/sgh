package Logicas;

import Dados.vProdutos;
import Dados.vsuites;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fsuites {

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

    public boolean inserir(vsuites dts) {
        sSQL = "insert into suite (tipoSuites,numero,piso,descricao,precoDiario,status)"
                + "values (?,?,?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getTipoSuites());
            pst.setString(2, dts.getNumero());
            pst.setString(3, dts.getPiso());
            pst.setString(4, dts.getDescricao());
            pst.setDouble(5, dts.getPrecoDiario());
            pst.setString(6, dts.getStatus());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(vsuites dts) {
        sSQL = "update suite set tipoSuites=?,numero=?,piso=?,descricao=?,precoDiario=?,status=?"
                + " where idsuites=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getTipoSuites());
            pst.setString(2, dts.getNumero());
            pst.setString(3, dts.getPiso());
            pst.setString(4, dts.getDescricao());
            pst.setDouble(5, dts.getPrecoDiario());
            pst.setString(6, dts.getStatus());
            pst.setInt(7, dts.getIdsuites());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean excluir(vsuites dts) {
        sSQL = "delete from suite where idsuites=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdsuites());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

}
