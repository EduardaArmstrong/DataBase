package com.mvp.eduarda.studylist.data.model;

import com.mvp.eduarda.studylist.data.domain.Lista;
import com.mvp.eduarda.studylist.data.prefs.Preferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eduarda on 22/12/2017.
 */

public class DBModel implements IDBModel {
    private List<Lista> listaTodos = new ArrayList<Lista>();
    private ArrayList<Lista> listaItem = new ArrayList<Lista>();
    private Preferences preferences;

    public DBModel(Preferences preferences) {
        this.preferences = preferences;
    }

    @Override
    public void Cadastrar(String descricao){
        preferences.Cadastrar( descricao);
    }

    @Override
    public void Excluir(int id){
        preferences.Excluir(id);

    }

    @Override
    public void Editar(int id , String descricao) {
        preferences.Editar(id, descricao);
    }

    @Override
    public List<Lista> ListarTodos(){
       listaTodos = preferences.ListarTodos();
        return listaTodos;
    }

    @Override
    public ArrayList<Lista> BuscarItem(int id){
        listaItem = preferences.BuscarItem(id);
        return listaItem;
    }
}
