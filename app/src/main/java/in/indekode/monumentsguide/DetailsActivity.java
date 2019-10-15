package in.indekode.monumentsguide;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    ImageView MImg, MMap;
    TextView  MName, MAdd, MLoc, MEntryF, MDetails;
    double lat, lang, currLat, currLang;
    String NameM;
    LocationManager locationManager;
    private static  final int REQUEST_LOCATION=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initialize();

        Intent intent = getIntent();
        NameM = intent.getStringExtra("Name");
        MName.setText(NameM);
        MAdd.setText(intent.getStringExtra("Adrs"));
        MDetails.setText(intent.getStringExtra("Details"));
        MEntryF.setText(intent.getStringExtra("EntryFees"));

        lat = Double.parseDouble(intent.getStringExtra("Lat"));
        lang = Double.parseDouble(intent.getStringExtra("Lang"));

        ActivityCompat.requestPermissions(this,new String[]
                {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        MMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationManager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
                if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
                    OnGPS();
                else
                    getLocation();

                Intent i = new Intent(DetailsActivity.this, MapsActivity.class);
                i.putExtra("Lang", String.valueOf(lang));
                i.putExtra("Lat", String.valueOf(lat));
                i.putExtra("NameM", NameM);
                i.putExtra("CurrLang", String.valueOf(currLang));
                i.putExtra("CurrLat", String.valueOf(currLat));
                startActivity(i);
            }
        });

        if(getIntent().hasExtra("byteArray")) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(
                    getIntent().getByteArrayExtra("byteArray"), 0, getIntent().getByteArrayExtra("byteArray").length);
            MImg.setImageBitmap(bitmap);
        }
    }

    private void initialize() {
        MImg = findViewById(R.id.MonumentImage);
        MMap = findViewById(R.id.MAP);

        MName = findViewById(R.id.MonumentName);
        MAdd = findViewById(R.id.Address);
        MLoc = findViewById(R.id.MapLocation);
        MEntryF = findViewById(R.id.EntryFee);
        MDetails = findViewById(R.id.Description);
    }


    private void getLocation() {
        //Check Permissions again
        if (ActivityCompat.checkSelfPermission(DetailsActivity.this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(DetailsActivity.this,
                Manifest.permission.ACCESS_COARSE_LOCATION) !=PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        }
        else {
            Location LocationGps= locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Location LocationNetwork=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            Location LocationPassive=locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

            if (LocationGps !=null) {
                currLat=LocationGps.getLatitude();
                currLang=LocationGps.getLongitude();
            }
            else if (LocationNetwork !=null) {
                currLat=LocationNetwork.getLatitude();
                currLang=LocationNetwork.getLongitude();
            }
            else if (LocationPassive !=null) {
                currLat=LocationPassive.getLatitude();
                currLang=LocationPassive.getLongitude();

            }
            else {
                Toast.makeText(this, "Can't Get Your Location", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void OnGPS() {

        final AlertDialog.Builder builder= new AlertDialog.Builder(this);

        builder.setMessage("Enable GPS").setCancelable(false).setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });
        final AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}
