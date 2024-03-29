package amazoniaresilientes.durand.josue.amazoniaresiliente.Inicio;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import amazoniaresilientes.durand.josue.amazoniaresiliente.Room.SincronizarPoligono;
import amazoniaresilientes.durand.josue.amazoniaresiliente.adapter.SQLiteHelper3;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import amazoniaresilientes.durand.josue.amazoniaresiliente.R;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import android.widget.Button;
import android.widget.TextView;

public class PhotoActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {
    String geoJson;
    public static final int REQUEST_CODE = 1000;
    public static final int REQUEST_CODE2 = 1001;
    public static final int REQUEST_CODE3= 1002;
    public static final int REQUEST_CODE4 = 1003;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";
    ImageView imagePhoto, imagePhoto2, imagePhoto3, imagePhoto4;
    private Location location;
    double latitude, longitude,latitude2, longitude2,latitude3, longitude3,latitude4, longitude4;

    private GoogleApiClient googleApiClient;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private LocationRequest locationRequest;
    private static final long UPDATE_INTERVAL = 5000, FASTEST_INTERVAL = 5000; // = 5 seconds
    // lists for permissions
    private ArrayList<String> permissionsToRequest;
    private ArrayList<String> permissionsRejected = new ArrayList<>();
    private ArrayList<String> permissions = new ArrayList<>();
    // integer for permissions results request
    private static final int ALL_PERMISSIONS_RESULT = 1011;
    String area;
    String cultivo,primerNombre,segundoNombre,apellidoPaterno,apellidoMaterno,estadoCivil,dni,referenciaPredio,regionSeleccionado;


    String edadCultivo,procedenciaCombo,txtprocedencia,asociacionProductiva,edadCliente;
    String lat1;
    TextView txtnombres, txtregion,txtcultivo,txtdni;
    Button btnAdd;
    ImageView imageView;

    final int REQUEST_CODE_GALLERY = 999;

    public static SQLiteHelper3 sqLiteHelper;
    String   ecotipo;
    public  static RegisterClienteActivity objregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        area=getIntent().getStringExtra("area");
        regionSeleccionado = getIntent().getStringExtra("region");
        cultivo = getIntent().getStringExtra("cultivo");
        edadCultivo = getIntent().getStringExtra("edadCultivo");
        primerNombre = getIntent().getStringExtra("primerNombre");
        segundoNombre = getIntent().getStringExtra("segundoNombre");
        apellidoPaterno = getIntent().getStringExtra("apellidoPaterno");
        apellidoMaterno = getIntent().getStringExtra("apellidoMaterno");
           edadCliente = getIntent().getStringExtra("edadCliente");
        ecotipo = getIntent().getStringExtra("ecotipo");
        estadoCivil = getIntent().getStringExtra("estadoCivil");
        dni = getIntent().getStringExtra("dni");
        referenciaPredio = getIntent().getStringExtra("referenciaPredio");
        procedenciaCombo = getIntent().getStringExtra("procedenciaCombo");
        txtprocedencia = getIntent().getStringExtra("txtprocedencia");
        asociacionProductiva = getIntent().getStringExtra("asociacionProductiva");
        geoJson = getIntent().getStringExtra("GeoJson");

        setContentView(R.layout.activity_photo);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        //      Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        imagePhoto = findViewById(R.id.imagePhoto);
        imagePhoto2 = findViewById(R.id.imagePhoto2);
        imagePhoto3 = findViewById(R.id.imagePhoto3);
        imagePhoto4 = findViewById(R.id.imagePhoto4);

        Toast.makeText(getApplicationContext(), "sssss"+edadCliente +" ddd"+edadCultivo, Toast.LENGTH_SHORT).show();

