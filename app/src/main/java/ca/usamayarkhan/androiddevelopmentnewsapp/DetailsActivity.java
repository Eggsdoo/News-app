package ca.usamayarkhan.androiddevelopmentnewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ca.usamayarkhan.androiddevelopmentnewsapp.Models.NewsHeadlines;

public class DetailsActivity extends AppCompatActivity {
    NewsHeadlines headlines;
    TextView txt_title, txt_author, txt_time, txt_detail, txt_content;
    ImageView img_news;

    private NewsHeadlines newsHeadlines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        txt_title = findViewById(R.id.text_detail_title);
        txt_author = findViewById(R.id.text_detail_author);
        txt_time = findViewById(R.id.text_detail_time);
        txt_detail = findViewById(R.id.text_detail_detail);
        txt_content = findViewById(R.id.text_detail_content);
        img_news = findViewById(R.id.img_detail_news);

        headlines = (NewsHeadlines) getIntent().getSerializableExtra("data");

        txt_title.setText(headlines.getTitle());
        txt_author.setText(headlines.getAuthor());
        txt_time.setText(headlines.getPublishedAt());
        txt_detail.setText(headlines.getDescription());
        txt_content.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);

        Button btnReadFullNews = findViewById(R.id.button_read_full_news);

        btnReadFullNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String mainArticleUrl = headlines.getUrl(); // this will retrieve URL from 'headlines' object and then puts it in the mainArticleUrl
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mainArticleUrl)); // opens the web page
                    startActivity(intent);
                }
        });
    }
}