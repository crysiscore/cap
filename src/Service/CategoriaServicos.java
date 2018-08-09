package Service;

import BussinessLogic.Categoria;
import DataAcessLayer.CategoriaDAO;
import java.sql.SQLException;

public class CategoriaServicos
{
  private CategoriaDAO categoriaDAO;
  
  public CategoriaServicos()
  {
    this.categoriaDAO = new CategoriaDAO();
  }
  
  public void cadastrarcategoria(Categoria r)
    throws SQLException
  {
    this.categoriaDAO.cadastrarcategoria(r.getNome());
  }
  
  public void atualizacategoria(Categoria u)
    throws SQLException
  {
    this.categoriaDAO.atualizacategoria(u.getIdCategoria().intValue(), u.getNome());
  }
}