       // sqLiteHelper = new SQLiteHelper2(this, "AmazoniaDB.sqlite", null, 1);
     //   sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS AMAZONIA(Id INTEGER PRIMARY KEY AUTOINCREMENT, cultivo VARCHAR, primer_nombre VARCHAR, segundo_nombre VARCHAR, apellido_paterno VARCHAR, apellido_materno VARCHAR, estado_civil VARCHAR, dni VARCHAR, referencia_predio VARCHAR, edad_cultivo VARCHAR, edad_cliente VARCHAR, procedenciaCombo VARCHAR, txtprocedencia VARCHAR, asociacionProductiva VARCHAR, departamento_cliente VARCHAR, poligono VARCHAR, area VARCHAR, precision VARCHAR, imagen1 BLOB, lat1 VARCHAR, lng1 VARCHAR, imagen2 BLOB, lat2 VARCHAR, lng2 VARCHAR, imagen3 BLOB, lat3 VARCHAR, lng3 VARCHAR, imagen4 BLOB, lat4 VARCHAR, lng4 VARCHAR)");
//        sqLiteHelper = new SQLiteHelper3(this, "AmazoniaDB.sqlite", null, 1);
//        sqLiteHelper.queryData3("CREATE TABLE IF NOT EXISTS AMAZONIA(Id INTEGER PRIMARY KEY AUTOINCREMENT, cultivo VARCHAR, primer_nombre VARCHAR, segundo_nombre VARCHAR, apellido_paterno VARCHAR, apellido_materno VARCHAR, estado_civil VARCHAR, dni VARCHAR, referencia_predio VARCHAR, edad_cultivo VARCHAR, edad_cliente VARCHAR, procedenciaCombo VARCHAR, txtprocedencia VARCHAR, asociacionProductiva VARCHAR, departamento_cliente VARCHAR, poligono VARCHAR, area VARCHAR, precision VARCHAR, imagen1 BLOB, lat1 VARCHAR, lng1 VARCHAR, imagen2 BLOB, lat2 VARCHAR, lng2 VARCHAR, imagen3 BLOB, lat3 VARCHAR, lng3 VARCHAR, imagen4 BLOB, lat4 VARCHAR, lng4 VARCHAR)");
//

