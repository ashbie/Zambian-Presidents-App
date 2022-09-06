package kas.du.usingrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class AddOneEdit extends AppCompatActivity {
    private static final String TAG = "AddOneEdit-Activity";
    Button btn_add, btn_cancel;
    List<President> presidentList;

    EditText presName, presDate, presImageURL;
    President newPresident;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_one_edit);

        btn_add = findViewById(R.id.btn_add);
        btn_cancel = findViewById(R.id.btn_cancel);
        presName = findViewById(R.id.et_name);
        presDate = findViewById(R.id.et_date);
        presImageURL = findViewById(R.id.et_imageURL);

        // get the global list of presidents
        MyApplication myApplication = (MyApplication) this.getApplication();
        Log.d(TAG, "[ (AddOneEdit.java) myApplication ]: this.getApplication() = "+ myApplication);
        presidentList = myApplication.getPresidentList();
        Log.d(TAG, "[ (AddOneEdit.java) presidentList ]: myApplication.getPresidentList() = "+ presidentList);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add the new president to the global list
                ///////// Make a new president object
                newPresident = new President( myApplication.getNextId(), presName.getText().toString(), Integer.parseInt(presDate.getText().toString()), presImageURL.getText().toString());
                ////////// Add it to the global list
                presidentList.add(newPresident);
                ///////// Increment the nextId attribute. It will be used to create the next president object id.
                int nextId = myApplication.getNextId();
                myApplication.setNextId(nextId+1);
                // Go back to MainActivity ( show the president list )
                Intent startAddOneEdit = new Intent(AddOneEdit.this, MainActivity.class);
                startActivity(startAddOneEdit);
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startAddOneEdit = new Intent(AddOneEdit.this, MainActivity.class);
                startActivity(startAddOneEdit);
            }
        });
    }
}