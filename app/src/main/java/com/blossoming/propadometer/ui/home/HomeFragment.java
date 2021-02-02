package com.blossoming.propadometer.ui.home;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.blossoming.propadometer.R;
import com.blossoming.propadometer.graphaa;
import com.blossoming.propadometer.infolayout;
import com.blossoming.propadometer.webb;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static android.content.ContentValues.TAG;
import static android.content.Context.SENSOR_SERVICE;
import static android.content.Context.VIBRATOR_SERVICE;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static android.content.ContentValues.TAG;
import static android.content.Context.SENSOR_SERVICE;
import static android.content.Context.VIBRATOR_SERVICE;

public class HomeFragment extends Fragment implements SensorEventListener {

    float cachedAcceleration = 0.0f;
    float[] cachedAccelerometer = new float[]{0.0f, 0.0f, 0.0f};
    Context context;
    int glsteps;
    Sensor sensor;
    Boolean openn = true;
    boolean isPaused = false;
    boolean isPlaying = false;
    Button iv_play, iv_pause, iv_stop;
    CircularProgressBar circularProgressBar;
    private long lastStepCountTime = 0L;
    LinearLayout ll_timer, wholesteps;
    private SensorManager mSensorManager;
    private int numSteps = 0;
    private Sensor senAccelerometer;
    Timer t,aaa;
    long temp_milis;
    long temp_total = 0L;
    long total_seconds = System.currentTimeMillis();
    TextView tv_steps , starter, distance, maxstep, caloriestext;
    //TextView tv_steps_count;
    TextView tv_timer, weighttexts,heighttexts, textfortest, intte;
    Vibrator v;
    int a,b;
    String Last_date, kk;
    int aa;
    BarChart barChart;
    LinearLayout maincontent, sharethat, ratethat,feedbackthat, infothat;
    ArrayList arry;
    ImageView editmaxstep, Weightedit,Heightedit;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    float weighte,heighte;
    //EditText input;
    String currentDateandTime, date= "nuhu";
    int total_no_of_data;
    int BMI, data_no;
    double BMI_const = 49.43;
    int no_of_data;
    float heighttext;

    private InterstitialAd interstitialAd;
    LottieAnimationView lootiad, party, drawer;

    String linkk = "0";
    CardView firebasecard;
    ImageView firebaseimageView;

    public void onAccuracyChanged(Sensor sensor, int n) {
    }




    AnimatedVectorDrawableCompat avd;
    AnimatedVectorDrawable avd2;
    TextView glasscount, vol,bmitext;
    ImageView glass[] = new ImageView[7];
    ImageView plus, minus;


    int screenheight, count,gcount;
    int screenwidth, Dataaa;
    LinearLayout meter, layoutdraw;
    float weighttext;
    private HomeViewModel homeViewModel;
    Animation fadein,fadego, fadego2,drawfadego,drawfadein;
    RelativeLayout thanklay;
    // List<BarEntry> valsComp1;

