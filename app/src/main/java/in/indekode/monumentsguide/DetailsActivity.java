package in.indekode.monumentsguide;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.Locale;

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
                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f", lat,lang);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
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
}
