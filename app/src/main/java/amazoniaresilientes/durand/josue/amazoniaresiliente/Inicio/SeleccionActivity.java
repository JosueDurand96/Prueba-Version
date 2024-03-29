package amazoniaresilientes.durand.josue.amazoniaresiliente.Inicio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import amazoniaresilientes.durand.josue.amazoniaresiliente.Login.LoginActivity;
import androidx.appcompat.app.AppCompatActivity;
import amazoniaresilientes.durand.josue.amazoniaresiliente.R;
import androidx.appcompat.app.AppCompatDelegate;

public class SeleccionActivity extends AppCompatActivity {


    String cultivo,primerNombre,segundoNombre,apellidoPaterno,apellidoMaterno,estadoCivil,dni,referenciaPredio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        cultivo = getIntent().getStringExtra("cultivo");
        final String edadCultivo = getIntent().getStringExtra("edadCultivo");
        primerNombre = getIntent().getStringExtra("primerNombre");
        segundoNombre = getIntent().getStringExtra("segundoNombre");
        apellidoPaterno = getIntent().getStringExtra("apellidoPaterno");
        apellidoMaterno = getIntent().getStringExtra("apellidoMaterno");
        estadoCivil = getIntent().getStringExtra("estadoCivil");
        dni = getIntent().getStringExtra("dni");
        referenciaPredio = getIntent().getStringExtra("referenciaPredio");
        final String   procedenciaCombo = getIntent().getStringExtra("procedenciaCombo");
        final String   txtprocedencia = getIntent().getStringExtra("txtprocedencia");
        final String   asociacionProductiva = getIntent().getStringExtra("asociacionProductiva");
        final String   edadCliente = getIntent().getStringExtra("edadCliente");
        final String   ecotipo = getIntent().getStringExtra("ecotipo");
        setContentView(R.layout.activity_seleccion);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);



        final Button loginButton = findViewById(R.id.login);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        loginButton.setEnabled(true);
        String[] letra = {"Seleccione: ", "AMAZONAS","AYACUCHO","CAJAMARCA",
                "CUSCO","HUANCAVELICA","HUANUCO","JUNIN","PASCO","LORETO_A","LORETO_B","MADRE_DE_DIOS",
                "PIURA","PIURA_2","PUNO","SAN_MARTIN","UCAYALI"};
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, letra));
        //ENVIO DE PARAMETROS DEPENDIENDO DE LA REGION PARA LOS MAPAS
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(spinner.getSelectedItemPosition());
                if (spinner.getSelectedItemPosition() == 0) {
                    Toast.makeText(getApplicationContext(), "Seleccionar lugar", Toast.LENGTH_SHORT);
                } else {
                    if (spinner.getSelectedItemPosition() == 1) {
                        Intent intent = new Intent(SeleccionActivity.this, MapaActivity.class);
                        intent.putExtra("region","AMAZONAS");
                        intent.putExtra("cultivo",cultivo);
                        intent.putExtra("edadCultivo",edadCultivo);
                        intent.putExtra("primerNombre",primerNombre);
                        intent.putExtra("segundoNombre",segundoNombre);
                        intent.putExtra("apellidoPaterno",apellidoPaterno);
                        intent.putExtra("apellidoMaterno",apellidoMaterno);
                        intent.putExtra("edadCliente",edadCliente);
                        intent.putExtra("estadoCivil",estadoCivil);
                        intent.putExtra("dni",dni);
                        intent.putExtra("referenciaPredio",referenciaPredio);
                        intent.putExtra("procedenciaCombo",procedenciaCombo);
                        intent.putExtra("txtprocedencia",txtprocedencia);
                        intent.putExtra("asociacionProductiva",asociacionProductiva);
                        intent.putExtra("ecotipo",ecotipo);
                        intent.putExtra("regionTitulo","AMAZONAS");
                        startActivity(intent);
                    }
                    if (spinner.getSelectedItemPosition() == 2) {
                        Intent intent = new Intent(SeleccionActivity.this, MapaActivity.class);
                        intent.putExtra("region","AYACUCHO");
                        intent.putExtra("cultivo",cultivo);
                        intent.putExtra("edadCultivo",edadCultivo);
                        intent.putExtra("primerNombre",primerNombre);
                        intent.putExtra("segundoNombre",segundoNombre);
                        intent.putExtra("apellidoPaterno",apellidoPaterno);
                        intent.putExtra("apellidoMaterno",apellidoMaterno);
                        intent.putExtra("edadCliente",edadCliente);
                        intent.putExtra("estadoCivil",estadoCivil);
                        intent.putExtra("dni",dni);
                        intent.putExtra("referenciaPredio",referenciaPredio);
                        intent.putExtra("procedenciaCombo",procedenciaCombo);
                        intent.putExtra("txtprocedencia",txtprocedencia);
                        intent.putExtra("asociacionProductiva",asociacionProductiva);
                        intent.putExtra("regionTitulo","AYACUCHO");
                        intent.putExtra("ecotipo",ecotipo);
                        startActivity(intent);
                    }
                    if (spinner.getSelectedItemPosition() == 3) {
                        Intent intent = new Intent(SeleccionActivity.this, MapaActivity.class);
                        intent.putExtra("region","CAJAMARCA");
                        intent.putExtra("ecotipo",ecotipo);
                        intent.putExtra("cultivo",cultivo);
                        intent.putExtra("edadCultivo",edadCultivo);
                        intent.putExtra("primerNombre",primerNombre);
                        intent.putExtra("segundoNombre",segundoNombre);
                        intent.putExtra("apellidoPaterno",apellidoPaterno);
                        intent.putExtra("apellidoMaterno",apellidoMaterno);
                        intent.putExtra("edadCliente",edadCliente);
                        intent.putExtra("estadoCivil",estadoCivil);
                        intent.putExtra("dni",dni);
                        intent.putExtra("referenciaPredio",referenciaPredio);
                        intent.putExtra("procedenciaCombo",procedenciaCombo);
                        intent.putExtra("txtprocedencia",txtprocedencia);
                        intent.putExtra("asociacionProductiva",asociacionProductiva);
                        intent.putExtra("regionTitulo","CAJAMARCA");
                        startActivity(intent);
                    }
                    if (spinner.getSelectedItemPosition() == 4) {
                        Intent intent = new Intent(SeleccionActivity.this, MapaActivity.class);
                        intent.putExtra("region","CUSCO");
                        intent.putExtra("cultivo",cultivo);
                        intent.putExtra("ecotipo",ecotipo);
                        intent.putExtra("edadCultivo",edadCultivo);
                        intent.putExtra("primerNombre",primerNombre);
                        intent.putExtra("segundoNombre",segundoNombre);
                        intent.putExtra("apellidoPaterno",apellidoPaterno);
                        intent.putExtra("apellidoMaterno",apellidoMaterno);
                        intent.putExtra("edadCliente",edadCliente);
                        intent.putExtra("estadoCivil",estadoCivil);
                        intent.putExtra("dni",dni);
                        intent.putExtra("referenciaPredio",referenciaPredio);
                        intent.putExtra("procedenciaCombo",procedenciaCombo);
                        intent.putExtra("txtprocedencia",txtprocedencia);
                        intent.putExtra("asociacionProductiva",asociacionProductiva);
                        intent.putExtra("regionTitulo","CUSCO");
                        startActivity(intent);
                    }
                    if (spinner.getSelectedItemPosition() == 5) {
                        Intent intent = new Intent(SeleccionActivity.this, MapaActivity.class);
                        intent.putExtra("region","HUANCAVELICA");
                        intent.putExtra("cultivo",cultivo);
                        intent.putExtra("ecotipo",ecotipo);
                        intent.putExtra("edadCultivo",edadCultivo);
                        intent.putExtra("primerNombre",primerNombre);
                        intent.putExtra("segundoNombre",segundoNombre);
                        intent.putExtra("apellidoPaterno",apellidoPaterno);
                        intent.putExtra("apellidoMaterno",apellidoMaterno);
                        intent.putExtra("edadCliente",edadCliente);
                        intent.putExtra("estadoCivil",estadoCivil);
                        intent.putExtra("dni",dni);
                        intent.putExtra("referenciaPredio",referenciaPredio);
                        intent.putExtra("procedenciaCombo",procedenciaCombo);
                        intent.putExtra("txtprocedencia",txtprocedencia);
                        intent.putExtra("asociacionProductiva",asociacionProductiva);
                        intent.putExtra("regionTitulo","HUANCAVELICA");
                        startActivity(intent);
                    }
                    if (spinner.getSelectedItemPosition() == 6) {
                        Intent intent = new Intent(SeleccionActivity.this, MapaActivity.class);
                        intent.putExtra("region","HUANUCO");
                        intent.putExtra("cultivo",cultivo);
                        intent.putExtra("ecotipo",ecotipo);
                        intent.putExtra("edadCultivo",edadCultivo);
                        intent.putExtra("primerNombre",primerNombre);
                        intent.putExtra("segundoNombre",segundoNombre);
                        intent.putExtra("apellidoPaterno",apellidoPaterno);
                        intent.putExtra("apellidoMaterno",apellidoMaterno);
                        intent.putExtra("edadCliente",edadCliente);
                        intent.putExtra("estadoCivil",estadoCivil);
                        intent.putExtra("dni",dni);
                        intent.putExtra("referenciaPredio",referenciaPredio);
                        intent.putExtra("procedenciaCombo",procedenciaCombo);
                        intent.putExtra("txtprocedencia",txtprocedencia);
                        intent.putExtra("asociacionProductiva",asociacionProductiva);
                        intent.putExtra("regionTitulo","HUANUCO");
                        startActivity(intent);
                    }
                    if (spinner.getSelectedItemPosition() == 7) {
                        Intent intent = new Intent(SeleccionActivity.this, MapaActivity.class);
                        intent.putExtra("region","JUNIN");
                        intent.putExtra("cultivo",cultivo);
                        intent.putExtra("ecotipo",ecotipo);
                        intent.putExtra("edadCultivo",edadCultivo);
                        intent.putExtra("primerNombre",primerNombre);
                        intent.putExtra("segundoNombre",segundoNombre);
                        intent.putExtra("apellidoPaterno",apellidoPaterno);
                        intent.putExtra("apellidoMaterno",apellidoMaterno);
                        intent.putExtra("edadCliente",edadCliente);
                        intent.putExtra("estadoCivil",estadoCivil);
                        intent.putExtra("dni",dni);
                        intent.putExtra("referenciaPredio",referenciaPredio);
                        intent.putExtra("procedenciaCombo",procedenciaCombo);
                        intent.putExtra("txtprocedencia",txtprocedencia);
                        intent.putExtra("asociacionProductiva",asociacionProductiva);
                        intent.putExtra("regionTitulo","JUNIN");
                        startActivity(intent);
                    }
                    if (spinner.getSelectedItemPosition() == 8) {
                        Intent intent = new Intent(SeleccionActivity.this, MapaActivity.class);
                        intent.putExtra("region","PASCO");
                        intent.putExtra("cultivo",cultivo);
                        intent.putExtra("ecotipo",ecotipo);
                        intent.putExtra("edadCultivo",edadCultivo);
                        intent.putExtra("primerNombre",primerNombre);
                        intent.putExtra("segundoNombre",segundoNombre);
                        intent.putExtra("apellidoPaterno",apellidoPaterno);
                        intent.putExtra("apellidoMaterno",apellidoMaterno);
                        intent.putExtra("edadCliente",edadCliente);
                        intent.putExtra("estadoCivil",estadoCivil);
                        intent.putExtra("dni",dni);
                        intent.putExtra("referenciaPredio",referenciaPredio);
                        intent.putExtra("procedenciaCombo",procedenciaCombo);
                        intent.putExtra("txtprocedencia",txtprocedencia);
                        intent.putExtra("asociacionProductiva",asociacionProductiva);
                        intent.putExtra("regionTitulo","PASCO");
                        startActivity(intent);
                    }
                    if (spinner.getSelectedItemPosition() == 9) {
                        Intent intent = new Intent(SeleccionActivity.this, MapaActivity.class);
                        intent.putExtra("region","LORETO_A");
                        intent.putExtra("cultivo",cultivo);
                        intent.putExtra("ecotipo",ecotipo);
                        intent.putExtra("edadCultivo",edadCultivo);
                        intent.putExtra("primerNombre",primerNombre);
                        intent.putExtra("segundoNombre",segundoNombre);
                        intent.putExtra("apellidoPaterno",apellidoPaterno);
                        intent.putExtra("apellidoMaterno",apellidoMaterno);
                        intent.putExtra("edadCliente",edadCliente);
                        intent.putExtra("estadoCivil",estadoCivil);
                        intent.putExtra("dni",dni);
                        intent.putExtra("referenciaPredio",referenciaPredio);
                        intent.putExtra("procedenciaCombo",procedenciaCombo);
                        intent.putExtra("txtprocedencia",txtprocedencia);
                        intent.putExtra("asociacionProductiva",asociacionProductiva);
                        intent.putExtra("regionTitulo","LORETO A");
                        startActivity(intent);
                    }
                    if (spinner.getSelectedItemPosition() == 10) {
                        Intent intent = new Intent(SeleccionActivity.this, MapaActivity.class);
                        intent.putExtra("region","LORETO_B");
                        intent.putExtra("cultivo",cultivo);
                        intent.putExtra("ecotipo",ecotipo);
                        intent.putExtra("edadCultivo",edadCultivo);
                        intent.putExtra("primerNombre",primerNombre);
                        intent.putExtra("segundoNombre",segundoNombre);
                        intent.putExtra("apellidoPaterno",apellidoPaterno);
                        intent.putExtra("apellidoMaterno",apellidoMaterno);
                        intent.putExtra("edadCliente",edadCliente);
                        intent.putExtra("estadoCivil",estadoCivil);
                        intent.putExtra("dni",dni);
                        intent.putExtra("referenciaPredio",referenciaPredio);
                        intent.putExtra("procedenciaCombo",procedenciaCombo);
                        intent.putExtra("txtprocedencia",txtprocedencia);
                        intent.putExtra("asociacionProductiva",asociacionProductiva);
                        intent.putExtra("regionTitulo","LORETO B");
                        startActivity(intent);
                    }
                    if (spinner.getSelectedItemPosition() == 11) {
                        Intent intent = new Intent(SeleccionActivity.this, MapaActivity.class);
                        intent.putExtra("region","MADRE_DE_DIOS");
                        intent.putExtra("cultivo",cultivo);
                        intent.putExtra("ecotipo",ecotipo);
                        intent.putExtra("edadCultivo",edadCultivo);
                        intent.putExtra("primerNombre",primerNombre);
                        intent.putExtra("segundoNombre",segundoNombre);
                        intent.putExtra("apellidoPaterno",apellidoPaterno);
                        intent.putExtra("apellidoMaterno",apellidoMaterno);
                        intent.putExtra("edadCliente",edadCliente);
                        intent.putExtra("estadoCivil",estadoCivil);
                        intent.putExtra("dni",dni);
                        intent.putExtra("referenciaPredio",referenciaPredio);
                        intent.putExtra("procedenciaCombo",procedenciaCombo);
                        intent.putExtra("txtprocedencia",txtprocedencia);
                        intent.putExtra("asociacionProductiva",asociacionProductiva);
                        intent.putExtra("regionTitulo","MADRE DE DIOS");
                        startActivity(intent);
                    }
                    if (spinner.getSelectedItemPosition() == 12) {
                        Intent intent = new Intent(SeleccionActivity.this, MapaActivity.class);
                        intent.putExtra("region","PIURA");
                        intent.putExtra("cultivo",cultivo);
                        intent.putExtra("ecotipo",ecotipo);
                        intent.putExtra("edadCultivo",edadCultivo);
                        intent.putExtra("primerNombre",primerNombre);
                        intent.putExtra("segundoNombre",segundoNombre);
                        intent.putExtra("apellidoPaterno",apellidoPaterno);
                        intent.putExtra("apellidoMaterno",apellidoMaterno);
                        intent.putExtra("edadCliente",edadCliente);
                        intent.putExtra("estadoCivil",estadoCivil);
                        intent.putExtra("dni",dni);
                        intent.putExtra("referenciaPredio",referenciaPredio);
                        intent.putExtra("procedenciaCombo",procedenciaCombo);
                        intent.putExtra("txtprocedencia",txtprocedencia);
                        intent.putExtra("asociacionProductiva",asociacionProductiva);
                        intent.putExtra("regionTitulo","PIURA");
                        startActivity(intent);
                    }
                    if (spinner.getSelectedItemPosition() == 13) {
                        Intent intent = new Intent(SeleccionActivity.this, MapaActivity.class);
                        intent.putExtra("region","PIURA_2");
                        intent.putExtra("cultivo",cultivo);
                        intent.putExtra("ecotipo",ecotipo);
                        intent.putExtra("edadCultivo",edadCultivo);
                        intent.putExtra("primerNombre",primerNombre);
                        intent.putExtra("segundoNombre",segundoNombre);
                        intent.putExtra("apellidoPaterno",apellidoPaterno);
                        intent.putExtra("apellidoMaterno",apellidoMaterno);
                        intent.putExtra("edadCliente",edadCliente);
                        intent.putExtra("estadoCivil",estadoCivil);
                        intent.putExtra("dni",dni);
                        intent.putExtra("referenciaPredio",referenciaPredio);
                        intent.putExtra("procedenciaCombo",procedenciaCombo);
                        intent.putExtra("txtprocedencia",txtprocedencia);
                        intent.putExtra("asociacionProductiva",asociacionProductiva);
                        intent.putExtra("regionTitulo","PIURA 2");
                        startActivity(intent);
                    }
                    if (spinner.getSelectedItemPosition() == 14) {
                        Intent intent = new Intent(SeleccionActivity.this, MapaActivity.class);
                        intent.putExtra("region","PUNO");
                        intent.putExtra("cultivo",cultivo);
                        intent.putExtra("ecotipo",ecotipo);
                        intent.putExtra("edadCultivo",edadCultivo);
                        intent.putExtra("primerNombre",primerNombre);
                        intent.putExtra("segundoNombre",segundoNombre);
                        intent.putExtra("apellidoPaterno",apellidoPaterno);
                        intent.putExtra("apellidoMaterno",apellidoMaterno);
                        intent.putExtra("edadCliente",edadCliente);
                        intent.putExtra("estadoCivil",estadoCivil);
                        intent.putExtra("dni",dni);
                        intent.putExtra("referenciaPredio",referenciaPredio);
                        intent.putExtra("procedenciaCombo",procedenciaCombo);
                        intent.putExtra("txtprocedencia",txtprocedencia);
                        intent.putExtra("asociacionProductiva",asociacionProductiva);
                        intent.putExtra("regionTitulo","PUNO");
                        startActivity(intent);
                    }
                    if (spinner.getSelectedItemPosition() == 15) {
                        Intent intent = new Intent(SeleccionActivity.this, MapaActivity.class);
                        intent.putExtra("region","SAN_MARTIN");
                        intent.putExtra("cultivo",cultivo);
                        intent.putExtra("ecotipo",ecotipo);
                        intent.putExtra("edadCultivo",edadCultivo);
                        intent.putExtra("primerNombre",primerNombre);
                        intent.putExtra("segundoNombre",segundoNombre);
                        intent.putExtra("apellidoPaterno",apellidoPaterno);
                        intent.putExtra("apellidoMaterno",apellidoMaterno);
                        intent.putExtra("edadCliente",edadCliente);
                        intent.putExtra("estadoCivil",estadoCivil);
                        intent.putExtra("dni",dni);
                        intent.putExtra("referenciaPredio",referenciaPredio);
                        intent.putExtra("procedenciaCombo",procedenciaCombo);
                        intent.putExtra("txtprocedencia",txtprocedencia);
                        intent.putExtra("asociacionProductiva",asociacionProductiva);
                        intent.putExtra("regionTitulo","SAN MARTIN");
                        startActivity(intent);
                    }
                    if (spinner.getSelectedItemPosition() == 16) {
                        Intent intent = new Intent(SeleccionActivity    .this, MapaActivity.class);
                        intent.putExtra("region","UCAYALI");
                        intent.putExtra("cultivo",cultivo);
                        intent.putExtra("ecotipo",ecotipo);
                        intent.putExtra("edadCultivo",edadCultivo);
                        intent.putExtra("primerNombre",primerNombre);
                        intent.putExtra("segundoNombre",segundoNombre);
                        intent.putExtra("apellidoPaterno",apellidoPaterno);
                        intent.putExtra("apellidoMaterno",apellidoMaterno);
                        intent.putExtra("edadCliente",edadCliente);
                        intent.putExtra("estadoCivil",estadoCivil);
                        intent.putExtra("dni",dni);
                        intent.putExtra("referenciaPredio",referenciaPredio);
                        intent.putExtra("procedenciaCombo",procedenciaCombo);
                        intent.putExtra("txtprocedencia",txtprocedencia);
                        intent.putExtra("asociacionProductiva",asociacionProductiva);
                        intent.putExtra("regionTitulo","UCAYALI");
                        startActivity(intent);
                    }
                }

            }
        });
    }



    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(SeleccionActivity.this, RegisterClienteActivity.class));

    }
}