        imagePhoto4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Clicked", "YES");
                Log.i("PhotoActivity", "Latitude " + latitude4 + " longitude " + longitude4);
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(PhotoActivity.this,
                            Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_GRANTED) {
                        openCamera4();
                    }
                } else {
                    openCamera4();
                }
            }
        });

        imagePhoto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Clicked", "YES");
                Log.i("PhotoActivity", "Latitude " + latitude3 + " longitude " + longitude3);
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(PhotoActivity.this,
                            Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_GRANTED) {
                        openCamera3();
                    }
                } else {
                    openCamera3();
                }
            }
        });
        imagePhoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Clicked", "YES");
                Log.i("PhotoActivity", "Latitude " + latitude2 + " longitude " + longitude2);
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(PhotoActivity.this,
                            Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_GRANTED) {
                        openCamera2();
                    }
                } else {
                    openCamera2();
                }
            }
        });

        imagePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Clicked", "YES");
                Log.i("PhotoActivity", "Latitude " + latitude + " longitude " + longitude);
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(PhotoActivity.this,
                            Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_GRANTED) {
                        openCamera();
                    }
                } else {
                    openCamera();
                }
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(PhotoActivity.this, new String[]{Manifest.permission.CAMERA}, 1);
            }
        }

        permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);

        permissionsToRequest = permissionsToRequest(permissions);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (permissionsToRequest.size() > 0) {
                requestPermissions(permissionsToRequest.
                        toArray(new String[permissionsToRequest.size()]), ALL_PERMISSIONS_RESULT);
            }
        }

        // we build google api client
        googleApiClient = new GoogleApiClient.Builder(this).
                addApi(LocationServices.API).
                addConnectionCallbacks(this).
                addOnConnectionFailedListener(this).build();

        setUpButtons();


    }

    private ArrayList<String> permissionsToRequest(ArrayList<String> wantedPermissions) {
        ArrayList<String> result = new ArrayList<>();

        for (String perm : wantedPermissions) {
            if (!hasPermission(perm)) {
                result.add(perm);
            }
        }

        return result;
    }

    private boolean hasPermission(String permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
        }

        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (googleApiClient != null) {
            googleApiClient.connect();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        // stop location updates
        if (googleApiClient != null && googleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
            googleApiClient.disconnect();
        }
    }

    private boolean checkPlayServices() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);

        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST);
            } else {
                finish();
            }

            return false;
        }

        return true;
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        // Permissions ok, we get last location
        location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);

        if (location != null) {
            latitude = location.getLatitude();
            latitude = location.getLatitude();
            longitude =location.getLongitude();
            latitude2 = location.getLatitude();
            longitude2 = location.getLongitude();
            latitude3 = location.getLatitude();
            longitude3 = location.getLongitude();
            latitude4 = location.getLatitude();
            longitude4 = location.getLongitude();
        }
        startLocationUpdates();
    }

    private void startLocationUpdates() {
        locationRequest = new LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(UPDATE_INTERVAL);
        locationRequest.setFastestInterval(FASTEST_INTERVAL);

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "You need to enable permissions to display location !", Toast.LENGTH_SHORT).show();
        }

        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
    }

    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            latitude = location.getLatitude();
            latitude = location.getLatitude();
            longitude =location.getLongitude();
            latitude2 = location.getLatitude();
            longitude2 = location.getLongitude();
            latitude3 = location.getLatitude();
            longitude3 = location.getLongitude();
            latitude4 = location.getLatitude();
            longitude4 = location.getLongitude();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case ALL_PERMISSIONS_RESULT:
                for (String perm : permissionsToRequest) {
                    if (!hasPermission(perm)) {
                        permissionsRejected.add(perm);
                    }
                }

                if (permissionsRejected.size() > 0) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (shouldShowRequestPermissionRationale(permissionsRejected.get(0))) {
                            new AlertDialog.Builder(PhotoActivity.this).
                                    setMessage("These permissions are mandatory to get your location. You need to allow them.").
                                    setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                requestPermissions(permissionsRejected.
                                                        toArray(new String[permissionsRejected.size()]), ALL_PERMISSIONS_RESULT);
                                            }
                                        }
                                    }).setNegativeButton("Cancel", null).create().show();

                            return;
                        }
                    }
                } else {
                    if (googleApiClient != null) {
                        googleApiClient.connect();
                    }
                }

                break;
        }
    }

    private void openCamera() {
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePicture.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePicture, REQUEST_CODE);
        }
    }

    private void openCamera2() {
        Intent takePicture2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePicture2.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePicture2, REQUEST_CODE2);
        }
    }

    private void openCamera3() {
        Intent takePicture3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePicture3.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePicture3, REQUEST_CODE3);
        }
    }

    private void openCamera4() {
        Intent takePicture4 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePicture4.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePicture4, REQUEST_CODE4);
        }
    }


    //CONVERTIDOR
    public static byte[] imageViewToByte(ImageView image) {

        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }


    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        /*Photo 1*/
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE && data != null) {
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            imagePhoto.setImageBitmap(imageBitmap);
        }
        /*Photo 2*/
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE2 && data != null) {
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            imagePhoto2.setImageBitmap(imageBitmap);
        }
        /*Photo 3*/
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE3 && data != null) {
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            imagePhoto3.setImageBitmap(imageBitmap);
        }
        /*Photo 4*/
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE4 && data != null) {
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            imagePhoto4.setImageBitmap(imageBitmap);
        }
    }

        private void setUpButtons() {
        AppCompatImageView savePolygon = findViewById(R.id.savePolygon);
        savePolygon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(PhotoActivity.this);
                builder.setTitle("App");
                builder.setMessage("¿Desea guardar los datos 2");
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try{
                            String lat1 = String.valueOf(latitude);
                            String lng1 = String.valueOf(longitude);

                            String lat2 = String.valueOf(latitude2);
                            String lng2 = String.valueOf(longitude2);

                            String lat3 = String.valueOf(latitude3);
                            String lng3 = String.valueOf(longitude3);

                            String lat4 = String.valueOf(latitude4);
                            String lng4 = String.valueOf(longitude4);
                            RegisterClienteActivity.sqLiteHelper2.insertData3(
                                    cultivo,
                                    primerNombre,
                                    segundoNombre,
                                    apellidoPaterno,
                                    apellidoMaterno,
                                    estadoCivil,
                                    dni,
                                    referenciaPredio,
                                    regionSeleccionado,
                                    geoJson,
                                    area,
                                    "1.0",
                                    imageViewToByte(imagePhoto),
                                    lat1,
                                    lng1,
                                    imageViewToByte(imagePhoto2),
                                    lat2,
                                    lng2,
                                    imageViewToByte(imagePhoto3),
                                    lat3,
                                    lng3,
                                    imageViewToByte(imagePhoto4),
                                    lat4,
                                    lng4,
                                    edadCultivo,
                                    edadCliente,
                                    procedenciaCombo,
                                    txtprocedencia,
                                    asociacionProductiva,
                                    ecotipo
                            );
                            Toast.makeText(getApplicationContext(), "AGREGADO!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(PhotoActivity.this, SincronizarPoligono.class);
                            startActivity(intent);

                           // imageView.setImageResource(R.mipmap.ic_launcher);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                       // finish();
                        Log.i("PhotoActivity", "Latitude " + latitude + " longitude " + longitude);
                        Log.i("OK", "Si Clicked");
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(PhotoActivity.this, MapaActivity.class));

    }
}