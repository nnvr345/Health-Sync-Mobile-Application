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

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages =
            {
                    {"Paracetamol", "", "", "", "100"},
                    {"Ibuprofen Capsule", "", "", "", "350"},
                    {"Antihistamine", "", "", "", "268"},
                    {"Indigestion treatment", "", "", "", "233"},
                    {"Anti-diarrhoea remedy", "", "", "", "425"},
                    {"Hydrocortisone Cream or Ointment", "", "", "", "90"},
                    {"Pentazocine Injection 30mg/ml", "", "", "", "159"},
                    {"Ketamine Injection10 mg/ml", "", "", "", "120"},
                    {"Strepsils Medicated Lozenges for Sore Throat Relief (8 Each) | Flavour Orange", "", "", "", "46"},
            };
    private String[] package_details = {
            "Paracetamol is a common pain killer. You can take them for aches and pains. It is also commonly used for reducing high temperature (fever).\n" +
                  "\n"+
                    "essential medicines online chemist gorleston paracetamol\n" +
                    "How many to take?\n" +
                    "1 or 2 tablets/capsules up to every 4 to 6 hours, maximum 8 tablets in 24hours.\n" +
                    "\n" +
                    "Other information!\n" +
                    "--Paracetamol is safe to take in pregnancy and breastfeeding.\n" +
                    "--Do not take more than 2 tablets (1g) at a time or more than 8 tablets (4 g) in 24 hours.\n" +
                    "\n" +
                    "--Do not take other paracetamol containing medication at the same time.\n" +
                    "\n" +
                    "--Also available as a liquid for children or for people who can’t take tablets.",
            "Ibuprofen is a non-steroidal anti-inflammatory drug (NSAID). It reduces inflammation, hence helps to decrease swelling, pain, or fever.\n" +
                    "Ibuprofen is used to relieve pain from various conditions such as headache, dental pain, period pain, muscle aches, or arthritis.\n" +
                    "essential medicines online chemist gorleston ibuprofen\n" +
                    "How many to take?\n" +
                    "Take one or two 200 mg tablets 3 times a day with food or a drink of milk to reduce the chance of an upset stomach. Do not take it on an empty stomach.\n" +
                    "Other information!\n" +
                    "--Not suitable for pregnant women, patients suffering from stomach ulcer, asthma, high blood pressure etc\n" +
                    "--Do not take it in an empty stomach.\n" +
                    "--Ibuprofen is safe to take by mouth or use on your skin if you are breastfeeding.\n" +
                    "--Ask your pharmacist or call Online Chemist before you take ibuprofen if you are on other medicines\n" +
                    "--Available as tablets, capsules, liquid and gel",
            "Antihistamines are medicines often used to relieve symptoms of allergies, such as hay fever, hives, conjunctivitis and reactions to insect bites or stings.\n" +
                    "Antihistamines are of two main groups:\n" +
                    "--Drowsy-antihistamines, make you feel sleepy – such as Chlorphenamine (Piriton)\n" +
                    "--Non-drowsy antihistamines, less likely to make you feel sleepy – such as Cetirizine, Loratadine\n" +
                    "essential medicines online chemist gorleston antihistamine\n" +
                    "How many to take?\n" +
                    "--Non drowsy-antihistamines: normally take only ONE a day.\n" +
                    "--Drowsy-antihistamines: Take one tablet every 4-6 hours. Do not take more than 6 tablets in 24 hours\n" +
                    "Other information!\n" +
                    "--The common side effects are sleepiness, dry mouth, blurred vision\n" +
                    "--Available as tablets, capsules, liquids, syrups, creams, lotions, gels, eye drops and nasal sprays.\n" +
                    "--Its not safe to drive or use machineries after taking sedative (drowsy) antihistamines.",
            "Heartburn and acid reflux are the same thing – when the acid from your stomach comes up to your throat. You’ll have a burning feeling when this happens. This can be a symptom of indigestion.\n" +
                    "You can take indigestion remedies if you suffer from heartburn– a painful burning feeling in the chest, often after eating or you are feeling full and bloated, feeling sick, belching and passing wind or bringing up food or bitter tasting fluids.\n" +
                    "There are lots of over the counter indigestion remedies available, popular ones are Gaviscon, Rennie, Zantac\n" +
                    "How many to take?\n" +
                    "Dose is varied, so follow the instructions on the package of medication.\n" +
                    "It’s best to take indigestion treatment with food or soon after eating because this is when you’re most likely to get indigestion or heartburn.\n" +
                    "Other information!\n" +
                    "--Pregnant women often get indigestion. It’s very common from 27 weeks onwards.\n" +
                    "--Not all indigestion medicines are suitable for everyone. Check with your pharmacist or call Online Chemist.",
            "Diarrhoea is when you have frequent and liquid bowel movements. Many things can cause it, including viruses, bacteria and parasites, medicines such as antibiotics, digestive disorders such as coeliac disease or irritable bowel syndrome.\n" +
                    "Most of the time Diarrhoea doesn’t require treatment and usually lasts only a couple of days. But medicine can help you feel better. It especially helps if you also have cramping or stomach pain.\n" +
                    "The most common antidiarrhoeal medicines include loperamide (Imodium), bismuth subsalicylate (Pepto-Bismol). Dioralyte relief.\n" +
                    "How many to take?\n" +
                    "Please read the directions on the package or in the information leaflet inside the package. This will tell you how much medicine to take and how often to take it.\n" +
                    "Other information!\n" +
                    "--If you have a “stomach bug,” your body needs to get rid of the bacteria or parasite that is causing the diarrhoea. Stopping the diarrhoea, in this case, can make your condition worse. So do NOT take antidiarrhoeal remedies. However, you can take Dioralyte to replace the salt and water, that you are loosing with loose stool.\n" +
                    "--Don’t take loperamide if you have bloody or black stools. These may be signs of a more serious problem, such as a bacterial infection.\n" +
                    "--If you are allergic to aspirin, you should not take bismuth subsalicylate. Don’t give bismuth subsalicylate to children 12 years of age or younger.",
            "Hydrocortisone creams, ointments – also known as steroid. They are used on the skin to treat swelling, itching and irritation – eczema, psoriasis, contact dermatitis, prickly heat rash, insect bites and stings etc.\n" +
                    "Hydrocortisone creams or ointments are available to buy at 0.1% to 1%.\n" +
                    "How to use?\n" +
                    "Use hydrocortisone cream sparingly once or twice a day for a week or two.\n" +
                    "Other information!\n" +
                    "--Do not use in children under 10 years old unless their doctor recommends it.\n" +
                    "--Never put on your face unless your doctor says it’s ok and has given you a prescription for it.\n" +
                    "--It can make some skin problems of the face worse – such as impetigo, rosacea and acne.\n" +
                    "--Be careful not to get the cream into broken skin or cuts.\n" +
                    "--Wash your hands afterwards (unless it’s your hands that you’re treating).",
            "(Separate\n" +
                    "H1 Register shall be\n" +
                    "maintained- Name of\n" +
                    "drug, patient, prescriber\n" +
                    "and dispensed quantity\n" +
                    "shall be recorded",
            "Ketamine injection, at a concentration of 10 mg/ml, is primarily used for rapid anesthesia induction, making it vital in emergencies and short surgeries. It also effectively manages acute and chronic pain, particularly when other medications fail. Ketamine's sedative properties are useful for calming patients during minor surgeries or diagnostic procedures. Additionally, its potential in treating treatment-resistant depression highlights its expanding therapeutic applications. Overall, ketamine injection serves as a versatile medication for anesthesia, pain management, sedation, and emerging psychiatric treatments.",
            "Strepsils Medicated Lozenges for Sore Throat (8 Each) contain a combination of two effective antiseptics (2,4-dichlorobenzyl alcohol and amylmetacresol) to relieve the discomfort of sore throats in the soothing honey and lemon flavor. It can be taken by adults and children over six years."
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
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
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}