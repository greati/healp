package com.example.healt_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.healt_app.com.example.healt_app.adapters.RecommAdapter;
import com.example.healt_app.com.example.healt_app.models.Recommendation;

import java.util.ArrayList;

public class CreateRecommActivity extends AppCompatActivity {

    private EditText edtRecommQtd;
    private Spinner spRecommType;

    private ListView lvRecomm;
    private ArrayList<Recommendation> recomms;
    private ArrayList<Recommendation> recommsSugest;
    private RecommAdapter recommAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recomm);

        setTitle("Recomendações");

        lvRecomm = findViewById(R.id.lv_recomm_create);

        recomms = new ArrayList<>();
        recomms.add(new Recommendation("Consumir #L de água", Recommendation.Type.WATER, 2D));

        recommAdapter = new RecommAdapter(this, recomms);
        lvRecomm.setAdapter(recommAdapter);


        edtRecommQtd = findViewById(R.id.edt_recomm_qtd);

        recommsSugest = new ArrayList<Recommendation>();
        recommsSugest.add(new Recommendation("Consumir #g de carne vermelha", Recommendation.Type.FOOD));
        recommsSugest.add(new Recommendation("Beber #L de água", Recommendation.Type.WATER));
        recommsSugest.add(new Recommendation("Realizar exame de sangue", Recommendation.Type.HEALTH));

        ArrayAdapter<Recommendation> adapter = new ArrayAdapter<Recommendation>(this, android.R.layout.simple_spinner_item, recommsSugest);

        spRecommType = findViewById(R.id.sp_recomm_type);
        spRecommType.setAdapter(adapter);

        ImageButton btAddRecomm = findViewById(R.id.bt_add_recomm);

        btAddRecomm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double qtd = 0D;

                if (!edtRecommQtd.getText().toString().equals(""))
                    qtd = Double.valueOf(edtRecommQtd.getText().toString());

                Recommendation r = (Recommendation) spRecommType.getSelectedItem();

                r.setQtd(qtd);

                recomms.add(r);
                recommAdapter.notifyDataSetChanged();

                edtRecommQtd.setText("");

            }
        });
    }
}
