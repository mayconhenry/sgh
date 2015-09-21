/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logicas;

import Dados.vCliente;
import Dados.vProdutos;
import Dados.Vfuncionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CARLOS
 */
public class Ffuncionario {

    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nome", "CPF", "RG", "Endereço", "Bairro", "Cidade", "UF", "CEP", "Email","Telefone","Salário","Acesso","Login","Senha","Status"};

        String[] registro = new String[16];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.idpessoa,p.nome,p.cpf,p.rg,p.endereco,p.bairro,"
                + "p.cidade,p.uf,p.cep,p.email,p.telefone,t.salario,t.acesso,t.login,t.password,t.status from pessoa p inner join funcionario t "
                + "on p.idpessoa=t.idpessoa where nome like '%"
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
                registro[11] = rs.getString("salario");
                registro[12] = rs.getString("acesso");
                registro[13] = rs.getString("login");
                registro[14] = rs.getString("password");
                registro[15] = rs.getString("status");
                
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(Vfuncionario dts) {
        sSQL = "insert into pessoa (nome,cpf,rg,endereco,bairro,cidade,uf,cep,email,telefone)"
                + "values (?,?,?,?,?,?,?,?,?,?)";
        sSQL2 = "insert into funcionario (idpessoa,salario,acesso,login,password,status)"
                + "values ((select idpessoa from pessoa order by idpessoa desc limit 1),?,?,?,?,?)";
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

            pst2.setDouble(1, dts.getSalario());
            pst2.setString(2, dts.getAcesso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            pst2.setString(5, dts.getStatus());
            
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

    public boolean editar(Vfuncionario dts) {
        sSQL = "update pessoa set nome=?,cpf=?,rg=?,endereco=?,bairro=?,"
                + " cidade=?,uf=?,cep=?,email=?,telefone=? where idpessoa=?";
        
        sSQL2 = "update funcionario set salario=?,acesso=?,login=?,password=?,status=?"
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

            pst2.setDouble(1, dts.getSalario());
            pst2.setString(2, dts.getAcesso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            pst2.setString(5, dts.getStatus());
            pst2.setInt(6, dts.getIdpessoa());

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

    public boolean eliminar(Vfuncionario dts) {
        sSQL = "delete from trabajador where idpersona=?";
        sSQL2 = "delete from persona where idpersona=?";

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
    
    
    public DefaultTableModel login(String login,String password) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nome", "CPF", "RG","Acesso","Login","Senha","Status"};

        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.idpessoa,p.nome,cpf,p.rg,"
                + "t.acesso,t.login,t.password,t.status from pessoa p inner join funcionario t "
                + "on p.idpessoa=t.idpessoa where t.login='"
                + login + "' and t.password='" + password + "' and t.status='Ativo'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpessoa");
                registro[1] = rs.getString("nome");
                registro[2] = rs.getString("cpf");
                registro[3] = rs.getString("rg");
                
                registro[4] = rs.getString("acesso");
                registro[5] = rs.getString("login");
                registro[6] = rs.getString("password");
                registro[7] = rs.getString("status");
                
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
