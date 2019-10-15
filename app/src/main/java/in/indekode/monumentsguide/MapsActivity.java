package in.indekode.monumentsguide;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.UnsupportedEncodingException;
import java.util.List;

import in.indekode.monumentsguide.directionModules.DirectionFinder;
import in.indekode.monumentsguide.directionModules.DirectionFinderListener;
import in.indekode.monumentsguide.directionModules.Route;

import static in.indekode.monumentsguide.util.GoogleMapHelper.buildCameraUpdate;
import static in.indekode.monumentsguide.util.GoogleMapHelper.getDefaultPolyLines;
import static in.indekode.monumentsguide.util.GoogleMapHelper.getDottedPolylines;
import static in.indekode.monumentsguide.util.UiHelper.showAlwaysCircularProgressDialog;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, DirectionFinderListener {

    private enum PolylineStyle {
        DOTTED,
        PLAIN
    }
    private static final String[] POLYLINE_STYLE_OPTIONS = new String[]{
            "PLAIN",
            "DOTTED"
    };
    private PolylineStyle polylineStyle = PolylineStyle.PLAIN;
    private Polyline polyline;
    private MaterialDialog materialDialog;
    private GoogleMap mMap;

    double lat, lang, currlat, currlang;
    String Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
        lat = Double.parseDouble(intent.getStringExtra("Lat"));
        lang = Double.parseDouble(intent.getStringExtra("Lang"));
        currlat = Double.parseDouble(intent.getStringExtra("CurrLat"));
        currlang = Double.parseDouble(intent.getStringExtra("CurrLang"));
        Name = intent.getStringExtra("NameM");

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //Monument location
        LatLng destination = new LatLng(lat, lang);
        mMap.addMarker(new MarkerOptions().position(destination).title(Name));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(destination));

        //Current Location
        LatLng source = new LatLng(currlat, currlang);
        mMap.addMarker(new MarkerOptions().position(source).title("Current Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(source));

        String SLL = currlat+","+currlang;
        String DLL = lat+","+lang;
        fetchDirections(SLL, DLL);
    }

    private void fetchDirections(String origin, String destination) {
        try {
            new DirectionFinder(this, origin, destination).execute();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDirectionFinderStart() {
        if (materialDialog == null)
            materialDialog = showAlwaysCircularProgressDialog(this, "Fetching Directions...");
        else materialDialog.show();
    }

    @Override
    public void onDirectionFinderSuccess(List<Route> routes) {
        if (materialDialog != null && materialDialog.isShowing())
            materialDialog.dismiss();
        if (!routes.isEmpty() && polyline != null) polyline.remove();
        try {
            for (Route route : routes) {
                PolylineOptions polylineOptions = getDefaultPolyLines(route.points);
                if (polylineStyle == PolylineStyle.DOTTED)
                    polylineOptions = getDottedPolylines(route.points);
                polyline = mMap.addPolyline(polylineOptions);
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error occurred on finding the directions...", Toast.LENGTH_SHORT).show();
        }
        mMap.animateCamera(buildCameraUpdate(routes.get(0).endLocation), 10, null);
    }
}
