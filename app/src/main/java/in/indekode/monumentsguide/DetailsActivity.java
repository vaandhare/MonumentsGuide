package in.indekode.monumentsguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    ImageView MImg, MMap;
    TextView  MName, MAdd, MLoc, MEntryF, MDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initialize();

        Intent intent = getIntent();
        MName.setText(intent.getStringExtra("Name"));
        MAdd.setText(intent.getStringExtra("Adrs"));
        MDetails.setText(intent.getStringExtra("Details"));
        MEntryF.setText(intent.getStringExtra("EntryFees"));

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
