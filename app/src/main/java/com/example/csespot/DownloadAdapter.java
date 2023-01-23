package com.example.csespot;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DownloadAdapter extends RecyclerView.Adapter<DownloadAdapter.DownloadViewHolder> {

    PdfDownload_Activity pdfDownload_activity;
    ArrayList<DownloadModel> downModels;

    public DownloadAdapter(PdfDownload_Activity pdfDownload_activity, ArrayList<DownloadModel> downModels) {
        this.pdfDownload_activity = pdfDownload_activity;
        this.downModels = downModels;
    }

    @NonNull
    @Override
    public DownloadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(pdfDownload_activity.getBaseContext());
        View view = layoutInflater.inflate(R.layout.elements, null, false);
        return new DownloadViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return downModels.size();
    }

    @Override
    public void onBindViewHolder(@NonNull final DownloadViewHolder holder,final int position) {



        holder.mName.setText(downModels.get(position).getName());
        holder.mLink.setText(downModels.get(position).getLink());



        holder.mDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadFile(holder.mName.getContext(),downModels.get(holder.getAdapterPosition()).getName(),".pdf",DIRECTORY_DOWNLOADS,downModels.get(holder.getAdapterPosition()).getLink());
                //downloadFile(holder.mName.getContext(),mN,".pdf",DIRECTORY_DOWNLOADS,downModels.get(holder.getAdapterPosition()).getLink());
            }
        });


    }

    public class DownloadViewHolder extends RecyclerView.ViewHolder
    {
        TextView mName;
        TextView mLink;
        Button mDownload;
        public DownloadViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.name);
            mLink = itemView.findViewById(R.id.link);
            mDownload = itemView.findViewById(R.id.down);
        }
    }

    public void downloadFile(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {

        DownloadManager downloadmanager = (DownloadManager) context.
                getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);

        downloadmanager.enqueue(request);
    }

}
