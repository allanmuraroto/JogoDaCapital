package com.example.jogodacapital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity<array> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int x = new Random().nextInt(10);
    int ponto = 0;
    int tentativas = 0;
    int sorteio = 0;
    String[] estados = {"Parana", "Sao Paulo", "Amazonas", "Rio de Janeiro","Bahia","Ceara","Minas Gerais","Acre","Alagoas","Macapa","Rio Grande do Norte","Rio Grande do Sul","Piaui","Goias","Paraiba"};
    String[] capitais = {"Curitiba", "Sao Paulo", "Manaus", "Rio de Janeiro","Salvador","Fortaleza", "Belo Horizonte","Rio Branco","Maceio","Amapa","Natal","Porto Alegre","Teresina","Goiania","Joao Pessoa"};




    //TextView out = findViewById(R.id.textViewOutput); //sorteio
    //TextView score = findViewById(R.id.textViewOutput2); // pontos
    //TextView saida = findViewById(R.id.textViewSaida); //resposta
    //TextView entrada = findViewById(R.id.textEntrada); // entrada


    public void proxima(View view)
    {
        TextView out = findViewById(R.id.textViewOutput); //sorteio
        TextView entrada = findViewById(R.id.textEntrada); // entrada
        TextView saida = findViewById(R.id.textViewSaida);
        sorteio = 0;


        x = x+1;
        tentativas++;
        if(tentativas == 6)
        {
            Button btn = (Button) findViewById(R.id.buttonProxima);
            btn.setEnabled(false);

            Button btn2 = (Button) findViewById(R.id.buttonVerificar);
            btn2.setEnabled(false);
            saida.setText("Fim de Jogo");


        }
        else
        {
            entrada.setText("");
            saida.setText("");
            out.setText(estados[x]);
        }

    }



    public void verifica(View view)
    {
        TextView out = findViewById(R.id.textViewOutput); //sorteio

        TextView saida = findViewById(R.id.textViewSaida); //resposta
        EditText entrada = findViewById(R.id.textEntrada); // entrada
        String resposta = entrada.getText().toString();
        TextView score = findViewById(R.id.textViewOutput2); // pontos


        if(entrada.length() == 0)
        {
            Toast.makeText(this,"Entre com a capital", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(resposta.equals(capitais[x]))
            {
                if(sorteio == 0)
                {
                    saida.setText("acertou!");
                    ponto+=10;
                    score.setText(String.valueOf(ponto));
                    sorteio = 1;
                }
                else
                {
                    if(sorteio == 1)
                    {
                        saida.setText("clique em próxima");
                    }
                }

            }
            else
            {
                if(sorteio == 1)
                {
                    saida.setText("clique em próxima");
                }
                else
                {
                    saida.setText("errou");
                    sorteio = 1;
                }

            }
        }

    }

}