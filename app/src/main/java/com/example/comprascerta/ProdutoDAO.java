package com.example.comprascerta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public ProdutoDAO(Context context){
            conexao = new Conexao(context);
            banco = conexao.getWritableDatabase();
    }

    public long inserir(Produto produto){
        ContentValues values = new ContentValues();

        values.put("nomeproduto",produto.getNomeProduto());
        values.put("qtdproduto",produto.getQtdProduto());
        values.put("precoproduto",produto.getPrecoProduto());

        return banco.insert("produto",null,values);
    }
    public List<Produto> obterTodosProdutos(){
        List<Produto> produtos = new ArrayList<>();
        Cursor cursor = banco.query("produto",new String[]{"id","nomeproduto","qtdproduto","precoproduto"},null,null,null,null,null);

        while (cursor.moveToNext()){
            Produto p = new Produto();
            p.setId(cursor.getInt(0));
            p.setNomeProduto(cursor.getString(1));
            p.setPrecoProduto(cursor.getFloat(2));
            p.setQtdProduto(cursor.getInt(3));
            produtos.add(p);
        }
        return produtos;

    }
}
