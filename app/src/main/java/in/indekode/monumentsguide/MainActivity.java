package in.indekode.monumentsguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView tajmahal, mysorepalace, goldentemple, hindutemple, hawamahal, victoriamemorial, qutubminar, lotustemple, lalqila, shaniwarwada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();

        tajmahal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("Name", "Taj Mahal");
                intent.putExtra("Adrs", "Address: Agra, Uttar Pradesh");
                intent.putExtra("EntryFees", "Entry Fee: INR 50 - 1100");
                intent.putExtra("Details", "The Taj Mahal is one of the seven wonders of the world. A symbol of love, the Taj was built by Mughal Emperor Shah Jahan for his queen Mumtaz. Tagore described the Taj as an eardrop on the cheek of eternity. Covering an area of approximately 42 Acres, the Taj Mahal was constructed using white marble obtained from Makrana in Rajasthan. ");
                startActivity(intent);
            }
        });

        mysorepalace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("Name", "Mysore Palace");
                intent.putExtra("Adrs", "Address: Mysuru, Karnataka");
                intent.putExtra("EntryFees", "Entry Fee: INR 40 - 200");
                intent.putExtra("Details", "The former residence of the royal family of Mysore, the Mysore Palace is an extremely breath-taking example of the Indo-Sarcenic style of architecture. It was built in the year 1912 for the 24th Ruler of the Wodeyar Dynasty, and is till date one of the biggest palaces in the country. The construction of the Mysore Palace was orchestrated by the Maharaja Krishnaraja Wadiyar IV referred as \"Rajarishi\". ");
                startActivity(intent);
            }
        });

        goldentemple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("Name", "Golden Temple");
                intent.putExtra("Adrs", "Address: Amritsar, Punjab");
                intent.putExtra("EntryFees", "Entry Fee: FREE");
                intent.putExtra("Details", "Also called Sri Harmandir Sahib or Swarna Mandir, the shrine was designed by Guru Arjan Sahib and its foundation laid by Muslim saint Hazrat Mian Mir ji of Lahore on 1st December 1588. It is the view of the resplendent shrine, glistening in the centre of the tank that brings an infinite calmness. It is located right in the heart of Amritsar and is easily reachable from any part of the city.");
                startActivity(intent);
            }
        });

        hindutemple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("Name", "Meenakshi Amman Temple");
                intent.putExtra("Adrs", "Address: Madurai, Tamil Nadu");
                intent.putExtra("EntryFees", "Entry Fee: FREE");
                intent.putExtra("Details", "This is a historic Hindu temple located on the southern bank of the Vaigai River, Madurai, Tamil Nadu. It is primarily dedicated to Parvati, known as Meenakshi, and her spouse, Shiva. What makes this one of the unique monuments of India is that this is a temple different from the others, where both God and Goddess are worshipped together. According to the mythology, Lord Shiva visited Madurai to marry Parvati.");
                startActivity(intent);
            }
        });

        hawamahal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("Name", "Hawa Mahal");
                intent.putExtra("Adrs", "Address: Jaipur, Rajastan.");
                intent.putExtra("EntryFees", "Entry Fee: INR 50 - 200");
                intent.putExtra("Details", "The Hawa Mahal stands at the intersection of the main road in Jaipur, Badi Chaupad. It is regarded as the signature building of Jaipur and was built by Maharaja Sawai Pratap Singh. Hawa Mahal is a structure made of red and pink sandstone and has a pyramidal structure which almost resembles a crown. It has been embellished with 953 tiny windows, also known as 'Jharokhas' and embellished with gorgeous latticework.");
                startActivity(intent);
            }
        });

        victoriamemorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("Name", "Victoria Memorial");
                intent.putExtra("Adrs", "Address: Kolkata, West Bengal");
                intent.putExtra("EntryFees", "Entry Fee: INR 10 - 200");
                intent.putExtra("Details", "The Victoria Memorial is a large marble building, which is considered to be the pride of Kolkata. Built between 1906 and 1921, it is dedicated to the memory of Queen Victoria. Presently it is a museum and a popular tourist spot under the Ministry of Culture. The memorial is surrounded by a lush green and well-maintained garden, which spreads over 64 acres and has numerous statues and sculptures in it.");
                startActivity(intent);
            }
        });

        qutubminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("Name", "Qutub Minar");
                intent.putExtra("Adrs", "Address: Delhi");
                intent.putExtra("EntryFees", "Entry Fee: INR 10 - 250");
                intent.putExtra("Details", "The soaring and brave tower that allures tourists despite being destroyed by ravages of natural apocalypses several times, Qutub Minar is the tallest individual tower in the world and second tallest monument of Delhi. A UNESCO World Heritage Site, it is located in Mehrauli and its construction was started in 1192 by Qutb Ud-Din-Aibak, founder of Delhi Sultanate.");
                startActivity(intent);
            }
        });

        lotustemple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("Name", "Lotus Temple");
                intent.putExtra("Adrs", "Address: Kalkanji, New Delhi");
                intent.putExtra("EntryFees", "Entry Fee: FREE");
                intent.putExtra("Details", "Commonly known as Lotus temple, this monument is one of the seven Baha'i Houses of Worship. Located in the national capital of New Delhi, the Lotus Temple is an edifice dedicated to the Baha'i faith. The magnificent structure of this building unfolds in the form of a stupendous white petal lotus and is one of the most visited establishments in the world.");
                startActivity(intent);
            }
        });

        lalqila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("Name", "Lal Qila");
                intent.putExtra("Adrs", "Address: Chandani Chowk, Delhi");
                intent.putExtra("EntryFees", "Entry Fee: INR 40 - 550");
                intent.putExtra("Details", "Also known as Lal Qila, Fort Rouge or Red Fort of Agra, the Agra Fort is a UNESCO world heritage site. It is situated at a distance of about 2.5 km north-west of the famous Taj Mahal. Agra Fort is one of the most special monuments built by the Mughals and has richly decorated buildings. It is the perfect example of the Mughal style of art and architecture and is one of the most visited tourist spots in Agra.");
                startActivity(intent);
            }
        });

        shaniwarwada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("Name", "Shaniwar Wada");
                intent.putExtra("Adrs", "Address: Pune, Maharashtra");
                intent.putExtra("EntryFees", "Entry Fee: INR 5 - 125");
                intent.putExtra("Details", "Shaniwarwada, once the seat of the Peshwa governance in Pune is a 286-year-old mansion and is one of the finest examples of architecture in the city. It is now one of the most popular tourist destinations in Maharashtra. This grand mansion was built by the Peshwa Bajirao I himself as the residence of the Peshwas. Although the Wada currently covers an area of 625 acres.");
                startActivity(intent);
            }
        });

    }

    private void initialization() {
        tajmahal = findViewById(R.id.TajMahal);
        mysorepalace = findViewById(R.id.MysorePalace);
        goldentemple = findViewById(R.id.GoldenTemple);
        hindutemple = findViewById(R.id.HinduTemple);
        hawamahal = findViewById(R.id.HawaMahal);
        victoriamemorial = findViewById(R.id.VictoriaMemorial);
        qutubminar = findViewById(R.id.QutubMinar);
        lotustemple = findViewById(R.id.LotusTemple);
        lalqila = findViewById(R.id.LalQila);
        shaniwarwada = findViewById(R.id.ShaniwarWada);
    }

}
