package tech.gregori.rotationcounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/*
Crie um aplicativo com um leiaute que contenha um TextView que seja um contador, um Button,
para incrementar o contador e um EditText. Use o screenshot anexo como um exemplo.
Não é necessário replicar exatamente o leiaute.

1. Adicione um "onClick" handler para o Button, que incremente o contador
2. Execute o aplicativo e incremente o contador. Digite algum texto no EditText
3. Rotacione o dispositivo. Note que o contador é resetado, mas o EditText não.
4. Implemente o método onSaveInstanceState() para armazenar o estado atual do aplicativo
6. Atualize o onCreate() para restaurar o estado do aplicativo.
7. Certifique-se de que quando o dispositivo é rotacionado, o estado do aplicativo é preservado.
 */

public class MainActivity extends AppCompatActivity {
    private int counter;
    private TextView displayCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = 0;
        displayCounter = findViewById(R.id.counter);

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter");
            displayCounter.setText(Integer.toString(counter));
        }
    }

    public void increment(View view) {
        counter++;
        displayCounter.setText(Integer.toString(counter));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
    }
}