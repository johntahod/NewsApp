package models;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jonathantahod.newsapp.R;

import java.util.ArrayList;


public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsHolder> {

    Context mContext;
    public ArrayList<NewsItem> mNews;

    public NewsRecyclerViewAdapter(Context context, ArrayList<NewsItem> newsData) {
        this.mContext = context;
        this.mNews = newsData;

    }

    @Override
    public NewsRecyclerViewAdapter.NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttatchToParentImmiatley = false;
        View view = inflater.inflate(R.layout.item, parent, shouldAttatchToParentImmiatley);
        NewsHolder viewHolder = new NewsHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsRecyclerViewAdapter.NewsHolder holder, final int position)
    {
        holder.title.setText(mNews.get(position).getTitle());
        holder.desc.setText(mNews.get(position).getDescription());
        holder.date.setText(mNews.get(position).getpublishedAt());
        holder.desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String m = mNews.get(position).getUrl();
                openWebPage(m);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mNews.size();
    }


    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            webpage = Uri.parse("http://" + url);
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(mContext.getPackageManager()) != null) {
            mContext.startActivity(intent);
        }
    }
    public class NewsHolder extends RecyclerView.ViewHolder {

        private TextView title,desc,date;

        public NewsHolder(View itemView){
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.title);
            desc = (TextView)itemView.findViewById(R.id.description);
            date = (TextView)itemView.findViewById(R.id.date);

        }

//        void bind(final int listIndex) {
//            title.setText(mNews.get(listIndex).getTitle());
//            desc.setText(mNews.get(listIndex).getDescription());
//            date.setText(mNews.get((listIndex)).getpublishedAt());
//        }

    }
}

