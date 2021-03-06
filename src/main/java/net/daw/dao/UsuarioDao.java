package net.daw.dao;

import net.daw.bean.UsuarioBean;
import net.daw.data.Mysql;
import net.daw.helper.Enum;

public class UsuarioDao {

    private final Mysql oMysql;
    private final Enum.Connection enumTipoConexion;

    public UsuarioDao(Enum.Connection tipoConexion) throws Exception {
        oMysql = new Mysql();
        enumTipoConexion = tipoConexion;
    }

    public UsuarioBean getFromLogin(UsuarioBean oUsuario) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            String strId = oMysql.getId("usuario", "login", oUsuario.getLogin());
            if (strId == null) {
                oUsuario.setId(0);
            } else {
                oUsuario.setId(Integer.parseInt(strId));
                oUsuario.setPassword(oMysql.getOne("usuario", "password", oUsuario.getId()));
                oUsuario.setNombre(oMysql.getOne("usuario", "nombre", oUsuario.getId()));
                oUsuario.setEmail(oMysql.getOne("usuario", "email", oUsuario.getId()));
            }
            oMysql.desconexion();
            return oUsuario;
        } catch (Exception e) {
            throw new Exception("ClienteDao.getPage: Error: " + e.getMessage());
        }
    }
    
    public void set(UsuarioBean oUsuarioBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.initTrans();
            if (oUsuarioBean.getId() == 0) {
                oUsuarioBean.setId(oMysql.insertOne("producto"));
            }
            oMysql.updateOne(oUsuarioBean.getId(), "usuario", "nombre", oUsuarioBean.getNombre());
            oMysql.updateOne(oUsuarioBean.getId(), "usuario", "password", oUsuarioBean.getPassword());
            oMysql.updateOne(oUsuarioBean.getId(), "usuario", "email", oUsuarioBean.getEmail());
            oMysql.commitTrans();
        } catch (Exception e) {
            oMysql.rollbackTrans();
            throw new Exception("ProductoDao.set: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }
}
