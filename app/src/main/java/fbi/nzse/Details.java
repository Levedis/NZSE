package fbi.nzse;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final Globals g = (Globals)getApplication();

        Context context = getApplicationContext();
        CharSequence wurdeAusgeliehen = "Buch wurde für sie vorgemerkt";
        CharSequence wurdeNICHTAusgeliehen = "Alle Exemplare bereits ausgeliehen";
        int duration = Toast.LENGTH_SHORT;
        final Toast toastAusgeliehen = Toast.makeText(context, wurdeAusgeliehen, duration);
        final Toast toastNICHTAusgeliehen = Toast.makeText(context, wurdeNICHTAusgeliehen, duration);
        final Button ausleihenButton = findViewById(R.id.ausleihenButton);


        ausleihenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(g.bookDatabase.elementAt(g.findCurrentBook()).rent() == true) {
                    toastAusgeliehen.show();
                }
                else {
                    toastNICHTAusgeliehen.show();
                }
            }
        });

        TextView mBookName = (TextView)findViewById(R.id.detailsBookName);
        TextView mBookAuthor = (TextView)findViewById(R.id.detailsBookAuthor);
        TextView mBookYear = (TextView)findViewById(R.id.detailsBookYear);
        TextView mBookSummary = (TextView)findViewById(R.id.detailsBookSummary);


        int currbook = g.findCurrentBook();
        mBookName.setText(g.bookDatabase.elementAt(currbook).name);
        mBookAuthor.setText(g.bookDatabase.elementAt(currbook).author);
        mBookYear.setText(g.bookDatabase.elementAt(currbook).pubYear);
        mBookSummary.setText(g.bookDatabase.elementAt(currbook).details);

    }

}
