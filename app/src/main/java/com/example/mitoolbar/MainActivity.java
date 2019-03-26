/*
1. Modificar estilo del Theme usado para que no use uno se los que añaden una actionbar
    Ver Theme  AppTheme declarado en styles.xml
2. Crear el toolbar (preferiblemente en layaut aparte y luego incluir en principal).
    Ver toolbar.xml
3. Dotar al toolbar de las capacidades de una actionbar. Esto se hace  con setSupportActionBar(toolbar)
    Para utilizar las capacidades de la actionbar utilizar getSupportActionBar() que devuelve
    objeto actionbar.
4. Agregar menú a la toolbar.
    - Crear recurso xml menu.
    - Implementar métodos callback onCreateOptionsMenu() y onOptionsItemSelected()
 */

package com.example.mitoolbar;

import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);

        // Indica que la toolbar actuará como action bar en la actividad
        setSupportActionBar(toolbar);

       // Operaciones propias del ActionBar
        ActionBar actionBar = getSupportActionBar();
        
        if(actionBar != null) {
            actionBar.setTitle("Otro Título");
            actionBar.setSubtitle("Subtitulo");
            //actionBar.setDisplayShowTitleEnabled(false); // Quita de la barra nombre de la app
            actionBar.setDisplayHomeAsUpEnabled(true);  // Miestra flecha back en la barra.
            //actionBar.hide();  // Oculata la toolbar
            //actionBar.show();  // Muestra la toolbar
        }

        // Muestra un logo en la toolbar.
          //toolbar.setLogo(R.drawable.ic_action_config);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10.0f);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla el recurso menu. Añade sus items al acction bar si está pressente.
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Maneja los clics de la actionbar.
        // La barra de acción manejará automáticamente los clics en el botón Home/Up,
        // siempre que se especifique una actividad principal en AndroidManifest.xml.
        String mensaje = null;

        switch (item.getItemId()){
            case R.id.borra:
            case R.id.buscar:
            case R.id.configuracion:
                 mensaje = "Pulsada opción... " + item.getTitle();
                Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
                break;

            case R.id.Salir:
                finish();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    // Para que al pulsar la flecha atras lance evento de tecla back
    // y salga de la activity
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
