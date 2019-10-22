package com.example.comprascerta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CadastroActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViwHolder = new ViewHolder();
    private  ProdutoDAO dao;
    private List<Produto> produtos;
    private  List<Produto> produtosFiltrados = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        dao = new ProdutoDAO(this);



        this.mViwHolder.editTextNomeProduto = findViewById(R.id.editTextNomeProduto);
        this.mViwHolder.editTextqtd = findViewById(R.id.editTextqtd);
        this.mViwHolder.editTextpreco = findViewById(R.id.editTextpreco);
        this.mViwHolder.listViewProdutos = findViewById(R.id.listViewProdutos);

        this.mViwHolder.buttonCadastratProduto = findViewById(R.id.buttonCadastratProduto);


        this.mViwHolder.buttonCadastratProduto.setOnClickListener(this);




        produtos = dao.obterTodosProdutos();
        produtosFiltrados.addAll(produtos);

        ArrayAdapter<Produto> adapter = new ArrayAdapter<Produto>(this,android.R.layout.simple_dropdown_item_1line,produtos);
        this.mViwHolder.listViewProdutos.setAdapter(adapter);



    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonCadastratProduto){
            String nomeproduto = this.mViwHolder.editTextNomeProduto.getText().toString().trim();
            int qtd = Integer.parseInt(this.mViwHolder.editTextqtd.getText().toString());
            float preco = Float.parseFloat(this.mViwHolder.editTextpreco.getText().toString());


            if((nomeproduto.length()>2)){
                Salvar(nomeproduto,qtd,preco);
            }else{
                Toast.makeText(getApplicationContext(), "Campo nome produto está vazio!", Toast.LENGTH_SHORT).show();
            }

        }
    }


    private static class ViewHolder{
        EditText editTextNomeProduto;
        EditText editTextqtd;
        EditText editTextpreco;
        Button buttonCadastratProduto;
        ListView listViewProdutos;

    }
    public void Salvar(String NomProduto, int qtd, float preco){
        Produto p = new Produto();
        p.setNomeProduto(NomProduto);
        p.setPrecoProduto(preco);
        p.setQtdProduto(qtd);
        long id = dao.inserir(p);
        //Toast.makeText(this, "Inserido: " + id, Toast.LENGTH_SHORT).show();
    }


}
