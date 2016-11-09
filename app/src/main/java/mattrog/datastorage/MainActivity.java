package mattrog.datastorage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "MyPrefsFile";

    int _count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        _count = settings.getInt("counter", 0);
        updateText();

        final Button _advance = (Button) findViewById(R.id.advance);
        _advance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                advance();
                updateText();
            }
        });

        final Button _save = (Button) findViewById(R.id.save);
        _save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    void advance() {
        ++_count;
    }

    void updateText() {
        final TextView number = (TextView) findViewById(R.id.count);
        number.setText(Integer.toString(_count));
    }

    void save() {
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, 0).edit();
        editor.putInt("counter", _count);
        editor.commit();
    }

}
