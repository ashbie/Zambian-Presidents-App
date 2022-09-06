package kas.du.usingrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn_addOne;
    List<President> presidentList = new ArrayList<President>();


    //Fill the List(the central storage area) with president objects
/***** First get the global list of presidents from the application ***/

    private static final String TAG = "President App";

    //to make the RecyclerView work
    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication myApplication = (MyApplication) this.getApplication();
        Log.d(TAG, "[ myApplication ]: this.getApplication() = "+ myApplication);
        presidentList = myApplication.getPresidentList();
        Log.d(TAG, "[ presidentList ]: myApplication.getPresidentList() = "+ presidentList);
        //
        //
        //
        Log.d(TAG, "onCreate: "+ presidentList.toString());

        btn_addOne = findViewById(R.id.btn_addOne);

        btn_addOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startAddOneEdit = new Intent(MainActivity.this, AddOneEdit.class);
                startActivity(startAddOneEdit);
            }
        });

        // For the RecyclerView
        recyclerView = findViewById(R.id.rv_presidents);
        recyclerView.setHasFixedSize(true);
        //      Use a Layout Manager
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        //      Specify an adapter
        myAdapter = new MyAdapter(presidentList, MainActivity.this);
        recyclerView.setAdapter(myAdapter);


    }


}