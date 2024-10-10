package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
         {"Doctor Name : Ravi Teja Goud", "Hospital Address : Sai Clinic, Vijayawada", "Exp : 12 years", "Mobile No: 9876543210", "600"},
         {"Doctor Name : Divya Reddy", "Hospital Address : Apollo Hospital, Sri Kakulam", "Exp : 15 years", "Mobile No: 8765432109", "700"},
        {"Doctor Name : Ramya Krishna", "Hospital Address : Care Hospital, Visakhapatnam", "Exp : 10 years", "Mobile No: 7654321098", "800"},
        {"Doctor Name : Karthik Kumar", "Hospital Address : Global Hospital, Guntur", "Exp : 8 years", "Mobile No: 6543210987", "500"},
        {"Doctor Name : Srinivas Rao", "Hospital Address : Lotus Hospital, Rajahmundry", "Exp : 20 years", "Mobile No: 5432109876", "1000"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Ananya Patel", "Hospital Address : City Hospital, Vizianagaram", "Exp : 12 years", "Mobile No: 9876543210", "600"},
                    {"Doctor Name : Vikram Singhania", "Hospital Address : Metro Liver Clinic, Kakinada", "Exp : 15 years", "Mobile No: 8765432109", "700"},
                    {"Doctor Name : Priya Sharma", "Hospital Address : LiverCare Hospital, Amalapuram", "Exp : 10 years", "Mobile No: 7654321098", "800"},
                    {"Doctor Name : Arjun Reddy","Hospital Address : GastroMed Hospital, Bhimavaram", "Exp : 8 years", "Mobile No: 6543210987", "500"},
                    {"Doctor Name : Neha Gupta","Hospital Address : Advanced Liver Center, Eluru", "Exp : 20 years", "Mobile No: 5432109876", "1000"},
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Venkatesh Reddy", "Hospital Address : Telugu Kidney Care Center, Amaravati", "Exp : 10 years", "Mobile No: 9876543210", "600"},
                    {"Doctor Name : Lakshmi Priya Reddy", "Hospital Address : Andhra Kidney Hospital, Prakasam", "Exp : 15 years", "Mobile No: 8765432109", "700"},
                    {"Doctor Name : Suresh Babu Reddy", "Hospital Address : Visakhapatnam Renal Clinic, Visakhapatnam", "Exp : 8 years", "Mobile No: 7654321098", "800"},
                    {"Doctor Name : Srinivas Naidu", "Hospital Address : Naidu Nephrology Clinic, Vijayawada", "Exp : 12 years", "Mobile No: 9876543210", "600"},
                    {"Doctor Name : Anusha Rao", "Hospital Address : Rao Renal Care Center, Kurnool", "Exp : 15 years", "Mobile No: 8765432109", "700"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Venkataramana Goud", "Hospital Address : Goud Cardiac Center, Nandhyal", "Exp : 10 years", "Mobile No: 9876543210", "600"},
                    {"Doctor Name : Anand Reddy", "Hospital Address : Reddy Cardiac Care Center, Kadapa", "Exp : 15 years", "Mobile No: 8765432109", "700"},
                    {"Doctor Name : Varalakshmi Naidu", "Hospital Address : Naidu Cardiac Hospital, Tirupati", "Exp : 8 years", "Mobile No: 7654321098", "800"},
                    {"Doctor Name : Ramesh Babu", "Hospital Address : Babu Cardiac Care, Chittor", "Exp : 12 years", "Mobile No: 6543210987", "900"},
                    {"Doctor Name : Suresh Kumar", "Hospital Address : Kumar Heart Institute, Ananthapur", "Exp : 20 years", "Mobile No: 5432109876", "1000"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Rajeshwari Rao", "Hospital Address : Rao Neurology Clinic, Annamayya", "Exp : 10 years", "Mobile No: 9876543210", "600"},
                    {"Doctor Name : Surya Prakash Reddy", "Hospital Address : Reddy Neurological Center, Idupulapaya", "Exp : 15 years", "Mobile No: 8765432109", "700"},
                    {"Doctor Name : Anitha Kumari Naidu", "Hospital Address : Naidu Neurology Hospital, Visakhapatnam", "Exp : 8 years", "Mobile No: 7654321098", "800"},
                    {"Doctor Name : Vivek Babu", "Hospital Address : Babu Neuroscience Center, Guntur", "Exp : 12 years", "Mobile No: 6543210987", "900"},
                    {"Doctor Name : Lakshmi Narayana Sharma", "Hospital Address : Sharma Neurocare Institute, Ravulapalem", "Exp : 20 years", "Mobile No: 5432109876", "1000"}
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonBMCartBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        assert title != null;
        if(title.compareTo("Primary_care_providers")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("liver")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("kidney")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("cardiologists")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put( "line1", doctor_details[i][0]);
            item.put( "line2", doctor_details[i][1]);
            item.put( "line3", doctor_details[i][2]);
            item.put( "line4", doctor_details[i][3]);
            item.put( "line5", "Cons Fees:"+doctor_details[i][4]+"/-");
            list.add( item );
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewBMCart);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}