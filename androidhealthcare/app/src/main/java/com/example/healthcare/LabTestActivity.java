package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Package 1 : Basic Health Check", "", "", "", "1500"},
                    {"Package 2 : Kidney Health Package", "", "", "", "999"},
                    {"Package 3 : Cardiac Advanced Package MBP", "", "", "", "8000"},
                    {"Package 4 : Liver Health Screening Package", "", "", "", "2000"},
                    {"Package 5 : Master Health Check", "", "", "", "5000"}
            };
    private String[] package_details = {
            "CONSULTATION INTERNAL MEDICINE\n" +
                    "Cholesterol - Total\n" +
                    "Creatinine- Serum\n" +
                    "ECG- Adult\n" +
                    "Glucose - Fasting\n" +
                    "Haemoglobin ( Automated )\n" +
                    "SGOT ( Ast )\n" +
                    "SGPT ( Alt )\n" +
                    "Triglycerides",
            "Creatinine- Serum\n" +
                    "Ultrasound KUB\n" +
                    "Urine - Protein Creatinine Ratio",
            "Apolipoprotein - A1 & B\n" +
                    "Blood Grouping & Rh Typing\n" +
                    "Bun (Blood Urea Nitrogen)\n" +
                    "C-Reactive Protein\n" +
                    "C-Reactive Protein (CRP)\n" +
                    "Calcium - Total\n" +
                    "Cardiac Advanced Package\n" +
                    "Cardio HS - CRP\n" +
                    "Complete Blood Counts (Automated)\n" +
                    "Creatinine- Serum\n" +
                    "ECG\n" +
                    "ESR ( Automated )\n" +
                    "Echo-Cardiogram\n" +
                    "Fibrinogen Level ( Automated / Clotting Assay )\n" +
                    "Glucose - Fasting\n" +
                    "Glucose - Post Prandial (Ppbs)\n" +
                    "Glycated Hemoglobin ( Hba1C )\n" +
                    "Glycated Hemoglobin ( Hba1C ) Test\n" +
                    "HC Cardiology Consultation\n" +
                    "HC Physical Examination\n" +
                    "HC Physician Consultation\n" +
                    "Homocystine (Plasma)\n" +
                    "Lipid Profile\n" +
                    "Lipoprotein (A)\n" +
                    "Phosphorus - Serum\n" +
                    "Thyroid Profile (T3 T4 Tsh)\n" +
                    "Tread Mill Test\n" +
                    "Uric Acid - Serum\n" +
                    "Urine Routine and Microscopy ( Qualitative Method)\n" +
                    "Xray chest PA (CXR)",
            "CONSULTATION GASTRO MEDICAL\n" +
                    "Hepatitis B Surface Antigen (Hbsag) - (ECLIA)\n" +
                    "Hepatitis C Virus Antibody (ECLIA)\n" +
                    "Liver Function Test\n" +
                    "Ultrasound abdomen n pelvis",
            "Blood Urea\n" +
                    "CONSULTATION INTERNAL MEDICINE\n" +
                    "Calcium - Total\n" +
                    "Complete Blood Counts (Automated)\n" +
                    "Creatinine- Serum\n" +
                    "ECG- Adult\n" +
                    "ESR ( Automated )\n" +
                    "Glucose - Fasting\n" +
                    "Glycated Hemoglobin ( Hba1C )\n" +
                    "Lipid Profile\n" +
                    "Liver Function Test\n" +
                    "TSH (Thyroid Stimulating Hormone)\n" +
                    "Ultrasound Abdomen\n" +
                    "Uric Acid - Serum\n" +
                    "Urine Complete Analysis\n" +
                    "Xray chest PA (CXR)"
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart,btnBack;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart = findViewById(R.id.buttonBMCartCheckout);
        btnBack = findViewById(R.id.buttonBMCartBack);
        listView = findViewById(R.id.listViewBMCart);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put( "line1", packages[i][0]);
            item.put( "line2", packages[i][1]);
            item.put( "line3", packages[i][2]);
            item.put( "line4", packages[i][3]);
            item.put( "line5", "Total Cost:"+packages[i][4]+"/-");
            list.add( item );
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[] { "line1","line2", "line3", "line4", "line5" },
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,CartLabActivity.class));
            }
        });
    }
}