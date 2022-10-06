package com.example.marvin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView1 , recyclerView2;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView1 = findViewById(R.id.rec_view1);
        recyclerView2 = findViewById(R.id.rec_view2);
        dialog = progressDialog();
        dialog.show();
        getData();


    }

    private void getData()
    {
        Call<List<MarvinModel>> call = MarvinClient.getInstance().getMyAPI().getMarvin();
        call.enqueue(new Callback<List<MarvinModel>>() {
            @Override
            public void onResponse(Call<List<MarvinModel>> call, Response<List<MarvinModel>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Code is : "+String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                    return;
                }

                List<MarvinModel> Marvins = response.body();
                MarvinAdapter adapter = new MarvinAdapter(MainActivity.this , Marvins);
                recyclerView1.setAdapter(adapter);
                recyclerView1.setLayoutManager(new LinearLayoutManager(MainActivity.this ,LinearLayoutManager.HORIZONTAL , false ));

                MarvinAdapter adapter2 = new MarvinAdapter(MainActivity.this , Marvins);
                recyclerView2.setAdapter(adapter2);
                recyclerView2.setLayoutManager(new LinearLayoutManager(MainActivity.this , LinearLayoutManager.HORIZONTAL , false ));
                dialog.cancel();


            }

            @Override
            public void onFailure(Call<List<MarvinModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
    }

    public ProgressDialog progressDialog() {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("API Fertching");
        dialog.setMessage("Loading Data.....");
        dialog.setCancelable(false);
        return dialog;

    }

}