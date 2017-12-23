package com.mvp.eduarda.studylist.data.model;

import com.mvp.eduarda.studylist.data.domain.Lista;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eduarda on 22/12/2017.
 */

public interface IDBModel {

    void Cadastrar ( String descricao);
    void Editar(int id , String descricao);
    void Excluir(int id);
    List<Lista> ListarTodos();
    ArrayList<Lista> BuscarItem(int id);
}