    CardView privacy,rateus,shareit;
    float speed;
    ArrayList valsComp1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        circularProgressBar = root.findViewById(R.id.circle);
        tv_steps = (TextView)root.findViewById(R.id.text);
        tv_timer = (TextView)root.findViewById(R.id.timer);
        intte = root.findViewById(R.id.textView414);
        //tv_steps_count = (TextView)root.findViewById(R.id.stepup);
        lootiad = root.findViewById(R.id.lottie_ad);
        party = root.findViewById(R.id.lottiparty);
        sharedPreferences = this.getActivity().getSharedPreferences("pref",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        starter = root.findViewById(R.id.starter);
        privacy = root.findViewById(R.id.privacy);
        drawer = root.findViewById(R.id.drawer);
        sharethat = root.findViewById(R.id.sharee);
        ratethat = root.findViewById(R.id.ratee);
        feedbackthat = root.findViewById(R.id.feed);
        infothat = root.findViewById(R.id.inform);
        layoutdraw = root.findViewById(R.id.contentdraw);
        iv_play = (Button)root.findViewById(R.id.play);
        iv_pause = (Button)root.findViewById(R.id.pause);
        iv_stop = (Button)root.findViewById(R.id.stop);
        caloriestext = root.findViewById(R.id.caloriestext);
        distance = root.findViewById(R.id.distance);
        editmaxstep = root.findViewById(R.id.imageVie);
        barChart = (BarChart) root.findViewById(R.id.graph);
        ll_timer = (LinearLayout)root.findViewById(R.id.lay);
        maxstep =root.findViewById(R.id.maxstep);
        Weightedit = root.findViewById(R.id.image2);
        Heightedit = root.findViewById(R.id.image1);
        wholesteps = root.findViewById(R.id.wholesteps);
        weighttexts = root.findViewById(R.id.weight);
        heighttexts = root.findViewById(R.id.height);
        meter = root.findViewById(R.id.imageView3);
        bmitext =root.findViewById(R.id.bminumber);
        thanklay= root.findViewById(R.id.thanklay);
        maincontent = root.findViewById(R.id.maincontent);

        glasscount = root.findViewById(R.id.glasscount);
        vol =root.findViewById(R.id.ml);
        glass[0] = root.findViewById(R.id.glass1);
        glass[1] = root.findViewById(R.id.glass2);
        glass[2] = root.findViewById(R.id.glass3);
        glass[3] = root.findViewById(R.id.glass4);
        glass[4] = root.findViewById(R.id.glass5);
        glass[5] = root.findViewById(R.id.glass6);
        glass[6] = root.findViewById(R.id.glass7);

        plus = root.findViewById(R.id.plus);
        minus =root.findViewById(R.id.minus);

        v = (Vibrator)getContext().getSystemService(VIBRATOR_SERVICE);
        glsteps = sharedPreferences.getInt("maxstep",0);
        weighte = sharedPreferences.getFloat("weight",0);
        heighte = sharedPreferences.getFloat("height",0);


        weighttexts.setText(String.valueOf(weighte) + " Kg");
        heighttexts.setText(String.valueOf(heighte) + " cm");


        drawfadego = AnimationUtils.loadAnimation(getContext(),R.anim.drawfadego);
        drawfadein = AnimationUtils.loadAnimation(getContext(),R.anim.drawfadein);
        fadein = AnimationUtils.loadAnimation(getContext(), R.anim.fadein);
        fadego = AnimationUtils.loadAnimation(getContext(), R.anim.fadego);
        fadego2 = AnimationUtils.loadAnimation(getContext(), R.anim.fadeonly);
        fadego.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        firebaseimageView = root.findViewById(R.id.firebaseimage);
        firebasecard = root.findViewById(R.id.firebase);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Image Link");
        DatabaseReference myRef2 = database.getReference("Link");
        DatabaseReference myRef3 = database.getReference("Link_Out_in");

        valsComp1 = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY");
        currentDateandTime = sdf.format(new Date());
        Log.d("CurrentDate",currentDateandTime);
        date = sharedPreferences.getString("Date_no","null");
        data_no = sharedPreferences.getInt("Data",0);
        // Water Info
        //String gg = "Count_at_" + data_no;
        //-till here
        editor.putString("Date_no",currentDateandTime);
        editor.apply();


        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);
        screenwidth = displayMetrics.widthPixels;
        screenheight = displayMetrics.heightPixels;
        screenwidth = screenwidth - 50;
        bmitext.setText(String.valueOf(((float)((int) (1000000* (weighte/(heighte*heighte)))))/100));
        meter.setX((float) ((((10000 * weighte/(heighte*heighte))-16)*screenwidth*12/300)+10));


        final LinearLayout.LayoutParams layoutParamsa = new LinearLayout.LayoutParams(
                (LinearLayout.LayoutParams.MATCH_PARENT),
                9*screenheight/10);
        maincontent.setLayoutParams(layoutParamsa);


/**

 for(int i = no_of_data+1 ; i >= no_of_data; i--){

 String stepString = (new StringBuilder().append("step-Data").append(i).toString());
 int last_step = sharedPreferences.getInt(stepString,0);
 float bba = last_step;
 valsComp1.add(new BarEntry(i,bba));
 }// 0 == quarter 1
 BarDataSet set = new BarDataSet(valsComp1, "BarDataSet");
 BarData data = new BarData(set);
 //data.setBarWidth(0.9f); // set custom bar width
 graph.setData(data);
 graph.setFitBars(true); // make the x-axis fit exactly all bars
 graph.invalidate(); // refresh
 **/




