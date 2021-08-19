package com.example.project_005;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class loadGridView extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("오늘의 메뉴 : 추천 레스토랑");
        setContentView(R.layout.view_grid);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final GridView gv = (GridView) findViewById(R.id.setGrid);
        setGrid gridList = new setGrid(this);
        gv.setAdapter(gridList);

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

    public class setGrid extends BaseAdapter{


        Context context;
        public setGrid(Context c){
            context = c;
        }

        Integer [] gridArr = {
                R.drawable.grid_01, R.drawable.grid_02, R.drawable.grid_03,
                R.drawable.grid_04, R.drawable.grid_05, R.drawable.grid_06
        };

        String [] gridTit = {
                "| 아모르파티", "| Aphrodite", "| 근의 공식", "| 피자의 사탑", "| inputText = Fun Tonight!", "| No.9"
        };

        String [] gridTxt = {
                "낭만적인 만남이 기다리고 있을 것만 같은 예감! 이탈리안의 깊은 풍미를 즐길 수 있는 아모르파티입니다.",
                "미의 여신 아프로디테를 테마로 마치 그리스 신전에 온 것만 같은 느낌이 드는 곳입니다.",
                "육즙이 풍부한 스테이크 전문점으로써 진짜 근의 공식이 무엇인지 알 수 있습니다.",
                "하루하루가 파티와 같다면? 이 곳에서는 그러한 기분을 맛볼 수 있습니다.",
                "너무 무겁지 않게 심플하지만 근사한 분위기도 원하신다면? 이곳은 어떠세요?",
                "마치 유럽 도시의 카페에 온 것만 같은 분위기와 향신료 향이 물씬 풍기는 곳에서 한 때를 보내시는 건 어떠세요?"
        };

        String [] gridType = {
                "양식 | 부산진구 양정동 ", "이탈리안 | 부산 중구 남포동", "나이트바 | 부산 연제구 연산동", "남미 요리 | 부산 수영구 광안동", "양식 | 부산진구 전포동", "커피 | 부산 해운대구 중동"
        };

        String [] gridGift = {
                "화이트 와인 두 잔 무료", "이벤트 메뉴 10% 추가 할인", "드링크바 무료", "사이드메뉴 1+1 서비스", "일부 매뉴 15% 할인", "디저트 1종 무료 제공"
        };
        Integer [] gridDeposit = {
                15000, 10000, 8000, 12000, 12500, 7500
        };

        @Override
        public int getCount() {
            return gridArr.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View gridViewing = (View) View.inflate(loadGridView.this, R.layout.grid_detail, null);

            ImageView gImg = (ImageView) gridViewing.findViewById(R.id.gImg);
            gImg.setImageResource(gridArr[position]);
            TextView gTit = (TextView) gridViewing.findViewById(R.id.gTit);
            gTit.setText(gridTit[position]);
            TextView gTxt = (TextView) gridViewing.findViewById(R.id.gTxt);
            gTxt.setText(gridTxt[position]);

            gImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder gridDlg = new AlertDialog.Builder(loadGridView.this);
                    View gridDetail = (View) View.inflate(loadGridView.this, R.layout.dlg_detail, null);
                    ImageView rImg = (ImageView) gridDetail.findViewById(R.id.rImg);
                    rImg.setImageResource(gridArr[position]);
                    TextView resName = (TextView) gridDetail.findViewById(R.id.resName);
                    resName.setText(gridTit[position]);
                    TextView resTxt = (TextView) gridDetail.findViewById(R.id.resTxt);
                    resTxt.setText(gridTxt[position]);
                    TextView resType = (TextView) gridDetail.findViewById(R.id.resType);
                    resType.setText(gridType[position]);
                    TextView resDeposit = (TextView) gridDetail.findViewById(R.id.resDeposit);
                    resDeposit.setText("￦" + gridDeposit[position]);
                    TextView resGift = (TextView) gridDetail.findViewById(R.id.resGift);
                    resGift.setText(gridGift[position]);
                    gridDlg.setView(gridDetail);
                    gridDlg.setNegativeButton(Html.fromHtml("<font color='#202020'>닫기</font>"), null);
                    gridDlg.show();
                }
            });

            return gridViewing;
        }
    }

}

