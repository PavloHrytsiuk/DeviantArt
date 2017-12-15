package org.hrytsiuk.deviantart.core;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.hrytsiuk.deviantart.R;
import org.hrytsiuk.deviantart.base.BaseActivity;
import org.hrytsiuk.deviantart.core.pictures.model.Picture;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PictureDetailActivity extends BaseActivity {

    private static final String CLICKED_PICTURE = "Pictures list";

    @BindView(R.id.pictureDetailImage)
    ImageView image;
    @BindView(R.id.pictureDetailTitle)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_picture);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        Picture picture = bundle.getParcelable(CLICKED_PICTURE);
        Log.d("TAG", "Picture from detail " + picture);
        if (picture != null && picture.getContent() != null) {
            Picasso.with(this).load(picture.getContent().getSrc()).into(image);
            title.setText(picture.getTitle());
        }
    }
}
