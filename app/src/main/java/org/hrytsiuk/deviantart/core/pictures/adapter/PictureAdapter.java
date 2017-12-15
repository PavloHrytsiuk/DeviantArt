package org.hrytsiuk.deviantart.core.pictures.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.hrytsiuk.deviantart.R;
import org.hrytsiuk.deviantart.base.OnItemClickListener;
import org.hrytsiuk.deviantart.core.pictures.model.Picture;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public final class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder> {

    private List<Picture> pictures = new ArrayList<>();
    private final OnItemClickListener listener;

    public PictureAdapter(@NonNull final List<Picture> pictures, @NonNull final OnItemClickListener listener) {
        this.pictures = pictures;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        return new ViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.item_picture, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Picture picture = pictures.get(position);
        if (picture.getTitle() != null) {
            holder.pictureTitle.setText(picture.getTitle());
        }
        //holder.recipeRating.setText(String.valueOf(recipe.getSocialRank()));
        if (picture.getContent() != null && picture.getContent().getSrc() != null) {
            Picasso.with(holder.itemView.getContext()).load(picture.getContent().getSrc()).into(holder.pictureImage);
        }
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    static final class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.pictureCard)
        CardView pictureCard;
        @BindView(R.id.pictureTitle)
        TextView pictureTitle;
        @BindView(R.id.pictureRating)
        TextView pictureRating;
        @BindView(R.id.pictureImage)
        ImageView pictureImage;

        public ViewHolder(@NonNull final View itemView, @NonNull final OnItemClickListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            pictureCard.setOnClickListener(view -> listener.onItemClick(getAdapterPosition()));
        }
    }
}
