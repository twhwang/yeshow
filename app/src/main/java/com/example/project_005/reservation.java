package com.example.project_005;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class reservation extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("예약하기");
        setContentView(R.layout.reservation);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        EditText inputRName = (EditText) findViewById(R.id.inputRName);
        EditText inputRNum = (EditText) findViewById(R.id.inputRNum);
        EditText inputPhone = (EditText) findViewById(R.id.inputPhone);

        Spinner spinPhone = (Spinner) findViewById(R.id.spinPhone);
        final String [] phone = {
                "010" , "011" , "019"
        };
        ArrayAdapter<String> spinP;
        spinP = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, phone);
        spinPhone.setAdapter(spinP);

        RadioButton rd_Seat01 = (RadioButton) findViewById(R.id.rd_Seat01);
        RadioButton rd_Seat02 = (RadioButton) findViewById(R.id.rd_Seat02);
        RadioButton rd_Seat03 = (RadioButton) findViewById(R.id.rd_Seat03);

        Button btnDate = (Button) findViewById(R.id.btnDate);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dateDlg = new AlertDialog.Builder(reservation.this);
                final View dateView = getLayoutInflater().inflate(R.layout.dlg_date, null);
                DatePicker setDate = (DatePicker) dateView.findViewById(R.id.setDate);
                dateDlg.setTitle("날짜 선택");
                dateDlg.setView(dateView);
                dateDlg.setPositiveButton(Html.fromHtml("<font color='#202020'>OK</font>"), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String year = Integer.toString(setDate.getYear());
                                String month = Integer.toString(setDate.getMonth()+1);
                                String date = Integer.toString(setDate.getDayOfMonth());
                                btnDate.setText(year + "-" + month + "-" + date);
                            }
                        });
                dateDlg.setNegativeButton(Html.fromHtml("<font color='#202020'>CANCEL</font>"), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                dateDlg.show();
            }
        });

        Button btnTime = (Button) findViewById(R.id.btnTime);
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder timeDlg = new AlertDialog.Builder(reservation.this);
                final View timeView = getLayoutInflater().inflate(R.layout.dlg_time, null);
                TimePicker setTime = (TimePicker) timeView.findViewById(R.id.setTime);
                timeDlg.setTitle("시간 선택")
                        .setView(timeView)
                        .setPositiveButton(Html.fromHtml("<font color='#202020'>OK</font>"), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String hour = Integer.toString(setTime.getCurrentHour());
                                String minutes = Integer.toString(setTime.getCurrentMinute());
                                btnTime.setText(hour + ":" + minutes);
                            }
                        })
                        .setNegativeButton(Html.fromHtml("<font color='#202020'>CANCEL</font>"), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }
        });

        Button btnRsvCancel = (Button) findViewById(R.id.btnRsvCancel);
        btnRsvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder closeD = new AlertDialog.Builder(reservation.this);
                closeD.setMessage("예약을 취소하시겠습니까?");
                closeD.setPositiveButton(Html.fromHtml("<font color='#202020'>OK</font>"), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                closeD.setNegativeButton(Html.fromHtml("<font color='#202020'>CANCEL</font>"), null);
                closeD.show();
            }
        });

        Button btnRsvComplete = (Button) findViewById(R.id.btnRsvComplete);
        btnRsvComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getName = inputRName.getText().toString();
                String getNum = inputRNum.getText().toString();
                String getPhone1 = spinPhone.getSelectedItem().toString();
                String getPhone2 = inputPhone.getText().toString();
                RadioGroup rd_Seat = (RadioGroup) findViewById(R.id.rd_Seat);
                int seatNum = rd_Seat.getCheckedRadioButtonId();
                String getDate = btnDate.getText().toString();
                String getTime = btnTime.getText().toString();

                if(getName.equals("") || getName.isEmpty() || getPhone2.equals("") || getPhone2.isEmpty()){
                    Toast.makeText(getApplicationContext(), "예약자 성명과 연락처는 필수입니다.", Toast.LENGTH_SHORT).show();
                }
                else {

                    if(getNum.equals("")){
                        getNum = "1";
                    }
                    
                    if (getDate.equals("예약날짜 선택")){
                        getDate = "-";
                    }
                    if (getTime.equals("예약시간 선택")){
                        getTime = "-";
                    }

                    AlertDialog.Builder rsvDlg = new AlertDialog.Builder(reservation.this);
                    final View rsvView = getLayoutInflater().inflate(R.layout.dlg_rsv, null);
                    rsvDlg.setView(rsvView);
                    TextView rsvName = (TextView) rsvView.findViewById(R.id.rsvName);
                    TextView rsvNum = (TextView) rsvView.findViewById(R.id.rsvNum);
                    TextView rsvPhone = (TextView) rsvView.findViewById(R.id.rsvPhone);
                    TextView rsvSeat = (TextView) rsvView.findViewById(R.id.rsvSeat);
                    TextView rsvDateTime = (TextView) rsvView.findViewById(R.id.rsvDateTime);

                    rsvName.setText(getName+"님");
                    rsvNum.setText(getNum+"명");
                    rsvPhone.setText(getPhone1 + " - " + getPhone2.substring(0, 4) + " - " + getPhone2.substring(4, 8));
                    switch (seatNum){
                        case R.id.rd_Seat01:
                            rsvSeat.setText(rd_Seat01.getText().toString());
                            break;
                        case R.id.rd_Seat02:
                            rsvSeat.setText(rd_Seat02.getText().toString());
                            break;
                        case R.id.rd_Seat03:
                            rsvSeat.setText(rd_Seat03.getText().toString());
                            break;
                    }
                    rsvDateTime.setText(getDate + " " + getTime);

                    rsvDlg.setPositiveButton(Html.fromHtml("<font color='#202020'>예약 확정</font>"), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "예약이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });
                    rsvDlg.setNegativeButton(Html.fromHtml("<font color='#202020'>다시 입력</font>"), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    rsvDlg.show();

                }

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
