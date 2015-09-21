
package Logicas;

import Dados.vProdutos;
import Dados.vsuites;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class fProduto {
    
     private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Produto", "Descrição", "Quantidade", "Preço"};
        String[] registro = new String[5];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select *from produto where nome like '%" + buscar + "%' order by idproduto";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idproduto");
                registro[1] = rs.getString("nome");
                registro[2] = rs.getString("descricao");
                registro[3] = rs.getString("quantidade");
                registro[4] = rs.getString("preco");


                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean inserir(vProdutos dts) {
        sSQL = "insert into produto (nome,descricao,quantidade,preco)"
                + "values (?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getDescricao());
            pst.setString(3, dts.getQuantidade());
            pst.setDouble(4, dts.getPreco());


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

    public boolean editar(vProdutos dts) {
        sSQL = "update produto set nome=?,descricao=?,quantidade=?,preco=?"
                + " where idproduto=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getDescricao());
            pst.setString(3, dts.getQuantidade());
            pst.setDouble(4, dts.getPreco());
            pst.setInt(5, dts.getIdproduto());

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

    public boolean excluir(vProdutos dts) {
        sSQL = "delete from produto where idproduto=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdproduto());

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
