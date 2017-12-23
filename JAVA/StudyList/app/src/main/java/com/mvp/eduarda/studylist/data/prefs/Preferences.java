package com.mvp.eduarda.studylist.data.prefs;

import android.content.Context;
import com.mvp.eduarda.studylist.data.db.ListaDaoImpl;
import com.mvp.eduarda.studylist.data.domain.Lista;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eduarda on 22/12/2017.
 */

public class Preferences {
    private ListaDaoImpl listaDao;
    private List<Lista> listaTodos = new ArrayList<Lista>();
    private ArrayList<Lista> listaItem = new ArrayList<Lista>();

    public Preferences(Context context) {
        listaDao = new ListaDaoImpl(context);

    }

    public void Cadastrar( String descricao){
        listaDao.salvarItemLista(descricao);
    }

    public void Excluir(int id){
        listaDao.deletarItemLista(id);
    }

    public void Editar(int id , String descricao){
        listaDao.editarItemLista(id,descricao);
    }

    public List<Lista> ListarTodos(){
        listaTodos = listaDao.listarItens();

        return listaTodos;
    }

    public ArrayList<Lista> BuscarItem(int id){
        listaItem = listaDao.buscarItemLista(id);
        return listaItem;
    }

}
