
package Logicas;

import Dados.vCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mac
 */
public class Fcliente {
    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nome", "CPF", "RG", "Endereço", "Bairro", "Cidade", "UF","CEP","Email", "Telefone","Código"};

        String[] registro = new String[12];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.idpessoa,p.nome,p.cpf,p.rg,p.endereco,p.bairro,"
                + "p.cidade,p.uf,p.cep,p.email,p.telefone,c.codigo_cliente from pessoa p inner join cliente c "
                + "on p.idpessoa=c.idpessoa where nome like '%"
                + buscar + "%' order by idpessoa desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpessoa");
                registro[1] = rs.getString("nome");
                registro[2] = rs.getString("cpf");
                registro[3] = rs.getString("rg");
                registro[4] = rs.getString("endereco");
                registro[5] = rs.getString("bairro");
                registro[6] = rs.getString("cidade");
                registro[7] = rs.getString("uf");
                registro[8] = rs.getString("cep");
                registro[9] = rs.getString("email");
                registro[10] = rs.getString("telefone");
                registro[11] = rs.getString("codigo_cliente");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vCliente dts) {
        sSQL = "insert into pessoa (nome,cpf,rg,endereco,bairro,cidade,uf,cep,email,telefone)"
                + "values (?,?,?,?,?,?,?,?,?,?)";
        sSQL2 = "insert into cliente (idpessoa,codigo_cliente)"
                + "values ((select idpessoa from pessoa order by idpessoa desc limit 1),?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getCpf());
            pst.setString(3, dts.getRg());
            pst.setString(4, dts.getEndereco());
            pst.setString(5, dts.getBairro());
            pst.setString(6, dts.getCidade());
            pst.setString(7, dts.getUf());
            pst.setString(8, dts.getCep());
            pst.setString(9, dts.getEmail());
            pst.setString(10, dts.getTelefone());

            pst2.setString(1, dts.getCodigo_cliente());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(vCliente dts) {
        sSQL = "update pessoa set nome=?,cpf=?,rg=?,endereco=?,bairro=?,"
                + " cidade=?,uf=?,cep=?,email=?,telefone=? where idpessoa=?";
        
        sSQL2 = "update cliente set codigo_cliente=?"
                + " where idpessoa=?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getCpf());
            pst.setString(3, dts.getRg());
            pst.setString(4, dts.getEndereco());
            pst.setString(5, dts.getBairro());
            pst.setString(6, dts.getCidade());
            pst.setString(7, dts.getUf());
            pst.setString(8, dts.getCep());
            pst.setString(9, dts.getEmail());
            pst.setString(10, dts.getTelefone());
            pst.setInt(11, dts.getIdpessoa());

            pst2.setString(1, dts.getCodigo_cliente());
            pst2.setInt(2, dts.getIdpessoa());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(vCliente dts) {
        sSQL = "delete from cliente where idpessoa=?";
        sSQL2 = "delete from pessoa where idpessoa=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            
            pst.setInt(1, dts.getIdpessoa());

            
            pst2.setInt(1, dts.getIdpessoa());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
}
