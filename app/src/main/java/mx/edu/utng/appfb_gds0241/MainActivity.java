package mx.edu.utng.appfb_gds0241;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    //Clase para manejar la lógica o control de la vista
    EditText etTema;
    Spinner spiArea;
    Spinner spiSec;
    Button btnRegistrar;

    private DatabaseReference bdDiario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asociar los objetos de control con la vista del xml
        etTema = (EditText)findViewById(R.id.etTema);
        spiArea = (Spinner)findViewById(R.id.spiArea);
        spiSec = (Spinner)findViewById(R.id.spiSeccion);
        btnRegistrar = (Button)findViewById(R.id.btnRegistrar);

        //Se define el objet (Clase) haciendo referencia a la conexión de Firebase
        bdDiario = FirebaseDatabase.getInstance().getReference("Clase");
        //Manejo del evento onClick
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarCLase();//Invocar el método registrarClase (método auxiliar)
            }
        });
    }//fin del onCreate

    public void registrarCLase(){
        //Obtener los valores que tienen los componentes de la vista
        String seccion = spiSec.getSelectedItem().toString();
        String area = spiArea.getSelectedItem().toString();
        String tema = etTema.getText().toString();

        if (!TextUtils.isEmpty(tema)){//Si el tema está correctamente ingresado
            String id = bdDiario.push().getKey();//Se genera un elemento para BD con una nueva clave
            Clase leccion = new Clase(id, seccion, area, tema);//Instancia de la clase POJO (modelo)
            bdDiario.child("Leccion").child(id).setValue(leccion);//Crea un hijo (child) Llamado "Leccion"
            //Manejo de éxito
            Toast.makeText(this, "Clase registrada", Toast.LENGTH_LONG).show();
        }else{
            //Manejo de error
            Toast.makeText(this, "Debe introducir un tema", Toast.LENGTH_LONG).show();
        }
    }
}