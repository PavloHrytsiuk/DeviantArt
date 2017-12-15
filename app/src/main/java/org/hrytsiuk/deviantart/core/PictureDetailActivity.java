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

public final class PictureDetailActivity extends BaseActivity {

    private static final String CLICKED_PICTURE = "Pictures list";

    @BindView(R.id.pictureDetailImage)
    ImageView image;
    @BindView(R.id.pictureDetailTitle)
    TextView title;
    @BindView(R.id.pictureDetailStats)
    TextView stats;
    @BindView(R.id.pictureDetailAuthor)
    TextView author;
    @BindView(R.id.pictureDetailAuthorIcon)
    ImageView authorIcon;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_picture);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        Picture picture = bundle.getParcelable(CLICKED_PICTURE);
        Log.d("TAG", "Picture from detail " + picture);

        if (picture != null) {
            if (picture.getContent() != null && picture.getContent().getSrc() != null) {
                Picasso.with(this).load(picture.getContent().getSrc()).into(image);
            }
            title.setText(picture.getTitle());

            if (picture.getStats() != null) {
                StringBuilder buf = new StringBuilder();
                buf.append("Comments: ");
                buf.append(picture.getStats().getComments());
                buf.append("\n");
                buf.append("Favourites: ");
                buf.append(picture.getStats().getFavourites());
                stats.setText(buf);
            }

            if (picture.getAuthor() != null) {
                author.setText(picture.getAuthor().getName());
                if (picture.getAuthor().getUserIcon() != null) {
                    Picasso.with(this).load(picture.getAuthor().getUserIcon()).into(authorIcon);
                }
            }
        }
    }
}