        if (glsteps == 0) {
            glsteps = 100;
        }
        maxstep.setText(String.valueOf(glsteps));
        circularProgressBar.setProgressMax(glsteps);


        mSensorManager = (SensorManager)getActivity().getSystemService(SENSOR_SERVICE);
        sensor = senAccelerometer = mSensorManager.getDefaultSensor(1);


        Spinner spinner = (Spinner) root.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.Range, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        a = 6;
                        //textt.setText("1");
                        break;
                    case 1:
                        a = 29;
                        //textt.setText("2");
                        break;
                    case 2:
                        a = 364;
                        //textt.setText("3");
                        break;
                }
                working();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        working2();
        working();
        todaysteps();


        Weightedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertd = new AlertDialog.Builder(getActivity());
                alertd.setTitle("Set Weight ( in Kg )");
                final EditText weight = new EditText(getActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        (LinearLayout.LayoutParams.MATCH_PARENT)/2,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                weight.setLayoutParams(layoutParams);
                weight.setHint("Weight");
                weight.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                alertd.setView(weight);
                alertd.setPositiveButton("DONE",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {
                                weighttext = Float.parseFloat((weight.getEditableText().toString()));
                                editor.putFloat("weight",weighttext);
                                editor.apply();
                                weighttexts.setText(weight.getText() + " Kg");
                                BMICalcu();
                            }
                        });
                alertd.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                alertd.show();
            }
        });

        Heightedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertd = new AlertDialog.Builder(getActivity());
                alertd.setTitle("Set Height ( in cm )");
                final EditText height = new EditText(getActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        (LinearLayout.LayoutParams.MATCH_PARENT)/2,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                height.setLayoutParams(layoutParams);
                height.setHint("Height");
                height.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                alertd.setView(height);
                alertd.setPositiveButton("DONE",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {
                                heighttext = Float.parseFloat((height.getEditableText().toString()));
                                editor.putFloat("height",heighttext);
                                editor.apply();
                                heighttexts.setText(height.getText() + " cm");
                                BMICalcu();
                            }
                        });
                alertd.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertd.show();
            }
        });

        editmaxstep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("Target Steps");
                final EditText input = new EditText(getActivity());
                input.setHint("Number");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);
                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {
                                glsteps = Integer.parseInt(input.getEditableText().toString());
                                editor.putInt("maxstep",glsteps);
                                circularProgressBar.setProgressMax(glsteps);
                                maxstep.setText(input.getText());
                                editor.apply();
                            }
                        });
                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();
            }
        });

        iv_pause.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                if(iv_pause.getText()=="Pause"){
                    if(isPlaying){
                        isPaused = true;
                        temp_total = total_seconds;
                        backsensor();
                        t.cancel();
                        onPause();
                    }
                }
                else {
                    if(isPlaying) {
                        backrunsensor();
                        startTimer();
                        isPaused = false;
                        onResume();
                    }
                }
            }
        });

        iv_play.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                temp_milis = System.currentTimeMillis();
                iv_play.setVisibility(View.GONE);
                iv_play.startAnimation(fadego);
                ll_timer.setVisibility(View.VISIBLE);
                iv_stop.setVisibility(View.VISIBLE);
                iv_pause.setVisibility(View.VISIBLE);
                wholesteps.setVisibility(View.INVISIBLE);
                isPlaying = false;
                circularProgressBar.setProgress(0);
                isPaused=false;

                aaa = new Timer();
                aaa.scheduleAtFixedRate(new TimerTask(){

                    public void run() {
                        getActivity().runOnUiThread(new Runnable(){

                            public void run() {
                                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                                AnimationSet animationSet = new AnimationSet(false);
                                animationSet.addAnimation((Animation)scaleAnimation);
                                animationSet.addAnimation((Animation)alphaAnimation);
                                animationSet.setDuration(1000L);
                                starter.startAnimation(animationSet);
                                starter.setText(String.valueOf((long)(3L - (System.currentTimeMillis() - temp_milis) / 1000L)));
                                if ((System.currentTimeMillis() - temp_milis) / 1000L >= 3L) {
                                    aaa.cancel();
                                    ll_timer.setVisibility(View.GONE);
                                    wholesteps.setVisibility(View.VISIBLE);
                                    backrunsensor();
                                    isPlaying = true;
                                    startTimer();
                                }
                            }
                        });
                    }

                }, 0L, 1000L);

            }

        });

        iv_stop.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {


                if(isPlaying){
                    if(!isPaused){
                        t.cancel();
                    }

                    isPaused = false;
                    if(iv_pause.getText()=="Resume"){
                        iv_pause.setText("Pause");
                    }

                    tv_steps.setText("START !!");
                    tv_timer.setText("00 : 00 : 00");
                    circularProgressBar.setProgress(0);
                    temp_total = 0L;
                    iv_play.setVisibility(View.VISIBLE);
                    iv_play.startAnimation(fadein);
                    backsensor();
                    working2();
                    working();
                    todaysteps();

                }}
        });


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String c1titl = dataSnapshot.getValue(String.class);
                Picasso.get().load(c1titl).into(firebaseimageView);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                linkk = dataSnapshot.getValue(String.class);
                if(!linkk.equals("gone")){
                    Log.d("Date",linkk);
                    firebasecard.setVisibility(View.VISIBLE);
                }
                else if(linkk.equals("gone") && firebasecard.getVisibility() == View.VISIBLE){
                    firebasecard.setVisibility(View.GONE);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        myRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                kk = dataSnapshot.getValue(String.class);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        firebasecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(kk.equals("0")) {
                    Intent sharingIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkk));
                    startActivity(sharingIntent);
                }
                else{
                    Intent intent = new Intent(getActivity(), webb.class).putExtra("link",linkk);
                    startActivity(intent);
                }
            }
        });



        plus.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                gcount++;
                clickk(gcount);
                if(gcount<8){
                    glass[gcount-1].setImageDrawable(getResources().getDrawable(R.drawable.avd_anim));
                    anime(gcount-1);
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                gcount--;
                clickk(gcount);
                if(gcount<7){
                    glass[gcount].setImageDrawable(getResources().getDrawable(R.drawable.avd_anim_down));
                    anime(gcount);}
            }
        });


        clickk(gcount);

        if(gcount > 7){
            int fff = 6;
            for(int aj = 0;aj<=fff;aj++){
                glass[aj].setImageDrawable(getResources().getDrawable(R.drawable.avd_anim_down));
            }
        }
        else {
            for(int aj = 0;aj<gcount;aj++){
                glass[aj].setImageDrawable(getResources().getDrawable(R.drawable.avd_anim_down));
            }
        }
        lootiad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(interstitialAd.isAdLoaded()){
                interstitialAd.show();}
            }
        });
        party.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                thanklay.setVisibility(View.GONE);
                thanklay.startAnimation(fadego2);

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        //thanklay.getLayoutAnimationListener()
       /** .setLayoutAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                thanklay.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });**/
        drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(openn) {
                    drawer.setSpeed(1);
                    drawer.playAnimation();
                    openn = false;
                    layoutdraw.startAnimation(drawfadein);
                }
                else{
                    drawer.setSpeed(-1);
                    drawer.playAnimation();
                    openn = true;
                    layoutdraw.startAnimation(drawfadego);
                }
            }
        });

        drawfadego.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                layoutdraw.setScaleX(0);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        drawfadein.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                layoutdraw.setScaleX(1);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        intte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), graphaa.class);
                intent.putExtra("datano",data_no);
                startActivity(intent);
            }
        });

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), webb.class).putExtra("link",getResources().getString(R.string.privacy));
                startActivity(intent);
            }
        });
        ratethat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(getResources().getString(R.string.Link)));
                startActivity(sharingIntent);
            }
        });
        sharethat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Steps Counter App " +
                        "DOWNLOAD NOW:- "+ getResources().getString(R.string.Link));
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
        feedbackthat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mailIntent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:?subject=" + "FEED-BACK"+ "&body=" + "" + "&to=" + "dream11propredictionakshar@gmail.com");
                mailIntent.setData(data);
                startActivity(Intent.createChooser(mailIntent, "Go To Gmail..."));
            }
        });
        infothat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), infolayout.class);
                startActivity(intent);
            }
        });



        interstitialAd = new InterstitialAd(getActivity(), getResources().getString(R.string.Inter_id));
        interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callbackuguf
                //ugug
                thanklay.setVisibility(View.VISIBLE);
                party.playAnimation();
                interstitialAd.loadAd();
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                lootiad.setVisibility(View.INVISIBLE);
                if(lootiad.isAnimating()){
                lootiad.cancelAnimation();}
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                // Show the ad
                lootiad.setVisibility(View.VISIBLE);
                lootiad.playAnimation();
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
            }
        });
        interstitialAd.loadAd();



        return root;

    }

    public void onPause() {
        super.onPause();
        iv_pause.setText("Resume");
    }

    public void onDetach(){
        if(isPlaying){
            t.cancel();
        }
        super.onDetach();
    }

    public void backsensor(){
        mSensorManager.unregisterListener((SensorEventListener) this);
    }
    public void backrunsensor(){
        if(mSensorManager.registerListener((SensorEventListener)this, sensor, 0) == false){
            mSensorManager.registerListener((SensorEventListener)this, senAccelerometer, 3);}
    }
    public void onResume() {
        super.onResume();
        iv_pause.setText("Pause");
        if(!interstitialAd.isAdLoaded()){
            interstitialAd.loadAd();
        }
        //getActivity().getWindow().addFlags(128);
    }




    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        long l = System.currentTimeMillis();
        if (sensor.getType() == 1) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            double d = 0.3f * cachedAcceleration;
            double d2 = 0.699999988079071 * Math.sqrt((double)(f * f + f2 * f2 + f3 * f3));
            cachedAcceleration = (float)(d + d2);
            System.arraycopy((Object)sensorEvent.values, (int)0, (Object)cachedAccelerometer, (int)0, (int)sensorEvent.values.length);
            if ((double)cachedAcceleration > 11.5 && l - lastStepCountTime > 300L && isPlaying) {

                numSteps = 1 + numSteps;
                caloriestext.setText(String.valueOf(((float)((int) (numSteps*4.5))/100)));
                //distance.setText(String.valueOf((float)((numSteps*0.45)/));
                circularProgressBar.setProgressWithAnimation(numSteps, (long) 100);
                lastStepCountTime = l;
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                AnimationSet animationSet = new AnimationSet(false);
                animationSet.addAnimation((Animation)scaleAnimation);
                animationSet.addAnimation((Animation)alphaAnimation);
                animationSet.setDuration(1000L);
                tv_steps.setAnimation((Animation)animationSet);
                tv_steps.setText((CharSequence)String.valueOf((int)numSteps));
                //distance.setText(""+((numSteps*40)/100)+"");
                if (numSteps == glsteps + 1) {
                    v.vibrate(1000);
                    Toast.makeText(this.getContext(), (CharSequence)"You have Reached The Limit of Number of Steps You have Set Today!!",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    //Time Shown USe
    public String setCountDownTime(long l) {
        long l2 = l / 3600L;
        long l3 = l % 3600L;
        long l4 = l3 / 60L;
        long l5 = l3 % 60L;
        Object[] arrobject = new Object[]{l2, l4, l5};
        return String.format((String)"%02d : %02d : %02d", (Object[])arrobject);
    }

    public void startTimer() {
        temp_milis = System.currentTimeMillis();
        if (!isPaused) {
            numSteps = 0;
            tv_steps.setText((CharSequence)String.valueOf((int)numSteps));
            caloriestext.setText(String.valueOf((int) (numSteps*0.045)));
            //circularProgressBar.setProgress(0);
            //iv_play.setVisibility(View.GONE);
        }
        //isPaused = false;
        isPlaying = true;

        //Time Shown --

        t = new Timer();
        t.scheduleAtFixedRate(new TimerTask(){
            public void run() {
                getActivity().runOnUiThread(new Runnable(){

                    public void run() {
                        tv_timer.setText((CharSequence)setCountDownTime((System.currentTimeMillis() - temp_milis) / 1000L + temp_total));
                        total_seconds = (System.currentTimeMillis() - temp_milis) / 1000L + temp_total;
                    }
                });
            }

        }, 0L, 1000L);
        //--Time Shown

    }
    public void working2(){
        if(date.equals(currentDateandTime)){

            Log.d("Datechange",date);

            Log.d("Datechange",currentDateandTime);
            String datastring = "Data_at_" + data_no;
            String dag = "gCount_at_" + data_no;
            int Data_Value = sharedPreferences.getInt(datastring,0);
            Data_Value += numSteps;
            editor.putInt(datastring,Data_Value);
            editor.apply();
            gcount = sharedPreferences.getInt(dag,0);
        }
        else {
            Log.d("Date",date);
            Log.d("Datechange",currentDateandTime);
            data_no += 1;
            editor.putInt("Data",data_no);
            String datastring = "Data_at_" + data_no;
            String dag = "gCount_at_" + data_no;
            editor.putInt(datastring,no_of_data);
            editor.apply();
            gcount = sharedPreferences.getInt(dag,0);
        }
    }

    public void working(){

        Log.d("Working","yess");
        if (valsComp1.size()!=0){
            valsComp1.clear();
        }
        if(a>data_no){
            b = 1;
        }
        else {
            b = data_no - a;
        }
        for(int i=b;i<=data_no;i++){
            String datapoint = "Data_at_" + i;
            int Data_value = sharedPreferences.getInt(datapoint,0) ;
            valsComp1.add(new BarEntry(i,Data_value));
            //valsComp1.add(Data_value);
        }

        BarDataSet barDataSet = new BarDataSet(valsComp1, "Steps");
        BarData barData = new BarData(barDataSet);

        barDataSet.setValueTextColor(this.getResources().getColor(R.color.white));
        barChart.setData(barData);
        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);
        barChart.setMaxVisibleValueCount(50);
        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(true);
        barChart.animateXY(1000,1000);
        barChart.setBackgroundColor(this.getResources().getColor(R.color.transparent));
        barChart.setNoDataTextColor(this.getResources().getColor(R.color.white));
        barChart.setGridBackgroundColor(this.getResources().getColor(R.color.transparent));
        barChart.invalidate();
        //Log.d("data_no",String.valueOf(data_no));
        date = sharedPreferences.getString("Date_no","null");
        //Log.d("Date",date);
        //textView.setText(String.valueOf(valsComp1));}
    }

    public void BMICalcu(){
        weighte = sharedPreferences.getFloat("weight",0);
        heighte = sharedPreferences.getFloat("height",0);
        bmitext.setText(String.valueOf(((float)((int) (1000000* (weighte/(heighte*heighte)))))/100));
        meter.setX((float) ((((9090 * weighte/(heighte*heighte))-16)*screenwidth*12/300)+10));
    }

    public void todaysteps(){
        String datapoint = "Data_at_"+ data_no;
        int Data_value = sharedPreferences.getInt(datapoint,0);
        distance.setText(String.valueOf(Data_value));
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void anime(int no) {

        Drawable drawable = glass[no].getDrawable();
        if(drawable instanceof AnimatedVectorDrawableCompat){
            avd = (AnimatedVectorDrawableCompat) drawable;
            avd.start();
        }
        else if(drawable instanceof AnimatedVectorDrawable){
            avd2 = (AnimatedVectorDrawable) drawable;
            avd2.start();
        }

    }

    public void clickk(int ch){
        glasscount.setText(String.valueOf(ch));
        vol.setText(String.valueOf(ch*250) + " ml");

        String countstrig = "gCount_at_" + data_no;
        editor.putInt(countstrig,ch);
        editor.apply();
        if(ch == 0){
            minus.setClickable(false);
        }
        else if(!minus.isClickable()) {
            minus.setClickable(true);
        }

    }

}
